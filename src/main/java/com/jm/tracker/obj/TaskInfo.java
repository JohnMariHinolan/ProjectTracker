package com.jm.tracker.obj;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBL_TASK_INFO")
public class TaskInfo {

	private int taskInfoId;

	private int likes = 0;
	private int dislikes = 0;
	private int views = 0;
	private List<Tags> tag;

	private TaskObj taskObj;

	@Id
	@Column(name = "task_info_id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")

	public int getTaskInfoId() {
		return taskInfoId;
	}

	public void setTaskInfoId(int taskInfoId) {
		this.taskInfoId = taskInfoId;
	}

	@Column(name = "LIKES")
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Column(name = "DISLIKES")
	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Column(name = "VIEWS")
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_TASK_TAG_REL", joinColumns = { @JoinColumn(name = "task_id") }, inverseJoinColumns = {
			@JoinColumn(name = "TAG_ID") })
	public List<Tags> getTags() {
		return tag;
	}

	public void setTags(List<Tags> tags) {
		this.tag = tags;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TASK_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@JsonIgnore
	public TaskObj getTaskObj() {
		return taskObj;
	}

	public void setTaskObj(TaskObj taskObj) {
		this.taskObj = taskObj;
	}

}
