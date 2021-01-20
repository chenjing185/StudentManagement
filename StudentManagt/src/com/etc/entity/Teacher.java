package com.etc.entity;

public class Teacher {
	private int teacher_id;
	private String teacher_no;
	private String teacher_name;
	private String password;
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_no() {
		return teacher_no;
	}
	public void setTeacher_no(String teacher_no) {
		this.teacher_no = teacher_no;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Teacher(int teacher_id, String teacher_no, String teacher_name, String password) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_no = teacher_no;
		this.teacher_name = teacher_name;
		this.password = password;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_no=" + teacher_no + ", teacher_name=" + teacher_name
				+ ", password=" + password + "]";
	}
	
}
