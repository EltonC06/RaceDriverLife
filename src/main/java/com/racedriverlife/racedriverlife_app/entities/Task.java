package com.racedriverlife.racedriverlife_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Integer taskId;
	private String taskName;
	private TaskStatus taskStatus;
	
	@ManyToOne // muitas tarefas podem estar associada a uma unica corrida
	@JoinColumn(name = "race_id", nullable=false) // so pode ser criada se tem uma classe race associada
	@JsonIgnore
	private Race race;
	// na classe que não tem a lista
	
	public Task() {
		
	}


	public Task(String taskName, TaskStatus taskStatus, Race race) {
		super();
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.race = race;
	}


	public Integer getTaskId() {
		return taskId;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public TaskStatus getTaskStatus() {
		return taskStatus;
	}


	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
}
