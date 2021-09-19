package br.edu.ufersa.pw.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufersa.pw.todolist.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
