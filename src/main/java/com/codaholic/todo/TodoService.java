package com.codaholic.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository repo;

    TodoService(TodoRepository repo){
        this.repo = repo;
    }


    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    public Todo getTodoById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
    }

    public Todo updateTodo(UUID id, Todo todoDetail) {
        Todo todo = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found"));

        todo.setName(todoDetail.getName());
        todo.setStartTime(todoDetail.getStartTime());
        todo.setEndTime(todoDetail.getEndTime());
        todo.setTaskStatus(todoDetail.getTaskStatus());

        return repo.save(todo);
    }

    public void deleteTodo(UUID id) {
        repo.deleteById(id);
    }
}

