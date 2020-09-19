package com.RafalDebowski.toDoApp.dao;

import com.RafalDebowski.toDoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
