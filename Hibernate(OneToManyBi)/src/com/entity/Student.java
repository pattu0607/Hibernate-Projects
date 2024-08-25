package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student_details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String sname;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Subject> listofsubject = new ArrayList<Subject>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Subject> getListofsubject() {
		return listofsubject;
	}

	public void setListofsubject(List<Subject> listofsubject) {
		this.listofsubject = listofsubject;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", listofsubject=" + listofsubject + "]";
	}
	
	
}
