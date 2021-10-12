package br.edu.ufersa.pw.todolist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ufersa.pw.todolist.entities.Todo;

@RepositoryRestResource
public interface TodoRepository extends JpaRepository<Todo,Long>{
	
	List<Todo> findByDeadline(@Param("deadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline);
}
