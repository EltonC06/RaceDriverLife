package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.DTOs.TaskDTO;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	TaskService service;
	
	@GetMapping
	public List<Task> findAll() {
		List<Task> result = service.getAllTasks();
		return result;
	}
	
	@GetMapping("/{id}")
	public Task findById(@PathVariable(name = "id") Long id) {
		Task task = service.getTaskById(id);
		return task;
	}	
	
	@PostMapping
	public Task insert(@RequestBody TaskDTO taskDTO) {
		return service.save(taskDTO);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public Task update(@PathVariable(name = "id") Long id, @RequestBody TaskDTO taskDTO) {
		
		Task taskUpdated = service.update(id, taskDTO);
		
		service.updateRaceData(taskDTO.getRaceId());
		
		return taskUpdated;
	}
	
	
}

// deletar OK

// fazer o race atualizar o numero de tarefas OK

// atualizar OK

// assim que atualizar a tarefa atualizar a race (DONE e PENDING) OK

// estou conseguindo adicionar remover e atualizar tarefas e tudo isso está em pura sincronia com atributos da classe Race 08/08/2024
