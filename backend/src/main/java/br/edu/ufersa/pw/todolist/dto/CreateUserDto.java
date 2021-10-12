package br.edu.ufersa.pw.todolist.dto;

import java.util.UUID;

public class CreateUserDto {
	
	private String email;
	private String senha;
	private UUID uuid;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
