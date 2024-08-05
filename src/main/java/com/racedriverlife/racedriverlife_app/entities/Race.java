package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

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
	private Integer doneTasks = 0;
	private Integer taskQuantity = 0;
	private Boolean isActive = false;

	@OneToMany(mappedBy = "race") // uma corrida pode estar associada a varias tarefas
	// mapear e botar o nome de quem está mapeando essa classe
	public ArrayList<Task> taskList = new ArrayList<Task>();
	// corrida não recebe id das tarefas (para não criar uma lista)
	
	public Race() {
		
	}

	
	public Race(Integer doneTasks, Integer taskQuantity) {
		super();
		this.doneTasks = doneTasks;
		this.taskQuantity = taskQuantity;
		this.setIsActive(true);
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


	public ArrayList<Task> getTaskList() {
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
	
	public void changeTaskStatus(TaskStatus taskStatus, Integer taskId) {
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
		setIsActive(false);
	}



}
