package com.jm.tracker.obj;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.jm.tracker.interfaceUtil.CalculateTime;


@Entity
@Table( name = "TBL_TASK" )
public class TaskObj implements CalculateTime {

	private int taskId;
	private String taskName;
	private String taskDesc;
	private String userId;
	private Date timeStarted;
	private Date timeFinished;
	// Add to DB later
	private Date targetDate;
	
	// not in DB
	private List<TaskObj> tasks;

	public TaskObj() {}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "TASK_ID")
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	@Column(name = "TASK_NAME")
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	@Column(name = "TASK_DESC")
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	@Column(name = "TIME_STARTED")
	public Date getTimeStarted() {
		return timeStarted;
	}
	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}
	
	@Column(name = "TIME_FINISHED")
	public Date getTimeFinished() {
		return timeFinished;
	}
	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}
	@Transient
	public List<TaskObj> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskObj> tasks) {
		this.tasks = tasks;
	}
	
	@Column(name = "USER_ID" , nullable = false)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}



	@Transient
	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	
@Transient
	public long getRemainingTime() {
		// TODO Auto-generated method stub
		return 0;
	}
}
