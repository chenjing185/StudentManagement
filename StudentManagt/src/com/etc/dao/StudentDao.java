package com.etc.dao;

import java.util.List;

import com.etc.entity.Student;

public interface StudentDao {
	/**
	 * 登录
	 */
	Student login(String no,String password);
	/**
	 * 查询全部学生
	 */
	List<Student> query();
	/**
	 * 按照学生学号查询
	 */
	Student querysNo(String no);
	/**
	 * 按照学生姓名模糊查询
	 */
	List<Student> queryName(String key);
	/**
	 * 添加学生
	 */
	boolean addStu(Student student);
	/**
	 * 修改学生
	 */
	boolean update(Student student);
	/**
	 * 修改学生状态
	 */
	boolean updateStatus(String no);
}
