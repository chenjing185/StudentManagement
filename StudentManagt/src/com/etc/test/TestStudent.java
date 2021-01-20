package com.etc.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.etc.dao.StudentDaoImpl;
import com.etc.entity.Student;

public class TestStudent {
	StudentDaoImpl dao = new StudentDaoImpl();
	/**
	 * 学生登录
	 */
	@Test
	public void login() {
		Student student = dao.login("g1703005", "123");
		if (student==null) {
			System.out.println("登录失败");
		}else {
			System.out.println(student);
		}
	}
	/**
	 * 查询全部学生
	 */
	@Test
	public void de() {
		List<Student> students = dao.query();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	/**
	 * 按照学生学号查询
	 */
	@Test
	public void queryNo() {
		Student student = dao.querysNo("g1703005");
		System.out.println(student);
	}
	/**
	 * 按照学生姓名模糊查询
	 */
	@Test
	public void queryName() {
		List<Student> students = dao.queryName("艾");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	/**
	 * 添加学生
	 */
	@Test
	public void add() {
		boolean flag=dao.addStu(new Student("g1305005","张三","男","2018-05-24","123",0));
		if (flag) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
	}
	/**
	 * 修改学生
	 */
	@Test
	public void update() {
		boolean flag=dao.update(new Student("g1305005","李丽","男","2017-05-24","789",0));
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	/**
	 * 修改学生状态
	 */
	@Test
	public void updatestatus() {
		boolean flag=dao.updateStatus("g1703005");
		if (flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}

}
