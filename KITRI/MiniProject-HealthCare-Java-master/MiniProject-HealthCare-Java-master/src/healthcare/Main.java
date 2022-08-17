package healthcare;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Main {

	JFrame frame;
	float recommendCalory = 0;
	private LocalDate today = LocalDate.now();
	private String user_id;

	/**
	 * @wbp.parser.constructor
	 */
	public Main() {
		initialize();
	}

	public Main(String User_ID) {
		user_id = User_ID;
		initialize();
		System.out.println(user_id);
	}

	public void mainInit() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 794, 561);
		frame.getContentPane().add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		/* ======== Ķ���� ============== */
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendar.setBounds(39, 201, 691, 350);
		contentPane.add(calendar);
		JPanel jpanel = calendar.getDayChooser().getDayPanel();
		Component component[] = jpanel.getComponents();
		// default�� ����(Date)�� �Ѱ��ش�

		calendar.getMonthChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// System.out.println(evt.getPropertyName()+ ": " + evt.getNewValue());
				if (evt.getPropertyName().toString() == "month") {
					LocalDate date = today.withMonth(Integer.parseInt(evt.getNewValue().toString()) + 1);
					calTrafficLight(component, date);
				} // ����� property���� month�� ��� �ش� month�� date�� �Ѱ��ش�

			}
		}); // Ķ���� month���� �̺�Ʈ �ڵ鷯

		// ====================================JButton====================================

		// ���� ��ư �̹���
		ImageIcon back_main = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\back_main.png");
		Image back_main1 = back_main.getImage();
		Image back_main2 = back_main1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon back_main3 = new ImageIcon(back_main2);
		/* �����Է� ��ư */
		JButton btnMain = new JButton(back_main3);
		btnMain.setFont(new Font("����", Font.BOLD, 20));
		btnMain.setBounds(39, 20, 167, 50);
		contentPane.add(btnMain);
		btnMain.setBorderPainted(false); //��ư�׵θ� ����

		// �Ĵ� ��ư �̹���
		ImageIcon back_food = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\back_food.png");
		Image back_food1 = back_food.getImage();
		Image back_food2 = back_food1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon back_food3 = new ImageIcon(back_food2);
		/* �Ĵ��Է� ��ư */
		JButton btnFoodlist = new JButton(back_food3);
		btnFoodlist.setBounds(218, 20, 167, 50);
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
		ImageIcon back_ex = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\back_ex.png");
		Image back_ex1 = back_ex.getImage();
		Image back_ex2 = back_ex1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon back_ex3 = new ImageIcon(back_ex2);
		/* ��Է� ��ư */
		JButton btnExer = new JButton(back_ex3);
		btnExer.setBounds(397, 20, 167, 50);
		btnExer.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(btnExer);
		btnExer.setBorderPainted(false); //��ư�׵θ� ����


		btnExer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExerciseList ex = new ExerciseList(user_id);
				ex.frame.setVisible(true);
				frame.dispose();

			}
		});
		// ����Ʈ ��ư �̹���
		ImageIcon back_report = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\back_report.png");
		Image back_report1 = back_report.getImage();
		Image back_report2 = back_report1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon back_report3 = new ImageIcon(back_report2);
		/* ����Ʈ ��ư */
		JButton btnRept = new JButton(back_report3);
		btnRept.setBounds(576, 20, 167, 50);
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

		/* ===================== �� =================== */
		JLabel lblCal1 = new JLabel(getCal());
		lblCal1.setForeground(Color.DARK_GRAY);
		lblCal1.setBounds(163, 108, 230, 58);
		lblCal1.setFont(new Font("HY������M", Font.PLAIN, 50));
		contentPane.add(lblCal1);
//		 getCal(lblCal1);

		JLabel lblSlash = new JLabel("/");
		lblSlash.setForeground(Color.DARK_GRAY);
		lblSlash.setBounds(398, 112, 64, 50);
		lblSlash.setFont(new Font("HY������M", Font.PLAIN, 50));
		contentPane.add(lblSlash);

		JLabel lblCal2 = new JLabel(getCal2());
		lblCal2.setForeground(Color.DARK_GRAY);
		lblCal2.setBounds(460, 105, 180, 65);
		contentPane.add(lblCal2);
		lblCal2.setFont(new Font("HY������M", Font.PLAIN, 50));
