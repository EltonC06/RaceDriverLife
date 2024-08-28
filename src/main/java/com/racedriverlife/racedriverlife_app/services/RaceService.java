package com.racedriverlife.racedriverlife_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.RaceDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.Task;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;
import com.racedriverlife.racedriverlife_app.repositories.RaceRepository;
import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RaceService {

	@Autowired
	private RaceRepository repository;

	public List<Race> getAllRaces() {
		List<Race> raceList = this.repository.findAll();

		return raceList;
	}

	public Race getRaceById(Long id) {
		Optional<Race> obj = repository.findById(id);

		obj.orElseThrow(() -> new ResourceNotFoundException(id));

		Race race = obj.get();

		return race;
	}

	public Race save(Race race) {
		return this.repository.save(race);
	}

	public Race update(Long id, RaceDTO raceDTO) {
		try {
			Race entity = repository.getReferenceById(id);

			Race race = convertDTOtoEntity(raceDTO);

			entity = updateData(entity, race);

			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new DatabaseException("Resource not found. Id " + id);
		}
	}

	protected RaceDTO convertEntitytoDTO(Race race) {
		RaceDTO raceDTO = new RaceDTO();

		raceDTO.setActive(race.getIsActive());
		raceDTO.setDoneTasks(race.getDoneTasks());
		raceDTO.setTaskQuantity(race.getTaskQuantity());

		return raceDTO;
	}

	private Race convertDTOtoEntity(RaceDTO raceDTO) {
		Race race = new Race();

		race.setDoneTasks(raceDTO.getDoneTasks());
		race.setTaskQuantity(raceDTO.getTaskQuantity());
		race.setIsActive(raceDTO.isActive());

		return race;
	}

	private Race updateData(Race entity, Race race) {
		entity.setDoneTasks(race.getDoneTasks());
		entity.setIsActive(race.getIsActive());
		entity.setTaskQuantity(race.getTaskQuantity());
		countTotalTasks(entity);
		return entity;
	}

	private void countTotalTasks(Race race) {
		Integer totalTasks = race.taskList.size();
		Integer completedTasks = countCompletedTasks(race);
		Integer missedTasks = countMissedTasks(race);

		race.setDoneTasks(completedTasks);
		race.setTaskQuantity(totalTasks);
		race.setMissedTasks(missedTasks);

		if (race.getTaskQuantity().equals(0)) {
			race.setIsActive(false);
		} else {
			race.setIsActive(true);
		}
	}

	private Integer countCompletedTasks(Race race) {
		Integer completedTasks = 0;
		for (Task tk : race.getTaskList()) {
			if (tk.getTaskStatus().equals(TaskStatus.DONE.toString())) {
				completedTasks += 1;
			}
		}
		return completedTasks;
	}

	private Integer countMissedTasks(Race race) {
		Integer missedTasks = 0;
		for (Task tk : race.getTaskList()) {
			if (tk.getTaskStatus().equals(TaskStatus.MISSED.toString())) {
				missedTasks += 1;
			}
		}
		return missedTasks;
	}
}
