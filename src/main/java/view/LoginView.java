package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginListener;
import dao.userDAO;
import model.user;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JPanel pnlBackground_contentPane;
	private JPanel pnlFormLogin_contentPane;
	private JLabel lblTitle_pnlFormLogin_contentPane;
	private JLabel lblUsername_pnlFormLogin_contentPane;
	private JLabel lblPassword_pnlFormLogin_contentPane;
	private JLabel lblForgot_pnlFormLogin_contentPane;
	private JLabel lblCreateAccount_pnlFormLogin_contentPane;
	
	private JTextField txtUsername_pnlFormLogin_contentPane;
	private JPasswordField txtPassword_pnlFormLogin_contentPane;
	
	private JCheckBox chkRemember_pnlFormLogin_contentPane;
	
	private JButton btnLogin_pnlFormLogin_contentPane;
	
	private Font fontTitle;
	private Font fontLabel;
	private Font fontText;
	
	private String userName;
	private String passWord;
	private String role = "";
	private String regexUserName = "^\\D+.*@\\D+\\.\\D+(\\.\\D+)*";

	private LoginListener loginC = new LoginListener(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		this.setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 862, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.setLayout(null);
		setContentPane(contentPane);
		this.init();
	}
	
	public void init()
	{
		//setPanelMainContent
		pnlBackground_contentPane = new JPanel();
		pnlBackground_contentPane.setBounds(0,0, this.getWidth() , this.getHeight());
		pnlBackground_contentPane.setBackground(Color.green);
		pnlBackground_contentPane.setLayout(null);
		
		//addbackGround
		JLabel lblBackground_pnlBackground_contentPane = new JLabel();
//		lblBackground_pnlBackground_contentPane.setIcon(new ImageIcon(Paths.get("src/main/java/img/Background.png").toAbsolutePath().toString()));
		lblBackground_pnlBackground_contentPane.setIcon(new ImageIcon("E:\\Eclipse Project\\nhatdlps26321\\src\\main\\java\\img\\Background.png"));
		lblBackground_pnlBackground_contentPane.setBounds(0,0 , 862, 569);
		pnlBackground_contentPane.add(lblBackground_pnlBackground_contentPane);
		
		
		//addForm
		pnlFormLogin_contentPane = new JPanel();
		pnlFormLogin_contentPane.setLayout(null);
		pnlFormLogin_contentPane.setBackground(Color.white);
		pnlFormLogin_contentPane.setForeground(Color.black);
		pnlFormLogin_contentPane.setBounds(450, 75, 350, 400);
		
		fontTitle = new Font("Calibri" , Font.BOLD , 30);
		fontLabel = new Font("Calibri" , Font.BOLD , 14);
		fontText = new Font("Calibri Light" , 0 , 14);
		
		lblTitle_pnlFormLogin_contentPane = new JLabel("USER LOGIN");
		lblTitle_pnlFormLogin_contentPane.setFont(fontTitle);
		lblTitle_pnlFormLogin_contentPane.setForeground(new Color(0, 191, 255));
		lblTitle_pnlFormLogin_contentPane.setBounds(105, 62, 169, 30);
		
		lblUsername_pnlFormLogin_contentPane = new JLabel();
		lblUsername_pnlFormLogin_contentPane.setFont(fontLabel);
		lblUsername_pnlFormLogin_contentPane.setBounds(43, 116, 32, 30);
		//lblUsername_pnlFormLogin_contentPane.setIcon(new ImageIcon(Paths.get("src/main/java/img/User_Icon.png").toAbsolutePath().toString()));
		lblUsername_pnlFormLogin_contentPane.setIcon(new ImageIcon("E:\\Eclipse Project\\nhatdlps26321\\src\\main\\java\\img\\User_Icon.png"));
		
		lblPassword_pnlFormLogin_contentPane = new JLabel();
		lblPassword_pnlFormLogin_contentPane.setFont(fontLabel);
		lblPassword_pnlFormLogin_contentPane.setBounds(43, 157, 32, 30);
		//lblUsername_pnlFormLogin_contentPane.setIcon(new ImageIcon(Paths.get("src/main/java/img/Pass_Icon.png").toAbsolutePath().toString()));
		lblPassword_pnlFormLogin_contentPane.setIcon(new ImageIcon("E:\\Eclipse Project\\nhatdlps26321\\src\\main\\java\\img\\Pass_Icon.png"));
		
		txtUsername_pnlFormLogin_contentPane = new JTextField(50);
		txtUsername_pnlFormLogin_contentPane.setFont(fontText);
		txtUsername_pnlFormLogin_contentPane.setBounds(85, 116, 225, 30);
		
		txtPassword_pnlFormLogin_contentPane = new JPasswordField(50);
		txtPassword_pnlFormLogin_contentPane.setFont(fontText);
		txtPassword_pnlFormLogin_contentPane.setBounds(85, 157, 225, 30);
		
		chkRemember_pnlFormLogin_contentPane = new JCheckBox("Remember ?");
		chkRemember_pnlFormLogin_contentPane.setForeground(new Color(0, 191, 255));
		chkRemember_pnlFormLogin_contentPane.setSelected(false);
		chkRemember_pnlFormLogin_contentPane.setFont(fontLabel);
		chkRemember_pnlFormLogin_contentPane.setBounds(59, 208, 100, 30);
		chkRemember_pnlFormLogin_contentPane.setBackground(Color.white);
		
		lblForgot_pnlFormLogin_contentPane = new JLabel("Forgotten Password!!!");
		lblForgot_pnlFormLogin_contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginC.forgottenPassword();
			}
		});
		lblForgot_pnlFormLogin_contentPane.setForeground(new Color(0, 191, 255));
		lblForgot_pnlFormLogin_contentPane.setFont(fontLabel);
		lblForgot_pnlFormLogin_contentPane.setBounds(178, 208 , 149,30);

		
		btnLogin_pnlFormLogin_contentPane = new JButton("Log In");
		btnLogin_pnlFormLogin_contentPane.setFont(new Font("Calibri" , Font.BOLD , 20));
		btnLogin_pnlFormLogin_contentPane.setBackground(new Color(0 , 191 , 255));
		btnLogin_pnlFormLogin_contentPane.setForeground(Color.white);
		btnLogin_pnlFormLogin_contentPane.setBounds(130 , 263 , 110, 30);
		btnLogin_pnlFormLogin_contentPane.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				userName = txtUsername_pnlFormLogin_contentPane.getText();
				char[] pw = txtPassword_pnlFormLogin_contentPane.getPassword();
				passWord = new String(pw);
				if(userName.matches(regexUserName))
				{
					user u = new user(userName, passWord , "");
					user user = userDAO.getuserDAO().selectG(u);
					if(!user.getUsername().equals(""))
					{
						loginC.logIn(user , u);
					}
				}
				
			}
		});
		
		lblCreateAccount_pnlFormLogin_contentPane = new JLabel("Create Account");
		lblCreateAccount_pnlFormLogin_contentPane.setFont(fontText);
		lblCreateAccount_pnlFormLogin_contentPane.setBackground(new Color(0 , 191 , 255));
		lblCreateAccount_pnlFormLogin_contentPane.setBounds(139 , 321 , 93, 30);
		lblCreateAccount_pnlFormLogin_contentPane.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						loginC.creatAccount();
					}
				});

		
		pnlFormLogin_contentPane.add(lblTitle_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(lblUsername_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(lblPassword_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(txtUsername_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(txtPassword_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(chkRemember_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(lblForgot_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(btnLogin_pnlFormLogin_contentPane);
		pnlFormLogin_contentPane.add(lblCreateAccount_pnlFormLogin_contentPane);
		
		
		
		//add to contentPane
		contentPane.add(pnlFormLogin_contentPane);
		contentPane.add(pnlBackground_contentPane);
	}

}
