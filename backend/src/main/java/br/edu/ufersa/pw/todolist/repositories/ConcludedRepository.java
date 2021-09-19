package br.edu.ufersa.pw.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufersa.pw.todolist.entity.Concluded;

public interface ConcludedRepository extends JpaRepository<Concluded,Long>{

}
