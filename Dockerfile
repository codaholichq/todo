# Build stage
FROM gradle:8-alpine@sha256:2c45bb3c3076531fa7dccc97db01c605c5332de411079d9cd38d1d1552b24e09 AS build
LABEL maintainer="codaholic.com"
WORKDIR /
COPY . /
RUN gradle clean build --no-daemon -x test

# Package stage
FROM amazoncorretto:17-alpine@sha256:0770cab734f259b1f68060bd543aab1e217f1634d7bbac76c09996a1a9bf723b
RUN apk add --no-cache dumb-init
#RUN apt-get update && apt-get install -y --no-install-recommends dumb-init
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
#RUN groupadd -r javauser && useradd -r -g javauser javauser
COPY --from=build /target/libs/*.jar /app/app.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
EXPOSE 80
ENTRYPOINT ["dumb-init", "java", "-jar", "app.jar"]
