package healthcare;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Health_Login extends JFrame {
	DBConnect DBConnect = new DBConnect();

	private JPanel Login_panel;
	private JTextField loginID;
	private JButton loginBtn, joinBtn;
	private JLabel lblJoin;
	private JButton exitBtn;
	private JPasswordField loginPWD;

	// ������ ����
	public Health_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 400, 418, 295);
		Login_panel = new JPanel();
		Login_panel.setBackground(Color.WHITE);
		Login_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Login_panel);
		Login_panel.setLayout(null);
		Login_panel.setLayout(null);

		lblJoin = new JLabel("�α���");
		lblJoin.setForeground(new Color(255, 255, 255));
		Font f1 = new Font("����", Font.BOLD, 20);// ����ü
		Login_panel.setLayout(null);
		lblJoin.setFont(new Font("HY������M", Font.PLAIN, 16));
		lblJoin.setBounds(175, 0, 55, 32);
		Login_panel.add(lblJoin);
		

		// �α��� ��
		JLabel lblLogin = new JLabel("ID");
		lblLogin.setFont(new Font("HY������M", Font.PLAIN, 15));
		lblLogin.setBounds(45, 71, 29, 35);
		Login_panel.add(lblLogin);

		// �н����� ��
		JLabel lblPassword = new JLabel("PWD");
		lblPassword.setFont(new Font("HY������M", Font.PLAIN, 15));
		lblPassword.setBounds(37, 128, 36, 35);
		Login_panel.add(lblPassword);

		// �α��� �ؽ�Ʈ�ʵ�
		loginID = new JTextField();
		loginID.setFont(new Font("HY������M", Font.PLAIN, 12));
		loginID.setBounds(86, 71, 176, 35);
		Login_panel.add(loginID);
		loginID.setColumns(10);

		// ȸ������ ��ư �̹���
		ImageIcon join = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\login_signup.png");
		Image join1 = join.getImage();
		Image join2 = join1.getScaledInstance(104, 29, Image.SCALE_SMOOTH);
		ImageIcon join4 = new ImageIcon(join2);
		// ȸ������ ��ư
		joinBtn = new JButton(join4);
		joinBtn.setFont(new Font("HY������M", Font.PLAIN, 12));
		joinBtn.setBackground(Color.WHITE);
		joinBtn.setBounds(71, 202, 104, 29);
		Login_panel.add(joinBtn);
		joinBtn.setBorderPainted(false); //��ư�׵θ� ���ֱ�

		// ���� ��ư �̹���
		ImageIcon close = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\login_close.png");
		Image close1 = close.getImage();
		Image close2 = close1.getScaledInstance(104, 29, Image.SCALE_SMOOTH);
		ImageIcon close3 = new ImageIcon(close2);
		// ���� ��ư
		exitBtn = new JButton(close3);
		exitBtn.setFont(new Font("HY������M", Font.PLAIN, 12));
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setBounds(232, 202, 104, 29);
		Login_panel.add(exitBtn);
		exitBtn.setBorderPainted(false); //��ư�׵θ� ���ֱ�

		// �α��� ��ư �̹���
		ImageIcon login = new ImageIcon("C:\\Users\\kitri\\Desktop\\�̴�������Ʈ\\icon\\login_login.png");
		Image login1 = login.getImage();
		Image login2 = login1.getScaledInstance(78, 92, Image.SCALE_SMOOTH);
		ImageIcon login3 = new ImageIcon(login2);
		// �α��� ��ư
		loginBtn = new JButton(login3);
		loginBtn.setFont(new Font("HY������M", Font.PLAIN, 15));
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBounds(281, 71, 78, 92);
		Login_panel.add(loginBtn);
		loginBtn.setBorderPainted(false); //��ư�׵θ� ����

		loginPWD = new JPasswordField();
		loginPWD.setFont(new Font("Arial", Font.PLAIN, 15));
		loginPWD.setBounds(85, 128, 176, 32);
		Login_panel.add(loginPWD);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 402, 32);
		Login_panel.add(panel);
		panel.setBackground(new Color(112,139,151)); ////�гλ���ٲٱ�

		setVisible(true);

		// ȸ������ �׼�
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Health_Join frame = new Health_Join();
				dispose();

			}
		});

		// ���� �׼�
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// �α��� �׼�
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String User_ID = loginID.getText();
				char[] PSW = loginPWD.getPassword();
				String User_Password = String.valueOf(PSW);

				// �α��� �� �Ѿ��
				int login = healthcare.DBConnect.login(User_ID, User_Password);
				if (login >= 1) {
					Main main = new Main(User_ID);
					dispose();
					main.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
			}
		});

	}
}
