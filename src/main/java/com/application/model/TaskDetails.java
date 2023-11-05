package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_details")
public class TaskDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private int pendingTask;
	private int ongoingTask;
	private int completedTask;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPendingTask() {
		return pendingTask;
	}
	public void setPendingTask(int pendingTask) {
		this.pendingTask = pendingTask;
	}
	public int getOngoingTask() {
		return ongoingTask;
	}
	public void setOngoingTask(int ongoingTask) {
		this.ongoingTask = ongoingTask;
	}
	public int getCompletedTask() {
		return completedTask;
	}
	public void setCompletedTask(int completedTask) {
		this.completedTask = completedTask;
	}
	
	

}
