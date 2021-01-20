package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.StuScore;
import com.etc.util.DButil;

public class StudentScoreImpl implements StudentScoreDao{
	/**
	 * 查询学生的各科成绩
	 */
	@Override
	public List<StuScore> querystu(String stuNo) {
		CachedRowSet crs = DButil.execQuery("select b.course_name,b.course_score,a.score from tab_score a inner"
				+ " join tab_course b on a.course_no=b.course_no where a.student_no=?", stuNo);
		StuScore info = null;
		List<StuScore> list = new ArrayList<StuScore>();
		try {
			while (crs.next()) {
				String courseName = crs.getString(1);
				float courseScore = crs.getFloat(2);
				float score = crs.getFloat(3);
				info = new StuScore(courseScore, courseName, score);
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询所有学生的成绩
	 */
	@Override
	public List<StuScore> querystuAll() {
		CachedRowSet crs = DButil.execQuery("select a.score_id,c.student_no,c.student_name,b.course_name,a.score from  tab_score a \r\n" + 
				"inner join tab_course b on a.course_no=b.course_no \r\n" + 
				"inner join tab_student c on a.student_no=c.student_no "
				);
		StuScore info = null;
		List<StuScore> list = new ArrayList<StuScore>();
		try {
			while (crs.next()) {
				int scoreId = crs.getInt(1);
				String studentNo = crs.getString(2);
				String studentName = crs.getString(3);
				String courseName  = crs.getString(4);
				float score = crs.getFloat(5);
				info = new StuScore(studentNo, studentName, scoreId, score, courseName);
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 添加课程成绩
	 */
	@Override
	public boolean insertCourse(String stuNo, int course_no, float score) {
		return DButil.execUpdate("insert into tab_score values(null,?,?,?,now())", stuNo,course_no,score);
	}
	/**
	 * 按照不同条件查询
	 */
	@Override
	public List<StuScore> queryScore(String stuNo, String couName) {
		CachedRowSet crs = null;
		if (!"".equals(stuNo.trim()) && "".equals(couName.trim())) {
			crs=DButil.execQuery("select a.score_id,c.student_no,c.student_name,b.course_name,a.score from tab_score a\r\n"
					+ "inner join tab_course b on a.course_no=b.course_no\r\n"
					+ "inner join tab_student c on a.student_no=c.student_no where c.student_no=?",stuNo);
		}else if ("".equals(stuNo.trim()) && !"".equals(couName.trim())) {
			crs=DButil.execQuery("select a.score_id,c.student_no,c.student_name,b.course_name,a.score from tab_score a\r\n"
					+ "inner join tab_course b on a.course_no=b.course_no\r\n"
					+ "inner join tab_student c on a.student_no=c.student_no where b.course_name=?",couName);
		}else if (!"".equals(stuNo.trim()) && !"".equals(couName.trim())){
			crs=DButil.execQuery("select a.score_id,c.student_no,c.student_name,b.course_name,a.score from tab_score a\r\n"
					+ "inner join tab_course b on a.course_no=b.course_no\r\n"
					+ "inner join tab_student c on a.student_no=c.student_no where c.student_no=? and b.course_name=?",stuNo,couName);
		}else if ("".equals(stuNo.trim()) && "".equals(couName.trim())) {
			crs = DButil.execQuery("select a.score_id,c.student_no,c.student_name,b.course_name,a.score from tab_score a\r\n" + 
					"inner join tab_course b on a.course_no=b.course_no\r\n" + 
					"inner join tab_student c on a.student_no=c.student_no");
		}
		StuScore info = null;
		List<StuScore> list = new ArrayList<StuScore>();
		try {
			while (crs.next()) {
				int scoreId = crs.getInt(1);
				String studentNo = crs.getString(2);
				String studentName = crs.getString(3);
				String courseName = crs.getString(4);
				float score = crs.getFloat(5);
				info = new StuScore(studentNo, studentName, scoreId, score, courseName);
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 修改成绩
	 */
	@Override
	public boolean updateCourse(String stuNo, int course_no, float score) {
		String sql = "update tab_score SET score=? WHERE student_no=? and course_no=?";
		return DButil.execUpdate(sql, score,stuNo,course_no);
	}
	@Override
	public boolean deleteCourse(String stuNo, int course_no) {
		String sql = "DELETE from tab_score WHERE student_no=? and course_no=?";
		return DButil.execUpdate(sql, stuNo,course_no);
	}

}
