package com.etc.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.etc.dao.StudentDaoImpl;
import com.etc.dao.StudentScoreImpl;
import com.etc.entity.StuScore;

public class TestStuScore {
	StudentScoreImpl dao = new StudentScoreImpl();
	/**
	 * 通过学号查询学生课程成绩
	 */
	@Test
	public void t1() {
		List<StuScore> stuScore = dao.querystu("g1703005");
		for (StuScore stuScore2 : stuScore) {
			System.out.println(stuScore2);
		}
	}
	/**
	 * 查询所有学生的成绩
	 */
	@Test
	public void t2() {
		List<StuScore> stuScore = dao.querystuAll();
		for (StuScore stuScore2 : stuScore) {
			System.out.println(stuScore2);
		}
	}
	/**
	 * 添加课程成绩
	 */
	@Test
	public void t3() {
		boolean b = dao.insertCourse("g1703005",5, 80);
		System.out.println(b);
	}
	/**
	 * 按照不同条件查询
	 * 学号 课程名 学号+课程名
	 */
	@Test
	public void t4() {
		List<StuScore> stuScore = dao.queryScore("", "java");
		for (StuScore stuScore2 : stuScore) {
			System.out.println(stuScore2);
		}
	}
	/**
	 * 修改成绩
	 */
	@Test
	public void t5() {
		boolean s = dao.updateCourse("g1703005", 4, 90);
		System.out.println(s);
	}
	/**
	 * 删除成绩
	 */
	@Test
	public void t6() {
		boolean stucourse = dao.deleteCourse("g1703005", 1);
		System.out.println(stucourse);
	}
}
