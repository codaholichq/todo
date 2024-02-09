package com.codaholic.todo;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    PENDING,
    COMPLETED,
    CANCELED
}
