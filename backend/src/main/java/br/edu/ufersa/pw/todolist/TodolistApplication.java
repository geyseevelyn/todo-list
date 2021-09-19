package br.edu.ufersa.pw.todolist;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.ufersa.pw.todolist.entity.User;
import br.edu.ufersa.pw.todolist.repositories.UserRepository;

@SpringBootApplication
public class TodolistApplication {
	
	@Autowired
	UserRepository userRepo;
	
	private static final Logger logger =
		LoggerFactory.getLogger(TodolistApplication.class);
			

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
		logger.info("Hello start");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			 List<User> users = userRepo.findAll();
		 users.forEach(user -> System.out.println(user.getEmail()));
		};
	}
}
