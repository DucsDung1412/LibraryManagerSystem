package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.libraryManagerSystemController;
import dao.sachDAO;
import dao.userDAO;
import model.sach;
import model.user;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class libraryManagerSystemView extends JFrame {
	// thong tin
	public String emailLogin = "";
	public File fileClone = new File("");
	public String maSach = "";
	
	// controller
	private libraryManagerSystemController controller = new libraryManagerSystemController(this);
	
	// components
	public JPanel contentPane;
	public JTextField txtEmail_panelTTCN;
	public JTextField txtHoTen_panelTTCN;
	public JTextField txtSDT_panelTTCN;
	public JPasswordField txtMatKhau_panelTTCN;
	public JLabel lblTitle_panelTTCT;
	public JTextArea txtDiaChi_panelTTCN;
	public ImageRound imgAvata_panelMain;
	private JTextField txtNhaXuatBan_panelCTS;
	public JLabel imgHome_panelTop, imgMyBook_panelTop, imgBookManager_panelTop, imgUserManager_panelTop, imgThongKe_panelTop;
	public JPanel panel_top;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					libraryManagerSystemView frame = new libraryManagerSystemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 */
	public libraryManagerSystemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_top = new JPanel();
		panel_top.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_top.setBackground(Color.WHITE);
		panel_top.setBounds(-1, 0, this.getWidth() - 14, 148);
		contentPane.add(panel_top);
		panel_top.setLayout(null);

		// logo panelTop
		JLabel imgLogo_panelTop = new JLabel("");
		imgLogo_panelTop.setBounds(16, -18, 155, 156);
		ImageIcon imgILogo_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/logo.png").toAbsolutePath().toString());
//		ImageIcon imgILogo_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\logo.png");
		Image imLogo_panelTop = imgILogo_panelTop.getImage();
		Image imageLogo_panelTop = imLogo_panelTop.getScaledInstance(imgLogo_panelTop.getWidth(),
				imgLogo_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconLogo_panelTop = new ImageIcon(imageLogo_panelTop);
		imgLogo_panelTop.setIcon(imageIconLogo_panelTop);
		panel_top.add(imgLogo_panelTop);

		// Home
		imgHome_panelTop = new JLabel("Home");
		imgHome_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				imgHome_panelTop.setBackground(new Color(255, 255, 255));
				imgHome_panelTop.setOpaque(true);
				
				imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
				imgMyBook_panelTop.setOpaque(false);
				
				imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
				imgBookManager_panelTop.setOpaque(false);
				
				imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
				imgUserManager_panelTop.setOpaque(false);
				
				imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
				imgThongKe_panelTop.setOpaque(false);
			}
		});
		imgHome_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgHome_panelTop.setBackground(new Color(255, 255, 255));
		imgHome_panelTop.setOpaque(true);
		imgHome_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgHome_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgHome_panelTop.setBounds(276, 0, 74, 109);
		imgHome_panelTop.setVerticalTextPosition(JLabel.BOTTOM);
		imgHome_panelTop.setHorizontalTextPosition(JLabel.CENTER);
		ImageIcon imgIHome_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIHome_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_home_setting.png");
		Image imHome_panelTop = imgIHome_panelTop.getImage();
		Image imageHome_panelTop = imHome_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconHome_panelTop = new ImageIcon(imageHome_panelTop);
		imgHome_panelTop.setIcon(imageIconHome_panelTop);
		panel_top.add(imgHome_panelTop);

		// Sach cua toi
		imgMyBook_panelTop = new JLabel("Sách của tôi");
		imgMyBook_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				imgHome_panelTop.setBackground(new Color(244, 244, 244));
				imgHome_panelTop.setOpaque(false);
				
				imgMyBook_panelTop.setBackground(new Color(255, 255, 255));
				imgMyBook_panelTop.setOpaque(true);
				
				imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
				imgBookManager_panelTop.setOpaque(false);
				
				imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
				imgUserManager_panelTop.setOpaque(false);
				
				imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
				imgThongKe_panelTop.setOpaque(false);
			}
		});
		imgMyBook_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgMyBook_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgMyBook_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgMyBook_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgMyBook_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgMyBook_panelTop.setBounds(370, 0, 118, 109);
		ImageIcon imgIMyBook_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/icon_my_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIMyBook_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_my_setting.png");
		Image imMyBook_panelTop = imgIMyBook_panelTop.getImage();
		Image imageMyBook_panelTop = imMyBook_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconMyBook_panelTop = new ImageIcon(imageMyBook_panelTop);
		imgMyBook_panelTop.setIcon(imageIconMyBook_panelTop);
		panel_top.add(imgMyBook_panelTop);

		// Quan ly sach
		imgBookManager_panelTop = new JLabel("Quản lý sách");
		imgBookManager_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLSach();
			}
		});
		imgBookManager_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgBookManager_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgBookManager_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgBookManager_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgBookManager_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgBookManager_panelTop.setBounds(508, 0, 118, 109);
		ImageIcon imgIBookManager_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/icon_book_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIBookManager_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_book_setting.png");
		Image imBookManager_panelTop = imgIBookManager_panelTop.getImage();
		Image imageBookManager_panelTop = imBookManager_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconBookManager_panelTop = new ImageIcon(imageBookManager_panelTop);
		imgBookManager_panelTop.setIcon(imageIconBookManager_panelTop);
		panel_top.add(imgBookManager_panelTop);

		// quan ly user
		imgUserManager_panelTop = new JLabel("Quản lý user");
		imgUserManager_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLUser();
			}
		});
		imgUserManager_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgUserManager_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgUserManager_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgUserManager_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgUserManager_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgUserManager_panelTop.setBounds(646, 0, 118, 109);
		ImageIcon imgIUserManager_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/icon_user_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIUserManager_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imUserManager_panelTop = imgIUserManager_panelTop.getImage();
		Image imageUserManager_panelTop = imUserManager_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconUserManager_panelTop = new ImageIcon(imageUserManager_panelTop);
		imgUserManager_panelTop.setIcon(imageIconUserManager_panelTop);
		panel_top.add(imgUserManager_panelTop);

		// Thong ke
		imgThongKe_panelTop = new JLabel("Thống kê");
		imgThongKe_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseThongKe();
			}
		});
		imgThongKe_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgThongKe_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgThongKe_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgThongKe_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgThongKe_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgThongKe_panelTop.setBounds(784, 0, 93, 109);
		ImageIcon imgIThongKe_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/icon_thongke_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIThongKe_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_thongke_setting.png");
		Image imThongKe_panelTop = imgIThongKe_panelTop.getImage();
		Image imageThongKe_panelTop = imThongKe_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconThongKe_panelTop = new ImageIcon(imageThongKe_panelTop);
		imgThongKe_panelTop.setIcon(imageIconThongKe_panelTop);
		panel_top.add(imgThongKe_panelTop);

		// separator_panelTop
		JSeparator separator_panelTop = new JSeparator();
		separator_panelTop.setForeground(new Color(0, 0, 0));
		separator_panelTop.setOrientation(SwingConstants.VERTICAL);
		separator_panelTop.setBackground(new Color(0, 0, 0));
		separator_panelTop.setBounds(1160, 0, 1, 109);
		panel_top.add(separator_panelTop);

		// user
		JLabel imgUser_panelTop = new JLabel("");
		imgUser_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseTTCN();
			}
		});
		imgUser_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgUser_panelTop.setBounds(1176, 14, 36, 36);
		ImageIcon imgIUser_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/user.png").toAbsolutePath().toString());
//		ImageIcon imgIUser_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imUser_panelTop = imgIUser_panelTop.getImage();
		Image imageUser_panelTop = imUser_panelTop.getScaledInstance(imgUser_panelTop.getWidth(),
				imgUser_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconUser_panelTop = new ImageIcon(imageUser_panelTop);
		imgUser_panelTop.setIcon(imageIconUser_panelTop);
		panel_top.add(imgUser_panelTop);

		// noti
		JLabel imgNoti_panelTop = new JLabel("");
		imgNoti_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				imgHome_panelTop.setBackground(new Color(244, 244, 244));
				imgHome_panelTop.setOpaque(false);
				
				imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
				imgMyBook_panelTop.setOpaque(false);
				
				imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
				imgBookManager_panelTop.setOpaque(false);
				
				imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
				imgUserManager_panelTop.setOpaque(false);
				
				imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
				imgThongKe_panelTop.setOpaque(false);
			}
		});
		imgNoti_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgNoti_panelTop.setBounds(1236, 14, 36, 36);
		ImageIcon imgINoti_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/thongbao.png").toAbsolutePath().toString());
//		ImageIcon imgINoti_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imNoti_panelTop = imgINoti_panelTop.getImage();
		Image imageNoti_panelTop = imNoti_panelTop.getScaledInstance(imgNoti_panelTop.getWidth(),
				imgNoti_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconNoti_panelTop = new ImageIcon(imageNoti_panelTop);
		imgNoti_panelTop.setIcon(imageIconNoti_panelTop);
		panel_top.add(imgNoti_panelTop);

		// setting
		JLabel imgSetting_panelTop = new JLabel("");
		imgSetting_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				imgHome_panelTop.setBackground(new Color(244, 244, 244));
				imgHome_panelTop.setOpaque(false);
				
				imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
				imgMyBook_panelTop.setOpaque(false);
				
				imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
				imgBookManager_panelTop.setOpaque(false);
				
				imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
				imgUserManager_panelTop.setOpaque(false);
				
				imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
				imgThongKe_panelTop.setOpaque(false);
			}
		});
		imgSetting_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgSetting_panelTop.setBounds(1176, 62, 36, 36);
		ImageIcon imgISetting_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/setting_banhrang.png").toAbsolutePath().toString());
//		ImageIcon imgISetting_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imSetting_panelTop = imgISetting_panelTop.getImage();
		Image imageSetting_panelTop = imSetting_panelTop.getScaledInstance(imgSetting_panelTop.getWidth(),
				imgSetting_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconSetting_panelTop = new ImageIcon(imageSetting_panelTop);
		imgSetting_panelTop.setIcon(imageIconSetting_panelTop);
		panel_top.add(imgSetting_panelTop);

		// exit
		JLabel imgLogout_panelTop = new JLabel("");
		imgLogout_panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.logOut();
			}
		});
		imgLogout_panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgLogout_panelTop.setBounds(1236, 62, 36, 36);
		ImageIcon imgILogout_panelTop = new ImageIcon(
				Paths.get("src/main/java/icon/dangxuat.png").toAbsolutePath().toString());
//		ImageIcon imgILogout_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imLogout_panelTop = imgILogout_panelTop.getImage();
		Image imageLogout_panelTop = imLogout_panelTop.getScaledInstance(imgLogout_panelTop.getWidth(),
				imgLogout_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconLogout_panelTop = new ImageIcon(imageLogout_panelTop);
		imgLogout_panelTop.setIcon(imageIconLogout_panelTop);
		panel_top.add(imgLogout_panelTop);

		// image background
		JLabel imgBG_panelTop = new JLabel("");
		imgBG_panelTop.setBackground(new Color(0, 0, 0));
		imgBG_panelTop.setBounds(0, 0, panel_top.getWidth(), panel_top.getHeight());
//		ImageIcon imgIBG_panelTop = new ImageIcon(Paths.get("src/main/java/icon/main_BG1.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelTop = new ImageIcon(
				"C:\\Users\\Admin\\eclipse-workspace\\librarySys\\src\\main\\java\\icon\\main_BG1.png");
		Image imBG_panelTop = imgIBG_panelTop.getImage();
		Image imageBG_panelTop = imBG_panelTop.getScaledInstance(imgBG_panelTop.getWidth(), imgBG_panelTop.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelTop = new ImageIcon(imageBG_panelTop);
		imgBG_panelTop.setIcon(imageIconBG_panelTop);
		panel_top.add(imgBG_panelTop);

		// Thêm panel tại đây
		contentPane.add(panel_ThongKe());
	}

	public JPanel panel_TTCN() {
		// Find user login
//		this.emailLogin = this.emailLogin;
		user userLoginClone = new user();
		userLoginClone.setUsername(emailLogin);
		final user userLogin = userDAO.getuserDAO().selectG(userLoginClone);
		
		JPanel panel_TTCN = new JPanel();
		panel_TTCN.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_TTCN.setBackground(new Color(255, 255, 255));
		panel_TTCN.setBounds(-1, 158, 1286, 616);
		panel_TTCN.setLayout(null);

		// bat dau code

		JPanel panel_main = new JPanel();
		panel_main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtHoTen_panelTTCN.setEditable(true);
				txtMatKhau_panelTTCN.setEditable(true);
				txtSDT_panelTTCN.setEditable(true);
				txtDiaChi_panelTTCN.setEditable(true);
			}
		});
		panel_main.setBackground(new Color(255, 255, 255));
		panel_main.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.setBounds(60, 16, 1166, 556);
		panel_TTCN.add(panel_main);
		panel_main.setLayout(null);

		imgAvata_panelMain = new ImageRound();
		imgAvata_panelMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imgAvata_panelMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.setAvataUser();
			}
		});
		imgAvata_panelMain.setLocation(493, 50);
		imgAvata_panelMain.setSize(180, 160);
		imgAvata_panelMain.setImage(new javax.swing.ImageIcon(
				Paths.get("src\\main\\java\\icon\\" + userLogin.getTtcn().getHinh()).toAbsolutePath().toString()));
