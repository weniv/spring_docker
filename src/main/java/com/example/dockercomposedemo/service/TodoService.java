package com.example.dockercomposedemo.service;

import com.example.dockercomposedemo.ResourceNotFoundException;
import com.example.dockercomposedemo.entity.Todo;
import com.example.dockercomposedemo.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  @Autowired private TodoRepository todoRepository;

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public Todo getTodoById(Long id) {
    return todoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
  }

  public Todo createTodo(Todo todo) {
    return todoRepository.save(todo);
  }

  public Todo updateTodo(Long id, Todo todoDetails) {
    Todo todo = getTodoById(id);
    todo.setTitle(todoDetails.getTitle());
    todo.setCompleted(todoDetails.isCompleted());
    return todoRepository.save(todo);
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}