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
		
		JPanel panelDieuKhien = new JPanel();
		panelDieuKhien.setBounds(845, 36, 374, 540);
		panel_QLS.add(panelDieuKhien);
		panelDieuKhien.setLayout(null);
		
		JLabel lblTimKiem_panelDieuKhien = new JLabel("Tìm kiếm");
		lblTimKiem_panelDieuKhien.setFont(new Font("Calibri", Font.BOLD, 24));
		lblTimKiem_panelDieuKhien.setBounds(10, 10, 103, 43);
		panelDieuKhien.add(lblTimKiem_panelDieuKhien);
		
		txtTimKiem_panelDieuKhien = new JTextField();
		txtTimKiem_panelDieuKhien.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtTimKiem_panelDieuKhien.setBounds(40, 63, 294, 36);
		panelDieuKhien.add(txtTimKiem_panelDieuKhien);
		txtTimKiem_panelDieuKhien.setColumns(10);
		
		JLabel lblDK_panelDieuKhien = new JLabel("Điều khiển");
		lblDK_panelDieuKhien.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDK_panelDieuKhien.setBounds(10, 182, 134, 43);
		panelDieuKhien.add(lblDK_panelDieuKhien);
		
		JComboBox cbxLoc_panelDieuKhien = new JComboBox();
		cbxLoc_panelDieuKhien.setModel(new DefaultComboBoxModel(new String[] {"rfdrg", "uyhggh"}));
		cbxLoc_panelDieuKhien.setOpaque(true);
		cbxLoc_panelDieuKhien.setBounds(40, 124, 294, 36);
		panelDieuKhien.add(cbxLoc_panelDieuKhien);
		
		JPanel panelCTS = new JPanel();
		panelCTS.setBounds(10, 223, 354, 307);
		panelDieuKhien.add(panelCTS);
		panelCTS.setLayout(null);
		
		JButton btnSM_panelCTS = new JButton("Sách Mới");
		btnSM_panelCTS.setFont(new Font("Arial", Font.BOLD, 16));
		btnSM_panelCTS.setBounds(0, 280, 105, 27);
		panelCTS.add(btnSM_panelCTS);
		
		JLabel imgSach_panelCTS = new JLabel("New label");
		imgSach_panelCTS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		imgSach_panelCTS.setBounds(10, 10, 234, 93);
		panelCTS.add(imgSach_panelCTS);
		
		JButton btnSS_panelCTS = new JButton("Sửa Sách");
		btnSS_panelCTS.setFont(new Font("Arial", Font.BOLD, 16));
		btnSS_panelCTS.setBounds(126, 280, 105, 27);
		panelCTS.add(btnSS_panelCTS);
		
		JButton btnXS_panelCTS = new JButton("Xóa Sách");
		btnXS_panelCTS.setFont(new Font("Arial", Font.BOLD, 16));
		btnXS_panelCTS.setBounds(249, 280, 105, 27);
		panelCTS.add(btnXS_panelCTS);
		
		JLabel lblMaSach_panelCTS = new JLabel("Mã Sách");
		lblMaSach_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaSach_panelCTS.setBounds(0, 113, 60, 20);
		panelCTS.add(lblMaSach_panelCTS);
		
		JLabel lblTenSach_panelCTS = new JLabel("Tên Sách");
		lblTenSach_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTenSach_panelCTS.setBounds(0, 168, 60, 20);
		panelCTS.add(lblTenSach_panelCTS);
		
		JLabel lblTacGia_panelCTS = new JLabel("Tác Giả");
		lblTacGia_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTacGia_panelCTS.setBounds(0, 225, 60, 20);
		panelCTS.add(lblTacGia_panelCTS);
		
		txtMaSach_panelCTS = new JTextField();
		txtMaSach_panelCTS.setBounds(25, 133, 156, 30);
		panelCTS.add(txtMaSach_panelCTS);
		txtMaSach_panelCTS.setColumns(10);
		
		txtTenSach_panelCTS = new JTextField();
		txtTenSach_panelCTS.setBounds(25, 185, 156, 30);
		panelCTS.add(txtTenSach_panelCTS);
		txtTenSach_panelCTS.setColumns(10);
		
		txtTacGia_panelCTS = new JTextField();
		txtTacGia_panelCTS.setBounds(25, 240, 156, 30);
		panelCTS.add(txtTacGia_panelCTS);
		txtTacGia_panelCTS.setColumns(10);
		
		JComboBox cbxMaLS_panelCTS = new JComboBox();
		cbxMaLS_panelCTS.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxMaLS_panelCTS.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019"}));
		cbxMaLS_panelCTS.setBounds(254, 57, 90, 32);
		panelCTS.add(cbxMaLS_panelCTS);
		
		JLabel lblMaLS_panelCTS = new JLabel("Mã Loại Sách");
		lblMaLS_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMaLS_panelCTS.setBounds(254, 20, 90, 27);
		panelCTS.add(lblMaLS_panelCTS);
		
		JLabel lblTaiBan_panelCTS = new JLabel("Tái Bản");
		lblTaiBan_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTaiBan_panelCTS.setBounds(209, 113, 60, 20);
		panelCTS.add(lblTaiBan_panelCTS);
		
		JLabel lblSoLuong_panelCTS = new JLabel("Số Lượng");
		lblSoLuong_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSoLuong_panelCTS.setBounds(209, 168, 60, 20);
		panelCTS.add(lblSoLuong_panelCTS);
		
		JLabel lblNamXuatBan_panelCTS = new JLabel("Năm Xuất Bản");
		lblNamXuatBan_panelCTS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNamXuatBan_panelCTS.setBounds(209, 225, 75, 20);
		panelCTS.add(lblNamXuatBan_panelCTS);
		
		txtTaiBan_panelCTS = new JTextField();
		txtTaiBan_panelCTS.setBounds(235, 133, 96, 30);
		panelCTS.add(txtTaiBan_panelCTS);
		txtTaiBan_panelCTS.setColumns(10);
		
		txtSoLuong_panelCTS = new JTextField();
		txtSoLuong_panelCTS.setBounds(235, 185, 96, 30);
		panelCTS.add(txtSoLuong_panelCTS);
		txtSoLuong_panelCTS.setColumns(10);
		
		txtNamXuatBan_panelCTS = new JTextField();
		txtNamXuatBan_panelCTS.setBounds(235, 240, 96, 30);
		panelCTS.add(txtNamXuatBan_panelCTS);
		txtNamXuatBan_panelCTS.setColumns(10);
		
		JPanel panelNut = new JPanel();
		panelNut.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNut.setBounds(69, 36, 740, 61);
		panel_QLS.add(panelNut);
		panelNut.setLayout(null);
		
		JLabel lblSach_panelNut = new JLabel("Sách");
		lblSach_panelNut.setForeground(new Color(255, 255, 255));
		lblSach_panelNut.setBackground(new Color(27, 161, 226));
		lblSach_panelNut.setOpaque(true);
		lblSach_panelNut.setBounds(0, 0, 146, 61);
		panelNut.add(lblSach_panelNut);
		lblSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach_panelNut.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblLoaiSach_panelNut = new JLabel("Quản Lý Sách");
		lblLoaiSach_panelNut.setBounds(166, 0, 189, 61);
		panelNut.add(lblLoaiSach_panelNut);
		lblLoaiSach_panelNut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiSach_panelNut.setFont(new Font("Arial", Font.BOLD, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 117, 740, 459);
		panel_QLS.add(scrollPane);
		
		jblQuanLySach = new JTable();
		jblQuanLySach.setFont(new Font("Arial", Font.PLAIN, 16));
		jblQuanLySach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3", "S\u1ED1 L\u1EA7n T\u00E1i B\u1EA3n ", "N\u0103m Xu\u1EA5t B\u1EA3n", "S\u1ED1 L\u01B0\u1EE3ng ", "M\u00E3 Lo\u1EA1i S\u00E1ch"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jblQuanLySach);
		
		// bat dau code
		
		
		
		
		
		// ket thuc code
		
		return panel_QLS;
	}
	public JPanel panel_QuanLyUser() {
		JPanel panel_QLUS = new JPanel();
		panel_QLUS.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_QLUS.setBackground(new Color(255, 255, 255));
		panel_QLUS.setBounds(0, 148, 1286, 616);
		panel_QLUS.setLayout(null);
		
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
		
		JButton btnUserNew_panelCTUS = new JButton("User Mới");
		btnUserNew_panelCTUS.setFont(new Font("Arial", Font.BOLD, 16));
		btnUserNew_panelCTUS.setBounds(0, 280, 105, 27);
		panelCTUS.add(btnUserNew_panelCTUS);
		
		JLabel imgUser_panelCTUS = new JLabel("New label");
		imgUser_panelCTUS.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		imgUser_panelCTUS.setBounds(10, 10, 234, 93);
		panelCTUS.add(imgUser_panelCTUS);
		
		JButton btnSuaUser_panelCTUS = new JButton("Sửa User");
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
		txtEmail_panelCTUS.setBounds(25, 133, 306, 30);
		panelCTUS.add(txtEmail_panelCTUS);
		txtEmail_panelCTUS.setColumns(10);
		
		JTextField txtPassword_panelCTUS = new JTextField();
		txtPassword_panelCTUS.setBounds(25, 185, 306, 30);
		panelCTUS.add(txtPassword_panelCTUS);
		txtPassword_panelCTUS.setColumns(10);
		
		JTextField txtHoten_panelCTUS = new JTextField();
		txtHoten_panelCTUS.setBounds(25, 240, 156, 30);
		panelCTUS.add(txtHoten_panelCTUS);
		txtHoten_panelCTUS.setColumns(10);
		
		JLabel lblSDT_panelCTUS = new JLabel("Số diện thoại");
		lblSDT_panelCTUS.setHorizontalAlignment(SwingConstants.LEFT);
		lblSDT_panelCTUS.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSDT_panelCTUS.setBounds(209, 225, 75, 20);
		panelCTUS.add(lblSDT_panelCTUS);
		
		JTextField txtSDT_panelCTUS = new JTextField();
		txtSDT_panelCTUS.setBounds(235, 240, 96, 30);
		panelCTUS.add(txtSDT_panelCTUS);
		txtSDT_panelCTUS.setColumns(10);
		
		JPanel panelNutUser = new JPanel();
		panelNutUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNutUser.setBounds(69, 36, 740, 61);
		panel_QLUS.add(panelNutUser);
		panelNutUser.setLayout(null);
		
		JLabel lblUser_panelNutUser = new JLabel("User");
		lblUser_panelNutUser.setForeground(new Color(255, 255, 255));
		lblUser_panelNutUser.setBackground(new Color(27, 161, 226));
		lblUser_panelNutUser.setOpaque(true);
		lblUser_panelNutUser.setBounds(0, 0, 146, 61);
		panelNutUser.add(lblUser_panelNutUser);
		lblUser_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblDatSach_panelNutUser = new JLabel("Đặt sách");
		lblDatSach_panelNutUser.setBounds(145, 0, 130, 61);
		panelNutUser.add(lblDatSach_panelNutUser);
		lblDatSach_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatSach_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel lblYeuCau_panelNutUser = new JLabel("Yêu cầu");
		lblYeuCau_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblYeuCau_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblYeuCau_panelNutUser.setBounds(278, 0, 95, 61);
		panelNutUser.add(lblYeuCau_panelNutUser);
		
		JLabel lblDangMuon_panelNutUser = new JLabel("Đang mượn");
		lblDangMuon_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangMuon_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblDangMuon_panelNutUser.setBounds(383, 0, 146, 61);
		panelNutUser.add(lblDangMuon_panelNutUser);
		
		JLabel lblQuaHan_panelNutUser = new JLabel("Quá hạn");
		lblQuaHan_panelNutUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaHan_panelNutUser.setFont(new Font("Arial", Font.BOLD, 24));
		lblQuaHan_panelNutUser.setBounds(532, 4, 99, 57);
		panelNutUser.add(lblQuaHan_panelNutUser);
		
		JScrollPane scrollPaneUser = new JScrollPane();
		scrollPaneUser.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneUser.setBounds(69, 117, 740, 459);
		panel_QLUS.add(scrollPaneUser);
		
		JTable jblQuanLyUser = new JTable();
		jblQuanLyUser.setFont(new Font("Arial", Font.PLAIN, 16));
		jblQuanLyUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Mật khẩu", "Họ và tên", "Số điện thoại"
			}
		));
		scrollPaneUser.setViewportView(jblQuanLyUser);
		
		// bat dau code
		
		
		
		
		
		// ket thuc code
		
		return panel_QLUS;
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
