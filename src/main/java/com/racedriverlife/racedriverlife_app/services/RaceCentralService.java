package com.racedriverlife.racedriverlife_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racedriverlife.racedriverlife_app.DTOs.RaceCentralDTO;
import com.racedriverlife.racedriverlife_app.entities.Race;
import com.racedriverlife.racedriverlife_app.entities.RaceCentral;
import com.racedriverlife.racedriverlife_app.repositories.RaceCentralRepository;
import com.racedriverlife.racedriverlife_app.services.exceptions.DatabaseException;
import com.racedriverlife.racedriverlife_app.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RaceCentralService {

	@Autowired
	private RaceCentralRepository repository;

	@Autowired
	private RaceService raceService;

	@Autowired
	private TaskService taskService;

	public List<RaceCentral> getAllCentral() {
		return this.repository.findAll();
	}

	public RaceCentral getCentralById(Long id) {
		Optional<RaceCentral> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public RaceCentral save(RaceCentral raceCentral) {
		return this.repository.save(raceCentral);
	}

	public RaceCentral manualUpdate(Long id, RaceCentralDTO raceCentralDTO) {
		try {
			RaceCentral entity = repository.getReferenceById(id);

			RaceCentral raceCentralConverted = convertDTOtoEntity(raceCentralDTO);

			entity = updateData(entity, raceCentralConverted);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public RaceCentral autoUpdate(Long id) {
		try {
			RaceCentral entity = repository.getReferenceById(id);

			checkRaceStatus(entity.getCentralId());

			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private RaceCentral convertDTOtoEntity(RaceCentralDTO raceCentralDTO) {
		RaceCentral raceCentral = new RaceCentral();

		raceCentral.setRacesDisputed(raceCentralDTO.getRacesDisputed());
		raceCentral.setRacesWon(raceCentralDTO.getRacesWon());

		return raceCentral;
	}

	public void delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new DatabaseException("Resource not found. Id " + id);
		}
	}

	private void resetTasksAndRace(Long id) {
		taskService.deleteRaceBasedTasks(id);
	}

	private RaceCentral updateData(RaceCentral entity, RaceCentral raceCentral) {
		entity.setRacesDisputed(raceCentral.getRacesDisputed());
		entity.setRacesWon(raceCentral.getRacesWon());

		return entity;
	}

	private void checkRaceStatus(Long id) {
		RaceCentral raceCentral = getCentralById(id);
		Race race = raceService.getRaceById(id);
		if (race.isFinished()) {

			raceCentral.setRacesDisputed(raceCentral.getRacesDisputed() + 1);

			if (race.getDoneTasks().equals(race.getTaskQuantity())) {
				raceCentral.setRacesWon(raceCentral.getRacesWon() + 1);
			}
			resetTasksAndRace(id);
			this.save(raceCentral);
		} else {
			this.save(raceCentral);
		}
	}
}
