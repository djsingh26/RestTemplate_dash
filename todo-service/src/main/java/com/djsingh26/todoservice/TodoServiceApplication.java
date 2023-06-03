package com.djsingh26.todoservice;

import com.djsingh26.todoservice.model.Todo;
import com.djsingh26.todoservice.repository.TodoRepository;
import com.djsingh26.todoservice.service.JsonPlaceholderService;
import com.djsingh26.todoservice.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TodoServiceApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TodoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
	CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, TodoRepository repository, TodoService service){
		return args -> {
			//When the application loads get the 200 todos from json placeholder
			List<Todo> todos = jsonPlaceholderService.getTodos();

			// once we have the todos persist them to the db
			repository.saveAll(todos);

			LOG.info("Saved {} todos in the database", todos.size());

			// push this information to our dashboard service
			service.sendToDashboard(todos);

		};
	}

}
