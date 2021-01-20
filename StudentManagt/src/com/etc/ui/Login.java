//登录界面
package com.etc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.etc.dao.StudentDaoImpl;
import com.etc.dao.TeacherDaoImpl;
import com.etc.entity.Student;
import com.etc.entity.Teacher;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private StudentDaoImpl dao = new StudentDaoImpl();
	private TeacherDaoImpl daos = new TeacherDaoImpl();
	Student student = new Student();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("登录页面");
		frame.setVisible(true);
		
		JLabel label = new JLabel("学生信息管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(280, 75, 179, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("学号/工号:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(145, 130, 105, 24);
		frame.getContentPane().add(label_1);
		
		username = new JTextField();
		username.setBounds(272, 125, 272, 38);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel label_2 = new JLabel("密码:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(145, 201, 105, 24);
		frame.getContentPane().add(label_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(272, 196, 272, 38);
		frame.getContentPane().add(password);
		
		JLabel label_3 = new JLabel("角色:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(145, 271, 105, 24);
		frame.getContentPane().add(label_3);
		
		JRadioButton students = new JRadioButton("学生");
		students.setSelected(true);
		buttonGroup.add(students);
		students.setBounds(272, 272, 76, 27);
		frame.getContentPane().add(students);
		
		JRadioButton teachers = new JRadioButton("教师/管理员");
		buttonGroup.add(teachers);
		teachers.setBounds(427, 272, 117, 27);
		frame.getContentPane().add(teachers);
		
		JButton login_user = new JButton("登录");
		login_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//1.获取用户输入的学号/工号和密码
				String uno = username.getText();
				//密码
				String upwd = password.getText();
				String js = students.isSelected()?students.getText():teachers.getText();
				if (js==students.getText() && !uno.equals("") && !upwd.equals("")) {
					Student s = dao.login(uno, upwd);
					if (s != null) {
						Lndividualqueries lnds = new Lndividualqueries(s);
						frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "登录失败");
					}
				} 
				if (js==teachers.getText() && !uno.equals("") && !upwd.equals("")) {
					Teacher t = daos.queryNoPswd(uno, upwd);
					if (t != null) {
						TeacherMenu tmu = new TeacherMenu(uno);
						frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "登录失败");
					}
				}
			}
		});
		login_user.setFont(new Font("宋体", Font.PLAIN, 25));
		login_user.setBounds(291, 348, 136, 38);
		frame.getContentPane().add(login_user);
	}
}
