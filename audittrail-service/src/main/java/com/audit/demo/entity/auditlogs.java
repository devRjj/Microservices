package com.audit.demo.entity;

import jakarta.persistence.Id;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity

public class auditlogs {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
	
	private int Id;
	private long User_Id;
	private String Action;
	private String Service;
	private LocalDate TimeStamp;
	private String Ip_Add;
	private String Old_value;
	private String New_value;
	
	
	public auditlogs() {
		super();
		// TODO Auto-generated constructor stub
	}


	public auditlogs(int id, long user_Id, String action, String service, LocalDate timeStamp, String ip_Add,
			String old_value, String new_value) {
		super();
		Id = id;
		User_Id = user_Id;
		Action = action;
		Service = service;
		TimeStamp = timeStamp;
		Ip_Add = ip_Add;
		Old_value = old_value;
		New_value = new_value;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public long getUser_Id() {
		return User_Id;
	}


	public void setUser_Id(long user_Id) {
		User_Id = user_Id;
	}


	public String getAction() {
		return Action;
	}


	public void setAction(String action) {
		Action = action;
	}


	public String getService() {
		return Service;
	}


	public void setService(String service) {
		Service = service;
	}


	public LocalDate getTimeStamp() {
		return TimeStamp;
	}


	public void setTimeStamp(LocalDate timeStamp) {
		TimeStamp = timeStamp;
	}


	public String getIp_Add() {
		return Ip_Add;
	}


	public void setIp_Add(String ip_Add) {
		Ip_Add = ip_Add;
	}


	public String getOld_value() {
		return Old_value;
	}


	public void setOld_value(String old_value) {
		Old_value = old_value;
	}


	public String getNew_value() {
		return New_value;
	}


	public void setNew_value(String new_value) {
		New_value = new_value;
	}
	
	
	
	
	
	
}