//		imgAvata_panelMain.setImage(new javax.swing.ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\librarySys\\src\\main\\java\\icon\\employee.png")); 
		panel_main.add(imgAvata_panelMain);

		JLabel lblTitle_panelTTCN = new JLabel("Thông tin cá nhân");
		lblTitle_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitle_panelTTCN.setBounds(10, 10, 233, 39);
		panel_main.add(lblTitle_panelTTCN);

		JLabel lblEmail_panelTTCN = new JLabel("Email");
		lblEmail_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 26));
		lblEmail_panelTTCN.setBounds(50, 243, 136, 39);
		panel_main.add(lblEmail_panelTTCN);

		JLabel lblHoTen__panelTTCN = new JLabel("Họ & Tên");
		lblHoTen__panelTTCN.setFont(new Font("Calibri", Font.BOLD, 26));
		lblHoTen__panelTTCN.setBounds(50, 302, 136, 39);
		panel_main.add(lblHoTen__panelTTCN);

		JLabel lblDiaChi_panelTTCN = new JLabel("Địa chỉ");
		lblDiaChi_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 26));
		lblDiaChi_panelTTCN.setBounds(50, 361, 136, 39);
		panel_main.add(lblDiaChi_panelTTCN);

		txtEmail_panelTTCN = new JTextField();
		txtEmail_panelTTCN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtEmail_panelTTCN.setBackground(new Color(255,255,255));
		txtEmail_panelTTCN.setEditable(false);
		txtEmail_panelTTCN.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtEmail_panelTTCN.setText(userLogin.getUsername());
		txtEmail_panelTTCN.setBounds(195, 243, 390, 39);
		panel_main.add(txtEmail_panelTTCN);
		txtEmail_panelTTCN.setColumns(10);

		txtHoTen_panelTTCN = new JTextField();
		txtHoTen_panelTTCN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtHoTen_panelTTCN.getText().equals("")) {
					txtHoTen_panelTTCN.setText(userLogin.getUsername());
				}
			}
		});
		txtHoTen_panelTTCN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtHoTen_panelTTCN.setBackground(new Color(255,255,255));
		txtHoTen_panelTTCN.setEditable(false);
		txtHoTen_panelTTCN.setText(userLogin.getTtcn().getTen());
		txtHoTen_panelTTCN.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtHoTen_panelTTCN.setColumns(10);
		txtHoTen_panelTTCN.setBounds(195, 302, 390, 39);
		panel_main.add(txtHoTen_panelTTCN);

		txtDiaChi_panelTTCN = new JTextArea();
		txtDiaChi_panelTTCN.setEditable(false);
		txtDiaChi_panelTTCN.setLineWrap(true);
		txtDiaChi_panelTTCN.setWrapStyleWord(true);
		txtDiaChi_panelTTCN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtDiaChi_panelTTCN.setText(userLogin.getTtcn().getDiaChi());
		txtDiaChi_panelTTCN.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtDiaChi_panelTTCN.setBounds(197, 368, 919, 113);
		panel_main.add(txtDiaChi_panelTTCN);

		JLabel lblMatKhau_panelTTCN = new JLabel("Mật khẩu");
		lblMatKhau_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 26));
		lblMatKhau_panelTTCN.setBounds(622, 243, 141, 39);
		panel_main.add(lblMatKhau_panelTTCN);

		JLabel lblSDT_panelTTCN = new JLabel("Số điện thoại");
		lblSDT_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 26));
		lblSDT_panelTTCN.setBounds(622, 302, 156, 39);
		panel_main.add(lblSDT_panelTTCN);

		txtSDT_panelTTCN = new JTextField();
		txtSDT_panelTTCN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtSDT_panelTTCN.setBackground(new Color(255,255,255));
		txtSDT_panelTTCN.setEditable(false);
		txtSDT_panelTTCN.setText(userLogin.getTtcn().getSoDienThoai());
		txtSDT_panelTTCN.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtSDT_panelTTCN.setColumns(10);
		txtSDT_panelTTCN.setBounds(788, 302, 328, 39);
		panel_main.add(txtSDT_panelTTCN);

		txtMatKhau_panelTTCN = new JPasswordField();
		txtMatKhau_panelTTCN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMatKhau_panelTTCN.getText().equals("")) {
					txtMatKhau_panelTTCN.setText(userLogin.getPassword());
				}
			}
		});
		txtMatKhau_panelTTCN.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtMatKhau_panelTTCN.setBackground(new Color(255,255,255));
		txtMatKhau_panelTTCN.setEditable(false);
		txtMatKhau_panelTTCN.setText(userLogin.getPassword());
		txtMatKhau_panelTTCN.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtMatKhau_panelTTCN.setBounds(788, 243, 328, 39);
		panel_main.add(txtMatKhau_panelTTCN);

		JButton btnLuu_panelTTCN = new JButton("Lưu thay đổi");
		btnLuu_panelTTCN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLuu_panelTTCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveUser();
			}
		});
		btnLuu_panelTTCN.setBackground(new Color(255,255,255));
		btnLuu_panelTTCN.setBackground(new Color(192, 192, 192));
		btnLuu_panelTTCN.setFocusPainted(false);
		btnLuu_panelTTCN.setVerticalAlignment(SwingConstants.TOP);
		btnLuu_panelTTCN.setFont(new Font("Calibri", Font.BOLD, 30));
		btnLuu_panelTTCN.setBounds(476, 500, 213, 39);
		panel_main.add(btnLuu_panelTTCN);

		// ket thuc code

		return panel_TTCN;
	}
	

	public JScrollPane panel_TTS() {
		// tim sach
		sach sachClone = new sach();
		this.maSach = "MS08";
		sachClone.setMaSach(maSach);
		sach sach = sachDAO.getsachDAO().selectG(sachClone);
		
//		System.out.println(sach.getMoTa());
		
		final JScrollPane scrollPane_TTS = new JScrollPane();
		scrollPane_TTS.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_TTS.setBackground(new Color(255, 255, 255));
		scrollPane_TTS.setBounds(0, 148, 1286, 616);

		JPanel panel_main = new JPanel();
		panel_main.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_main.setBackground(new Color(255, 255, 255));
		scrollPane_TTS.setViewportView(panel_main);
		panel_main.setPreferredSize(new Dimension(1267, 1274));
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.Y_AXIS));

		JPanel panel_TTS = new JPanel();
		panel_TTS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_TTS.setBackground(new Color(255, 255, 255));
		panel_TTS.setPreferredSize(new Dimension(1267, 4)); // Set the preferred size of panel_1
		panel_main.add(panel_TTS);
		panel_TTS.setLayout(null);
		
		
		// panel Gioi Thieu
		JPanel panel_GT = new JPanel();
		panel_GT.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_GT.setBounds(66, 10, 1140, 337);
		panel_TTS.add(panel_GT);
		panel_GT.setLayout(null);

		JLabel imgSach_panelGT = new JLabel("");
		imgSach_panelGT.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		imgSach_panelGT.setBounds(0, 0, 1140, 268);
//			ImageIcon imgIBG_panelTop = new ImageIcon(Paths.get("src/main/java/icon/main_BG1.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelTTS = new ImageIcon(
				"C:\\Users\\Admin\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-07-16 154106.png");
		Image imBG_panelTTS = imgIBG_panelTTS.getImage();
		Image imageBG_panelTTS = imBG_panelTTS.getScaledInstance(imgSach_panelGT.getWidth(),
				imgSach_panelGT.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelTTS = new ImageIcon(imageBG_panelTTS);
		imgSach_panelGT.setIcon(imageIconBG_panelTTS);
		panel_GT.add(imgSach_panelGT);

		JButton btnDatSach_panelGT = new JButton("Đặt sách");
		btnDatSach_panelGT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.datSach();
			}
		});
		btnDatSach_panelGT.setFocusPainted(false);
		btnDatSach_panelGT.setForeground(new Color(255, 255, 255));
		btnDatSach_panelGT.setBackground(new Color(27, 161, 226));
		btnDatSach_panelGT.setFont(new Font("Arial", Font.BOLD, 24));
		btnDatSach_panelGT.setBounds(10, 278, 144, 49);
		panel_GT.add(btnDatSach_panelGT);

		JLabel lblTitle_panelGT = new JLabel(
				"Lập trình hướng đối tượng JAVA core dành cho người mới bắt đầu học lập trình");
		lblTitle_panelGT.setFont(new Font("Arial", Font.PLAIN, 22));
		lblTitle_panelGT.setBounds(164, 278, 931, 49);
		panel_GT.add(lblTitle_panelGT);
		
		
		// panel Thong tin chi tiet
		JPanel panel_TTCT = new JPanel();
		panel_TTCT.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TTCT.setBackground(new Color(255, 255, 255));
		panel_TTCT.setBounds(66, 368, 1140, 166);
		panel_TTS.add(panel_TTCT);
		panel_TTCT.setLayout(null);
		
		lblTitle_panelTTCT = new JLabel("Thông tin chi tiết");
		lblTitle_panelTTCT.setFont(new Font("Calibri", Font.BOLD, 26));
		lblTitle_panelTTCT.setBounds(10, 10, 252, 33);
		panel_TTCT.add(lblTitle_panelTTCT);
		
		JTextPane txtKey_panelTTCT = new JTextPane();
		txtKey_panelTTCT.setEditable(false);
		txtKey_panelTTCT.setBackground(new Color(238, 238, 238));
		txtKey_panelTTCT.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtKey_panelTTCT.setText(" Nhà xuất bản\r\n\r\n Tác giả");
		txtKey_panelTTCT.setBounds(20, 54, 202, 98);
		panel_TTCT.add(txtKey_panelTTCT);

		JTextPane txtValue_panelTTCT = new JTextPane();
		txtValue_panelTTCT.setEditable(false);
		txtValue_panelTTCT.setText(" Nhà Xuất Bản Lao Động\r\n\r\n Đào Đức Dũng");
		txtValue_panelTTCT.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtValue_panelTTCT.setBackground(new Color(255, 255, 255));
		txtValue_panelTTCT.setBounds(232, 54, 252, 98);
		panel_TTCT.add(txtValue_panelTTCT);
		
		JTextPane txtValue_panelTTCT_1 = new JTextPane();
		txtValue_panelTTCT_1.setText(" 2021\r\n Tái bản lần thứ nhất\r\n 21 cuốn");
		txtValue_panelTTCT_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtValue_panelTTCT_1.setEditable(false);
		txtValue_panelTTCT_1.setBackground(Color.WHITE);
		txtValue_panelTTCT_1.setBounds(868, 54, 252, 98);
		panel_TTCT.add(txtValue_panelTTCT_1);
		
		JTextPane txtKey_panelTTCT_1 = new JTextPane();
		txtKey_panelTTCT_1.setText(" Năm xuất bản\r\n Số lần tái bản\r\n Số lượng còn lại");
		txtKey_panelTTCT_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtKey_panelTTCT_1.setEditable(false);
		txtKey_panelTTCT_1.setBackground(new Color(238, 238, 238));
		txtKey_panelTTCT_1.setBounds(656, 54, 202, 98);
		panel_TTCT.add(txtKey_panelTTCT_1);
		
		
		// panel Mo ta san pham
		JPanel panel_MTSP = new JPanel();
		panel_MTSP.setLayout(null);
		panel_MTSP.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_MTSP.setBackground(Color.WHITE);
		panel_MTSP.setBounds(66, 557, 1140, 460);
		panel_TTS.add(panel_MTSP);

		JLabel lblTitle_panelMTSP = new JLabel("Mô tả sản phẩm");
		lblTitle_panelMTSP.setFont(new Font("Calibri", Font.BOLD, 26));
		lblTitle_panelMTSP.setBounds(10, 10, 252, 33);
		panel_MTSP.add(lblTitle_panelMTSP);

		JTextPane txtMTSP_panelMTSP = new JTextPane();
		txtMTSP_panelMTSP.setEditable(false);
		txtMTSP_panelMTSP.setText( sach.getMoTa());
