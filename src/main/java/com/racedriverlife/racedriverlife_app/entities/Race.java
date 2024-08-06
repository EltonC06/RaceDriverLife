package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_race")
public class Race {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long raceId;
	private Integer doneTasks;
	private Integer taskQuantity;
	private Boolean isActive = false;
	
	@OneToMany(mappedBy = "race") // uma corrida pode estar associada a varias tarefas
	@JsonIgnore
	public List<Task> taskList; // program to interface
	// corrida não recebe id das tarefas (para não criar uma lista)
	

	public Race() {
		super();
		this.doneTasks = 0;
		this.taskQuantity = 0;
		this.setIsActive(true);
		this.taskList = new ArrayList<Task>();
	}


	public Long getRaceId() {
		return raceId;
	}


	public Integer getDoneTasks() {
		return doneTasks;
	}


	public void setDoneTasks(Integer doneTasks) {
		this.doneTasks = doneTasks;
	}


	public Integer getTaskQuantity() {
		return taskQuantity;
	}


	public void setTaskQuantity(Integer taskQuantity) {
		this.taskQuantity = taskQuantity;
	}


	public List<Task> getTaskList() {
		return taskList;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	
	public void removeTask(Integer taskId) {
		for (Task tk : taskList) {
			if (tk.getTaskId().equals(taskId)) {
				taskList.remove(tk);
			}
		}
	}
	
	public void changeTaskStatus(String taskStatus, Integer taskId) {
		taskList.get(taskId).setTaskStatus(taskStatus);

	}
	
	public Integer countCompletedTasks() {
		Integer completedTasks = 0;
		for (Task tk : taskList) {
			if (tk.getTaskStatus().equals(TaskStatus.DONE)) {
				completedTasks += 1;
			}
		}
		return completedTasks;
	}
	
	protected void resetTaskList() {
		taskList.clear();
	}



}
