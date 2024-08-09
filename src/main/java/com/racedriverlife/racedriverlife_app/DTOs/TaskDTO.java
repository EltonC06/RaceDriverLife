package com.racedriverlife.racedriverlife_app.DTOs;

import jakarta.validation.constraints.NotBlank;

public class TaskDTO {
	
	@NotBlank(message = "Taskname can't be empty")
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
