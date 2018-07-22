package com.jm.tracker.obj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TBL_REMARKS" )
public class RemarksObj {

	private int remarksId;
	private String remark;
	private int likes = 0;
	private int dislikes = 0;
	
	public RemarksObj() {}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "REMARKS_ID")
	public int getRemarksId() {
		return remarksId;
	}
	public void setRemarksId(int remarksId) {
		this.remarksId = remarksId;
	}
	@Column(name = "TASK_REMARKS")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "NUM_LIKES")
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Column(name = "NUM_DISLIKES")
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	
	
	
}
