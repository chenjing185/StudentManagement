package com.etc.entity;

public class StuScore {
	private String student_no;//学生编号
	private String student_name;//学生姓名
	private String gender;//性别
	private String birth;//出生日期
	private String password;//密码
	private int status;//状态
	private int score_id;// 成绩编号
	private int course_no;//课程号
	private float score;//成绩
	private String pubDate;//录入时间
	private String course_name;//课程名
	private float course_score;//学分
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
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
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
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
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
	public StuScore(String student_no, String student_name, String gender, String birth, String password, int status,
			int score_id, int course_no, float score, String pubDate, String course_name, float course_score) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.gender = gender;
		this.birth = birth;
		this.password = password;
		this.status = status;
		this.score_id = score_id;
		this.course_no = course_no;
		this.score = score;
		this.pubDate = pubDate;
		this.course_name = course_name;
		this.course_score = course_score;
	}
	public StuScore(float score, String course_name, float course_score) {
		super();
		this.score = score;
		this.course_name = course_name;
		this.course_score = course_score;
	}
	
	public StuScore(String student_no, String student_name, int score_id, float score, String course_name) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.score_id = score_id;
		this.score = score;
		this.course_name = course_name;
	}
	public StuScore() {
		super();
	}
	@Override
	public String toString() {
		return "StuScore [student_no=" + student_no + ", student_name=" + student_name + ", gender=" + gender
				+ ", birth=" + birth + ", password=" + password + ", status=" + status + ", score_id=" + score_id
				+ ", course_no=" + course_no + ", score=" + score + ", pubDate=" + pubDate + ", course_name="
				+ course_name + ", course_score=" + course_score + "]";
	}
	
}
