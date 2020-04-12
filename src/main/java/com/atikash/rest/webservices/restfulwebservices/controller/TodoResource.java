package com.atikash.rest.webservices.restfulwebservices.controller;

import com.atikash.rest.webservices.restfulwebservices.services.TodoHardcodedService;
import com.atikash.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
public class TodoResource {
    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteById(id);
        if (todo != null)
            return ResponseEntity.status(HttpStatus.OK).body(todo);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo todoUpdated = todoService.save(todo);
        if (todoUpdated != null)
            return ResponseEntity.status(HttpStatus.OK).body(todoUpdated);
        else
            return ResponseEntity.status(500).build();
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity addTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        if (createdTodo != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
            ResponseEntity responseEntity= ResponseEntity.created(uri).build();
            return ResponseEntity.created(uri).build();
        } else
            return ResponseEntity.status(500).build();
    }


}
