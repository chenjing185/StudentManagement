package com.etc.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.etc.dao.TeacherDaoImpl;
import com.etc.entity.Student;
import com.etc.entity.Teacher;

public class TestTeacher {
	TeacherDaoImpl dao= new TeacherDaoImpl();
	/**
	 * 教师登录
	 */
	@Test
	public void login() {
		Teacher teacher =dao.queryNoPswd("h1001", "123");
		if (teacher==null) {
			System.out.println("登录失败");
		} else {
			System.out.println(teacher);
		}
	}
}
