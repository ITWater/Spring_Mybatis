package com.sunhui.redis.test;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 6977402643848374753L;
	
	private long id ;
	private String userName;
	private String note ;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
