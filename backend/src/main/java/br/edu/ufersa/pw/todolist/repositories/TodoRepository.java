package br.edu.ufersa.pw.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufersa.pw.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
