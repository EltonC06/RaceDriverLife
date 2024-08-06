package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	

	public List<Task> getAllTasks() {
		return this.taskRepository.findAll();
	}
	
	public Task getTaskById(Long id) {
		return this.taskRepository.findById(id).get();
	}
		
	public Task saveTask(Task task) {
		return this.taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
