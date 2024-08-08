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
	
	public Task getTaskById(Long id) {
		return this.repository.findById(id).get();
	}
		
	public Task save(TaskDTO taskDTO) {		
		Task convertedTask = convertDTOtoEntity(taskDTO);
		
		this.repository.save(convertedTask);
		
		Race raceUpdated = updateRaceData(taskDTO.getRaceId());
		
		raceService.update(taskDTO.getRaceId(), raceUpdated);
		
		return convertedTask;
	}
	

	public void delete(Long id) {
		Task task = this.getTaskById(id);
		
		Long raceId = task.getRace().getRaceId();
		
		repository.deleteById(id);
		
		updateRaceData(raceId);
	}
	
	public Task update(Long id, TaskDTO taskDTO) { 
		Task entity = repository.getReferenceById(id);
		
		entity = updateData(entity, taskDTO);
		
		return this.repository.save(entity);
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
		Race savedRace = raceRepository.findById(id).get();
		
		savedRace.countTotalTasks();
		
		System.out.println("Corrida atualizada");
		return raceService.update(id, savedRace);
	}
}
