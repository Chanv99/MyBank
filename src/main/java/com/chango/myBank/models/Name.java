package com.chango.myBank.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Name {
	@Id
	private int id;
	private String fname;
	private String mname;
	private String lname;
	
	public Name() {
		super();
	}
	
	public Name(String fname, String mname, String lname) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}
	
	public Name(int id, String fname, String mname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Name [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
