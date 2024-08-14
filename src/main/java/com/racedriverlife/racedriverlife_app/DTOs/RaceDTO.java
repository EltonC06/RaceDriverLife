package com.racedriverlife.racedriverlife_app.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RaceDTO {

	@NotNull
	@Min(0)
	@Max(54)
	private Integer doneTasks;

	@NotNull
	@Min(0)
	@Max(54)
	private Integer taskQuantity;

	@NotNull
	private boolean isActive;

	public RaceDTO() {

	}

	public RaceDTO(Integer doneTasks, Integer taskQuantity, boolean isActive) {
		super();
		this.doneTasks = doneTasks;
		this.taskQuantity = taskQuantity;
		this.isActive = isActive;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
