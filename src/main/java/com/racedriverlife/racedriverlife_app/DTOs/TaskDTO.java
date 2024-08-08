package com.racedriverlife.racedriverlife_app.DTOs;

public class TaskDTO {
	
	
	private String taskName;
	private Long raceId;
	private String taskStatus;
	
	public TaskDTO() {
		
	}

	public TaskDTO(String taskName, Long raceId, String taskStatus) {
		super();
		this.taskName = taskName;
		this.raceId = raceId;
		this.setTaskStatus(taskStatus);
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
}