//		getCal2(lblCal2);

		JLabel lblText = new JLabel("�Ϸ���� Į�θ�");
		lblText.setFont(new Font("HY������M", Font.PLAIN, 13));
		lblText.setForeground(Color.GRAY);
		lblText.setBounds(494, 169, 103, 22);
		contentPane.add(lblText);

		calTrafficLight(component, today); // ��ȣ�� Ķ���� ���
	}

	// Į�θ� �� �󺧿� �Ѹ���
	public String getCal() {
		// db���� �� �޾ƿ���
		float day_eat_cal = 0;
		float day_use_cal = 0;
		float result = 0;
		DBConnect dao = new DBConnect();
		String sql;
		sql = "Select ifnull(Day_Use_Cal,0), ifnull(Day_Cal,0) from report where User_ID = '" + user_id
				+ "' and Report_Date = '" + today + "' LIMIT 0, 1;";
		ResultSet rs = dao.getInfo(sql);

		try {
			while (rs.next()) {
				day_use_cal = rs.getFloat("ifnull(Day_Use_Cal,0)");
				day_eat_cal = rs.getFloat("ifnull(Day_Cal,0)");
				result = day_eat_cal - day_use_cal;
				System.out.println(result + "=" + day_use_cal + "-" + day_eat_cal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(String.format("%.2f",result));
	}

	// ����Į�θ� �� �󺧿� �Ѹ���
	public String getCal2() {
		// ���������� db���� �ҷ��ͼ� ����Į�θ� ����ϱ�
		// �Ϸ� ���� Į�θ� = <ǥ��ü��>(�ڽ���Ű - 100)*0.9 * Ȱ������
		// Ȱ������ = HIGH : 60 MID : 40 LOW:20
		DBConnect dao = new DBConnect();
		String sql;

		sql = "Select Day_Recommend_Cal from user_personal where User_ID = '" + user_id + "';";
		// ȸ����ȣ�� �������� ��ȸ

		ResultSet rs = dao.getInfo(sql);

		try {
			while (rs.next()) {
				this.recommendCalory = rs.getFloat("Day_Recommend_Cal");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(recommendCalory);
	}

	public void calTrafficLight(Component component[], LocalDate changedDate) {
		float[] arr = new float[32];
		// ���� �޷��� �� get
		// �ش���� �Ϻ��� db.report�� ��Į�θ� ���
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0.0f;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		LocalDate firstDay = changedDate.with(TemporalAdjusters.firstDayOfMonth()); // 2021-02-01
		LocalDate lastDay = changedDate.with(TemporalAdjusters.lastDayOfMonth()); // 2021-02-28
		DBConnect dao = new DBConnect();
		String sql;
		sql = "Select * from report where User_ID = '" + user_id + "' and Report_Date between '" + firstDay + "' and '"
				+ lastDay + "';";
		ResultSet rs = dao.getInfo(sql);
		// today��ü�� ����ִ� ���� ù��~������ ����ƮDB�� ��Į�θ� ���
		try {
			while (rs.next()) {
				// ��¥�� �� Į�θ� �ҷ�����
				float totalCal = rs.getFloat("Day_Cal") - rs.getFloat("Day_Use_Cal");
				String date = transFormat.format(rs.getDate("Report_Date"));
				int i = Integer.parseInt(date.substring(8)); // ���ڸ� i�� ���
				System.out.println("i : " + i + " date: " + date);
				System.out.println(totalCal);
				arr[i] = totalCal;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setCalColor(arr, component, recommendCalory);

	}

	public void setCalColor(float arr[], Component component[], float recommendCalory) {
		System.out.println("recommendCalory: " + recommendCalory);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 0) {
				// System.out.println("i: " + i);
				// System.out.println("arr[i] : " + arr[i]);
				if (arr[i] >= recommendCalory * 1.3)
					component[i + 7].setBackground(new Color(254,111,105)); // ����Į�θ����� 2000Į�θ��̻� ����������
				else if (arr[i] >= recommendCalory*1.1)
					component[i + 7].setBackground(new Color(255,203,91)); // ����Į�θ����� 1000 Į�θ��̻� ����������
				else 
					component[i + 7].setBackground(new Color(137,216,174)); // ����Į�θ�-500 ~ ����Į�θ� + 999 Į�θ��̻� ����������
				
			}
		}
	}
}
