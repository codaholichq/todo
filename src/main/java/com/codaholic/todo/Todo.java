package com.codaholic.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@EqualsAndHashCode(callSuper = false)
public class Todo extends BaseEntity {
    @NotEmpty(message = "Name cannot be blank")
    private String Name;

    @NotNull(message = "Start Time cannot be blank")
    private LocalDateTime StartTime;

    @NotNull(message = "End Time cannot be blank")
    private LocalDateTime EndTime;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status TaskStatus = Status.PENDING;
}
