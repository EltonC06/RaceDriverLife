package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	/*
	public Task getTaskById(Long id) {
		return taskRepository.findById(id);
	}
	*/
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
}
