package br.edu.ufersa.pw.todolist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.pw.todolist.entity.User;
import br.edu.ufersa.pw.todolist.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
}
