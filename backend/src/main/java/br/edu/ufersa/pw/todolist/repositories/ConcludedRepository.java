package br.edu.ufersa.pw.todolist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import br.edu.ufersa.pw.todolist.entities.Concluded;

public interface ConcludedRepository extends JpaRepository<Concluded,Long>{
	
	@RestResource(exported = false)
	@Query(
			value = "SELECT t.id, t.id_user, t.todo, t.completed_in FROM tb_concluded t "
					+ "INNER JOIN tb_users user ON user.id=t.id_user AND user.email= :email",
					nativeQuery = true)
	List<Concluded> findByUser(String email);
	
	@RestResource(exported = false)
	@Query(
			value = "SELECT t.id, t.id_user, t.todo, t.completed_in FROM tb_concluded t "
					+ "INNER JOIN tb_users user ON user.id=t.id_user AND user.email= :email "
					+ "AND t.deadline= :deadline",
					nativeQuery = true)
	List<Concluded> findByUserAndDeadline(String email, LocalDate deadline);
}
