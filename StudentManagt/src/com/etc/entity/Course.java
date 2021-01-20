package com.etc.entity;

public class Course {
	private int course_no;
	private String course_name;
	private float course_score;
	public int getCourse_no() {
		return course_no;
	}
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public float getCourse_score() {
		return course_score;
	}
	public void setCourse_score(float course_score) {
		this.course_score = course_score;
	}
	public Course(int course_no, String course_name, float course_score) {
		super();
		this.course_no = course_no;
		this.course_name = course_name;
		this.course_score = course_score;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [course_no=" + course_no + ", course_name=" + course_name + ", course_score=" + course_score
				+ "]";
	}
	
}
