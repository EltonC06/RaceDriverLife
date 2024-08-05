package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_race_central")
public class RaceCentral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long centralId;
	private Integer racesWon = 0;
	private Integer racesDisputed = 0;
	
	@OneToOne
	@JoinColumn(name = "race_id")
	private Race race;
	
	public RaceCentral() {
		
	}

	public RaceCentral(Long centralId, Integer racesWon, Integer racesDisputed) {
		super();
		this.centralId = centralId;
		this.racesWon = racesWon;
		this.racesDisputed = racesDisputed;
	}

	public Long getCentralId() {
		return centralId;
	}


	public Integer getRacesWon() {
		return racesWon;
	}

	public void setRacesWon(Integer racesWon) {
		this.racesWon = racesWon;
	}

	public Integer getRacesDisputed() {
		return racesDisputed;
	}

	public void setRacesDisputed(Integer racesDisputed) {
		this.racesDisputed = racesDisputed;
	}
	
	
	public void createRace(ArrayList<String> tasksName) {
		endRace();
		for (String taskName : tasksName) {
			race.addTask(new Task(null, taskName, TaskStatus.PENDING)); // tenho que permitir o banco de dados gerar o id da tarefa automaticamente de alguma forma
		}
		race.setIsActive(true);
	}
	
	public void endRace() {
		countPoints();
		resetRace();
	}
	
	private void countPoints() {
		this.racesDisputed += 1;
		if (race.getTaskQuantity().equals(race.countCompletedTasks())) {
			this.racesWon += 1;
		}
		else {
			
		}
	}
	
	private void resetRace() {
		race.setDoneTasks(0);
		race.setTaskQuantity(0);
		race.setIsActive(false);
		race.resetTaskList();

	}

	
	
	
}
