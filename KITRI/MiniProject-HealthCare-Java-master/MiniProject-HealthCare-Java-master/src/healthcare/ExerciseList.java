package healthcare;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;

public class ExerciseList {
	DBConnect db = new DBConnect();
	TableRowSorter<TableModel> tableRowSorter2; // ���� �����Ҷ� ��µǴ� ���̺��� ���� �����ϴ� ����
	float totalCal = (float) 0;
	LocalDate today = LocalDate.now();
	JFrame frame;
	private String user_id;
	String selectedDate;
	Object ob1[][] = new Object[0][3];
	Object ob2[][] = new Object[0][2];
	DefaultTableModel model1;
	DefaultTableModel model2;

	String str1[] = { "��ڵ�", "�", "�Ҹ�Į�θ�(1�ð���)" };
	String str2[] = { "��ڵ�", "�", "�Ҹ�Į�θ�", "��ð�" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseList e = new ExerciseList();
					e.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new ExerciseList();

	}

	public ExerciseList() {
		initialize();
	}

	public ExerciseList(String User_ID) {
		user_id = User_ID;
		System.out.println("user id : " + user_id);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ExerciseList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(true);

		// ====================================Choice====================================
		Calendar calender = Calendar.getInstance();

		int today_year = calender.get(Calendar.YEAR);
		int today_month = calender.get(Calendar.MONTH) + 1;
		int today_day = calender.get(Calendar.DAY_OF_MONTH);

		String m = String.format("%02d", today_month);
		String d = String.format("%02d", today_day);

		selectedDate = today_year + "-" + m + "-" + d;

		Choice choiceDate = new Choice();
		choiceDate.setBounds(135, 60, 264, 21);
		contentPane.add(choiceDate);

		Calendar calender2 = Calendar.getInstance();
		for (int i = 2021; i < 2023; i++) {
			for (int j = 1; j <= 12; j++) {
				calender2.set(i, j - 1, 1);
				for (int k = 1; k <= calender2.getActualMaximum(Calendar.DAY_OF_MONTH); k++) {
					choiceDate.add(String.valueOf(i + "-" + j + "-" + k));
				}
			}
		}

		choiceDate.select(today_year + "-" + today_month + "-" + today_day);

		// ====================================JButton====================================
		// ���� ��ư �̹���
		ImageIcon ex_main = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_main.png");
		Image ex_main1 = ex_main.getImage();
		Image ex_main2 = ex_main1.getScaledInstance(121, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_main3 = new ImageIcon(ex_main2);
		// ���ι�ư
		JButton btnMain = new JButton(ex_main3);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main(user_id);
				m.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnMain.setBounds(12, 10, 121, 40);
		btnMain.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnMain);
		btnMain.setBorderPainted(false); //��ư�׵θ� ����

		// �Ĵ� ��ư �̹���
		ImageIcon ex_food = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_food.png");
		Image ex_food1 = ex_food.getImage();
		Image ex_food2 = ex_food1.getScaledInstance(121, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_food3 = new ImageIcon(ex_food2);
		// �Ĵܹ�ư
		JButton btnFoodlist = new JButton(ex_food3);
		btnFoodlist.setBounds(145, 10, 121, 40);
		btnFoodlist.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnFoodlist);
		btnFoodlist.setBorderPainted(false); //��ư�׵θ� ����


		btnFoodlist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FoodList fl = new FoodList(user_id);
				fl.frame.setVisible(true);
				frame.dispose();

			}
		});
		
		// � ��ư �̹���
		ImageIcon ex_ex = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_ex.png");
		Image ex_ex1 = ex_ex.getImage();
		Image ex_ex2 = ex_ex1.getScaledInstance(121, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_ex3 = new ImageIcon(ex_ex2);
		// ���ư
		JButton btnExer = new JButton(ex_ex3);
		btnExer.setFont(new Font("����", Font.BOLD, 20));
		btnExer.setBounds(278, 10, 121, 40);
		contentPane.add(btnExer);
		btnExer.setBorderPainted(false); //��ư�׵θ� ����


		// ����Ʈ ��ư �̹���
		ImageIcon ex_report = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_report.png");
		Image ex_report1 = ex_report.getImage();
		Image ex_report2 = ex_report1.getScaledInstance(121, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_report3 = new ImageIcon(ex_report2);
		// ����Ʈ ��ư
		JButton btnRept = new JButton(ex_report3);
		btnRept.setBounds(411, 10, 121, 40);
		btnRept.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnRept);
		btnRept.setBorderPainted(false); //��ư�׵θ� ����


		btnRept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Report rp = new Report(user_id);
				rp.frame.setVisible(true);
				frame.dispose();
			}
		});

		// �÷��� ��ư �̹���
		ImageIcon ex_plus = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_plus.png");
		Image ex_plus1 = ex_plus.getImage();
		Image ex_plus2 = ex_plus1.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_plus3 = new ImageIcon(ex_plus2);
		// �÷��� ��ư
		JButton btnPlus = new JButton(ex_plus3);
		btnPlus.setBounds(135, 511, 80, 40);
		btnPlus.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnPlus);
		btnPlus.setBorderPainted(false); //��ư�׵θ� ����


		// ���̳ʽ� ��ư �̹���
		ImageIcon ex_minus = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_minus.png");
		Image ex_minus1 = ex_minus.getImage();
		Image ex_minus2 = ex_minus1.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_minus3 = new ImageIcon(ex_minus2);
		// ���̳ʽ�
		JButton btnMinus = new JButton(ex_minus3);
		btnMinus.setBounds(227, 511, 80, 40);
		btnMinus.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnMinus);
		btnMinus.setBorderPainted(false); //��ư�׵θ� ����


		// ok ��ư �̹���
		ImageIcon ex_ok = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\ex_ok.png");
		Image ex_ok1 = ex_ok.getImage();
		Image ex_ok2 = ex_ok1.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		ImageIcon ex_ok3 = new ImageIcon(ex_ok2);
		// ok��ư
		JButton btnSave = new JButton(ex_ok3);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(319, 511, 80, 40);
		btnSave.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnSave);
		btnSave.setBorderPainted(false); //��ư�׵θ� ����


		//

		// ====================================TextField====================================
		JTextField fieldSearch = new JTextField();
		fieldSearch.setBounds(135, 87, 264, 21);
		contentPane.add(fieldSearch);
		fieldSearch.setColumns(10);

		JTextField fieldCount = new JTextField();
		fieldCount.setBounds(70, 512, 58, 39);
		contentPane.add(fieldCount);
		fieldCount.setColumns(10);

		JTextField fieldTC = new JTextField();
		fieldTC.setBounds(541, 511, 231, 33);
		contentPane.add(fieldTC);
		fieldTC.setColumns(10);

		model1 = new DefaultTableModel(ob1, str1) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		model2 = new DefaultTableModel(ob2, str2) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};

		try {
			ResultSet rs = db.getInfo("SELECT * FROM exercise;");
			while (rs.next()) {
				String Exercise_no = rs.getString("Exercise_no");
				String Exercise_Name = rs.getString("Exercise_Name");
				Float Exercise_Cal = rs.getFloat("Exercise_Cal");
				Object data[] = { Exercise_no, Exercise_Name, Exercise_Cal };
				model1.addRow(data);

			}
		} catch (Exception e) {
			System.out.println("select() ���� ���� : " + e.getMessage());
		}

		JTable table1 = new JTable(model1);
		JTable table2 = new JTable(model2);
		tableRowSorter2 = new TableRowSorter<>(table1.getModel()); // �����Ҷ�, ���� �������̺� ����
		// Exercis_no �÷� �����
		table1.setModel(model1);
		table1.removeColumn(table1.getColumnModel().getColumn(0));

		table2.setModel(model2);
		table2.removeColumn(table2.getColumnModel().getColumn(0));

		JScrollPane js1 = new JScrollPane(table1);
		js1.setBounds(12, 118, 383, 383);
		contentPane.add(js1);
		js1.getViewport().setBackground(Color.WHITE);

		JScrollPane js2 = new JScrollPane(table2);
		js2.setBounds(432, 118, 340, 383);
		contentPane.add(js2);
		js2.getViewport().setBackground(Color.WHITE);
		
		//���̺� ��Ʈ�ٲٱ�
		table1.setFont(new Font("���� ���", Font.PLAIN, 12));
		table1.getTableHeader().setFont(new Font("HY������M", Font.PLAIN, 12));
		table2.setFont(new Font("���� ���", Font.PLAIN, 12));
		table2.getTableHeader().setFont(new Font("HY������M", Font.PLAIN, 12));

		fieldTC.setText(showUserExerciseList(today.toString()) + "");
		// ��¥ Ŭ���� DB�� ������ �����ͼ� ���̺� �Ѹ���
		choiceDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getItem());
				selectedDate = (String) e.getItem(); // ������ ��¥ ���
				model2.setRowCount(0); // ������ ���̺� �ʱ�ȭ
				fieldTC.setText(showUserExerciseList(selectedDate) + ""); // ���������̺� ��� + ��Į�θ� ���
			}
		});

		String choice_date = choiceDate.getItem(choiceDate.getSelectedIndex());
		System.out.println(choice_date);

		fieldSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = fieldSearch.getText();// fieldsearch���� �ؽ�Ʈ��������
				TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<>(table1.getModel());
				table1.setRowSorter(tableRowSorter); // table row����
				tableRowSorter.setRowFilter(RowFilter.regexFilter(val)); // ���͸��ϱ�

				tableRowSorter2 = tableRowSorter;
			}
		});

		// +��ư ����
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table1.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "������ �������ּ���");
				}
				// ���� �Է¾��ҽ� �����޽���
				else if (fieldCount.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				} else {
					Object sdb[] = { tableRowSorter2.getModel().getValueAt(table1.convertRowIndexToModel(row), 0),
							tableRowSorter2.getModel().getValueAt(table1.convertRowIndexToModel(row), 1),
							tableRowSorter2.getModel().getValueAt(table1.convertRowIndexToModel(row), 2),
							fieldCount.getText() }; // ���ĸ���Ʈ.���ĸ�, ���ĸ���Ʈ.Į�θ� ���, ����
					// ->
					// sdb[]�� ���

					sdb[2] = Float.valueOf(sdb[2].toString()) * Float.valueOf(sdb[3].toString());
					totalCal += (float) sdb[2];
					fieldTC.setText(totalCal + "");
					model2.addRow(sdb);
					// System.out.println("cal= " + sdb[2]);

				}

			}
		});

		// -��ư ����

		btnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int mdel = table2.getSelectedRow();

				if (mdel != -1) {
					System.out.println("mdel" + mdel);
					totalCal -= Float.valueOf(model2.getValueAt(mdel, 2).toString());
					fieldTC.setText(totalCal + "");
					model2.removeRow(mdel);
				}

			}
		});

		// save��ư ����
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String choice_date = choiceDate.getItem(choiceDate.getSelectedIndex()); // ���õ� ��¥
				System.out.println(choice_date);

				db.delete_exercise(choice_date, user_id);
				// ���� ��ư�� ������ �ð��뺰�� �ڵ�,������ �����ϱ�
				// db�� ���� ���� -> rowcount==0�̸� ������ϰ� rowcount >= 1�̸� db�� ����
				// DB����� �Լ� �ʿ�
				if (model2.getRowCount() > 0) { // ���̺� ���� ������, DB�� ����
					for (int i = 0; i < model2.getRowCount(); i++) {
						db.user_exercise(user_id, choice_date, model2.getValueAt(i, 0).toString(),
								model2.getValueAt(i, 2).toString(), model2.getValueAt(i, 3).toString());
					}
				}

				db.exer_report(user_id, choice_date, fieldTC.getText());

				JOptionPane.showMessageDialog(null, "������͸� �����߽��ϴ�");

			}
		});
		// ====================================JLabel====================================

		JLabel lblChoiceDate_1 = new JLabel("�˻�");
		lblChoiceDate_1.setFont(new Font("HY������M", Font.PLAIN, 12));
		lblChoiceDate_1.setForeground(Color.DARK_GRAY);
		lblChoiceDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoiceDate_1.setBounds(12, 87, 121, 21);
		contentPane.add(lblChoiceDate_1);
		
		JLabel lblTC = new JLabel("�� Į�θ�");
		lblTC.setForeground(Color.DARK_GRAY);
		lblTC.setBounds(411, 511, 132, 33);
		lblTC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTC.setFont(new Font("HY������M", Font.PLAIN, 16));
		contentPane.add(lblTC);

		JLabel lblTime = new JLabel("�ð�");
		lblTime.setForeground(Color.DARK_GRAY);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("HY������M", Font.PLAIN, 16));
		lblTime.setBounds(0, 511, 70, 40);
		contentPane.add(lblTime);

		JLabel lblChoiceDate = new JLabel("��¥ ����");
		lblChoiceDate.setFont(new Font("HY������M", Font.PLAIN, 12));
		lblChoiceDate.setForeground(Color.DARK_GRAY);
		lblChoiceDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoiceDate.setBounds(12, 60, 121, 21);
		contentPane.add(lblChoiceDate);

		JLabel lblMyexer = new JLabel("������ �");
		lblMyexer.setForeground(Color.DARK_GRAY);
		lblMyexer.setBackground(Color.WHITE);
		lblMyexer.setFont(new Font("HY������M", Font.PLAIN, 18));
		lblMyexer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyexer.setBounds(432, 60, 340, 58);
		contentPane.add(lblMyexer);
	}

	public float showUserExerciseList(String date) {
		totalCal = 0;

		System.out.println();
		try {
			ResultSet rs_exercise = db.getInfo(
					"SELECT Ex_no, User_ID, Exercise_Date, u.Exercise_no, Exercise_Name, e.Exercise_Cal, Exercise_Time "
							+ "FROM user_exercise u LEFT OUTER JOIN exercise e " + "USING(Exercise_no) "
							+ "WHERE (User_ID = '" + user_id + "') AND (Exercise_Date ='" + selectedDate + "');");

			while (rs_exercise.next()) {
				String Exercise_no = rs_exercise.getString("Exercise_no");
				String Exercise_Name = rs_exercise.getString("Exercise_Name");
				String Exercise_Cal = rs_exercise.getString("Exercise_Cal");
				totalCal += Float.parseFloat(Exercise_Cal);
				Float Exercise_Time = rs_exercise.getFloat("Exercise_Time");
				Object data_exercise[] = { Exercise_no, Exercise_Name, Exercise_Cal, Exercise_Time };

				model2.addRow(data_exercise);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return totalCal;

	}
}