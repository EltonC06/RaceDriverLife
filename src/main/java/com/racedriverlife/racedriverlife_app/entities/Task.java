package com.racedriverlife.racedriverlife_app.entities;

import java.util.Objects;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

public class Task {
	
	private int taskId;
	private String taskName;
	
	private TaskStatus taskStatus;
	
	
	public Task() {
		
	}


	public Task(int taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = TaskStatus.PENDING; // tarefa começa como pendente
	}


	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
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


	@Override
	public int hashCode() {
		return Objects.hash(taskId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(taskId, other.taskId);
	}

}
