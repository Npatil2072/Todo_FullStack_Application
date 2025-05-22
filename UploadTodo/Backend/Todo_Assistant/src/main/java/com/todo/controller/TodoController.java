package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.repo.TodoRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
	@Autowired
     private TodoRepository repo;
	

    @GetMapping
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
    	System.out.println(todo.toString());
        return repo.save(todo);
    }

    @DeleteMapping("/{id}") 
    public void deleteTodo(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

