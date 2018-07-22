package com.jm.tracker.obj;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "TBL_USER" )
public class UserObj {

	
	private int userId;
	private String username;
	private String password;
	
	
	private List<TaskObj> tasks;
	private Set<RemarksObj> getRemarks = new HashSet<RemarksObj>();
	
	public UserObj() {}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "USER_PWD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public List<TaskObj> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskObj> tasks) {
		this.tasks = tasks;
	}
	

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_USER_REMARKS", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "REMARKS_ID") })
	public Set<RemarksObj> getGetRemarks() {
		return getRemarks;
	}

	public void setGetRemarks(Set<RemarksObj> getRemarks) {
		this.getRemarks = getRemarks;
	}
	public void addRemark(RemarksObj remarksObj) {
		this.getRemarks.add(remarksObj);
	}
	
}
