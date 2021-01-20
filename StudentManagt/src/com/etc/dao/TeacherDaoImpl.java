package com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Student;
import com.etc.entity.Teacher;
import com.etc.util.DButil;

public class TeacherDaoImpl implements TeacherDao{
	/**
	 * 教师登录
	 */
	@Override
	public Teacher queryNoPswd(String no, String psword) {
		String sql="select * from tab_teacher where teacher_no=? and password=?";
		CachedRowSet  crs=DButil.execQuery(sql, no,psword);
		Teacher teacher = null;
		try {
			while (crs.next()) {
				int teacher_id = crs.getInt(1);
				String teacher_no = crs.getString(2);
				String teacher_name = crs.getString(3);
				String password = crs.getString(4);
				teacher = new Teacher(teacher_id, teacher_no, teacher_name, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	
}
