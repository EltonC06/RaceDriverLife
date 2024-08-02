package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

public class Race {
	
	private Long raceId;
	private Integer doneTasks = 0;
	private Integer taskQuantity = 0;
	// private Boolean raceStatus = true ou false para saber se a corrida ta correndo ou n
	
	private RaceCentral raceCentral;
	public ArrayList<Task> taskList = new ArrayList<Task>();
 	
	
	


	public Race() {
		
	}

	
	public Race(Long raceId, Integer doneTasks, Integer taskQuantity) {
		super();
		this.raceId = raceId;
		this.doneTasks = doneTasks;
		this.taskQuantity = taskQuantity;
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
	
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	
	public void removeTask(Long taskId) {
		for (Task tk : taskList) {
			if (tk.getTaskId().equals(taskId)) {
				taskList.remove(tk);
			}
		}
	}
	
		
}
