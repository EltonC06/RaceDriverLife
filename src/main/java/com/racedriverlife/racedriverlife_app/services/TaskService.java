package com.racedriverlife.racedriverlife_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.TaskDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;
import com.racedriverlife.racedriverlife_app.repositories.TaskRepository;

import jakarta.transaction.Transactional;

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
	@Transactional
	public Task getTaskById(Long id) {
		return this.repository.findById(id).get();
	}
		
	public Task save(TaskDTO taskDTO) {		
		Task convertedTask = convertDTOtoEntity(taskDTO);
		
		this.repository.save(convertedTask);
		
		Race raceUpdated = updateRaceData(taskDTO);
		
		raceService.update(taskDTO.getRaceId(), raceUpdated);
		
		return convertedTask;
	}
	

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Task update(Long id, TaskDTO taskDTO) { 
		Task entity = repository.getReferenceById(id);
		
		Task task = convertDTOtoEntity(taskDTO);
		
		entity = updateData(entity, task);
		
		repository.save(entity);
		
		//Race raceUpdated = updateRaceData(taskDTO);
		
		//raceService.update(taskDTO.getRaceId(), raceUpdated);
		
		return entity;
	}
	
	private Task updateData(Task entity, Task task) {
		entity.setTaskName(task.getTaskName());
		entity.setTaskStatus(task.getTaskStatus());
		return entity;
	}
	
	private Task convertDTOtoEntity(TaskDTO taskDTO) {
		Task convertedTask = new Task();
		
		convertedTask.setTaskName(taskDTO.getTaskName());
		convertedTask.setRace(raceRepository.findById(taskDTO.getRaceId()).get()); // usei o id que é passado no DTO para achar a corrida
		
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
		
		 // reavaliar esse problema com o metodo update
		
		
		return convertedTask;
	}
	
	private Race updateRaceData(TaskDTO taskDTO) {
		Race savedRace = raceRepository.findById(taskDTO.getRaceId()).get();
		
		savedRace.countTotalTasks();
		
		return savedRace;
	}
}
