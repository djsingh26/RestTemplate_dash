package com.djsingh26.dashboardservice.controller;

import com.djsingh26.dashboardservice.Repository.TodoRepository;
import com.djsingh26.dashboardservice.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/todos")
    public void loadTodos(@RequestBody List<Todo> todos){
        todoRepository.saveAll(todos);
    }
}
