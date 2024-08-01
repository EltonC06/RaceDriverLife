package com.racedriverlife.racedriverlife_app.entities;

import java.util.ArrayList;

import com.racedriverlife.racedriverlife_app.entities.enums.TaskStatus;

public class Race {
	
	// essa classe adiciona, remove, gerencia status das tarefas
	
	private Long raceId;
	
	private ArrayList<Task> listOfTasks = new ArrayList<>(); 
	
	
	public Race() {
		
	}


	public Race(ArrayList<Task> listOfTasks) {
		super();
		this.listOfTasks = listOfTasks;
	}


	
	public ArrayList<Task> getListOfTasks() {
		return listOfTasks;
	}
	
	public Integer getTotalTasks() {
		return listOfTasks.size();
	}
	
	
	public Integer getDoneTasks() {
		Integer doneTasks = 0;
		for (Task tk : listOfTasks) {
			if (tk.getTaskStatus().equals(TaskStatus.DONE)) {
				doneTasks += 1;
			}
			else {
			}
		}
		
		return doneTasks;
	}
	
	
	public void addTask(Task task) {
		listOfTasks.add(task);
	}
	
	public void removeTask(int taskId) {
		listOfTasks.remove(taskId);
	}
	
	public void clearList() {
		listOfTasks.clear();
	}
	
	
	public void changeTaskStatus(int taskId, TaskStatus taskStatus) {
		listOfTasks.get(taskId).setTaskStatus(taskStatus);
	}
	
	

}
