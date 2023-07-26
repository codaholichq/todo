package com.codaholic.todo.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    PENDING,
    COMPLETED,
    CANCELED
}
