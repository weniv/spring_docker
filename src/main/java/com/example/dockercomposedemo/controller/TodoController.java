package com.example.dockercomposedemo.controller;

import com.example.dockercomposedemo.entity.Todo;
import com.example.dockercomposedemo.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
    return ResponseEntity.ok(todoService.getTodoById(id));
  }

  @PostMapping
  public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
    return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Todo> updateTodo(
      @PathVariable("id") Long id, @RequestBody Todo todoDetails) {
    return ResponseEntity.ok(todoService.updateTodo(id, todoDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return ResponseEntity.noContent().build();
  }
}