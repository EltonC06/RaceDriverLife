package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> getAllTasks() {
		return this.repository.findAll();
	}
	@Transactional
	public Task getTaskById(Long id) {
		return this.repository.findById(id).get();
	}
		
	public Task save(Task task) {
		return this.repository.save(task);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Task update(Long id, Task task) {
		Task entity = repository.getReferenceById(id);
		entity = updateData(entity, task);
		return repository.save(entity);
	}
	
	private Task updateData(Task entity, Task task) {
		entity.setTaskName(task.getTaskName());
		entity.setTaskStatus(task.getTaskStatus());
		return entity;
	}
}
