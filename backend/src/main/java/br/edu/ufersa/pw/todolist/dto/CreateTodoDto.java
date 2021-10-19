package br.edu.ufersa.pw.todolist.dto;

import java.time.LocalDate;

import br.edu.ufersa.pw.todolist.entities.Concluded;
import br.edu.ufersa.pw.todolist.entities.Todo;

public class CreateTodoDto {
	
	private Long id;
	private String todo;
	private LocalDate data;
	private String email;
	
	public CreateTodoDto() {}
	
	public CreateTodoDto(Todo todo) {
		setId(todo.getId());
		setTodo(todo.getTodo());
		setData(todo.getDeadline());
	}
	
	public CreateTodoDto(Concluded todo) {
		setId(todo.getId());
		setTodo(todo.getTodo());
		setData(todo.getCompletedIn());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
