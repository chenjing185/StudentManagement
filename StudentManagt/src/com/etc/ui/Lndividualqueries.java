//学生个人成绩查询
package com.etc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.etc.dao.StudentScoreImpl;
import com.etc.entity.StuScore;
import com.etc.entity.Student;

import javax.swing.JScrollPane;

public class Lndividualqueries {

	private JFrame frame;
	private JTextField stunum;
	private JTextField stuname;
	private JTable table;
	private StudentScoreImpl dao = new StudentScoreImpl();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Lndividualqueries window = new Lndividualqueries(null);
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
	public Lndividualqueries(Student s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param student2 
	 * @param student2 
	 */
	private void initialize(Student s) {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("学生个人查询页面");
		frame.setVisible(true);
		
		JLabel label = new JLabel("学号:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(81, 67, 58, 37);
		frame.getContentPane().add(label);
		
		stunum = new JTextField();
		stunum.setBounds(139, 67, 159, 32);
		frame.getContentPane().add(stunum);
		stunum.setColumns(10);
		stunum.setText(s.getStudent_no());
		
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(312, 67, 58, 37);
		frame.getContentPane().add(label_1);
		
		stuname = new JTextField();
		stuname.setColumns(10);
		stuname.setBounds(378, 67, 159, 32);
		frame.getContentPane().add(stuname);
		stuname.setText(s.getStudent_name());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 121, 456, 322);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		String[] col = {"课程名","课程学分","成绩"};
		List<StuScore> list = dao.querystu(s.getStudent_no());
		Object[][] tol = new Object[4][3];
		for (int i = 0; i < list.size(); i++) {
			StuScore stuScore = list.get(i);
			tol[i][0] = stuScore.getCourse_score();
			tol[i][1] = stuScore.getCourse_name();
			tol[i][2] = stuScore.getScore();
		}
		table.setModel(new DefaultTableModel(
			tol,
			col
		));
		scrollPane.setViewportView(table);
	}
}
