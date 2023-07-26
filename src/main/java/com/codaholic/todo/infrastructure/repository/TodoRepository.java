package com.codaholic.todo.infrastructure.repository;

import com.codaholic.todo.domain.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}

