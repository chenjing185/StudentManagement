package com.etc.dao;

import java.util.List;

import com.etc.entity.StuScore;

public interface StudentScoreDao {
	/**
	 * 通过学号查询学生课程成绩
	 * @param stuNo
	 * @return
	 */
	List<StuScore> querystu(String stuNo);
	/**
	 * 查询所有学生的成绩
	 */
	List<StuScore> querystuAll();
	/**
	 * 添加课程成绩
	 */
	boolean insertCourse(String stuNo, int course_no, float score);
	/**
	 * 按照不同条件查询
	 * 学号 课程名 学号+课程名
	 */
	List<StuScore> queryScore(String stuNo,String couName);
	/**
	 * 修改成绩
	 */
	boolean updateCourse(String stuNo,int course_no,float score);
	/**
	 * 删除成绩
	 */
	boolean deleteCourse(String stuNo,int course_no);
}
