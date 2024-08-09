package com.racedriverlife.racedriverlife_app.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.TaskDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;
import com.racedriverlife.racedriverlife_app.repositories.TaskRepository;
import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.RaceNotFoundException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private RaceRepository raceRepository;
	
	@Autowired
	private RaceService raceService;
	
	public List<Task> getAllTasks() {
		return this.repository.findAll();
	}
	
	public Task getTaskById(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) ); 
	}
		
	public Task save(TaskDTO taskDTO) {		
		try {
			Task convertedTask = convertDTOtoEntity(taskDTO);
			
			this.repository.save(convertedTask);
			
			Race raceUpdated = updateRaceData(taskDTO.getRaceId());
			
			raceService.update(taskDTO.getRaceId(), raceUpdated);
			
			return convertedTask;
		}
		catch (NoSuchElementException e) {
			throw new RaceNotFoundException(taskDTO.getRaceId());
		}
	}
	


	
	public Task update(Long id, TaskDTO taskDTO) { 
		
		
		try {
			Task entity = repository.getReferenceById(id);
			entity = updateData(entity, taskDTO);
			return this.repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void delete(Long id) {
		if (repository.existsById(id)) {
			Task task = this.getTaskById(id);
			
			Long raceId = task.getRace().getRaceId();
			
			repository.deleteById(id);
			
			updateRaceData(raceId);
		}
		else {
			throw new DatabaseException("Resource not found. Id " + id);
		}
	}
	
	private Task updateData(Task entity, TaskDTO task) {
		entity.setTaskName(task.getTaskName());
		entity.setTaskStatus(task.getTaskStatus());
		return entity;
	}
	
	private Task convertDTOtoEntity(TaskDTO taskDTO) {
		Task convertedTask = new Task();
		
		convertedTask.setTaskName(taskDTO.getTaskName());
		convertedTask.setRace(raceRepository.findById(taskDTO.getRaceId()).get());
		
		if (taskDTO.getTaskStatus().equals(null)) {
			convertedTask.setTaskStatus(TaskStatus.PENDING.toString());
		}
		else {
			if (taskDTO.getTaskStatus().equals(TaskStatus.DONE.toString())) {
				convertedTask.setTaskStatus(TaskStatus.DONE.toString());
			}
			else {
				convertedTask.setTaskStatus(TaskStatus.PENDING.toString());
			}
		}

		return convertedTask;
	}
	
	
	public Race updateRaceData(Long id) {
		try {
			Race savedRace = raceRepository.findById(id).get();
			
			savedRace.countTotalTasks();
			
			System.out.println("Corrida atualizada");
			return raceService.update(id, savedRace);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
