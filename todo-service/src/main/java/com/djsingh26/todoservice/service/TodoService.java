package com.djsingh26.todoservice.service;

import com.djsingh26.todoservice.model.Todo;
import com.djsingh26.todoservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);
    private final String DASHBOARD_API_URL = "http://localhost:8091/api/dashboard/todos";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TodoRepository todoRepository;

    public void sendToDashboard(List<Todo> todos){
        ResponseEntity<String> response = restTemplate.postForEntity(DASHBOARD_API_URL, todos, String.class );
        if( response.getStatusCode().is2xxSuccessful()){
            LOG.info("Todos sent to dashboard successfully");
        }
    }

}
