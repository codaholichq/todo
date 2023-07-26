package com.codaholic.todo.domain.entities;

import com.codaholic.todo.domain.common.BaseEntity;
import com.codaholic.todo.domain.enums.Status;
import jakarta.persistence.*;
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
