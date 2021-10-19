package br.edu.ufersa.pw.todolist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ufersa.pw.todolist.entities.Todo;

@RepositoryRestResource
public interface TodoRepository extends JpaRepository<Todo,Long>{
	
	List<Todo> findByDeadline(@Param("deadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate deadline);
	
	@RestResource(exported = false)
	@Query(
			value = "SELECT t.id, t.id_user, t.todo, t.deadline FROM tb_todo t INNER JOIN tb_users user "
					+ "ON user.id=t.id_user AND user.email= :email",
					nativeQuery = true)
	List<Todo> findByUser(String email);
	
	@RestResource(exported = false)
	@Query(
			value = "SELECT t.id, t.id_user, t.todo, t.deadline FROM tb_todo t INNER JOIN tb_users user "
					+ "ON user.id=t.id_user AND user.email= :email AND t.deadline= :deadline",
					nativeQuery = true)
	List<Todo> findByUserAndDeadline(String email, LocalDate deadline);
	
}
