package br.edu.ufersa.pw.todolist.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private UUID uuid;
	@Column(unique=true)
	private String email;
	private String senha;
	@OneToMany(mappedBy="user")
	private List<Todo> todoList = new ArrayList<Todo>();
	@OneToMany(mappedBy="user")
	private List<Concluded> concludedList = new ArrayList<Concluded>();
	
	public User() {
		uuid = UUID.randomUUID();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}

	public List<Concluded> getConcludedList() {
		return concludedList;
	}

	public void setConcludedList(List<Concluded> concludedList) {
		this.concludedList = concludedList;
	}
}
