package com.racedriverlife.racedriverlife_app.entities;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

public class Task {
	
	private Integer taskId;
	private String taskName;
	private TaskStatus taskStatus;
	
	
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
