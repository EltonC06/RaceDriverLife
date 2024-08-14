package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

import jakarta.persistence.CascadeType;
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
	private Integer missedTasks;
	private Integer taskQuantity;
	private Boolean isActive = false;

	@OneToMany(mappedBy = "race", cascade = CascadeType.ALL) // uma corrida pode estar associada a varias tarefas
	@JsonIgnore
	public List<Task> taskList; 

	public Race() {
		super();
		this.setMissedTasks(0);
		this.doneTasks = 0;
		this.taskQuantity = 0;
		this.setIsActive(true);
		this.taskList = new ArrayList<Task>();
	}

	public Long getRaceId() {
		return raceId;
	}

	public Integer getMissedTasks() {
		return missedTasks;
	}

	public void setMissedTasks(Integer missedTasks) {
		this.missedTasks = missedTasks;
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
		this.countTotalTasks();
	}

	public void removeTask(Long taskId) {
		for (Task tk : taskList) {
			if (tk.getTaskId().equals(taskId)) {
				taskList.remove(tk);
			}
		}
	}
	
	public boolean isFinished() {
		Integer totalDoneAndMissedTasks = this.getDoneTasks() + this.getMissedTasks();

		if (this.getTaskQuantity() != 0 && totalDoneAndMissedTasks.equals(this.getTaskQuantity())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetTaskList() {
		taskList.clear();
	}

	public void countTotalTasks() {
		Integer totalTasks = taskList.size();
		Integer completedTasks = countCompletedTasks();
		Integer missedTasks = countMissedTasks();

		this.doneTasks = completedTasks;
		this.taskQuantity = totalTasks;
		this.missedTasks = missedTasks;

		if (this.taskQuantity.equals(0)) {
			this.isActive = false;
		} else {
			this.isActive = true;
		}
	}
	
	protected Integer countCompletedTasks() {
		Integer completedTasks = 0;
		for (Task tk : taskList) {
			if (tk.getTaskStatus().equals(TaskStatus.DONE.toString())) {
				completedTasks += 1;
			}
		}
		return completedTasks;
	}
	
	private Integer countMissedTasks() {
		Integer missedTasks = 0;
		for (Task tk : taskList) {
			if (tk.getTaskStatus().equals(TaskStatus.MISSED.toString())) {
				missedTasks += 1;
			}
		}
		return missedTasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(raceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		return Objects.equals(raceId, other.raceId);
	}
}
