package com.etc.dao;

import java.util.List;

import com.etc.entity.Student;
import com.etc.entity.Teacher;

public interface TeacherDao {
	/**
	 * 根据教工号和密码查询
	 */
	Teacher queryNoPswd(String no,String password);
}
