package com.racedriverlife.racedriverlife_app.entities;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // é uma entidade (tabela)
@Table(name = "tb_task") // nome da tabela
public class Task {
	
	@Id // é uma chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gerar id automatico
	private Long taskId;
	private String taskName;
	
	private String taskStatus;
	
	// muitas tarefas podem estar associada a uma unica corrida
	@ManyToOne
	@JoinColumn(name = "race_id", referencedColumnName = "raceId") // so pode ser criada se tem uma classe race associada
	private Race race;
	
	public Task() {
		
	}


	public Task(String taskName, Race race) {
		super();
		this.taskName = taskName;
		this.taskStatus = TaskStatus.PENDING.name();
		this.race = race;
	}


	public Long getTaskId() {
		return taskId;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}


	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
		this.race = race;
	}
	
	
}