//				"I. Đôi điều về tác giả\r\nTôi là NEOS.THÀNH (Nguyễn Văn Thành) – Một lập trình viên Java-Android, tác giả cuốn sách “Lập trình hướng đối tượng Java Core”, CEO của công ty TNHH MTV DV   Giáo Dục Thành Nguyên, đồng thời là mentor tại trường ĐH trực tuyến FUNiX, giảng viên giảng dạy tại cao đẳng nghề PolyTechnic,  công ty phần mềm Luvina và công ty phần mềm FPT.\r\n\r\nII. Quyển sách này nói về điều gì?\r\n- JAVA là ngôn ngữ lập trình rất phổ biến nhất hiện nay, học Lập trình hướng đối tượng JAVA bạn sẽ có rất nhiều hướng đi, từ lập trình Mobile app, Java web, Desktop\r\n  App, Game, và tất cả đều sử dụng nền tảng của JAVA CORE.\r\n- Quyển sách này gồm 22 bài học từ Tư duy Lập trình hướng đối tượng JAVA(Đa hình, kế thừa) đến các đối tượng #JavaCore (String, Array, File), lập trình giao diện Swing.\r\n- Quyển sách Lập trình hướng đối tượng JAVA này sẽ giúp bạn:\r\n    + Đi vào thế giới lập trình hết sức tự nhiên, thân thiện và dễ hiểu - LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG LÀ TƯ DUY GẮN LIỀN VỚI CUỘC SỐNG HẰNG NGÀY\r\n    + Nắm vững được thế nào là tư duy lập trình hướng đối tượng và cách phân tích một bài toán lập trình\r\n    + Hiểu được các khái niệm lập trình Java cơ bản.\r\n    + Thực hành xây dựng được các giao diện phần mềm desktop bằng ngôn ngữ JAVA\r\n=> Sau khi có được nền tảng kiến thức Lập trình hướng đối tượng JAVA bạn có thể tự học các ngôn ngữ lập trình hướng đối tượng khác như C++/C, Python,\r\n\r\nIII. Quyển sách này dành cho ai?\r\n- Là sách tham khảo, hướng dẫn tự học Lập trình hướng đối tượng JAVA bằng ngôn ngữ JAVA Core\r\n- Dành cho người mới bắt đầu học lập trình, sinh viên chưa vững tư duy LTHĐT, Java core\r\n- Dành cho người mất gốc hoặc trái ngành muốn học Lập trình hướng đối tượng JAVA");
		txtMTSP_panelMTSP.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtMTSP_panelMTSP.setBackground(Color.WHITE);
		txtMTSP_panelMTSP.setBounds(20, 40, 1092, 404);
		panel_MTSP.add(txtMTSP_panelMTSP);

		
		// panel Danh gia
		JPanel panel_DG = new JPanel();
		panel_DG.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_DG.setBackground(new Color(255, 255, 255));
		panel_DG.setBounds(66, 1042, 1140, 222);
		panel_TTS.add(panel_DG);
		panel_DG.setLayout(null);
		
		JLabel lblTitle_panelDG = new JLabel("Đánh giá - nhận xét từ đọc giả");
		lblTitle_panelDG.setFont(new Font("Calibri", Font.BOLD, 26));
		lblTitle_panelDG.setBounds(10, 10, 400, 33);
		panel_DG.add(lblTitle_panelDG);

		JScrollPane scrollPane_panelDG = new JScrollPane();
		scrollPane_panelDG.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_panelDG.setBounds(0, 44, 1140, 178);
		panel_DG.add(scrollPane_panelDG);

		JTextPane txtDG_panelDG = new JTextPane();
		txtDG_panelDG.setEditable(false);
		txtDG_panelDG.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		txtDG_panelDG.setText("asjdjasd: aksdhlkasd");
		scrollPane_panelDG.setViewportView(txtDG_panelDG);

		
		// set scrollPane len dau
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scrollPane_TTS.getViewport().setViewPosition(new Point(0, 0));
			}
		});

		// ket thuc code

		return scrollPane_TTS;
	}
	

	public JPanel panel_QuanLySach() {
		JPanel panel_QLS = new JPanel();
		panel_QLS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_QLS.setBackground(new Color(255, 255, 255));
		panel_QLS.setBounds(0, 148, 1286, 616);
		panel_QLS.setLayout(null);
		
		// bat dau code
		
		JPanel panelDieuKhien = new JPanel();
		panelDieuKhien.setBounds(845, 36, 374, 540);
		panel_QLS.add(panelDieuKhien);
		panelDieuKhien.setLayout(null);
		
		JLabel lblTimKiem_panelDieuKhien = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhien.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhien.setBounds(10, 10, 103, 43);
		panelDieuKhien.add(lblTimKiem_panelDieuKhien);
		
		JTextField txtTimKiem_panelDieuKhien = new JTextField();
		txtTimKiem_panelDieuKhien.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtTimKiem_panelDieuKhien.setBounds(40, 50, 294, 36);
		panelDieuKhien.add(txtTimKiem_panelDieuKhien);
		txtTimKiem_panelDieuKhien.setColumns(10);
		
		JLabel lblDK_panelDieuKhien = new JLabel("Điều khiển");
		lblDK_panelDieuKhien.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhien.setBounds(10, 157, 134, 43);
		panelDieuKhien.add(lblDK_panelDieuKhien);
		
		JComboBox cbxLoc_panelDieuKhien = new JComboBox();
		cbxLoc_panelDieuKhien.setModel(new DefaultComboBoxModel(new String[] {"rfdrg", "uyhggh"}));
		cbxLoc_panelDieuKhien.setOpaque(true);
		cbxLoc_panelDieuKhien.setBounds(40, 111, 294, 36);
		panelDieuKhien.add(cbxLoc_panelDieuKhien);
		
		JPanel panelCTS = new JPanel();
		panelCTS.setBounds(10, 190, 354, 340);
		panelDieuKhien.add(panelCTS);
		panelCTS.setLayout(null);
		
		JButton btnSM_panelCTS = new JButton("Sách Mới");
		btnSM_panelCTS.setFont(new Font("Arial", Font.BOLD, 14));
		btnSM_panelCTS.setBounds(0, 313, 105, 27);
		panelCTS.add(btnSM_panelCTS);
		
		JLabel imgSach_panelCTS = new JLabel("New label");
		imgSach_panelCTS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		imgSach_panelCTS.setBounds(20, 4, 156, 93);
		panelCTS.add(imgSach_panelCTS);
		
		JButton btnSS_panelCTS = new JButton("Lưu Sách");
		btnSS_panelCTS.setFont(new Font("Arial", Font.BOLD, 14));
		btnSS_panelCTS.setBounds(126, 313, 105, 27);
		panelCTS.add(btnSS_panelCTS);
		
		JButton btnXS_panelCTS = new JButton("Xóa Sách");
		btnXS_panelCTS.setFont(new Font("Arial", Font.BOLD, 14));
		btnXS_panelCTS.setBounds(249, 313, 105, 27);
		panelCTS.add(btnXS_panelCTS);
		
		JLabel lblTenSach_panelCTS = new JLabel("Tên Sách");
		lblTenSach_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTenSach_panelCTS.setBounds(0, 101, 60, 20);
		panelCTS.add(lblTenSach_panelCTS);
		
		JLabel lblTacGia_panelCTS = new JLabel("Tác Giả");
		lblTacGia_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTacGia_panelCTS.setBounds(0, 158, 60, 20);
		panelCTS.add(lblTacGia_panelCTS);
		
		JTextField txtMaSach_panelCTS = new JTextField();
		txtMaSach_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMaSach_panelCTS.setBounds(230, 21, 109, 30);
		panelCTS.add(txtMaSach_panelCTS);
		txtMaSach_panelCTS.setColumns(10);
		
		JTextField txtTenSach_panelCTS = new JTextField();
		txtTenSach_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenSach_panelCTS.setBounds(20, 118, 156, 30);
		panelCTS.add(txtTenSach_panelCTS);
		txtTenSach_panelCTS.setColumns(10);
		
		JTextField txtTacGia_panelCTS = new JTextField();
		txtTacGia_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTacGia_panelCTS.setBounds(20, 173, 156, 30);
		panelCTS.add(txtTacGia_panelCTS);
		txtTacGia_panelCTS.setColumns(10);
		
		JComboBox cbxMaLS_panelCTS = new JComboBox();
		cbxMaLS_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		cbxMaLS_panelCTS.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019"}));
		cbxMaLS_panelCTS.setBounds(230, 86, 109, 32);
		panelCTS.add(cbxMaLS_panelCTS);
		
		JLabel lblMaLS_panelCTS = new JLabel("Mã Loại Sách");
		lblMaLS_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaLS_panelCTS.setBounds(209, 64, 90, 27);
		panelCTS.add(lblMaLS_panelCTS);
		
		JLabel lblTaiBan_panelCTS = new JLabel("Tái Bản");
		lblTaiBan_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTaiBan_panelCTS.setBounds(209, 128, 60, 20);
		panelCTS.add(lblTaiBan_panelCTS);
		
		JLabel lblSoLuong_panelCTS = new JLabel("Số Lượng");
		lblSoLuong_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSoLuong_panelCTS.setBounds(209, 183, 60, 20);
		panelCTS.add(lblSoLuong_panelCTS);
		
		JLabel lblNamXuatBan_panelCTS = new JLabel("Năm Xuất Bản");
		lblNamXuatBan_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNamXuatBan_panelCTS.setBounds(209, 240, 75, 20);
		panelCTS.add(lblNamXuatBan_panelCTS);
		
		JTextField txtTaiBan_panelCTS = new JTextField();
		txtTaiBan_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTaiBan_panelCTS.setBounds(230, 148, 109, 30);
		panelCTS.add(txtTaiBan_panelCTS);
		txtTaiBan_panelCTS.setColumns(10);
		
		JTextField txtSoLuong_panelCTS = new JTextField();
		txtSoLuong_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSoLuong_panelCTS.setBounds(230, 200, 109, 30);
		panelCTS.add(txtSoLuong_panelCTS);
		txtSoLuong_panelCTS.setColumns(10);
		
		JTextField txtNamXuatBan_panelCTS = new JTextField();
		txtNamXuatBan_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNamXuatBan_panelCTS.setBounds(230, 255, 109, 30);
		panelCTS.add(txtNamXuatBan_panelCTS);
		txtNamXuatBan_panelCTS.setColumns(10);
		
		JLabel lblMaLS_panelCTS_1 = new JLabel("Mã Sách");
		lblMaLS_panelCTS_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaLS_panelCTS_1.setBounds(209, 0, 90, 27);
		panelCTS.add(lblMaLS_panelCTS_1);
		
		JLabel lblNhaXuatBan_panelCTS = new JLabel("Nhà Xuất Bản");
		lblNhaXuatBan_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNhaXuatBan_panelCTS.setBounds(0, 213, 90, 20);
		panelCTS.add(lblNhaXuatBan_panelCTS);
		
		txtNhaXuatBan_panelCTS = new JTextField();
		txtNhaXuatBan_panelCTS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNhaXuatBan_panelCTS.setColumns(10);
		txtNhaXuatBan_panelCTS.setBounds(20, 228, 156, 30);
		panelCTS.add(txtNhaXuatBan_panelCTS);
		
		JButton btnMoTa_panelCTS = new JButton("Mô Tả");
		btnMoTa_panelCTS.setFont(new Font("Arial", Font.BOLD, 16));
		btnMoTa_panelCTS.setBounds(46, 270, 105, 27);
		panelCTS.add(btnMoTa_panelCTS);
		
		JPanel panelQLS = new JPanel();
		panelQLS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelQLS.setBounds(69, 36, 740, 61);
		panel_QLS.add(panelQLS);
		panelQLS.setLayout(null);
		
		JLabel lblSach_panelNut = new JLabel("Sách");
		lblSach_panelNut.setForeground(new Color(255, 255, 255));
		lblSach_panelNut.setBackground(new Color(27, 161, 226));
		lblSach_panelNut.setOpaque(true);
		lblSach_panelNut.setBounds(0, 0, 146, 61);
		panelQLS.add(lblSach_panelNut);
		lblSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach_panelNut.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblLoaiSach_panelNut = new JLabel("Loại Sách");
		lblLoaiSach_panelNut.setBounds(166, 0, 169, 61);
		panelQLS.add(lblLoaiSach_panelNut);
		lblLoaiSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiSach_panelNut.setFont(new Font("Arial", Font.BOLD, 24));
		
		JScrollPane scrollPane_QLS = new JScrollPane();
		scrollPane_QLS.setBounds(69, 117, 740, 459);
		panel_QLS.add(scrollPane_QLS);
		
		JTable lblQuanLySach = new JTable();
		lblQuanLySach.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQuanLySach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3", "Nh\u00E0 Xu\u1EA5t B\u1EA3n", "S\u1ED1 L\u1EA7n T\u00E1i B\u1EA3n ", "N\u0103m Xu\u1EA5t B\u1EA3n", "S\u1ED1 L\u01B0\u1EE3ng ", "M\u00E3 Lo\u1EA1i S\u00E1ch"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_QLS.setViewportView(lblQuanLySach);
		
		// ket thuc code
		
		return panel_QLS;
	}
	
	public JPanel panel_QuanLyUser() {
		JPanel panel_QLUS = new JPanel();
		panel_QLUS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_QLUS.setBackground(new Color(255, 255, 255));
		panel_QLUS.setBounds(0, 148, 1286, 616);
		panel_QLUS.setLayout(null);
		
		// bat dau code
		
		JPanel panelDieuKhienUser = new JPanel();
		panelDieuKhienUser.setBounds(845, 36, 374, 540);
		panel_QLUS.add(panelDieuKhienUser);
		panelDieuKhienUser.setLayout(null);
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienUser.add(lblTimKiem_panelDieuKhienUser);
		
		
		JTextField txtTimKiem_panelDieuKhienUser = new JTextField();
		txtTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtTimKiem_panelDieuKhienUser.setBounds(40, 63, 294, 36);
		panelDieuKhienUser.add(txtTimKiem_panelDieuKhienUser);
		txtTimKiem_panelDieuKhienUser.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser.setBounds(10, 182, 134, 43);
		panelDieuKhienUser.add(lblDK_panelDieuKhienUser);
		
		JComboBox cbxLoc_panelDieuKhienUser = new JComboBox();
		cbxLoc_panelDieuKhienUser.setModel(new DefaultComboBoxModel(new String[] {"Email", "Họ và tên", "Số điện thoại"}));
		cbxLoc_panelDieuKhienUser.setOpaque(true);
		cbxLoc_panelDieuKhienUser.setBounds(40, 124, 294, 36);
		panelDieuKhienUser.add(cbxLoc_panelDieuKhienUser);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienUser.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		JButton btnUserNew_panelCTUS = new JButton("Làm mới");
		btnUserNew_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnUserNew_panelCTUS.setBounds(0, 280, 105, 27);
		panelCTUS.add(btnUserNew_panelCTUS);
		
		JLabel imgUser_panelCTUS = new JLabel("New label");
		imgUser_panelCTUS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		imgUser_panelCTUS.setBounds(20, 10, 180, 92);
		panelCTUS.add(imgUser_panelCTUS);
		
		JButton btnSuaUser_panelCTUS = new JButton("Lưu User");
		btnSuaUser_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS.setBounds(126, 280, 105, 27);
		panelCTUS.add(btnSuaUser_panelCTUS);
		
		JButton btnDeleteUser_panelCTUS = new JButton("Xóa User");
		btnDeleteUser_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteUser_panelCTUS.setBounds(249, 280, 105, 27);
		panelCTUS.add(btnDeleteUser_panelCTUS);
		
		JLabel lblEmail_panelCTUS = new JLabel("Email");
		lblEmail_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS.setBounds(0, 113, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS);
		
		JLabel lblPassword_panelCTUS = new JLabel("Password");
		lblPassword_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword_panelCTUS.setBounds(0, 168, 60, 20);
		panelCTUS.add(lblPassword_panelCTUS);
		
		JLabel lblHoten_panelCTUS = new JLabel("Họ tên");
		lblHoten_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoten_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblHoten_panelCTUS.setBounds(0, 225, 60, 20);
		panelCTUS.add(lblHoten_panelCTUS);
		
		JTextField txtEmail_panelCTUS = new JTextField();
		txtEmail_panelCTUS.setBounds(20, 133, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS);
		txtEmail_panelCTUS.setColumns(10);
		
		JTextField txtPassword_panelCTUS = new JTextField();
		txtPassword_panelCTUS.setBounds(20, 185, 314, 30);
		panelCTUS.add(txtPassword_panelCTUS);
		txtPassword_panelCTUS.setColumns(10);
		
		JTextField txtHoten_panelCTUS = new JTextField();
		txtHoten_panelCTUS.setBounds(20, 240, 156, 30);
		panelCTUS.add(txtHoten_panelCTUS);
		txtHoten_panelCTUS.setColumns(10);
		
		JLabel lblSDT_panelCTUS = new JLabel("Số diện thoại");
		lblSDT_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSDT_panelCTUS.setBounds(209, 225, 75, 20);
		panelCTUS.add(lblSDT_panelCTUS);
		
		JTextField txtSDT_panelCTUS = new JTextField();
		txtSDT_panelCTUS.setBounds(220, 240, 114, 30);
		panelCTUS.add(txtSDT_panelCTUS);
		txtSDT_panelCTUS.setColumns(10);
		
		JButton btnSuaUser_panelCTUS_1 = new JButton("Xem thêm");
		btnSuaUser_panelCTUS_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS_1.setBounds(218, 46, 116, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_1);
		
		JPanel panelNutUser = new JPanel();
		panelNutUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNutUser.setBounds(69, 36, 740, 61);
		panel_QLUS.add(panelNutUser);
		panelNutUser.setLayout(null);
		
		JLabel lblUser_panelNutUser = new JLabel("User");
		lblUser_panelNutUser.setForeground(new Color(255, 255, 255));
		lblUser_panelNutUser.setBackground(new Color(27, 161, 226));
		lblUser_panelNutUser.setOpaque(true);
		lblUser_panelNutUser.setBounds(0, 0, 136, 61);
		panelNutUser.add(lblUser_panelNutUser);
		lblUser_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblDatSach_panelNutUser = new JLabel("Đặt sách");
		lblDatSach_panelNutUser.setBounds(151, 0, 136, 61);
		panelNutUser.add(lblDatSach_panelNutUser);
		lblDatSach_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatSach_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblYeuCau_panelNutUser = new JLabel("Yêu cầu");
		lblYeuCau_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblYeuCau_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblYeuCau_panelNutUser.setBounds(302, 0, 136, 61);
		panelNutUser.add(lblYeuCau_panelNutUser);
		
		JLabel lblDangMuon_panelNutUser = new JLabel("Đang mượn");
		lblDangMuon_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangMuon_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblDangMuon_panelNutUser.setBounds(453, 0, 136, 61);
		panelNutUser.add(lblDangMuon_panelNutUser);
		
		JLabel lblQuaHan_panelNutUser = new JLabel("Quá hạn");
		lblQuaHan_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaHan_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblQuaHan_panelNutUser.setBounds(604, 0, 136, 61);
		panelNutUser.add(lblQuaHan_panelNutUser);
		
		JScrollPane scrollPaneUser = new JScrollPane();
//		scrollPaneUser.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		
		JTable lblQuanLyUser = new JTable();
		lblQuanLyUser.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQuanLyUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Mật khẩu", "Họ và tên", "Số điện thoại"
			}
		));
		scrollPaneUser.setViewportView(lblQuanLyUser);
		
		// ket thuc code
		
		return panel_QLUS;
	}	
	
	public JPanel panel_ThongKe() {
		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_ThongKe.setBackground(new Color(255, 255, 255));
		panel_ThongKe.setBounds(0, 148, 1286, 616);
		panel_ThongKe.setLayout(null);
		
		// bat dau code
		
		JPanel panel_TongSoNguoiDung = new JPanel();
		panel_TongSoNguoiDung.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TongSoNguoiDung.setBounds(80, 60, 291, 204);
		panel_ThongKe.add(panel_TongSoNguoiDung);
		panel_TongSoNguoiDung.setLayout(null);
		

		JLabel lblTitle_panelTongSoNguoiDung = new JLabel("Tổng số người dùng");
		lblTitle_panelTongSoNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelTongSoNguoiDung.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelTongSoNguoiDung.setForeground(new Color(255, 255, 255));
		lblTitle_panelTongSoNguoiDung.setBounds(36, 26, 218, 44);
		panel_TongSoNguoiDung.add(lblTitle_panelTongSoNguoiDung);
		
		JLabel lblTong__panelTongSoNguoiDung = new JLabel("100 người");
		lblTong__panelTongSoNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong__panelTongSoNguoiDung.setForeground(Color.WHITE);
		lblTong__panelTongSoNguoiDung.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong__panelTongSoNguoiDung.setBounds(36, 70, 218, 44);
		panel_TongSoNguoiDung.add(lblTong__panelTongSoNguoiDung);
		
		JLabel imgBG_panelTongSoNguoiDung = new JLabel("");
		imgBG_panelTongSoNguoiDung.setBounds(0, 0, panel_TongSoNguoiDung.getWidth(), panel_TongSoNguoiDung.getHeight());
//		ImageIcon imgITongSoNguoiDung_panelThongKe = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelThongKe = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSoNguoiDung.jpg");
		Image imBG_panelThongKe = imgIBG_panelThongKe.getImage();
		Image imageBG_panelThongKe = imBG_panelThongKe.getScaledInstance(imgBG_panelTongSoNguoiDung.getWidth(), imgBG_panelTongSoNguoiDung.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelThongKe = new ImageIcon(imageBG_panelThongKe);
		imgBG_panelTongSoNguoiDung.setIcon(imageIconBG_panelThongKe);
		panel_TongSoNguoiDung.add(imgBG_panelTongSoNguoiDung);
		
		
		JPanel panel_TongSoSach = new JPanel();
		panel_TongSoSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TongSoSach.setBounds(498, 60, 291, 204);
		panel_ThongKe.add(panel_TongSoSach);
		panel_TongSoSach.setLayout(null);
		
		JLabel lblTong_panelTongSoSach = new JLabel("1000 cuốn");
		lblTong_panelTongSoSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelTongSoSach.setForeground(Color.WHITE);
		lblTong_panelTongSoSach.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelTongSoSach.setBounds(36, 70, 218, 44);
		panel_TongSoSach.add(lblTong_panelTongSoSach);
		
		JLabel lblTitle_panelTongSoSach = new JLabel("Tổng số sách");
		lblTitle_panelTongSoSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelTongSoSach.setForeground(Color.WHITE);
		lblTitle_panelTongSoSach.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelTongSoSach.setBounds(36, 26, 218, 44);
		panel_TongSoSach.add(lblTitle_panelTongSoSach);
		
		JLabel imgBG_panelTongSoSach = new JLabel("");
		imgBG_panelTongSoSach.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelTongSoSach = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelTongSoSach = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSoSach.jpg");
		Image imBG_panelTongSoSach = imgIBG_panelTongSoSach.getImage();
		Image imageBG_panelTongSoSach = imBG_panelTongSoSach.getScaledInstance(imgBG_panelTongSoSach.getWidth(), imgBG_panelTongSoSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelTongSoSach = new ImageIcon(imageBG_panelTongSoSach);
		imgBG_panelTongSoSach.setIcon(imageIconBG_panelTongSoSach);	
		panel_TongSoSach.add(imgBG_panelTongSoSach);
		
		
		JPanel panel_DoPhoBienCuaSach = new JPanel();
		panel_DoPhoBienCuaSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DoPhoBienCuaSach.setBounds(915, 60, 291, 204);
		panel_ThongKe.add(panel_DoPhoBienCuaSach);
		panel_DoPhoBienCuaSach.setLayout(null);
		
		JLabel lblTitle_panelDoPhoBienCuaSach = new JLabel("Độ phổ biến của sách");
		lblTitle_panelDoPhoBienCuaSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelDoPhoBienCuaSach.setForeground(Color.WHITE);
		lblTitle_panelDoPhoBienCuaSach.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelDoPhoBienCuaSach.setBounds(10, 26, 271, 44);
		panel_DoPhoBienCuaSach.add(lblTitle_panelDoPhoBienCuaSach);
		
		JButton btnXemChiTiet_panelDoPhoBienCuaSach = new JButton("Xem chi tiết");
		btnXemChiTiet_panelDoPhoBienCuaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXemChiTiet_panelDoPhoBienCuaSach.setFocusPainted(false);
		btnXemChiTiet_panelDoPhoBienCuaSach.setFont(new Font("Arial", Font.BOLD, 18));
		btnXemChiTiet_panelDoPhoBienCuaSach.setBounds(74, 70, 143, 44);
		panel_DoPhoBienCuaSach.add(btnXemChiTiet_panelDoPhoBienCuaSach);
		
		JLabel imgBG_panelDoPhoBienCuaSach = new JLabel("");
		imgBG_panelDoPhoBienCuaSach.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangMuon  = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelDoPhoBienCuaSach = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\doPhoBienCuaSachjpg.jpg");
		Image imBG_panelDoPhoBienCuaSach = imgIBG_panelDoPhoBienCuaSach.getImage();
		Image imageBG_panelDoPhoBienCuaSach = imBG_panelDoPhoBienCuaSach.getScaledInstance(imgBG_panelDoPhoBienCuaSach.getWidth(), imgBG_panelDoPhoBienCuaSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelDoPhoBienCuaSach = new ImageIcon(imageBG_panelDoPhoBienCuaSach);
		imgBG_panelDoPhoBienCuaSach.setIcon(imageIconBG_panelDoPhoBienCuaSach);	
		panel_DoPhoBienCuaSach.add(imgBG_panelDoPhoBienCuaSach);
		
		
		JPanel panel_SachQuaHan = new JPanel();
		panel_SachQuaHan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachQuaHan.setBounds(915, 342, 291, 204);
		panel_ThongKe.add(panel_SachQuaHan);
		panel_SachQuaHan.setLayout(null);
		
		JLabel lblTitle_panelSachQuaHan = new JLabel("Tống số sách quá hạn");
		lblTitle_panelSachQuaHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachQuaHan.setForeground(Color.WHITE);
		lblTitle_panelSachQuaHan.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachQuaHan.setBounds(10, 26, 271, 44);
		panel_SachQuaHan.add(lblTitle_panelSachQuaHan);
		
		JLabel lblTong_panelSachQuaHan = new JLabel("100 cuốn");
		lblTong_panelSachQuaHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachQuaHan.setForeground(Color.WHITE);
		lblTong_panelSachQuaHan.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachQuaHan.setBounds(36, 70, 218, 44);
		panel_SachQuaHan.add(lblTong_panelSachQuaHan);
		
		JLabel imgBG_panelSachQuaHan = new JLabel("");
		imgBG_panelSachQuaHan.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachQuaHan  = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachQuaHan  = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachQuaHanjpg.jpg");
		Image imBG_panelSachQuaHan  = imgIBG_panelSachQuaHan.getImage();
		Image imageBG_panelSachQuaHan  = imBG_panelSachQuaHan.getScaledInstance(imgBG_panelSachQuaHan.getWidth(), imgBG_panelSachQuaHan.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachQuaHan  = new ImageIcon(imageBG_panelSachQuaHan);
		imgBG_panelSachQuaHan.setIcon(imageIconBG_panelSachQuaHan);	
		panel_SachQuaHan.add(imgBG_panelSachQuaHan);
		
		JPanel panel_SachDangDat = new JPanel();
		panel_SachDangDat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachDangDat.setBounds(498, 342, 291, 204);
		panel_ThongKe.add(panel_SachDangDat);
		panel_SachDangDat.setLayout(null);
		
		JLabel lblTitle_panelSachDangDat = new JLabel("Tống số sách đang đặt");
		lblTitle_panelSachDangDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachDangDat.setForeground(Color.WHITE);
		lblTitle_panelSachDangDat.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachDangDat.setBounds(10, 26, 271, 44);
		panel_SachDangDat.add(lblTitle_panelSachDangDat);
		
		JLabel lblTong_panelSachDangDat = new JLabel("100 cuốn");
		lblTong_panelSachDangDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachDangDat.setForeground(Color.WHITE);
		lblTong_panelSachDangDat.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachDangDat.setBounds(36, 70, 218, 44);
		panel_SachDangDat.add(lblTong_panelSachDangDat);
		
		JLabel imgBG_panelSachDangDat = new JLabel("");
		imgBG_panelSachDangDat.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangDat = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachDangDat  = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachDangDatjpg.jpg");
		Image imBG_panelSachDangDat  = imgIBG_panelSachDangDat.getImage();
		Image imageBG_panelSachDangDat  = imBG_panelSachDangDat.getScaledInstance(imgBG_panelSachDangDat.getWidth(), imgBG_panelSachDangDat.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachDangDat  = new ImageIcon(imageBG_panelSachDangDat);
		imgBG_panelSachDangDat.setIcon(imageIconBG_panelSachDangDat);	
		panel_SachDangDat.add(imgBG_panelSachDangDat);
		
		JPanel panel_SachDangMuon = new JPanel();
		panel_SachDangMuon.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachDangMuon.setBounds(80, 342, 291, 204);
		panel_ThongKe.add(panel_SachDangMuon);
		panel_SachDangMuon.setLayout(null);
		
		JLabel lblTitle_panelSachDangMuon = new JLabel("Tống số sách đang mượn");
		lblTitle_panelSachDangMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachDangMuon.setForeground(Color.WHITE);
		lblTitle_panelSachDangMuon.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachDangMuon.setBounds(10, 26, 271, 44);
		panel_SachDangMuon.add(lblTitle_panelSachDangMuon);
		
		JLabel lblTong_panelSachDangMuon = new JLabel("100 cuốn");
		lblTong_panelSachDangMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachDangMuon.setForeground(Color.WHITE);
		lblTong_panelSachDangMuon.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachDangMuon.setBounds(36, 70, 218, 44);
		panel_SachDangMuon.add(lblTong_panelSachDangMuon);
		
		JLabel imgBG_panelSachDangMuon = new JLabel("");
		imgBG_panelSachDangMuon.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangMuon  = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachDangMuon = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachDangMuonjpg.jpg");
		Image imBG_panelSachDangMuon = imgIBG_panelSachDangMuon.getImage();
		Image imageBG_panelSachDangMuon = imBG_panelSachDangMuon.getScaledInstance(imgBG_panelSachDangMuon.getWidth(), imgBG_panelSachDangMuon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachDangMuon = new ImageIcon(imageBG_panelSachDangMuon);
		imgBG_panelSachDangMuon.setIcon(imageIconBG_panelSachDangMuon);	
		panel_SachDangMuon.add(imgBG_panelSachDangMuon);
		
		// ket thuc code
		
		return panel_ThongKe;
	}
		public JPanel panel_QuanLyUser() {
		panel_QLUS = new JPanel();
		panel_QLUS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_QLUS.setBackground(new Color(255, 255, 255));
		panel_QLUS.setBounds(0, 148, 1286, 616);
		panel_QLUS.setLayout(null);
		
		// bat dau code

		panelNutUser = new JPanel();
		panelNutUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNutUser.setBounds(69, 36, 740, 61);
		panel_QLUS.add(panelNutUser);
		panelNutUser.setLayout(null);
		
		lblUser_panelNutUser = new JLabel("User");
		lblUser_panelNutUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeToUser();
			}
		});
		lblUser_panelNutUser.setForeground(new Color(255, 255, 255));
		lblUser_panelNutUser.setBackground(new Color(27, 161, 226));
		lblUser_panelNutUser.setOpaque(true);
		lblUser_panelNutUser.setBounds(0, 0, 136, 61);
		panelNutUser.add(lblUser_panelNutUser);
		lblUser_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		lblDatSach_panelNutUser = new JLabel("Đặt sách");
		lblDatSach_panelNutUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeToDatSach();
			}
		});
		lblDatSach_panelNutUser.setBackground(new Color(27, 161, 226));
		lblDatSach_panelNutUser.setBounds(151, 0, 136, 61);
		panelNutUser.add(lblDatSach_panelNutUser);
		lblDatSach_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatSach_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		lblYeuCau_panelNutUser = new JLabel("Yêu cầu");
		lblYeuCau_panelNutUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeToYeuCau();
			}
		});
		lblYeuCau_panelNutUser.setBackground(new Color(27, 161, 226));
		lblYeuCau_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblYeuCau_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblYeuCau_panelNutUser.setBounds(302, 0, 136, 61);
		panelNutUser.add(lblYeuCau_panelNutUser);
		
		lblDangMuon_panelNutUser = new JLabel("Đang mượn");
		lblDangMuon_panelNutUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeToDangMuon();
			}
		});
		lblDangMuon_panelNutUser.setBackground(new Color(27, 161, 226));
		lblDangMuon_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangMuon_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblDangMuon_panelNutUser.setBounds(453, 0, 136, 61);
		panelNutUser.add(lblDangMuon_panelNutUser);
		
		lblQuaHan_panelNutUser = new JLabel("Quá hạn");
		lblQuaHan_panelNutUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeToQuaHan();
			}
		});
		lblQuaHan_panelNutUser.setBackground(new Color(27, 161, 226));
		lblQuaHan_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaHan_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblQuaHan_panelNutUser.setBounds(604, 0, 136, 61);
		panelNutUser.add(lblQuaHan_panelNutUser);
		
		
		
		panel_QLUS.add(panel_dieukhienUser());
		panel_QLUS.add(tblQuanLyUser());
		
		// ket thuc code
		
		return panel_QLUS;
	}	
	
	
	public JScrollPane tblQuanLyUser() {
		tblQuanLyUser = new JTable();
		tblQuanLyUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.chooseQLUS();
			}
		});
		tblQuanLyUser.setFont(new Font("Arial", Font.PLAIN, 16));
		tblQuanLyUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "M\u1EADt kh\u1EA9u", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblQuanLyUser.setRowHeight(25);
		
		DefaultTableModel tableModel_User = (DefaultTableModel)tblQuanLyUser.getModel();
		tableModel_User.setRowCount(0);
		List<user> luser =  userDAO.getuserDAO().selectAll();
		for (user user : luser) {
			tableModel_User.addRow(new Object[] {
					user.getUsername(),
					user.getPassword(),
					user.getTtcn().getTen(),
					user.getTtcn().getSoDienThoai()
					
			});
		}
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		scrollPaneUser.setViewportView(tblQuanLyUser);
		
		return scrollPaneUser;
	}
	
	
	public JScrollPane tblQuanLyDatSach() {
		tblQuanLyDatSach = new JTable();
		tblQuanLyDatSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.chooseQLDatsach();
			}
		});
		tblQuanLyDatSach.setFont(new Font("Arial", Font.PLAIN, 16));
		tblQuanLyDatSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "M\u00E3 S\u00E1ch", "Ng\u00E0y \u0110\u1EB7t", "Tr\u1EA1ng Th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblQuanLyDatSach.setRowHeight(25);
		
		DefaultTableModel tableModel_DatSach = (DefaultTableModel)tblQuanLyDatSach.getModel();
		tableModel_DatSach.setRowCount(0);
		List<phieuMuonSach> lpms = phieuMuonSachDAO.getphieuMuonSachDAO().selectAllDangDat();
		for (phieuMuonSach phieuMuonSach : lpms) {
			tableModel_DatSach.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().subSequence(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
					
			});
		}
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		scrollPaneUser.setViewportView(tblQuanLyDatSach);
		
		return scrollPaneUser;
	}

	public JScrollPane tblQuanLyYeuCau() {
		tblQuanLyYeuCau = new JTable();
		tblQuanLyYeuCau.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.chooseQLYeuCau();
			}
		});
		tblQuanLyYeuCau.setFont(new Font("Arial", Font.PLAIN, 16));
		tblQuanLyYeuCau.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Lo\u1EA1i S\u00E1ch", "T\u00EAn S\u00E1ch", "M\u00F4 T\u1EA3"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblQuanLyYeuCau.setRowHeight(25);
		
		DefaultTableModel tableModel_YeuCau = (DefaultTableModel)tblQuanLyYeuCau.getModel();
		tableModel_YeuCau.setRowCount(0);
		List<yeuCau> lyc = yeuCauDAO.getyeuCauDAO().selectAll();
		for (yeuCau yeuCau : lyc) {
			tableModel_YeuCau.addRow(new Object[] {
					yeuCau.getEmail().getUsername(),
					yeuCau.getLoaiSach(),
					yeuCau.getSach(),
					yeuCau.getMoTa()				
			});
		}
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		scrollPaneUser.setViewportView(tblQuanLyYeuCau);
		
		return scrollPaneUser;
	}
	
	
	public JScrollPane tblQuanLyDangMuon() {
		tblQuanLyDangMuon = new JTable();
		tblQuanLyDangMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.chooseQlDangMuon();
			}
		});
		tblQuanLyDangMuon.setFont(new Font("Arial", Font.PLAIN, 16));
		tblQuanLyDangMuon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "M\u00E3 S\u00E1ch", "Ng\u00E0y M\u01B0\u1EE3n", "Ng\u00E0y Tr\u1EA3", "Tr\u1EA1ng Th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblQuanLyDangMuon.setRowHeight(25);
		
		DefaultTableModel tableModel_DangMuon = (DefaultTableModel)tblQuanLyDangMuon.getModel();
		tableModel_DangMuon.setRowCount(0);
		List<phieuMuonSach> lpms = phieuMuonSachDAO.getphieuMuonSachDAO().selectAllDangMuon();
		for (phieuMuonSach phieuMuonSach : lpms) {
			tableModel_DangMuon.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().substring(0, 10),
					phieuMuonSach.getNgayTra().toString().substring(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
					
			});
		}
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		scrollPaneUser.setViewportView(tblQuanLyDangMuon);
		
		return scrollPaneUser;
	}
	
	
	public JScrollPane tblQuanLyQuaHan() {
		tblQuanLyQuaHan = new JTable();
		tblQuanLyQuaHan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.chooseQLQuaHan();
			}
		});
		tblQuanLyQuaHan.setFont(new Font("Arial", Font.PLAIN, 16));
		tblQuanLyQuaHan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "M\u00E3 S\u00E1ch", "Ng\u00E0y M\u01B0\u1EE3n", "Ng\u00E0y Tr\u1EA3", "Tr\u1EA1ng Th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblQuanLyQuaHan.setRowHeight(25);
		
		DefaultTableModel tableModel_QuaHan = (DefaultTableModel)tblQuanLyQuaHan.getModel();
		tableModel_QuaHan.setRowCount(0);
		List<phieuMuonSach> lpms = phieuMuonSachDAO.getphieuMuonSachDAO().selectAllQuaHan();
		for (phieuMuonSach phieuMuonSach : lpms) {
			tableModel_QuaHan.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().substring(0, 10),
					phieuMuonSach.getNgayTra().toString().substring(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
					
			});
		}
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		scrollPaneUser.setViewportView(tblQuanLyQuaHan);
		
		return scrollPaneUser;
	}
	
	
	public JPanel panel_dieukhienUser() {
		JPanel panelDieuKhienUser = new JPanel();
		panelDieuKhienUser.setBounds(845, 36, 374, 540);

		panelDieuKhienUser.setLayout(null);
		
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienUser.add(lblTimKiem_panelDieuKhienUser);
		
		
		txtTimKiem_panelDieuKhienUser = new JTextField();
		txtTimKiem_panelDieuKhienUser.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.timUserTheoCBX();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.timUserTheoCBX();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		txtTimKiem_panelDieuKhienUser.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimKiem_panelDieuKhienUser.setBounds(40, 63, 294, 36);
		panelDieuKhienUser.add(txtTimKiem_panelDieuKhienUser);
		txtTimKiem_panelDieuKhienUser.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser.setBounds(10, 182, 134, 43);
		panelDieuKhienUser.add(lblDK_panelDieuKhienUser);
		
		cbxLoc_panelDieuKhienUser = new JComboBox();
		cbxLoc_panelDieuKhienUser.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxLoc_panelDieuKhienUser.setModel(new DefaultComboBoxModel(new String[] {"Email", "Họ và tên", "Số điện thoại"}));
		cbxLoc_panelDieuKhienUser.setOpaque(true);
		cbxLoc_panelDieuKhienUser.setBounds(40, 124, 294, 36);
		panelDieuKhienUser.add(cbxLoc_panelDieuKhienUser);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienUser.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		
		JButton btnUserNew_panelCTUS = new JButton("Làm mới");
		btnUserNew_panelCTUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnNewuser();
			}
		});
		btnUserNew_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnUserNew_panelCTUS.setBounds(0, 280, 105, 27);
		panelCTUS.add(btnUserNew_panelCTUS);
		
		imgUser_panelCTUS = new JLabel("Nhấn để tải hình ảnh");
		imgUser_panelCTUS.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.changeAvatar_panelCTUS();
			}
		});
		imgUser_panelCTUS.setHorizontalAlignment(SwingConstants.CENTER);
		imgUser_panelCTUS.setFont(new Font("Arial", Font.BOLD, 14));
		imgUser_panelCTUS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		imgUser_panelCTUS.setBounds(20, 10, 180, 92);
		panelCTUS.add(imgUser_panelCTUS);
		
		JButton btnSuaUser_panelCTUS = new JButton("Lưu User");
		btnSuaUser_panelCTUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addOrUpdateUser();
			}
		});
		btnSuaUser_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS.setBounds(126, 280, 105, 27);
		panelCTUS.add(btnSuaUser_panelCTUS);
		
		JButton btnDeleteUser_panelCTUS = new JButton("Xóa User");
		btnDeleteUser_panelCTUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteUser();
			}
		});
		btnDeleteUser_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteUser_panelCTUS.setBounds(249, 280, 105, 27);
		panelCTUS.add(btnDeleteUser_panelCTUS);
		
		JLabel lblEmail_panelCTUS = new JLabel("Email");
		lblEmail_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS.setBounds(0, 113, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS);
		
		JLabel lblPassword_panelCTUS = new JLabel("Password");
		lblPassword_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword_panelCTUS.setBounds(0, 168, 60, 20);
		panelCTUS.add(lblPassword_panelCTUS);
		
		JLabel lblHoten_panelCTUS = new JLabel("Họ tên");
		lblHoten_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoten_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblHoten_panelCTUS.setBounds(0, 225, 60, 20);
		panelCTUS.add(lblHoten_panelCTUS);
		
		txtEmail_panelCTUS = new JTextField();
		txtEmail_panelCTUS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail_panelCTUS.setBounds(20, 133, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS);
		txtEmail_panelCTUS.setColumns(10);
		
		txtHoten_panelCTUS = new JTextField();
		txtHoten_panelCTUS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHoten_panelCTUS.setBounds(20, 240, 156, 30);
		panelCTUS.add(txtHoten_panelCTUS);
		txtHoten_panelCTUS.setColumns(10);
		
		JLabel lblSDT_panelCTUS = new JLabel("Số diện thoại");
		lblSDT_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSDT_panelCTUS.setBounds(209, 225, 75, 20);
		panelCTUS.add(lblSDT_panelCTUS);
		
		txtSDT_panelCTUS = new JTextField();
		txtSDT_panelCTUS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSDT_panelCTUS.setBounds(220, 240, 114, 30);
		panelCTUS.add(txtSDT_panelCTUS);
		txtSDT_panelCTUS.setColumns(10);
		
		JButton btnSuaUser_panelCTUS_1 = new JButton("Xem thêm");
		btnSuaUser_panelCTUS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeToChiTietUser();
			}
		});
		btnSuaUser_panelCTUS_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS_1.setBounds(218, 46, 116, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_1);
		
		txtPassword_panelCTUS = new JPasswordField();
		txtPassword_panelCTUS.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPassword_panelCTUS.setBounds(20, 190, 314, 30);
		panelCTUS.add(txtPassword_panelCTUS);
		
		JButton btnXuatFileLS_panelDieuKhienLS = new JButton("Xuất File");
		btnXuatFileLS_panelDieuKhienLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.xuatFileUser();
			}
		});
		btnXuatFileLS_panelDieuKhienLS.setFocusPainted(false);
		btnXuatFileLS_panelDieuKhienLS.setFont(new Font("Arial", Font.BOLD, 18));
		btnXuatFileLS_panelDieuKhienLS.setBounds(247, 182, 117, 32);
		panelDieuKhienUser.add(btnXuatFileLS_panelDieuKhienLS);
		
		return panelDieuKhienUser;
	}
	
	
	public JPanel panel_dieukhienDatSach() {
		JPanel panelDieuKhienDatSach = new JPanel();
		panelDieuKhienDatSach.setBounds(845, 36, 374, 540);

		panelDieuKhienDatSach.setLayout(null);
		
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienDatSach.add(lblTimKiem_panelDieuKhienUser);
		
		
		txtTimKiem_panelDieuKhienUser_dkDS = new JTextField();
		txtTimKiem_panelDieuKhienUser_dkDS.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelDangDat();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelDangDat();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtTimKiem_panelDieuKhienUser_dkDS.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimKiem_panelDieuKhienUser_dkDS.setBounds(40, 63, 294, 36);
		panelDieuKhienDatSach.add(txtTimKiem_panelDieuKhienUser_dkDS);
		txtTimKiem_panelDieuKhienUser_dkDS.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser_dkDS = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser_dkDS.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser_dkDS.setBounds(10, 182, 134, 43);
		panelDieuKhienDatSach.add(lblDK_panelDieuKhienUser_dkDS);
		
		cbxLoc_panelDieuKhienUser_dkDS = new JComboBox();
		cbxLoc_panelDieuKhienUser_dkDS.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxLoc_panelDieuKhienUser_dkDS.setModel(new DefaultComboBoxModel(new String[] {"Email", "Mã sách"}));
		cbxLoc_panelDieuKhienUser_dkDS.setOpaque(true);
		cbxLoc_panelDieuKhienUser_dkDS.setBounds(40, 124, 294, 36);
		panelDieuKhienDatSach.add(cbxLoc_panelDieuKhienUser_dkDS);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienDatSach.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		JButton btnSuaUser_panelCTUS_dkDS = new JButton("Đã lấy sách");
		btnSuaUser_panelCTUS_dkDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.chuyenTrangThaiPhieuThanhDangMuon();
			}
		});
		btnSuaUser_panelCTUS_dkDS.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS_dkDS.setBounds(50, 280, 130, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_dkDS);
		
		JButton btnDeleteUser_panelCTUS_dkDS = new JButton("Xóa");
		btnDeleteUser_panelCTUS_dkDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteDatSach();
			}
		});
		btnDeleteUser_panelCTUS_dkDS.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteUser_panelCTUS_dkDS.setBounds(199, 280, 105, 27);
		panelCTUS.add(btnDeleteUser_panelCTUS_dkDS);
		
		JLabel lblEmail_panelCTUS_dkDS = new JLabel("Email");
		lblEmail_panelCTUS_dkDS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS_dkDS.setBounds(0, 0, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS_dkDS);
		
		JLabel lblPassword_panelCTUS_dkDS = new JLabel("Mã sách");
		lblPassword_panelCTUS_dkDS.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword_panelCTUS_dkDS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword_panelCTUS_dkDS.setBounds(0, 64, 60, 20);
		panelCTUS.add(lblPassword_panelCTUS_dkDS);
		
		JLabel lblHoten_panelCTUS_dkDS = new JLabel("Ngày Đặt");
		lblHoten_panelCTUS_dkDS.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoten_panelCTUS_dkDS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblHoten_panelCTUS_dkDS.setBounds(0, 134, 60, 20);
		panelCTUS.add(lblHoten_panelCTUS_dkDS);
		
		txtEmail_panelCTUS_dkDS = new JTextField();
		txtEmail_panelCTUS_dkDS.setBounds(20, 24, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS_dkDS);
		txtEmail_panelCTUS_dkDS.setColumns(10);
		
		txtNgayMuon_panelCTUS_dkDS = new JTextField();
		txtNgayMuon_panelCTUS_dkDS.setBounds(20, 164, 314, 30);
		panelCTUS.add(txtNgayMuon_panelCTUS_dkDS);
		txtNgayMuon_panelCTUS_dkDS.setColumns(10);
		
		JLabel lblSDT_panelCTUS_dkDS = new JLabel("Trạng thái");
		lblSDT_panelCTUS_dkDS.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT_panelCTUS_dkDS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSDT_panelCTUS_dkDS.setBounds(0, 204, 75, 20);
		panelCTUS.add(lblSDT_panelCTUS_dkDS);
		
		txtTrangThai_panelCTUS_dkDS = new JTextField();
		txtTrangThai_panelCTUS_dkDS.setBounds(20, 234, 314, 30);
		panelCTUS.add(txtTrangThai_panelCTUS_dkDS);
		txtTrangThai_panelCTUS_dkDS.setColumns(10);
		
		txtMaSach_panelCTUS_dkDS = new JTextField();
		txtMaSach_panelCTUS_dkDS.setBounds(20, 94, 314, 30);
		panelCTUS.add(txtMaSach_panelCTUS_dkDS);
		
		JButton btnXuatFileLS_panelDieuKhienLS = new JButton("Xuất File");
		btnXuatFileLS_panelDieuKhienLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.xuatFileDatSach();
			}
		});
		btnXuatFileLS_panelDieuKhienLS.setFocusPainted(false);
		btnXuatFileLS_panelDieuKhienLS.setFont(new Font("Arial", Font.BOLD, 18));
		btnXuatFileLS_panelDieuKhienLS.setBounds(247, 182, 117, 32);
		panelDieuKhienDatSach.add(btnXuatFileLS_panelDieuKhienLS);
		
		return panelDieuKhienDatSach;
		
	}

	public JPanel panel_dieukhienYeuCau() {
		JPanel panelDieuKhienYeuCau = new JPanel();
		panelDieuKhienYeuCau.setBounds(845, 36, 374, 540);

		panelDieuKhienYeuCau.setLayout(null);
		
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienYeuCau.add(lblTimKiem_panelDieuKhienUser);
		
		
		txtTimKiem_panelDieuKhienUser_dkYC = new JTextField();
		txtTimKiem_panelDieuKhienUser_dkYC.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.timYCTheoCBX_panelYC();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.timYCTheoCBX_panelYC();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtTimKiem_panelDieuKhienUser_dkYC.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimKiem_panelDieuKhienUser_dkYC.setBounds(40, 63, 294, 36);
		panelDieuKhienYeuCau.add(txtTimKiem_panelDieuKhienUser_dkYC);
		txtTimKiem_panelDieuKhienUser_dkYC.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser.setBounds(10, 182, 134, 43);
		panelDieuKhienYeuCau.add(lblDK_panelDieuKhienUser);
		
		cbxLoc_panelDieuKhienUser_dkYC = new JComboBox();
		cbxLoc_panelDieuKhienUser_dkYC.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxLoc_panelDieuKhienUser_dkYC.setModel(new DefaultComboBoxModel(new String[] {"Email"}));
		cbxLoc_panelDieuKhienUser_dkYC.setOpaque(true);
		cbxLoc_panelDieuKhienUser_dkYC.setBounds(40, 124, 294, 36);
		panelDieuKhienYeuCau.add(cbxLoc_panelDieuKhienUser_dkYC);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienYeuCau.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		
		JButton btnUserNew_panelCTUS_dkYC = new JButton("Làm mới");
		btnUserNew_panelCTUS_dkYC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnNewYeuCau();
			}
		});
		btnUserNew_panelCTUS_dkYC.setFont(new Font("Arial", Font.BOLD, 10));
		btnUserNew_panelCTUS_dkYC.setBounds(0, 280, 105, 27);
		panelCTUS.add(btnUserNew_panelCTUS_dkYC);
		
		JButton btnSuaUser_panelCTUS_dkYC = new JButton("Lưu Yêu Cầu");
		btnSuaUser_panelCTUS_dkYC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addOrUpdateYeuCau();
			}
		});
		btnSuaUser_panelCTUS_dkYC.setFont(new Font("Arial", Font.BOLD, 10));
		btnSuaUser_panelCTUS_dkYC.setBounds(126, 280, 105, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_dkYC);
		
		JButton btnDeleteUser_panelCTUS_dkYC = new JButton("Xóa Yêu Cầu");
		btnDeleteUser_panelCTUS_dkYC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteUser_panelCTUS_dkYC.setFont(new Font("Arial", Font.BOLD, 10));
		btnDeleteUser_panelCTUS_dkYC.setBounds(249, 280, 105, 27);
		panelCTUS.add(btnDeleteUser_panelCTUS_dkYC);
		
		JLabel lblEmail_panelCTUS_dkYC = new JLabel("Email");
		lblEmail_panelCTUS_dkYC.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS_dkYC.setBounds(0, 0, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS_dkYC);
		
		JLabel lblPassword_panelCTUS_dkYC = new JLabel("Loại sách");
		lblPassword_panelCTUS_dkYC.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword_panelCTUS_dkYC.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword_panelCTUS_dkYC.setBounds(0, 65, 60, 20);
		panelCTUS.add(lblPassword_panelCTUS_dkYC);
		
		JLabel lblHoten_panelCTUS_dkYC = new JLabel("Tên Sách");
		lblHoten_panelCTUS_dkYC.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoten_panelCTUS_dkYC.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblHoten_panelCTUS_dkYC.setBounds(0, 135, 60, 20);
		panelCTUS.add(lblHoten_panelCTUS_dkYC);
		
		txtEmail_panelCTUS_dkYC = new JTextField();
		txtEmail_panelCTUS_dkYC.setBounds(20, 25, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS_dkYC);
		txtEmail_panelCTUS_dkYC.setColumns(10);
		
		txtTenSach_panelCTUS_dkYC = new JTextField();
		txtTenSach_panelCTUS_dkYC.setBounds(20, 165, 314, 30);
		panelCTUS.add(txtTenSach_panelCTUS_dkYC);
		txtTenSach_panelCTUS_dkYC.setColumns(10);
		
		JLabel lblSDT_panelCTUS_dkYC = new JLabel("Mô Tả");
		lblSDT_panelCTUS_dkYC.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT_panelCTUS_dkYC.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSDT_panelCTUS_dkYC.setBounds(0, 205, 75, 20);
		panelCTUS.add(lblSDT_panelCTUS_dkYC);
		
		txtMoTa_panelCTUS_dkYC = new JTextField();
		txtMoTa_panelCTUS_dkYC.setBounds(20, 235, 314, 30);
		panelCTUS.add(txtMoTa_panelCTUS_dkYC);
		txtMoTa_panelCTUS_dkYC.setColumns(10);
		
		txtLoaiSach_panelCTUS_dkYC = new JTextField();
		txtLoaiSach_panelCTUS_dkYC.setBounds(20, 95, 314, 30);
		panelCTUS.add(txtLoaiSach_panelCTUS_dkYC);
		
		JButton btnXuatFileLS_panelDieuKhienLS = new JButton("Xuất File");
		btnXuatFileLS_panelDieuKhienLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.xuatFileYeuCau();
			}
		});
		btnXuatFileLS_panelDieuKhienLS.setFocusPainted(false);
		btnXuatFileLS_panelDieuKhienLS.setFont(new Font("Arial", Font.BOLD, 18));
		btnXuatFileLS_panelDieuKhienLS.setBounds(247, 182, 117, 32);
		panelDieuKhienYeuCau.add(btnXuatFileLS_panelDieuKhienLS);
		
		return panelDieuKhienYeuCau;
	}
		
	
	public JPanel panel_dieukhienDangMuon() {
		JPanel panelDieuKhienDangMuon = new JPanel();
		panelDieuKhienDangMuon.setBounds(845, 36, 374, 540);

		panelDieuKhienDangMuon.setLayout(null);
		
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienDangMuon.add(lblTimKiem_panelDieuKhienUser);
		
		
		txtTimKiem_panelDieuKhienUser_dkDM = new JTextField();
		txtTimKiem_panelDieuKhienUser_dkDM.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelDangMuon();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelDangMuon();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtTimKiem_panelDieuKhienUser_dkDM.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimKiem_panelDieuKhienUser_dkDM.setBounds(40, 63, 294, 36);
		panelDieuKhienDangMuon.add(txtTimKiem_panelDieuKhienUser_dkDM);
		txtTimKiem_panelDieuKhienUser_dkDM.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser.setBounds(10, 182, 134, 43);
		panelDieuKhienDangMuon.add(lblDK_panelDieuKhienUser);
		
		cbxLoc_panelDieuKhienUser_dkDM = new JComboBox();
		cbxLoc_panelDieuKhienUser_dkDM.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxLoc_panelDieuKhienUser_dkDM.setModel(new DefaultComboBoxModel(new String[] {"Email", "Mã sách"}));
		cbxLoc_panelDieuKhienUser_dkDM.setOpaque(true);
		cbxLoc_panelDieuKhienUser_dkDM.setBounds(40, 124, 294, 36);
		panelDieuKhienDangMuon.add(cbxLoc_panelDieuKhienUser_dkDM);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienDangMuon.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		JButton btnSuaUser_panelCTUS_dkDM = new JButton("Đã Trả");
		btnSuaUser_panelCTUS_dkDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.chuyenTrangThaiPhieuThanhDaTra_DangMuon();
			}
		});
		btnSuaUser_panelCTUS_dkDM.setFont(new Font("Arial", Font.BOLD, 14));
		btnSuaUser_panelCTUS_dkDM.setBounds(126, 280, 105, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_dkDM);
		
		JLabel lblEmail_panelCTUS_dkDM = new JLabel("Email");
		lblEmail_panelCTUS_dkDM.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS_dkDM.setBounds(0, 0, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS_dkDM);
		
		JLabel lblPassword_panelCTUS_dkDM = new JLabel("Mã Sách");
		lblPassword_panelCTUS_dkDM.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword_panelCTUS_dkDM.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword_panelCTUS_dkDM.setBounds(0, 65, 60, 20);
		panelCTUS.add(lblPassword_panelCTUS_dkDM);
		
		JLabel lblNgayMuon_panelCTUS_dkDM = new JLabel("Ngày Mượn");
		lblNgayMuon_panelCTUS_dkDM.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayMuon_panelCTUS_dkDM.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNgayMuon_panelCTUS_dkDM.setBounds(0, 135, 60, 20);
		panelCTUS.add(lblNgayMuon_panelCTUS_dkDM);
		
		txtEmail_panelCTUS_dkDM = new JTextField();
		txtEmail_panelCTUS_dkDM.setBounds(20, 25, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS_dkDM);
		txtEmail_panelCTUS_dkDM.setColumns(10);
		
		txtNgayMuon_panelCTUS_dkDM = new JTextField();
		txtNgayMuon_panelCTUS_dkDM.setBounds(20, 165, 314, 30);
		panelCTUS.add(txtNgayMuon_panelCTUS_dkDM);
		txtNgayMuon_panelCTUS_dkDM.setColumns(10);
		
		JLabel lblNgayTra_panelCTUS_dkDM = new JLabel("Ngày Trả");
		lblNgayTra_panelCTUS_dkDM.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayTra_panelCTUS_dkDM.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNgayTra_panelCTUS_dkDM.setBounds(0, 205, 75, 20);
		panelCTUS.add(lblNgayTra_panelCTUS_dkDM);
		
		txtNgayTra_panelCTUS_dkDM = new JTextField();
		txtNgayTra_panelCTUS_dkDM.setBounds(20, 235, 314, 30);
		panelCTUS.add(txtNgayTra_panelCTUS_dkDM);
		txtNgayTra_panelCTUS_dkDM.setColumns(10);
		
		txtMaSach_panelCTUS_dkDM = new JTextField();
		txtMaSach_panelCTUS_dkDM.setBounds(20, 95, 314, 30);
		panelCTUS.add(txtMaSach_panelCTUS_dkDM);
		
		JButton btnNewDM_panelCTUS_dkDM = new JButton("Làm Mới");
		btnNewDM_panelCTUS_dkDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnNewDangMuon();
			}
		});
		btnNewDM_panelCTUS_dkDM.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewDM_panelCTUS_dkDM.setBounds(0, 280, 105, 27);
		panelCTUS.add(btnNewDM_panelCTUS_dkDM);
		
		JButton btnSaveDM_panelCTUS_dkDM = new JButton("Thêm Mới");
		btnSaveDM_panelCTUS_dkDM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveDangMuon();
			}
		});
		btnSaveDM_panelCTUS_dkDM.setFont(new Font("Arial", Font.BOLD, 14));
		btnSaveDM_panelCTUS_dkDM.setBounds(249, 280, 105, 27);
		panelCTUS.add(btnSaveDM_panelCTUS_dkDM);
		
		JButton btnXuatFileLS_panelDieuKhienLS = new JButton("Xuất File");
		btnXuatFileLS_panelDieuKhienLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.xuatFileDangMuon();
			}
		});
		btnXuatFileLS_panelDieuKhienLS.setFocusPainted(false);
		btnXuatFileLS_panelDieuKhienLS.setFont(new Font("Arial", Font.BOLD, 18));
		btnXuatFileLS_panelDieuKhienLS.setBounds(247, 182, 117, 32);
		panelDieuKhienDangMuon.add(btnXuatFileLS_panelDieuKhienLS);
		
		return panelDieuKhienDangMuon;
	}

	public JPanel panel_dieukhienQuaHan() {
		JPanel panelDieuKhienQuaHan = new JPanel();
		panelDieuKhienQuaHan.setBounds(845, 36, 374, 540);

		panelDieuKhienQuaHan.setLayout(null);
		
		
		JLabel lblTimKiem_panelDieuKhienUser = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhienUser.setBounds(10, 10, 103, 43);
		panelDieuKhienQuaHan.add(lblTimKiem_panelDieuKhienUser);
		
		
		txtTimKiem_panelDieuKhienUser_dkQH = new JTextField();
		txtTimKiem_panelDieuKhienUser_dkQH.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelQuaHan();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.timPMSTheoCBX_panelQuaHan();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txtTimKiem_panelDieuKhienUser_dkQH.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimKiem_panelDieuKhienUser_dkQH.setBounds(40, 63, 294, 36);
		panelDieuKhienQuaHan.add(txtTimKiem_panelDieuKhienUser_dkQH);
		txtTimKiem_panelDieuKhienUser_dkQH.setColumns(10);
		
		JLabel lblDK_panelDieuKhienUser = new JLabel("Điều khiển");
		lblDK_panelDieuKhienUser.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhienUser.setBounds(10, 182, 134, 43);
		panelDieuKhienQuaHan.add(lblDK_panelDieuKhienUser);
		
		cbxLoc_panelDieuKhienUser_dkQH = new JComboBox();
		cbxLoc_panelDieuKhienUser_dkQH.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxLoc_panelDieuKhienUser_dkQH.setModel(new DefaultComboBoxModel(new String[] {"Email", "Mã sách"}));
		cbxLoc_panelDieuKhienUser_dkQH.setOpaque(true);
		cbxLoc_panelDieuKhienUser_dkQH.setBounds(40, 124, 294, 36);
		panelDieuKhienQuaHan.add(cbxLoc_panelDieuKhienUser_dkQH);
		
		JPanel panelCTUS = new JPanel();
		panelCTUS.setBounds(10, 223, 354, 307);
		panelDieuKhienQuaHan.add(panelCTUS);
		panelCTUS.setLayout(null);
		
		JButton btnSuaUser_panelCTUS_dkQH = new JButton("Đã Trả");
		btnSuaUser_panelCTUS_dkQH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.chuyenTrangThaiPhieuThanhDaTra_QuaHan();
			}
		});
		btnSuaUser_panelCTUS_dkQH.setFont(new Font("Arial", Font.BOLD, 16));
		btnSuaUser_panelCTUS_dkQH.setBounds(126, 280, 105, 27);
		panelCTUS.add(btnSuaUser_panelCTUS_dkQH);
		
		JLabel lblEmail_panelCTUS_dkQH = new JLabel("Email");
		lblEmail_panelCTUS_dkQH.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail_panelCTUS_dkQH.setBounds(0, 0, 60, 20);
		panelCTUS.add(lblEmail_panelCTUS_dkQH);
		
		JLabel lblMaSach_panelCTUS_dkQH = new JLabel("Mã Sách");
		lblMaSach_panelCTUS_dkQH.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaSach_panelCTUS_dkQH.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaSach_panelCTUS_dkQH.setBounds(0, 65, 60, 20);
		panelCTUS.add(lblMaSach_panelCTUS_dkQH);
		
		JLabel lblNgayMuon_panelCTUS_dkQH = new JLabel("Ngày Mượn");
		lblNgayMuon_panelCTUS_dkQH.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayMuon_panelCTUS_dkQH.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNgayMuon_panelCTUS_dkQH.setBounds(0, 135, 60, 20);
		panelCTUS.add(lblNgayMuon_panelCTUS_dkQH);
		
		txtEmail_panelCTUS_dkQH = new JTextField();
		txtEmail_panelCTUS_dkQH.setBounds(20, 25, 314, 30);
		panelCTUS.add(txtEmail_panelCTUS_dkQH);
		txtEmail_panelCTUS_dkQH.setColumns(10);
		
		txtNgayMuon_panelCTUS_dkQH = new JTextField();
		txtNgayMuon_panelCTUS_dkQH.setBounds(20, 165, 314, 30);
		panelCTUS.add(txtNgayMuon_panelCTUS_dkQH);
		txtNgayMuon_panelCTUS_dkQH.setColumns(10);
		
		JLabel lblNgayTra_panelCTUS_dkQH = new JLabel("Ngày Trả");
		lblNgayTra_panelCTUS_dkQH.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayTra_panelCTUS_dkQH.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNgayTra_panelCTUS_dkQH.setBounds(0, 205, 75, 20);
		panelCTUS.add(lblNgayTra_panelCTUS_dkQH);
		
		txtNgayTra_panelCTUS_dkQH = new JTextField();
		txtNgayTra_panelCTUS_dkQH.setBounds(20, 235, 314, 30);
		panelCTUS.add(txtNgayTra_panelCTUS_dkQH);
		txtNgayTra_panelCTUS_dkQH.setColumns(10);
		
		txtMaSach_panelCTUS_dkQH = new JTextField();
		txtMaSach_panelCTUS_dkQH.setBounds(20, 95, 314, 30);
		panelCTUS.add(txtMaSach_panelCTUS_dkQH);
		
		JButton btnXuatFileLS_panelDieuKhienLS = new JButton("Xuất File");
		btnXuatFileLS_panelDieuKhienLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.xuatFileQuaHan();
			}
		});
		btnXuatFileLS_panelDieuKhienLS.setFocusPainted(false);
		btnXuatFileLS_panelDieuKhienLS.setFont(new Font("Arial", Font.BOLD, 18));
		btnXuatFileLS_panelDieuKhienLS.setBounds(247, 182, 117, 32);
		panelDieuKhienQuaHan.add(btnXuatFileLS_panelDieuKhienLS);
		
		return panelDieuKhienQuaHan;
	}
	
	public JPanel panel_ThongKe() {
		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_ThongKe.setBackground(new Color(255, 255, 255));
		panel_ThongKe.setBounds(0, 148, 1286, 616);
		panel_ThongKe.setLayout(null);
		
		// bat dau code
		
		JPanel panel_TongSoNguoiDung = new JPanel();
		panel_TongSoNguoiDung.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TongSoNguoiDung.setBounds(157, 77, 291, 204);
		panel_ThongKe.add(panel_TongSoNguoiDung);
		panel_TongSoNguoiDung.setLayout(null);
		

		JLabel lblTitle_panelTongSoNguoiDung = new JLabel("Tổng số người dùng");
		lblTitle_panelTongSoNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelTongSoNguoiDung.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelTongSoNguoiDung.setForeground(new Color(255, 255, 255));
		lblTitle_panelTongSoNguoiDung.setBounds(36, 26, 218, 44);
		panel_TongSoNguoiDung.add(lblTitle_panelTongSoNguoiDung);
		
		JLabel lblTong__panelTongSoNguoiDung = new JLabel(userDAO.getuserDAO().soNguoiDung() + " người dùng");
		lblTong__panelTongSoNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong__panelTongSoNguoiDung.setForeground(Color.WHITE);
		lblTong__panelTongSoNguoiDung.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong__panelTongSoNguoiDung.setBounds(36, 70, 218, 44);
		panel_TongSoNguoiDung.add(lblTong__panelTongSoNguoiDung);
		
		JLabel imgBG_panelTongSoNguoiDung = new JLabel("");
		imgBG_panelTongSoNguoiDung.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLUser();
			}
		});
		imgBG_panelTongSoNguoiDung.setBounds(0, 0, panel_TongSoNguoiDung.getWidth(), panel_TongSoNguoiDung.getHeight());
