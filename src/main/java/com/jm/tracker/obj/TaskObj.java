package com.jm.tracker.obj;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jm.tracker.interfaceUtil.CalculateTime;

@Entity
@Table(name = "TBL_TASK")
public class TaskObj implements CalculateTime {

	private int taskId;
	private String taskName;
	private String taskDesc;
	private String userId;
	private Date timeStarted;
	private Date timeFinished;
	private Set<RemarksObj> getRemarks = new HashSet<RemarksObj>();

	private TaskInfo taskInfo;
	private TaskObj parentTaskObj;

	private Set<TaskObj> childTaskSet = new HashSet<TaskObj>();
	// Add to DB later
	private Date targetDate;

	public TaskObj() {

	}

	// @JoinColumn(name = "taskInfoId")
	@OneToOne(mappedBy = "taskObj", cascade = CascadeType.ALL)

	public TaskInfo getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}

	public TaskObj(int taskId) {
		this.taskId = taskId;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
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

	@Column(name = "USER_ID", nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_TASK_REMARKS", joinColumns = { @JoinColumn(name = "TASK_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "REMARKS_ID") })
	public Set<RemarksObj> getGetRemarks() {
		return getRemarks;
	}

	public void setGetRemarks(Set<RemarksObj> getRemarks) {
		this.getRemarks = getRemarks;
	}

	public void addRemark(RemarksObj remarksObj) {
		this.getRemarks.add(remarksObj);
	}

	@Transient
	public long getRemainingTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PARENT_TASK")

	public TaskObj getParentTaskObj() {
		return this.parentTaskObj;
	}

	@OneToMany(mappedBy = "parentTaskObj")
	@JsonIgnore
	public Set<TaskObj> getChildTaskSet() {
		return childTaskSet;
	}

	public void setChildTaskSet(Set<TaskObj> childTaskSet) {
		this.childTaskSet = childTaskSet;
	}

	public void setParentTaskObj(TaskObj parentTaskObj) {
		this.parentTaskObj = parentTaskObj;
	}

	public boolean addChildTask(TaskObj childTask) {
		boolean isSuccess = false;

		if (childTask != null && !(this.taskId > 0 && this.equals(childTask))) {
			// childTask.setParentTaskObj(this);
			this.childTaskSet.add(childTask);
			isSuccess = true;
		}

		return isSuccess;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + taskId;
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// TaskObj other = (TaskObj) obj;
	// if (taskId != other.taskId)
	// return false;
	// return true;
	// }

}
