//学生成绩查询界面
package com.etc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.etc.dao.StudentScoreImpl;
import com.etc.entity.StuScore;
import com.etc.entity.Student;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreMenu {

	private JFrame frame;
	private JTextField studenNo;
	private JTextField studenName;
	private JTable table;
	private JTextField studenNo1;
	private JTextField studenName1;
	private JTextField score;
	StudentScoreImpl dao = new StudentScoreImpl();
	private JComboBox<String> comboBox = null;
	private JComboBox<String> comboBox_1 = null;
	private JScrollPane scrollPane = null;
	private JTextField stuscoreNo2;
	private JTextField studenName2;
	private JTextField score2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreMenu window = new ScoreMenu();
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
	public ScoreMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("学生成绩查询页面");
		frame.setVisible(true);

		JLabel label = new JLabel("学号:");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(10, 10, 54, 26);
		frame.getContentPane().add(label);

		studenNo = new JTextField();
		studenNo.setBounds(52, 13, 91, 21);
		frame.getContentPane().add(studenNo);
		studenNo.setColumns(10);

		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(153, 10, 54, 26);
		frame.getContentPane().add(label_1);

		studenName = new JTextField();
		studenName.setColumns(10);
		studenName.setBounds(192, 13, 91, 21);
		frame.getContentPane().add(studenName);

		JLabel label_2 = new JLabel("课程:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(293, 10, 54, 26);
		frame.getContentPane().add(label_2);

		//成绩查询-课程
		comboBox = new JComboBox<String>();
		comboBox.addItem("--选择课程--");
		comboBox.addItem("java");
		comboBox.addItem("前端");
		comboBox.addItem("python");
		comboBox.addItem("php");
		comboBox.addItem("C");
		comboBox.setBounds(347, 13, 83, 21);
		frame.getContentPane().add(comboBox);

		//教师查询所有学生成绩
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuNo = studenNo.getText();
				String coName = (String)comboBox.getSelectedItem();
					List<StuScore> score2 = dao.queryScore(stuNo,coName);
					showScore(score2);
					studenNo.setText("");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(470, 12, 83, 23);
		frame.getContentPane().add(button);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 543, 161);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			//录入修改成绩获取值
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				String studentNo = (String) table.getValueAt(row, 1);
				String studentName = (String) table.getValueAt(row, 2);
				studenNo1.setText(studentNo);
				studenName1.setText(studentName);
				stuscoreNo2.setText(studentNo);
				studenName2.setText(studentName);
			}
		});
		List<StuScore> list = dao.querystuAll();
		showScore(list);
		scrollPane.setViewportView(table);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 235, 543, 197);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("录入成绩", null, panel, null);
		panel.setLayout(null);

		JLabel label_3 = new JLabel("学号:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(10, 10, 54, 27);
		panel.add(label_3);

		studenNo1 = new JTextField();
		studenNo1.setBounds(52, 13, 103, 21);
		panel.add(studenNo1);
		studenNo1.setColumns(10);

		JLabel label_4 = new JLabel("姓名:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(180, 10, 54, 27);
		panel.add(label_4);

		studenName1 = new JTextField();
		studenName1.setColumns(10);
		studenName1.setBounds(222, 13, 103, 21);
		panel.add(studenName1);

		JLabel label_5 = new JLabel("课程名:");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(10, 72, 54, 27);
		panel.add(label_5);

		JLabel label_6 = new JLabel("成绩:");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(176, 72, 54, 27);
		panel.add(label_6);

		score = new JTextField();
		score.setColumns(10);
		score.setBounds(222, 75, 103, 21);
		panel.add(score);

		//成绩录入-课程
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("--选择课程--");
		comboBox_1.addItem("java");
		comboBox_1.addItem("前端");
		comboBox_1.addItem("python");
		comboBox_1.addItem("php");
		comboBox_1.addItem("C");
		comboBox_1.setBounds(72, 75, 83, 21);
		panel.add(comboBox_1);

		//录入学生成绩
		JButton insertScore = new JButton("录入");
		insertScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取学号
				String studentNo = studenNo1.getText();
				String studName = studenName1.getText();
				//获取课程
				int index = comboBox_1.getSelectedIndex();
				String text = score.getText();
				//获取成绩
				float scores = Float.parseFloat(text);
				//调用录入成绩的方法
				if (index!=0) {
					boolean flag = dao.insertCourse(studentNo,index, scores);
					if (flag) {
						JOptionPane.showMessageDialog(null, "录入成功");
						List<StuScore> list = dao.querystuAll();
						showScore(list);
						//清零
						studenNo1.setText("");
						score.setText("");
						comboBox_1.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "录入失败");
					}
				} else {
					JOptionPane.showMessageDialog(null, "请选择课程");
				}
				
			}
		});
		insertScore.setFont(new Font("宋体", Font.PLAIN, 20));
		insertScore.setBounds(375, 28, 93, 49);
		panel.add(insertScore);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("修改成绩", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("学号:");
		label_7.setFont(new Font("宋体", Font.PLAIN, 15));
		label_7.setBounds(27, 30, 54, 27);
		panel_1.add(label_7);
		
		stuscoreNo2 = new JTextField();
		stuscoreNo2.setColumns(10);
		stuscoreNo2.setBounds(69, 33, 103, 21);
		panel_1.add(stuscoreNo2);
		
		JLabel label_8 = new JLabel("姓名:");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(197, 30, 54, 27);
		panel_1.add(label_8);
		
		studenName2 = new JTextField();
		studenName2.setColumns(10);
		studenName2.setBounds(239, 33, 103, 21);
		panel_1.add(studenName2);
		
		JLabel label_9 = new JLabel("课程名:");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(27, 92, 54, 27);
		panel_1.add(label_9);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("--选择课程--");
		comboBox_2.addItem("java");
		comboBox_2.addItem("前端");
		comboBox_2.addItem("python");
		comboBox_2.addItem("php");
		comboBox_2.addItem("C");
		comboBox_2.setBounds(89, 95, 83, 21);
		panel_1.add(comboBox_2);
		
		score2 = new JTextField();
		score2.setColumns(10);
		score2.setBounds(239, 95, 103, 21);
		panel_1.add(score2);
		
		JLabel label_10 = new JLabel("成绩:");
		label_10.setFont(new Font("宋体", Font.PLAIN, 15));
		label_10.setBounds(193, 92, 54, 27);
		panel_1.add(label_10);
		
		JButton updaScore = new JButton("修改");
		updaScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentNo = stuscoreNo2.getText();
				String studName = studenName2.getText();
				//获取课程
				int index = comboBox_2.getSelectedIndex();
				String text = score2.getText();
				//获取成绩
				float scores = Float.parseFloat(text);
				boolean flag = dao.updateCourse(studentNo, index, scores);
				if (flag) {
					JOptionPane.showMessageDialog(null, "修改成功");
					List<StuScore> list = dao.querystuAll();
					showScore(list);
					stuscoreNo2.setText("");
					comboBox_2.setSelectedIndex(0);
					score2.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}
		});
		updaScore.setFont(new Font("宋体", Font.PLAIN, 20));
		updaScore.setBounds(384, 17, 93, 49);
		panel_1.add(updaScore);
		
		JButton deleScore = new JButton("删除");
		deleScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentNo = stuscoreNo2.getText();
				//获取课程
				int index = comboBox_2.getSelectedIndex();
				boolean flag = dao.deleteCourse(studentNo, index);
				if (flag) {
					JOptionPane.showMessageDialog(null, "删除成功");
					List<StuScore> list = dao.querystuAll();
					showScore(list);
					stuscoreNo2.setText("");
					comboBox_2.setSelectedIndex(0);
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}
		});
		deleScore.setFont(new Font("宋体", Font.PLAIN, 20));
		deleScore.setBounds(384, 92, 93, 49);
		panel_1.add(deleScore);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uno = "h1001";
				TeacherMenu menu = new TeacherMenu(uno);
				frame.setVisible(false);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 17));
		button_1.setBounds(440, 438, 113, 27);
		frame.getContentPane().add(button_1);

	}

	private void showScore(List<StuScore> list) {
		String[] col = {"成绩编号","学生学号","学生姓名","课程名","成绩"};
		Object[][] tol = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			StuScore stuScore = list.get(i);
			tol[i][0] = stuScore.getScore_id();
			tol[i][1] = stuScore.getStudent_no();
			tol[i][2] = stuScore.getStudent_name();
			tol[i][3] = stuScore.getCourse_name();
			tol[i][4] = stuScore.getScore();
		}
		table.setModel(new DefaultTableModel(
				tol,
				col
				));
	}
}
