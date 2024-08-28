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

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	private TaskService service;

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

	@GetMapping("/racebased/{id}")
	public List<Task> findRaceBasedTasks(@PathVariable(name = "id") Long id) {
		List<Task> result = service.getRaceBasedTask(id);
		return result;
	}

	@PostMapping
	public Task insert(@Valid @RequestBody TaskDTO taskDTO) {
		return service.save(taskDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}

	@DeleteMapping("/racebased/{id}")
	public void deleteRaceBasedTasks(@PathVariable(name = "id") Long id) {
		service.deleteRaceBasedTasks(id);
	}

	@PutMapping("/{id}")
	public Task update(@Valid @PathVariable(name = "id") Long id, @Valid @RequestBody TaskDTO taskDTO) {
		Task taskUpdated = service.update(id, taskDTO);
		return taskUpdated;
	}
}
