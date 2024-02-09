package com.codaholic.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue
    private UUID id;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;

    @JsonIgnore
    @Version
    private Integer version;
}
