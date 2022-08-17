package healthcare;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class Report {

	JFrame frame;
	JPanel chartPanel;
	private String user_id;
	private String sql;
	LocalDate today = LocalDate.now();
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @wbp.parser.constructor
	 */

	public Report() {
		initialize();
	}

	public Report(String User_ID) {
		user_id = User_ID;
		System.out.println("user id : " + user_id);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("FoodList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// Content Panel ����
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(0, 0, 794, 124);
		frame.getContentPane().add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(true);

		// ������ CharPanel ����
		chartPanel = createChartPanel(1);
		chartPanel.setBounds(44, 138, 700, 240);
		frame.getContentPane().add(chartPanel);
		chartPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		chartPanel.setLayout(null);
		chartPanel.setVisible(true);

		// ź���� ChartPanel ����
		JPanel chartPanel2 = new JPanel();
		chartPanel2 = createChartPanel(2);
		chartPanel2.setBounds(44, 373, 700, 172);
		frame.getContentPane().add(chartPanel2);
		chartPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		chartPanel2.setLayout(null);
		chartPanel2.setVisible(true);
		// ====================================JButton====================================
		// ���� ��ư �̹���
		ImageIcon report_main = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\report_main.png");
		Image report_main1 = report_main.getImage();
		Image report_main2 = report_main1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon report_main3 = new ImageIcon(report_main2);
		// ���� ��ư
		JButton btnMain = new JButton(report_main3);
		btnMain.setFont(new Font("����", Font.BOLD, 20));
		btnMain.setBounds(40, 20, 167, 50);
		contentPane.add(btnMain);
		btnMain.setBorderPainted(false); //��ư�׵θ� ����

		btnMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main m = new Main(user_id);
				m.frame.setVisible(true);
				frame.dispose();
			}
		}); // Main��ư Ŭ�� �׼�
		// �Ĵ� ��ư �̹���
		ImageIcon report_food = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\report_food.png");
		Image report_food1 = report_food.getImage();
		Image report_food2 = report_food1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon report_food3 = new ImageIcon(report_food2);
		// �Ĵ� ��ư
		JButton btnFoodlist = new JButton(report_food3);
		btnFoodlist.setFont(new Font("����", Font.BOLD, 20));
		btnFoodlist.setBounds(219, 20, 167, 50);
		contentPane.add(btnFoodlist);
		btnFoodlist.setBorderPainted(false); //��ư�׵θ� ����

		btnFoodlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FoodList fl = new FoodList(user_id);
				fl.frame.setVisible(true);
				frame.dispose();
			}
		}); // �Ĵܹ�ư Ŭ�� �׼�
		// � ��ư �̹���
		ImageIcon report_ex = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\report_ex.png");
		Image report_ex1 = report_ex.getImage();
		Image report_ex2 = report_ex1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon report_ex3 = new ImageIcon(report_ex2);
		// ���ư
		JButton btnExer = new JButton(report_ex3);
		btnExer.setFont(new Font("����", Font.BOLD, 20));
		btnExer.setBounds(398, 20, 167, 50);
		contentPane.add(btnExer);
		btnExer.setBorderPainted(false); //��ư�׵θ� ����


		btnExer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExerciseList ex = new ExerciseList(user_id);
				ex.frame.setVisible(true);
				frame.dispose();
			}
		}); // ���ư Ŭ�� �׼�

		// ����Ʈ ��ư �̹���
		ImageIcon report_report = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\report_report.png");
		Image report_report1 = report_report.getImage();
		Image report_report2 = report_report1.getScaledInstance(167, 50, Image.SCALE_SMOOTH);
		ImageIcon report_report3 = new ImageIcon(report_report2);
		// ����Ʈ��ư
		JButton btnRept = new JButton(report_report3);
		btnRept.setFont(new Font("����", Font.BOLD, 20));
		btnRept.setBounds(577, 20, 167, 50);
		contentPane.add(btnRept);
		btnRept.setBorderPainted(false); //��ư�׵θ� ����


		// ok ��ư �̹���
		ImageIcon report_ok = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\report_ok.png");
		Image report_ok1 = report_ok.getImage();
		Image report_ok2 = report_ok1.getScaledInstance(97, 29, Image.SCALE_SMOOTH);
		ImageIcon report_ok3 = new ImageIcon(report_ok2);
		JButton btnWeightSave = new JButton(report_ok3);
		btnWeightSave.setFont(new Font("����", Font.BOLD, 20));
		btnWeightSave.setBounds(639, 95, 97, 29);
		contentPane.add(btnWeightSave);
		btnWeightSave.setBorderPainted(false); //��ư�׵θ� ����

		// =================================== textField=========================================
		
		JTextField txtWeight = new JTextField();
		txtWeight.setBounds(253, 95, 374, 29);
		contentPane.add(txtWeight);
		txtWeight.setColumns(10);
		// =================================== JLabel=========================================
		JLabel lblWeight = new JLabel("ü��");
		lblWeight.setForeground(Color.DARK_GRAY);
		lblWeight.setFont(new Font("HY������M", Font.PLAIN, 16));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(40, 95, 105, 29);
		contentPane.add(lblWeight);
		
		// =================================== dataChooser=========================================	
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(144, 95, 97, 29);
		dateChooser.setCalendar(Calendar.getInstance());
		contentPane.add(dateChooser);

		// =============================== Action Handlerr=========================================	
		
		// ������ �Է� Button Click �׼�
		btnWeightSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String weight = txtWeight.getText();
				if (!checkRightWeight(weight)) {
					JOptionPane.showMessageDialog(null, "ü���� ��Ȯ�� �Է��� �ּ���.");
					return;
				} // ������ �Է� üũ
				ResultSet rs = null;
				DBConnect dbconn = new DBConnect();
				Float curWeight = Float.parseFloat(txtWeight.getText()); // �Է¹��� ������ 0���ϰų� �Է¾��Ұ�� ����ó��
				String chosenDate = transFormat.format(dateChooser.getDate()); // dataChooser���� ��¥ �޾ƿ���
				sql = "SELECT User_Day_Weight FROM report WHERE Report_Date = '" + chosenDate + "' and User_ID = '"
						+ user_id + "';";
				rs = dbconn.getInfo(sql);

				// report table�� ������ ���� �� - insert
				try {
					if (!rs.next())
						sql = "insert into report(User_ID, Report_Date, User_Day_Weight) values ('" + user_id + "','"
								+ chosenDate + "', " + curWeight + ");";
					else {
						// report table�� ������ ���� �� - update
						sql = "UPDATE report SET User_Day_Weight = " + curWeight + " where User_ID = '" + user_id
								+ "' and Report_Date = '" + chosenDate + "';";
					}
					dbconn.updateInfo(sql);
					rs.close();
					updatePanel(chartPanel, 1); // �г� ������Ʈ
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	// ������ ChartPanel ����
	private JPanel createChartPanel(int code) {
		JFreeChart chart = null;
		CategoryDataset dataset = null;
		DBConnect dbconn = new DBConnect();
		CategoryPlot plot = null;
		LineAndShapeRenderer lineRenderer = null;
		StackedBarRenderer stackedBarRenderer = null;
		DecimalFormat decimalformat = new DecimalFormat("##");
		switch (code) {
		case 1: // ������ ��Ʈ
			CreateChart ch = new CreateChart(user_id, "ü�� ��ȭ �׷���", "Day", "Weight(kg)");
			dataset = ch.createDataset(1, dbconn);
			chart = ChartFactory.createLineChart(ch.chartTitle, ch.categoryAxisLabel, ch.valueAxisLabel, dataset);

			plot = (CategoryPlot) chart.getPlot();
			ValueAxis vaxis = (ValueAxis) plot.getRangeAxis();
			vaxis.setRange(30, 120); // y�� ���� (���������� - 10 , �������ְ� + 10)
			lineRenderer = (LineAndShapeRenderer) plot.getRenderer();
			lineRenderer.setDefaultShapesVisible(true);
			lineRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalformat));
			lineRenderer.setDefaultItemLabelsVisible(true);
			lineRenderer.setDefaultSeriesVisible(true);
			break;
		case 2: // ź���� ��Ʈ
			CreateChart ch2 = new CreateChart(user_id, "������ ź����", "", "total(g)");
			dataset = ch2.createDataset(2, dbconn);
			chart = ChartFactory.createStackedBarChart(ch2.chartTitle, ch2.categoryAxisLabel, ch2.valueAxisLabel,
					dataset, PlotOrientation.HORIZONTAL, true, true, false);

			plot = (CategoryPlot) chart.getPlot();
			stackedBarRenderer = (StackedBarRenderer) plot.getRenderer();
			stackedBarRenderer
					.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalformat));
			stackedBarRenderer.setDefaultItemLabelsVisible(true);
			stackedBarRenderer.setDefaultSeriesVisible(true);
			break;
		}
		chart.getTitle().setFont(new Font("���� ���", Font.BOLD, 18));
		chart.getLegend().setItemFont(new Font("���� ���", Font.BOLD, 15));
		return new ChartPanel(chart);
	}

	// �г� ������Ʈ
	private void updatePanel(JPanel panel, int code) {
		frame.remove(panel);
		this.chartPanel = createChartPanel(code);
		this.chartPanel.setBounds(50, 140, 700, 240);
		this.chartPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(this.chartPanel);

		frame.revalidate();
		frame.repaint();

		this.chartPanel.setLayout(null);
		this.chartPanel.setVisible(true);
	}

	// ������ �ùٸ��� �Է��ߴ��� Ȯ��
	private boolean checkRightWeight(String weight) {
		try {
			if (weight.isEmpty() || Float.parseFloat(weight) <= 0) {
				return false;
			} else
				return true;
		} catch (Exception ex) {
			return false;
		}
	}
}