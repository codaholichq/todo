# Build stage
FROM gradle:8.1-jdk AS build
LABEL maintainer="codaholic.com"
WORKDIR /
COPY . /
RUN gradle clean build --no-daemon -x test

# Package stage
FROM eclipse-temurin:20-jre-alpine@sha256:9e0e03b2d3222f54a7a222cd2bd16301d1653be508b84d62487383bb7e420be2
RUN apk add --no-cache dumb-init
#RUN apt-get update && apt-get install -y dumb-init
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
#RUN groupadd -r javauser && useradd -r -g javauser javauser
COPY --from=build /target/libs/*.jar /app/app.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
EXPOSE 80
ENTRYPOINT ["dumb-init", "java", "-jar", "app.jar"]
