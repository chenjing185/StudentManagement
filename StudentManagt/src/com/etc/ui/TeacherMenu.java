//教师操作界面
package com.etc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherMenu window = new TeacherMenu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param uno 
	 */
	public TeacherMenu(String uno) {
		initialize(uno);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param uno 
	 */
	private void initialize(String uno) {
		frame = new JFrame();
		frame.setBounds(100, 100, 543, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("教师操作页面");
		frame.setVisible(true);
		
		JButton button = new JButton("学生管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu stu = new StudentMenu();
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(167, 38, 156, 52);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("学生成绩查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreMenu sco = new ScoreMenu();
				frame.setVisible(false);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBounds(150, 130, 190, 52);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("退出系统");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_2.setBounds(167, 221, 156, 52);
		frame.getContentPane().add(button_2);
	}

}
