package com.etc.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.etc.entity.Student;
import com.etc.util.DButil;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 学生登录
	 */
	@Override
	public Student login(String no, String password) {
		String sql="select * from tab_student where student_no=? and password=?";
		CachedRowSet  crs=DButil.execQuery(sql, no,password);
		Student student=null;
		try {
			while(crs.next()) {
				String student_no = crs.getString(1);
				String student_name=crs.getString(2);
				String gender = crs.getString(3);
				String birth = crs.getString(4);
				String password1 = crs.getString(5);
				int status = crs.getInt(6);
				student=new Student(student_no, student_name, gender, birth, password1, status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	/**
	 * 查询全部学生
	 */
	@Override
	public List<Student> query() {
		String sql="select * from tab_student ";
		CachedRowSet  crs=DButil.execQuery(sql);
		List<Student> list = new ArrayList<Student>();
		Student student=null;
		try {
			while(crs.next()) {
				String student_no =crs.getString(1);
				String student_name =crs.getString(2);
				String gender = crs.getString(3);
				String birth = crs.getString(4);
				String password = crs.getString(5);
				int status =crs.getInt(6);
				student=new Student(student_no, student_name, gender, birth, password, status);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 按照学生学号查询
	 */
	@Override
	public Student querysNo(String no) {
		String sql="select * from tab_student where student_no=?";
		CachedRowSet  crs=DButil.execQuery(sql, no);
		Student student=null;
		try {
			while(crs.next()) {
				String student_no = crs.getString(1);
				String student_name=crs.getString(2);
				String gender = crs.getString(3);
				String birth = crs.getString(4);
				String password1 = crs.getString(5);
				int status = crs.getInt(6);
				student=new Student(student_no, student_name, gender, birth, password1, status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	/**
	 * 按照学生姓名模糊查询
	 */
	@Override
	public List<Student> queryName(String key) {
		CachedRowSet  crs=DButil.execQuery("select * from tab_student where student_name like ?","%"+key+"%");
		List<Student> list = new ArrayList<Student>();
		Student student=null;
		try {
			while(crs.next()) {
				String student_no =crs.getString(1);
				String student_name =crs.getString(2);
				String gender = crs.getString(3);
				String birth = crs.getString(4);
				String password = crs.getString(5);
				int status =crs.getInt(6);
				student=new Student(student_no, student_name, gender, birth, password, status);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 添加学生
	 */
	@Override
	public boolean addStu(Student student) {
		if (student != null) {
			String sql="insert into tab_student values(?,?,?,?,?,?)";
			return DButil.execUpdate(sql, student.getStudent_no(),student.getStudent_name(),student.getGender(),student.getBirth(),student.getPassword(),student.getStatus());
		}
		return false;
	}
	/**
	 * 修改学生
	 */
		@Override
		public boolean update(Student student) {
			if (null!=student) {
				String sql="update tab_student set student_name=?,gender=?,birth=?,password=?,status=? where student_no=? ";
				return DButil.execUpdate(sql,student.getStudent_name(),student.getGender(),student.getBirth(),student.getPassword(),student.getStatus(),student.getStudent_no());
			}
			return false;
		}

	/**
	 * 修改学生状态
	 */
	@Override
	public boolean updateStatus(String no) {
		if(null!=no) {
			String sql="update tab_student set status=? where student_no=? ";
			return DButil.execUpdate(sql,1,no);
		}
		return false;
	}

	
}
