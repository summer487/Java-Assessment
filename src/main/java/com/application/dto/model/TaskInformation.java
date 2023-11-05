package com.application.dto.model;

public class TaskInformation {

	private String department;
	private String pendingTasks;
	private String ongoingTasks;
	private String completedTasks;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPendingTasks() {
		return pendingTasks;
	}

	public void setPendingTasks(String pendingTasks) {
		this.pendingTasks = pendingTasks;
	}

	public String getOngoingTasks() {
		return ongoingTasks;
	}

	public void setOngoingTasks(String ongoingTasks) {
		this.ongoingTasks = ongoingTasks;
	}

	public String getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(String completedTasks) {
		this.completedTasks = completedTasks;
	}

	

}
