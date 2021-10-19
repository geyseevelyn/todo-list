package br.edu.ufersa.pw.todolist.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.pw.todolist.dto.CreateTodoDto;
import br.edu.ufersa.pw.todolist.dto.TodoDto;
import br.edu.ufersa.pw.todolist.services.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping("/search/byEmail")
	public ResponseEntity<?> getByEmail(@Param("email") String email) {
		return new ResponseEntity<List<TodoDto>>(service.findByUser(email), HttpStatus.OK);
	}
	
	@GetMapping("/search/byEmailAndDeadline")
	public ResponseEntity<?> getByEmailAndDeadline(@Param("email") String email, @Param("deadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline){
		return new ResponseEntity<List<TodoDto>>(service.findByUserAndDeadline(email, deadline), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CreateTodoDto> save(@RequestBody CreateTodoDto dto) {
		
		CreateTodoDto todo = service.save(dto);
		
		if(todo == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		else {
			return new ResponseEntity<>(todo, HttpStatus.CREATED);
		}
	}
	
	@PutMapping
	public ResponseEntity<CreateTodoDto> update(@RequestBody CreateTodoDto dto) {
		CreateTodoDto todo = service.update(dto);
		
		if(todo == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		else {
			return new ResponseEntity<>(todo, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		TodoDto dto = new TodoDto();
		dto.setId(id);
		
		try {
			service.delete(dto);
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}
}
