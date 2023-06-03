package com.djsingh26.dashboardservice.Repository;

import com.djsingh26.dashboardservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
