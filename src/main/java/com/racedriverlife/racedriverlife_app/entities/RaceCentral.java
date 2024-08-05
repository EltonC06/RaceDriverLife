package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

import jakarta.persistence.CascadeType;
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
	
	@OneToOne(cascade = CascadeType.ALL) // a classe Race não pode existir sem essa
	@JoinColumn(name = "race_id", nullable = false)
	private Race race;
	
	
	
	public RaceCentral() {
		
	}

	public RaceCentral(Integer racesWon, Integer racesDisputed, Race race) {
		super();
		this.racesWon = racesWon;
		this.racesDisputed = racesDisputed;
		this.race = race;
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
	
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}
	
	

	public void createRace(ArrayList<String> tasksName) {
		endRace();
		for (String taskName : tasksName) {
			race.addTask(new Task(taskName, TaskStatus.PENDING, race)); // tenho que permitir o banco de dados gerar o id da tarefa automaticamente de alguma forma
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
