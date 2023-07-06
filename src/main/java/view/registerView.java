package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.controllerRegister;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Paths;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registerView extends JFrame {

	public JPanel contentPane;
	public JTextField txtName;
	public JTextField txtEmail;
	public JPasswordField txtPass;
	public JPasswordField txtConfirm;
	public JLabel lblName;
	public JLabel lblEmail;
	public JLabel lblPass;
	public JLabel lblConfirm;
	public JLabel lblNewLabel;
	public controllerRegister c = new controllerRegister(this);
	public JCheckBox chkAgree;
	public JButton btnHienPass, btnCancel, btnSign;
	private JButton btnAnPass;
	private JButton btnHienConfirm;
	private JButton btnAnConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerView frame = new registerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public registerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);

		JLabel lblTitle = new JLabel("REGISTER");
		lblTitle.setBounds(280, 82, 519, 37);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 33));

		txtName = new JTextField();
		txtName.setBounds(527, 169, 251, 28);
		txtName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(527, 212, 251, 28);
		txtEmail.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setBounds(527, 255, 251, 28);

		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(527, 298, 250, 28);

		chkAgree = new JCheckBox("I Agree to the Term of User");
		chkAgree.setBackground(new Color(255, 255, 255));
		chkAgree.setBounds(527, 344, 251, 25);
		chkAgree.setOpaque(false);
		chkAgree.setFocusPainted(false);
		chkAgree.setForeground(new Color(0, 0, 0));
		chkAgree.setFont(new Font("Tahoma", Font.ITALIC, 14));

		btnSign = new JButton("SIGN UP\r\n");
		btnSign.setBounds(527, 411, 92, 30);
		btnSign.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSign.addActionListener(c);

		btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(686, 411, 92, 30);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.addActionListener(c);

		lblName = new JLabel("Name");
		lblName.setBounds(280, 177, 250, 20);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(280, 223, 250, 17);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		lblPass = new JLabel("Password");
		lblPass.setBounds(280, 263, 250, 20);
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setBounds(280, 306, 250, 20);
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));

		// hien pass
		btnHienPass = new JButton("");
		btnHienPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAnPass.setVisible(true);
				btnHienPass.setVisible(false);
				txtPass.setEchoChar((char) 0);

			}
		});
		btnHienPass.setIcon(new ImageIcon(Paths.get("src/main/java/icon/hien_mk.png").toAbsolutePath().toString()));
		btnHienPass.setForeground(Color.BLACK);
		btnHienPass.setBounds(788, 255, 37, 28);
		contentPane.add(btnHienPass);

		// an pass
		btnAnPass = new JButton("");
		btnAnPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnHienPass.setVisible(true);
				btnAnPass.setVisible(false);
				txtPass.setEchoChar('*');
			}
		});
		btnAnPass.setVisible(false);
		btnAnPass.setIcon(new ImageIcon(Paths.get("src/main/java/icon/an_mk.png").toAbsolutePath().toString()));
		btnAnPass.setForeground(Color.BLACK);
		btnAnPass.setBounds(788, 255, 37, 28);
		contentPane.add(btnAnPass);

		btnHienConfirm = new JButton("");
		btnHienConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAnConfirm.setVisible(true);
				btnHienConfirm.setVisible(false);
				txtConfirm.setEchoChar((char) 0);
			}
		});
		btnHienConfirm.setIcon(new ImageIcon(Paths.get("src/main/java/icon/hien_mk.png").toAbsolutePath().toString()));
		btnHienConfirm.setForeground(Color.BLACK);
		btnHienConfirm.setBounds(787, 298, 37, 28);
		contentPane.add(btnHienConfirm);

		btnAnConfirm = new JButton("");
		btnAnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnHienConfirm.setVisible(true);
				btnAnConfirm.setVisible(false);
				txtConfirm.setEchoChar('*');
			}
		});
		btnAnConfirm.setVisible(false);
		btnAnConfirm.setIcon(new ImageIcon(Paths.get("src/main/java/icon/an_mk.png").toAbsolutePath().toString()));
		btnAnConfirm.setForeground(Color.BLACK);
		btnAnConfirm.setBounds(787, 298, 37, 28);
		contentPane.add(btnAnConfirm);

		contentPane.setLayout(null);
		contentPane.add(lblTitle);
		contentPane.add(lblName);
		contentPane.add(txtName);
		contentPane.add(lblEmail);
		contentPane.add(lblPass);
		contentPane.add(lblConfirm);
		contentPane.add(txtPass);
		contentPane.add(txtConfirm);
		contentPane.add(txtEmail);
		contentPane.add(btnSign);
		contentPane.add(btnCancel);
		contentPane.add(chkAgree);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Paths.get("src/main/java/icon/login_BG.png").toAbsolutePath().toString()));
		lblNewLabel.setBounds(0, 0, 862, 569);
		contentPane.add(lblNewLabel);

	}
}
