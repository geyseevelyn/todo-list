package br.edu.ufersa.pw.todolist.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufersa.pw.todolist.dto.CreateTodoDto;
import br.edu.ufersa.pw.todolist.dto.TodoDto;
import br.edu.ufersa.pw.todolist.entities.Concluded;
import br.edu.ufersa.pw.todolist.entities.Todo;
import br.edu.ufersa.pw.todolist.repositories.ConcludedRepository;
import br.edu.ufersa.pw.todolist.repositories.TodoRepository;
import br.edu.ufersa.pw.todolist.repositories.UserRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ConcludedRepository concRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public List<TodoDto> findByUser(String email) {
		List<Todo> todos = repo.findByUser(email);
		return todos.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public List<TodoDto> findByUserAndDeadline(String email, LocalDate deadline) {
		List<Todo> todos = repo.findByUserAndDeadline(email, deadline);
		return todos.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public CreateTodoDto save(CreateTodoDto dto) {
		Todo todo = new Todo();
		todo.setTodo(dto.getTodo());
		todo.setDeadline(dto.getData());
		todo.setUser(userRepo.findByEmail(dto.getEmail()));
		todo = repo.save(todo);
		
		CreateTodoDto retorno = new CreateTodoDto();
		retorno.setId(todo.getId());
		retorno.setTodo(todo.getTodo());
		retorno.setData(todo.getDeadline());
		retorno.setEmail(dto.getEmail());
		
		return retorno;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public CreateTodoDto update(CreateTodoDto dto) {
		Todo todo = new Todo();
		todo.setTodo(dto.getTodo());
		todo.setDeadline(dto.getData());
		todo.setUser(userRepo.findByEmail(dto.getEmail()));
		todo.setId(dto.getId());
		todo = repo.save(todo);
		
		CreateTodoDto retorno = new CreateTodoDto();
		retorno.setId(todo.getId());
		retorno.setTodo(todo.getTodo());
		retorno.setData(todo.getDeadline());
		retorno.setEmail(dto.getEmail());
		
		return retorno;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(TodoDto dto) {
		Todo todo = repo.getById(dto.getId());
		Concluded conc = mapper.map(todo, Concluded.class);
		conc.setCompletedIn(LocalDate.now());
		concRepo.save(conc); //coloca na lista de concluídos
		repo.delete(todo);
	}
}
