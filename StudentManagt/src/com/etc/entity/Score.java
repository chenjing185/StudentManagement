package com.etc.entity;

public class Score {
	private int score_id;
	private String student_no;
	private int course_no;
	private float score;
	private String pub_date;
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public int getCourse_no() {
		return course_no;
	}
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public Score(int score_id, String student_no, int course_no, float score, String pub_date) {
		super();
		this.score_id = score_id;
		this.student_no = student_no;
		this.course_no = course_no;
		this.score = score;
		this.pub_date = pub_date;
	}
	public Score() {
		super();
	}
	@Override
	public String toString() {
		return "Score [score_id=" + score_id + ", student_no=" + student_no + ", course_no=" + course_no + ", score="
				+ score + ", pub_date=" + pub_date + "]";
	}
	
}
