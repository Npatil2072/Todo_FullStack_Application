package com.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
