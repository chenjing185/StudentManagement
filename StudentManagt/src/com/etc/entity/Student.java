package com.etc.entity;

public class Student {
	private String student_no;
	private String student_name;
	private String gender;
	private String birth;
	private String password;
	private int status;
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Student(String student_no, String student_name, String gender, String birth, String password, int status) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.gender = gender;
		this.birth = birth;
		this.password = password;
		this.status = status;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [student_no=" + student_no + ", student_name=" + student_name + ", gender=" + gender
				+ ", birth=" + birth + ", password=" + password + ", status=" + status + "]";
	}
	
}
