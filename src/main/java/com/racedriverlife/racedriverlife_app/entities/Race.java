package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

public class Race {
	
	private Long raceId;
	private Integer doneTasks = 0;
	private Integer taskQuantity = 0;
	private Boolean isActive = false;
	
	private RaceCentral raceCentral;
	public ArrayList<Task> taskList = new ArrayList<Task>();
 	
	public Race() {
		
	}

	
	public Race(Long raceId, Integer doneTasks, Integer taskQuantity) {
		super();
		this.raceId = raceId;
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
	
	
	public RaceCentral getRaceCentral() {
		return raceCentral;
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