//		ImageIcon imgITongSoNguoiDung_panelThongKe = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelThongKe = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSoNguoiDung.jpg");
		Image imBG_panelThongKe = imgIBG_panelThongKe.getImage();
		Image imageBG_panelThongKe = imBG_panelThongKe.getScaledInstance(imgBG_panelTongSoNguoiDung.getWidth(), imgBG_panelTongSoNguoiDung.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelThongKe = new ImageIcon(imageBG_panelThongKe);
		imgBG_panelTongSoNguoiDung.setIcon(imageIconBG_panelThongKe);
		panel_TongSoNguoiDung.add(imgBG_panelTongSoNguoiDung);
		
		
		JPanel panel_TongSoSach = new JPanel();
		panel_TongSoSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TongSoSach.setBounds(498, 77, 291, 204);
		panel_ThongKe.add(panel_TongSoSach);
		panel_TongSoSach.setLayout(null);
		
		JLabel lblTong_panelTongSoSach = new JLabel(sachDAO.getsachDAO().soLuongSach() + " cuốn sách");
//		JLabel lblTong_panelTongSoSach = new JLabel(11 + " cuốn sách");
		lblTong_panelTongSoSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelTongSoSach.setForeground(Color.WHITE);
		lblTong_panelTongSoSach.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelTongSoSach.setBounds(36, 70, 218, 44);
		panel_TongSoSach.add(lblTong_panelTongSoSach);
		
		JLabel lblTitle_panelTongSoSach = new JLabel("Tổng số sách");
		lblTitle_panelTongSoSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelTongSoSach.setForeground(Color.WHITE);
		lblTitle_panelTongSoSach.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelTongSoSach.setBounds(36, 26, 218, 44);
		panel_TongSoSach.add(lblTitle_panelTongSoSach);
		
		JLabel imgBG_panelTongSoSach = new JLabel("");
		imgBG_panelTongSoSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLSach();
			}
		});
		imgBG_panelTongSoSach.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelTongSoSach = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelTongSoSach = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSoSach.jpg");
		Image imBG_panelTongSoSach = imgIBG_panelTongSoSach.getImage();
		Image imageBG_panelTongSoSach = imBG_panelTongSoSach.getScaledInstance(imgBG_panelTongSoSach.getWidth(), imgBG_panelTongSoSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelTongSoSach = new ImageIcon(imageBG_panelTongSoSach);
		imgBG_panelTongSoSach.setIcon(imageIconBG_panelTongSoSach);	
		panel_TongSoSach.add(imgBG_panelTongSoSach);
		
		
		JPanel panel_DoPhoBienCuaSach = new JPanel();
		panel_DoPhoBienCuaSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DoPhoBienCuaSach.setBounds(839, 77, 291, 204);
		panel_ThongKe.add(panel_DoPhoBienCuaSach);
		panel_DoPhoBienCuaSach.setLayout(null);
		
		JLabel lblTitle_panelDoPhoBienCuaSach = new JLabel("Độ phổ biến của sách");
		lblTitle_panelDoPhoBienCuaSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelDoPhoBienCuaSach.setForeground(Color.WHITE);
		lblTitle_panelDoPhoBienCuaSach.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelDoPhoBienCuaSach.setBounds(10, 26, 271, 44);
		panel_DoPhoBienCuaSach.add(lblTitle_panelDoPhoBienCuaSach);
		
		JButton btnXemChiTiet_panelDoPhoBienCuaSach = new JButton("Xem chi tiết");
		btnXemChiTiet_panelDoPhoBienCuaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.createdChart();
			}
		});
		btnXemChiTiet_panelDoPhoBienCuaSach.setFocusPainted(false);
		btnXemChiTiet_panelDoPhoBienCuaSach.setFont(new Font("Arial", Font.BOLD, 18));
		btnXemChiTiet_panelDoPhoBienCuaSach.setBounds(74, 70, 143, 44);
		panel_DoPhoBienCuaSach.add(btnXemChiTiet_panelDoPhoBienCuaSach);
		
		JLabel imgBG_panelDoPhoBienCuaSach = new JLabel("");
		imgBG_panelDoPhoBienCuaSach.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangMuon  = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelDoPhoBienCuaSach = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\doPhoBienCuaSachjpg.jpg");
		Image imBG_panelDoPhoBienCuaSach = imgIBG_panelDoPhoBienCuaSach.getImage();
		Image imageBG_panelDoPhoBienCuaSach = imBG_panelDoPhoBienCuaSach.getScaledInstance(imgBG_panelDoPhoBienCuaSach.getWidth(), imgBG_panelDoPhoBienCuaSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelDoPhoBienCuaSach = new ImageIcon(imageBG_panelDoPhoBienCuaSach);
		imgBG_panelDoPhoBienCuaSach.setIcon(imageIconBG_panelDoPhoBienCuaSach);	
		panel_DoPhoBienCuaSach.add(imgBG_panelDoPhoBienCuaSach);
		
		
		JPanel panel_SachQuaHan = new JPanel();
		panel_SachQuaHan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachQuaHan.setBounds(839, 321, 291, 204);
		panel_ThongKe.add(panel_SachQuaHan);
		panel_SachQuaHan.setLayout(null);
		
		JLabel lblTitle_panelSachQuaHan = new JLabel("Tống số sách quá hạn");
		lblTitle_panelSachQuaHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachQuaHan.setForeground(Color.WHITE);
		lblTitle_panelSachQuaHan.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachQuaHan.setBounds(10, 26, 271, 44);
		panel_SachQuaHan.add(lblTitle_panelSachQuaHan);
		
		JLabel lblTong_panelSachQuaHan = new JLabel(phieuMuonSachDAO.getphieuMuonSachDAO().soLuongSachDaQuaHan() + " cuốn sách");
//		JLabel lblTong_panelSachQuaHan = new JLabel(11 + " cuốn sách");
		lblTong_panelSachQuaHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachQuaHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachQuaHan.setForeground(Color.WHITE);
		lblTong_panelSachQuaHan.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachQuaHan.setBounds(36, 70, 218, 44);
		panel_SachQuaHan.add(lblTong_panelSachQuaHan);
		
		JLabel imgBG_panelSachQuaHan = new JLabel("");
		imgBG_panelSachQuaHan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLUser();
				controller.changeToQuaHan();
			}
		});
		imgBG_panelSachQuaHan.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachQuaHan  = new ImageIcon(
//				Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachQuaHan  = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachQuaHanjpg.jpg");
		Image imBG_panelSachQuaHan  = imgIBG_panelSachQuaHan.getImage();
		Image imageBG_panelSachQuaHan  = imBG_panelSachQuaHan.getScaledInstance(imgBG_panelSachQuaHan.getWidth(), imgBG_panelSachQuaHan.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachQuaHan  = new ImageIcon(imageBG_panelSachQuaHan);
		imgBG_panelSachQuaHan.setIcon(imageIconBG_panelSachQuaHan);	
		panel_SachQuaHan.add(imgBG_panelSachQuaHan);
		
		JPanel panel_SachDangDat = new JPanel();
		panel_SachDangDat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachDangDat.setBounds(498, 321, 291, 204);
		panel_ThongKe.add(panel_SachDangDat);
		panel_SachDangDat.setLayout(null);
		
		JLabel lblTitle_panelSachDangDat = new JLabel("Tống số sách đang đặt");
		lblTitle_panelSachDangDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachDangDat.setForeground(Color.WHITE);
		lblTitle_panelSachDangDat.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachDangDat.setBounds(10, 26, 271, 44);
		panel_SachDangDat.add(lblTitle_panelSachDangDat);
		
//		JLabel lblTong_panelSachDangDat = new JLabel(11 + " cuốn sách");
		JLabel lblTong_panelSachDangDat = new JLabel(phieuMuonSachDAO.getphieuMuonSachDAO().soLuongSachDangDat() + " cuốn sách");
		lblTong_panelSachDangDat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachDangDat.setForeground(Color.WHITE);
		lblTong_panelSachDangDat.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachDangDat.setBounds(36, 70, 218, 44);
		panel_SachDangDat.add(lblTong_panelSachDangDat);
		
		JLabel imgBG_panelSachDangDat = new JLabel("");
		imgBG_panelSachDangDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLUser();
				controller.changeToDatSach();
			}
		});
		imgBG_panelSachDangDat.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangDat = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachDangDat  = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachDangDatjpg.jpg");
		Image imBG_panelSachDangDat  = imgIBG_panelSachDangDat.getImage();
		Image imageBG_panelSachDangDat  = imBG_panelSachDangDat.getScaledInstance(imgBG_panelSachDangDat.getWidth(), imgBG_panelSachDangDat.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachDangDat  = new ImageIcon(imageBG_panelSachDangDat);
		imgBG_panelSachDangDat.setIcon(imageIconBG_panelSachDangDat);	
		panel_SachDangDat.add(imgBG_panelSachDangDat);
		
		JPanel panel_SachDangMuon = new JPanel();
		panel_SachDangMuon.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_SachDangMuon.setBounds(157, 321, 291, 204);
		panel_ThongKe.add(panel_SachDangMuon);
		panel_SachDangMuon.setLayout(null);
		
		JLabel lblTitle_panelSachDangMuon = new JLabel("Tống số sách đang mượn");
		lblTitle_panelSachDangMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_panelSachDangMuon.setForeground(Color.WHITE);
		lblTitle_panelSachDangMuon.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTitle_panelSachDangMuon.setBounds(10, 26, 271, 44);
		panel_SachDangMuon.add(lblTitle_panelSachDangMuon);
		
		JLabel lblTong_panelSachDangMuon = new JLabel(phieuMuonSachDAO.getphieuMuonSachDAO().soLuongSachDangMuon() + " cuốn sách");
//		JLabel lblTong_panelSachDangMuon = new JLabel(11 + " cuốn sách");
		lblTong_panelSachDangMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTong_panelSachDangMuon.setForeground(Color.WHITE);
		lblTong_panelSachDangMuon.setFont(new Font("Calibri", Font.BOLD, 23));
		lblTong_panelSachDangMuon.setBounds(36, 70, 218, 44);
		panel_SachDangMuon.add(lblTong_panelSachDangMuon);
		
		JLabel imgBG_panelSachDangMuon = new JLabel("");
		imgBG_panelSachDangMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.choseQLUser();
				controller.changeToDangMuon();
			}
		});
		imgBG_panelSachDangMuon.setBounds(0, 0, 291, 204);
//		ImageIcon imgIBG_panelSachDangMuon  = new ImageIcon(
//		Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
		ImageIcon imgIBG_panelSachDangMuon = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\tongSachDangMuonjpg.jpg");
		Image imBG_panelSachDangMuon = imgIBG_panelSachDangMuon.getImage();
		Image imageBG_panelSachDangMuon = imBG_panelSachDangMuon.getScaledInstance(imgBG_panelSachDangMuon.getWidth(), imgBG_panelSachDangMuon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelSachDangMuon = new ImageIcon(imageBG_panelSachDangMuon);
		imgBG_panelSachDangMuon.setIcon(imageIconBG_panelSachDangMuon);	
		panel_SachDangMuon.add(imgBG_panelSachDangMuon);
		
		// ket thuc code
		
		return panel_ThongKe;
	}
}
