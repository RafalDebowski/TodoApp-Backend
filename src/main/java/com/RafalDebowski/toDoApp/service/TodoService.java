package com.RafalDebowski.toDoApp.service;

import com.RafalDebowski.toDoApp.entity.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> findAll();

    public Todo findById(int theId);

    public void save(Todo theTodo);

    public void delateById(int theId);


}
