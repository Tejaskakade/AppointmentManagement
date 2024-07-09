package com.ams.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class AppManage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String userName;
	
	private String description;
	
	private Date targetDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public AppManage(long id, String userName, String description, Date targetDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
	}

	public AppManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppManage(String name, String desc, Date targetDate, boolean isDone) {
		this.userName = name;
		this.description = desc;
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "AppManage [id=" + id + ", userName=" + userName + ", description=" + description + ", targetDate="
				+ targetDate + "]";
	}
	
	

}
