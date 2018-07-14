package com.jm.tracker.obj;

import java.util.Date;

public class TaskObj {

	private int taskId;
	private String taskName;
	private String taskDesc;
	private Date timeStarted;
	private Date timeFinished;
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
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTimeStarted() {
		return timeStarted;
	}
	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}
	public Date getTimeFinished() {
		return timeFinished;
	}
	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}
	
}
