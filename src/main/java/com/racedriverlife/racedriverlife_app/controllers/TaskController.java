package com.racedriverlife.racedriverlife_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.services.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/task/{id}")
	@ResponseBody
	public Task getTask(@PathVariable(name = "id") Long id) {
		Task task = taskService.getTaskById(id);
		return task;
	}
		
}
