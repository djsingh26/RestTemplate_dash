package com.djsingh26.todoservice.repository;

import com.djsingh26.todoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
