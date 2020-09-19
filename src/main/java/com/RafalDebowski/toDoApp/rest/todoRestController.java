package com.RafalDebowski.toDoApp.rest;

import com.RafalDebowski.toDoApp.entity.Todo;
import com.RafalDebowski.toDoApp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class todoRestController {

    private TodoService todoService;

    public todoRestController(TodoService service) {
        this.todoService = service;
    }

    @GetMapping("/todo")
    public List<Todo> findAll() {
        return this.todoService.findAll();
    }

    @GetMapping("/todo/{todoID}")
    public Todo getTodo(@PathVariable int todoID) {
        Todo theTodo = this.todoService.findById(todoID);
        if (theTodo == null) {
            throw new RuntimeException("Did not find todo with id - " + todoID);
        }
        return theTodo;
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo theTodo) {
        theTodo.setId(0);
        this.todoService.save(theTodo);
        return theTodo;
    }

    @PutMapping("/todo")
    public Todo update(@RequestBody Todo todo) {
        this.todoService.save(todo);
        return todo;
    }

    @DeleteMapping("/todo/{todoId}")
    public String delate(@PathVariable int todoId) {
        Todo templTodo = this.todoService.findById(todoId);

        if (templTodo == null){
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }

        this.todoService.delateById(todoId);
        return "todo with id " + todoId + "  delated ";
    }


}
