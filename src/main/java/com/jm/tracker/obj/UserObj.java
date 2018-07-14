package com.jm.tracker.obj;


import java.util.List;

public class UserObj {

	private int userId;
	private String username;
	private String password;
	
	
	List<TaskObj> tasks;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<TaskObj> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskObj> tasks) {
		this.tasks = tasks;
	}

	
}
