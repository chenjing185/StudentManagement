//学生管理界面
package com.etc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.etc.dao.StudentDaoImpl;
import com.etc.entity.Student;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentMenu {

	protected static final JLabel woman1 = null;
	private JFrame frame;
	private JTextField studentNo;
	private JTextField studentName;
	private JTable table;
	private JTextField studentNO1;
	private JTextField studentName1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField studentBirth;
	private JTextField studentName2;
	private JTextField studentBirth1;
	private JTextField passwd;
	private StudentDaoImpl dao = new StudentDaoImpl();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton woman_up = null;
	private JRadioButton man_up = null;
	private JLabel studentNo2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu window = new StudentMenu();
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
	public StudentMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 784);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("学生管理页面");
		frame.setVisible(true);
		
		JLabel label = new JLabel("学号:");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 24, 54, 15);
		frame.getContentPane().add(label);
		
		studentNo = new JTextField();
		studentNo.setBounds(57, 23, 91, 21);
		frame.getContentPane().add(studentNo);
		studentNo.setColumns(10);
		
		JLabel label_1 = new JLabel("学生姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(158, 26, 91, 15);
		frame.getContentPane().add(label_1);
		
		studentName = new JTextField();
		studentName.setColumns(10);
		studentName.setBounds(242, 23, 91, 21);
		frame.getContentPane().add(studentName);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuNo = studentNo.getText();
				String stuName = studentName.getText();
				if (stuNo.trim().length()!=0 && stuName.trim().length()==0) {
					//按学号查询
					Student student = dao.querysNo(stuNo);
					if (student!=null) {
						List<Student> list = new ArrayList<Student>();
						list.add(student);
						showTable(list);
					} else {
						List<Student> list = new ArrayList<>();
						showTable(list);
					}
				}else if (stuName.trim().length()!=0 && stuNo.trim().length()==0) {
					//姓名模糊查询
					List<Student> list = dao.queryName(stuName);
					showTable(list);
				}else if (stuName.trim().length()==0 && stuNo.trim().length()==0) {
					List<Student> list = dao.query();
					showTable(list);
				}else {
					List<Student> list = new ArrayList<Student>();
					showTable(list);
				}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(355, 22, 68, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 413, 167);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//修改学生获取值
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String studentNo = (String) table.getValueAt(row, 0);
				String studentName = (String) table.getValueAt(row, 1);
				String gender = (String) table.getValueAt(row, 2);
				String birth = (String) table.getValueAt(row, 3);
				String pwd = (String) table.getValueAt(row, 4);
				studentNo2.setText(studentNo);
				studentName2.setText(studentName);
				if ("男".equals(gender)) {
					man_up.setSelected(true);
				} else {
					woman_up.setSelected(true);
				}
				studentBirth1.setText(birth);
				passwd.setText(pwd);
			}
		});
		List<Student> list = dao.query();
		showTable(list);
		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 267, 432, 199);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("新增学生", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("学号:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(10, 10, 54, 24);
		panel.add(label_2);
		
		studentNO1 = new JTextField();
		studentNO1.setBounds(49, 12, 81, 21);
		panel.add(studentNO1);
		studentNO1.setColumns(10);
		
		JLabel label_3 = new JLabel("学生姓名:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(136, 10, 81, 24);
		panel.add(label_3);
		
		studentName1 = new JTextField();
		studentName1.setColumns(10);
		studentName1.setBounds(205, 12, 81, 21);
		panel.add(studentName1);
		
		JLabel label_4 = new JLabel("性别:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 15));
		label_4.setBounds(288, 10, 54, 24);
		panel.add(label_4);
		
		JRadioButton man = new JRadioButton("男");
		buttonGroup.add(man);
		man.setBounds(330, 11, 44, 23);
		panel.add(man);
		
		JRadioButton woman = new JRadioButton("女");
		buttonGroup.add(woman);
		woman.setBounds(376, 11, 45, 23);
		panel.add(woman);
		
		JLabel label_5 = new JLabel("出生日期");
		label_5.setFont(new Font("宋体", Font.PLAIN, 15));
		label_5.setBounds(10, 57, 81, 24);
		panel.add(label_5);
		
		studentBirth = new JTextField();
		studentBirth.setColumns(10);
		studentBirth.setBounds(87, 59, 110, 21);
		panel.add(studentBirth);
		
		JLabel label_6 = new JLabel("密码:");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(205, 55, 81, 29);
		panel.add(label_6);
		
		JLabel pswd = new JLabel("123456");
		pswd.setFont(new Font("宋体", Font.PLAIN, 18));
		pswd.setBounds(264, 57, 78, 20);
		panel.add(pswd);
		
		JButton button_1 = new JButton("新增学生");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuNO1 = studentNO1.getText();
				String stuName = studentName1.getText();
				String stuMan = man.isSelected()?man.getText():woman.getText();
				String stuth = studentBirth.getText();
				String pwd = pswd.getText();
				boolean student = dao.addStu(new Student(stuNO1, stuName, stuMan, stuth, pwd, 0));
				if (student) {
					JOptionPane.showMessageDialog(null, "添加成功");
				}else {
					JOptionPane.showMessageDialog(null, "添加失败");
				}
				List<Student> list = dao.query();
				showTable(list);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(272, 94, 110, 38);
		panel.add(button_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 512, 432, 190);
		frame.getContentPane().add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("修改学生", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_8 = new JLabel("学号:");
		label_8.setFont(new Font("宋体", Font.PLAIN, 15));
		label_8.setBounds(10, 10, 54, 24);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("学生姓名:");
		label_9.setFont(new Font("宋体", Font.PLAIN, 15));
		label_9.setBounds(134, 12, 81, 24);
		panel_1.add(label_9);
		
		studentName2 = new JTextField();
		studentName2.setColumns(10);
		studentName2.setBounds(203, 14, 81, 21);
		panel_1.add(studentName2);
		
		JLabel label_10 = new JLabel("性别:");
		label_10.setFont(new Font("宋体", Font.PLAIN, 15));
		label_10.setBounds(290, 9, 54, 24);
		panel_1.add(label_10);
		
		man_up = new JRadioButton("男");
		buttonGroup_1.add(man_up);
		man_up.setBounds(335, 11, 47, 23);
		panel_1.add(man_up);
		
		JLabel label_11 = new JLabel("出生日期:");
		label_11.setFont(new Font("宋体", Font.PLAIN, 15));
		label_11.setBounds(10, 56, 81, 24);
		panel_1.add(label_11);
		
		studentBirth1 = new JTextField();
		studentBirth1.setColumns(10);
		studentBirth1.setBounds(87, 58, 110, 21);
		panel_1.add(studentBirth1);
		
		JLabel label_12 = new JLabel("密码:");
		label_12.setFont(new Font("宋体", Font.PLAIN, 15));
		label_12.setBounds(203, 55, 81, 30);
		panel_1.add(label_12);
		
		passwd = new JTextField();
		passwd.setColumns(10);
		passwd.setBounds(246, 58, 110, 21);
		panel_1.add(passwd);
		
		JButton upda = new JButton("修改学生");
		upda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studNo = studentNo2.getText();
				String studName = studentName2.getText();
				String studMan = man_up.isSelected()?man_up.getText():woman_up.getText();
				String studth = studentBirth1.getText();
				String pwdd = passwd.getText();
				boolean stuUpda = dao.update(new Student(studNo, studName, studMan, studth, pwdd, 0));
				if (stuUpda) {
					JOptionPane.showMessageDialog(null, "修改成功");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
				List<Student> list = dao.query();
				showTable(list);
			}
		});
		upda.setFont(new Font("宋体", Font.PLAIN, 18));
		upda.setBounds(134, 95, 110, 38);
		panel_1.add(upda);
		
		JButton del = new JButton("注销学生");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuNo2 = studentNo2.getText();
				Student student = new Student();
				boolean stas = dao.updateStatus(stuNo2);
				if (stas) {
					JOptionPane.showMessageDialog(null, "注销成功");
				} else {
					JOptionPane.showMessageDialog(null, "注销失败");
				}
				List<Student> list = dao.query();
				showTable(list);
			}
		});
		del.setFont(new Font("宋体", Font.PLAIN, 18));
		del.setBounds(257, 95, 110, 38);
		panel_1.add(del);
		
		woman_up = new JRadioButton("女");
		buttonGroup_1.add(woman_up);
		woman_up.setBounds(382, 11, 45, 23);
		panel_1.add(woman_up);
		
		studentNo2 = new JLabel("--");
		studentNo2.setBounds(56, 15, 68, 15);
		panel_1.add(studentNo2);
		
		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uno = "h1001";
				TeacherMenu tm = new TeacherMenu(uno);
				frame.setVisible(false);
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 17));
		button_2.setBounds(321, 709, 113, 27);
		frame.getContentPane().add(button_2);
	}

	private void showTable(List<Student> list) {
		String[] col = {"学号","学生姓名","性别","出生日期","密码","状态"};
		Object[][] tol = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
			tol[i][0] = student.getStudent_no();
			tol[i][1] = student.getStudent_name();
			tol[i][2] = student.getGender();
			tol[i][3] = student.getBirth();
			tol[i][4] = student.getPassword();
			tol[i][5] = student.getStatus();
		}
		table.setModel(new DefaultTableModel(
			tol,
			col
		));
	}
}
