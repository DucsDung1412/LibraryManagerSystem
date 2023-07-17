package view;


import java.awt.EventQueue;
import java.awt.Image;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class libraryManagerSystemView extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panel_top = new JPanel();
		panel_top.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_top.setBackground(Color.WHITE);
		panel_top.setBounds(-1, 0, this.getWidth() - 14, 148);
		contentPane.add(panel_top);
		panel_top.setLayout(null);
		
		// logo panelTop
		JLabel imgLogo_panelTop = new JLabel("");
		imgLogo_panelTop.setBounds(16, 0, 144, 138);
		ImageIcon imgILogo_panelTop = new ImageIcon(Paths.get("src/main/java/icon/logo.png").toAbsolutePath().toString());
//		ImageIcon imgILogo_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\logo.png");
		Image imLogo_panelTop = imgILogo_panelTop.getImage();
		Image imageLogo_panelTop = imLogo_panelTop.getScaledInstance(imgLogo_panelTop.getWidth(), imgLogo_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconLogo_panelTop = new ImageIcon(imageLogo_panelTop);
		imgLogo_panelTop.setIcon(imageIconLogo_panelTop);
		panel_top.add(imgLogo_panelTop);
		
		
		// Home
		JLabel imgHome_panelTop = new JLabel("Home");
		imgHome_panelTop.setBackground(new Color(255, 255, 255));
		imgHome_panelTop.setOpaque(true);
		imgHome_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgHome_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgHome_panelTop.setBounds(276, 0, 74, 109);
		imgHome_panelTop.setVerticalTextPosition(JLabel.BOTTOM);
		imgHome_panelTop.setHorizontalTextPosition(JLabel.CENTER);
		ImageIcon imgIHome_panelTop = new ImageIcon(Paths.get("src/main/java/icon/icon_home_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIHome_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_home_setting.png");
		Image imHome_panelTop = imgIHome_panelTop.getImage();
		Image imageHome_panelTop = imHome_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconHome_panelTop = new ImageIcon(imageHome_panelTop);
		imgHome_panelTop.setIcon(imageIconHome_panelTop);
		panel_top.add(imgHome_panelTop);
		
		// Sach cua toi
		JLabel imgMyBook_panelTop = new JLabel("Sách của tôi");
		imgMyBook_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgMyBook_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgMyBook_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgMyBook_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgMyBook_panelTop.setBounds(370, 0, 118, 109);
		ImageIcon imgIMyBook_panelTop = new ImageIcon(Paths.get("src/main/java/icon/icon_my_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIMyBook_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_my_setting.png");
		Image imMyBook_panelTop = imgIMyBook_panelTop.getImage();
		Image imageMyBook_panelTop = imMyBook_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconMyBook_panelTop = new ImageIcon(imageMyBook_panelTop);
		imgMyBook_panelTop.setIcon(imageIconMyBook_panelTop);
		panel_top.add(imgMyBook_panelTop);
		
		// Quan ly sach
		JLabel imgBookManager_panelTop = new JLabel("Quản lý sách");
		imgBookManager_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgBookManager_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgBookManager_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgBookManager_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgBookManager_panelTop.setBounds(508, 0, 118, 109);
		ImageIcon imgIBookManager_panelTop = new ImageIcon(Paths.get("src/main/java/icon/icon_book_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIBookManager_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_book_setting.png");
		Image imBookManager_panelTop = imgIBookManager_panelTop.getImage();
		Image imageBookManager_panelTop = imBookManager_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconBookManager_panelTop = new ImageIcon(imageBookManager_panelTop);
		imgBookManager_panelTop.setIcon(imageIconBookManager_panelTop);
		panel_top.add(imgBookManager_panelTop);
		
		// quan ly user
		JLabel imgUserManager_panelTop = new JLabel("Quản lý user");
		imgUserManager_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgUserManager_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgUserManager_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgUserManager_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgUserManager_panelTop.setBounds(646, 0, 118, 109);
		ImageIcon imgIUserManager_panelTop = new ImageIcon(Paths.get("src/main/java/icon/icon_user_setting.png").toAbsolutePath().toString());
//		ImageIcon imgIUserManager_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imUserManager_panelTop = imgIUserManager_panelTop.getImage();
		Image imageUserManager_panelTop = imUserManager_panelTop.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon imageIconUserManager_panelTop = new ImageIcon(imageUserManager_panelTop);
		imgUserManager_panelTop.setIcon(imageIconUserManager_panelTop);
		panel_top.add(imgUserManager_panelTop);
		
		// Thong ke
		JLabel imgThongKe_panelTop = new JLabel("Thống kê");
		imgThongKe_panelTop.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgThongKe_panelTop.setHorizontalTextPosition(SwingConstants.CENTER);
		imgThongKe_panelTop.setHorizontalAlignment(SwingConstants.CENTER);
		imgThongKe_panelTop.setFont(new Font("Arial", Font.BOLD, 18));
		imgThongKe_panelTop.setBounds(784, 0, 93, 109);
		ImageIcon imgIThongKe_panelTop = new ImageIcon(Paths.get("src/main/java/icon/icon_thongke_setting.png").toAbsolutePath().toString());
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
		imgUser_panelTop.setBounds(1176, 14, 36, 36);
		ImageIcon imgIUser_panelTop = new ImageIcon(Paths.get("src/main/java/icon/user.png").toAbsolutePath().toString());
//		ImageIcon imgIUser_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imUser_panelTop = imgIUser_panelTop.getImage();
		Image imageUser_panelTop = imUser_panelTop.getScaledInstance(imgUser_panelTop.getWidth(), imgUser_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconUser_panelTop = new ImageIcon(imageUser_panelTop);
		imgUser_panelTop.setIcon(imageIconUser_panelTop);
		panel_top.add(imgUser_panelTop);
		
		// noti
		JLabel imgNoti_panelTop = new JLabel("");
		imgNoti_panelTop.setBounds(1236, 14, 36, 36);
		ImageIcon imgINoti_panelTop = new ImageIcon(Paths.get("src/main/java/icon/thongbao.png").toAbsolutePath().toString());
//		ImageIcon imgINoti_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imNoti_panelTop = imgINoti_panelTop.getImage();
		Image imageNoti_panelTop = imNoti_panelTop.getScaledInstance(imgNoti_panelTop.getWidth(), imgNoti_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconNoti_panelTop = new ImageIcon(imageNoti_panelTop);
		imgNoti_panelTop.setIcon(imageIconNoti_panelTop);
		panel_top.add(imgNoti_panelTop);
		
		// setting
		JLabel imgSetting_panelTop = new JLabel("");
		imgSetting_panelTop.setBounds(1176, 62, 36, 36);
		ImageIcon imgISetting_panelTop = new ImageIcon(Paths.get("src/main/java/icon/setting_banhrang.png").toAbsolutePath().toString());
//		ImageIcon imgISetting_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imSetting_panelTop = imgISetting_panelTop.getImage();
		Image imageSetting_panelTop = imSetting_panelTop.getScaledInstance(imgSetting_panelTop.getWidth(), imgSetting_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconSetting_panelTop = new ImageIcon(imageSetting_panelTop);
		imgSetting_panelTop.setIcon(imageIconSetting_panelTop);
		panel_top.add(imgSetting_panelTop);
		
		// exit
		JLabel imgLogout_panelTop = new JLabel("");
		imgLogout_panelTop.setBounds(1236, 62, 36, 36);
		ImageIcon imgILogout_panelTop = new ImageIcon(Paths.get("src/main/java/icon/dangxuat.png").toAbsolutePath().toString());
//		ImageIcon imgILogout_panelTop = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\New folder (2)\\icon_user_setting.png");
		Image imLogout_panelTop = imgILogout_panelTop.getImage();
		Image imageLogout_panelTop = imLogout_panelTop.getScaledInstance(imgLogout_panelTop.getWidth(), imgLogout_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconLogout_panelTop = new ImageIcon(imageLogout_panelTop);
		imgLogout_panelTop.setIcon(imageIconLogout_panelTop);
		panel_top.add(imgLogout_panelTop);
		
		// image background
		JLabel imgBG_panelTop = new JLabel("");
		imgBG_panelTop.setBackground(new Color(0, 0, 0));
		imgBG_panelTop.setBounds(0, 0, panel_top.getWidth(), panel_top.getHeight());
		ImageIcon imgIBG_panelTop = new ImageIcon(Paths.get("src/main/java/icon/main_BG1.png").toAbsolutePath().toString());
//		ImageIcon imgIBG_panelTop = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\librarySys\\src\\main\\java\\icon\\main_BG1.png");
		Image imBG_panelTop = imgIBG_panelTop.getImage();
		Image imageBG_panelTop = imBG_panelTop.getScaledInstance(imgBG_panelTop.getWidth(), imgBG_panelTop.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIconBG_panelTop = new ImageIcon(imageBG_panelTop);
		imgBG_panelTop.setIcon(imageIconBG_panelTop);
		panel_top.add(imgBG_panelTop);
		
		// Thêm panel tại đây
		contentPane.add(panel_QuanLySach());
	}
	
	public JPanel panel_QuanLySach() {
		JPanel panel_QLS = new JPanel();
		panel_QLS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_QLS.setBackground(new Color(255, 255, 255));
		panel_QLS.setBounds(0, 148, 1286, 616);
		panel_QLS.setLayout(null);
		
		JLabel lblSachHienCo_panelQLS = new JLabel("Sách hiện có ở đây");
		lblSachHienCo_panelQLS.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSachHienCo_panelQLS.setBounds(69, 159, 740, 411);
		panel_QLS.add(lblSachHienCo_panelQLS);
		
		JPanel panelDieuKhien = new JPanel();
		panelDieuKhien.setBounds(845, 36, 374, 534);
		panel_QLS.add(panelDieuKhien);
		panelDieuKhien.setLayout(null);
		
		JLabel lblTimKiem_panelDieuKhien = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhien.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTimKiem_panelDieuKhien.setBounds(10, 10, 103, 43);
		panelDieuKhien.add(lblTimKiem_panelDieuKhien);
		
		txtLoc = new JTextField();
		txtLoc.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtLoc.setBounds(43, 63, 291, 46);
		panelDieuKhien.add(txtLoc);
		txtLoc.setColumns(10);
		
		JLabel lblDK_panelDieuKhien = new JLabel("Điều khiển");
		lblDK_panelDieuKhien.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDK_panelDieuKhien.setBounds(10, 191, 103, 43);
		panelDieuKhien.add(lblDK_panelDieuKhien);
		
		JLabel lblThongTinSach_panelDieuKhien = new JLabel("Thông tin sách ở đây");
		lblThongTinSach_panelDieuKhien.setBounds(47, 244, 287, 257);
		panelDieuKhien.add(lblThongTinSach_panelDieuKhien);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 135, 291, 43);
		panelDieuKhien.add(comboBox);
		
		JPanel panel_Nut = new JPanel();
		panel_Nut.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Nut.setBounds(69, 36, 740, 76);
		panel_QLS.add(panel_Nut);
		panel_Nut.setLayout(null);
		
		JLabel lblSach_panelNut = new JLabel("Sách");
		lblSach_panelNut.setBounds(10, 7, 146, 59);
		panel_Nut.add(lblSach_panelNut);
		lblSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach_panelNut.setFont(new Font("Calibri", Font.PLAIN, 24));
		
		JLabel lblLoaiSach_panelNut = new JLabel("Quản Lý Sách");
		lblLoaiSach_panelNut.setBounds(166, 7, 131, 59);
		panel_Nut.add(lblLoaiSach_panelNut);
		lblLoaiSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiSach_panelNut.setFont(new Font("Calibri", Font.PLAIN, 24));
		
		// bat dau code
		
		
		
		
		
		// ket thuc code
		
		return panel_QLS;
	}
		
		// bat dau code
		
		
		
		
		
		// ket thuc code
		
		return panel;
	}

	/* 
	
	public JPanel panel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 148, 1286, 616);
		panel.setLayout(null);
		
		// bat dau code
		
		
		
		
		// ket thuc code
		
		return panel;
	}
	 
	**/
}
