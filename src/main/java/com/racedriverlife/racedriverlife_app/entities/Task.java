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
	private Integer taskId;
	private String taskName;
	private TaskStatus taskStatus;
	
	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race race;
	
	public Task() {
		
	}


	public Task(Integer taskId, String taskName, TaskStatus taskStatus) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
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
