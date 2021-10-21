package br.edu.ufersa.pw.todolist.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.todolist.dto.TodoDto;
import br.edu.ufersa.pw.todolist.entities.Concluded;
import br.edu.ufersa.pw.todolist.repositories.ConcludedRepository;

@Service
public class ConcludedService {

	@Autowired
	private ConcludedRepository repo;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public List<TodoDto> findByUser(String email){
		List<Concluded> todos = repo.findByUser(email);
		return todos.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public List<TodoDto> findByUserAndConcluded(String email, LocalDate concluded){
		List<Concluded> todos = repo.findByUserAndConcluded(email, concluded);
		return todos.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
	}
}
