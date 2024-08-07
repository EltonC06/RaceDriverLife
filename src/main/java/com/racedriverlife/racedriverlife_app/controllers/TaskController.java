package com.racedriverlife.racedriverlife_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.services.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	TaskService service;
	
	@GetMapping
	public List<Task> findAll() {
		List<Task> result = service.getAllTasks();
		return result;
	}
	
	@GetMapping("/{id}")
	public Task getTask(@PathVariable(name = "id") Long id) {
		Task task = service.getTaskById(id);
		return task;
	}	
	
	@PostMapping
	public Task insert(@RequestBody Task task) {
		service.save(task);
		return task;
	}
	
	
	
	
	
}
