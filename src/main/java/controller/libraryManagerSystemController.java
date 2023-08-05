package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JCalendar;

import dao.phieuMuonSachDAO;
import dao.thongTinCaNhanDAO;
import dao.userDAO;
import model.phieuMuonSach;
import model.sach;
import model.thongTinCaNhan;
import model.user;
import view.libraryManagerSystemView;
import view.loginView;

public class libraryManagerSystemController {
	private libraryManagerSystemView view;

	public libraryManagerSystemController(libraryManagerSystemView view) {
		this.view = view;
	}
	
	public void setAvataUser() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png"));
		int i = fc.showOpenDialog(this.view);
		if(i == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			this.view.imgAvata_panelMain.setImage(new javax.swing.ImageIcon(
					Paths.get(file.getAbsolutePath().toString()).toAbsolutePath().toString()));
			this.view.fileClone = file;
		}
	}
	
	public void saveUser() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định thay đổi này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			// luu hinh anh vao file
			String duoi = this.view.fileClone.getName().substring(this.view.fileClone.getName().indexOf(".")+1);
			String name = this.view.fileClone.getName().trim();
			try {
				BufferedImage bi = ImageIO.read(this.view.fileClone);
				ImageIO.write(bi, duoi, new File(Paths.get("src\\main\\java\\icon\\" + name).toAbsolutePath().toString()));
			} catch (Exception e) {
//			e.printStackTrace();
			}
			
			user userLoginClone = new user();
			userLoginClone.setUsername(this.view.txtEmail_panelTTCN.getText());
			user user = userDAO.getuserDAO().selectG(userLoginClone);
			
			user.setUsername(this.view.txtEmail_panelTTCN.getText());
			user.setPassword(this.view.txtMatKhau_panelTTCN.getText());
			if(!name.equals("")) {
				user.getTtcn().setHinh(name);
			}
			String sdt_test = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
		
			if(this.view.txtSDT_panelTTCN.getText().matches(sdt_test)) {
				this.updateTTCN_Of_user(user);
			} else {
				if(this.view.txtSDT_panelTTCN.getText().equals("")) {
					this.updateTTCN_Of_user(user);
				} else {
					JOptionPane.showMessageDialog(this.view, "Số điện thoại không đúng định dạng");
				}
			}
		}
	}
	
	public void updateTTCN_Of_user(user user) {
		user.getTtcn().setSoDienThoai(this.view.txtSDT_panelTTCN.getText());
		user.getTtcn().setDiaChi(this.view.txtDiaChi_panelTTCN.getText());
		user.getTtcn().setTen(this.view.txtHoTen_panelTTCN.getText());
		if(!user.getPassword().equals(userDAO.getuserDAO().selectG(user).getPassword())) {
			long maDk = Math.round((Math.random() * 8999) + 1000);

			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", "587");
			p.put("mail.smtp.ssl.protocols", "TLSv1.2");

			final String emailSever = "nguyenthikieutrang171116@gmail.com";
			final String passSever = "bbhrlzwcyylhdetc";

			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailSever, passSever);
				}
			};

			Session session = Session.getInstance(p, auth);
			Message mess = new MimeMessage(session);

			try {
				mess.setFrom(new InternetAddress(emailSever));
				mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.view.txtEmail_panelTTCN.getText()));
				mess.setSubject("Mã bảo vệ");
				mess.setText("Mã bảo vệ của bạn là: " + maDk);

				Transport.send(mess);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String ma = JOptionPane.showInputDialog(this.view, "Vui lòng nhập mã bảo vệ thông qua Email");

			try {
				if (Long.valueOf(ma) == maDk) {
					userDAO.getuserDAO().updateX(user);
					List<thongTinCaNhan> listTTCN = thongTinCaNhanDAO.getthongTinCaNhanDAO().selectAll();
					for (thongTinCaNhan thongTinCaNhan : listTTCN) {
						if(thongTinCaNhan.getEmail().getUsername().equals(user.getUsername())) {
							thongTinCaNhan.setDiaChi(user.getTtcn().getDiaChi());
							thongTinCaNhan.setHinh(user.getTtcn().getHinh());
							thongTinCaNhan.setSoDienThoai(user.getTtcn().getSoDienThoai());
							thongTinCaNhan.setTen(user.getTtcn().getTen());
							thongTinCaNhanDAO.getthongTinCaNhanDAO().updateX(thongTinCaNhan);
							break;
						}
					}
					JOptionPane.showMessageDialog(this.view, "Lưu thành công");
				} else {
					JOptionPane.showMessageDialog(this.view, "Mã bảo vệ không đúng\nĐổi mật khẩu thất bại");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			userDAO.getuserDAO().updateX(user);
			List<thongTinCaNhan> listTTCN = thongTinCaNhanDAO.getthongTinCaNhanDAO().selectAll();
			for (thongTinCaNhan thongTinCaNhan : listTTCN) {
				if(thongTinCaNhan.getEmail().getUsername().equals(user.getUsername())) {
					thongTinCaNhan.setDiaChi(user.getTtcn().getDiaChi());
					thongTinCaNhan.setHinh(user.getTtcn().getHinh());
					thongTinCaNhan.setSoDienThoai(user.getTtcn().getSoDienThoai());
					thongTinCaNhan.setTen(user.getTtcn().getTen());
					thongTinCaNhanDAO.getthongTinCaNhanDAO().updateX(thongTinCaNhan);
					break;
				}
			}
			JOptionPane.showMessageDialog(this.view, "Lưu thành công");
		}
	}

	public void choseTTCN() {
		this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgHome_panelTop.setOpaque(false);
		
		this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgMyBook_panelTop.setOpaque(false);
		
		this.view.imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgBookManager_panelTop.setOpaque(false);
		
		this.view.imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgUserManager_panelTop.setOpaque(false);
		
		this.view.imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgThongKe_panelTop.setOpaque(false);
		
		this.view.contentPane.removeAll();
		this.view.contentPane.add(this.view.panel_top);
		this.view.contentPane.add(this.view.panel_TTCN());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}

	public void choseQLUser() {
		this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgHome_panelTop.setOpaque(false);
		
		this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgMyBook_panelTop.setOpaque(false);
		
		this.view.imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgBookManager_panelTop.setOpaque(false);
		
		this.view.imgUserManager_panelTop.setBackground(new Color(255, 255, 255));
		this.view.imgUserManager_panelTop.setOpaque(true);
		
		this.view.imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgThongKe_panelTop.setOpaque(false);
		
		this.view.contentPane.removeAll();
		this.view.contentPane.add(this.view.panel_top);
		this.view.contentPane.add(this.view.panel_QuanLyUser());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}
	
	public void choseQLSach() {
		this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgHome_panelTop.setOpaque(false);
		
		this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgMyBook_panelTop.setOpaque(false);
		
		this.view.imgBookManager_panelTop.setBackground(new Color(255, 255, 255));
		this.view.imgBookManager_panelTop.setOpaque(true);
		
		this.view.imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgUserManager_panelTop.setOpaque(false);
		
		this.view.imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgThongKe_panelTop.setOpaque(false);
		
		this.view.contentPane.removeAll();
		this.view.contentPane.add(this.view.panel_top);
		this.view.contentPane.add(this.view.panel_QuanLySach());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}
	
	public void choseThongKe() {
		this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgHome_panelTop.setOpaque(false);
		
		this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgMyBook_panelTop.setOpaque(false);
		
		this.view.imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgBookManager_panelTop.setOpaque(false);
		
		this.view.imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgUserManager_panelTop.setOpaque(false);
		
		this.view.imgThongKe_panelTop.setBackground(new Color(255, 255, 255));
		this.view.imgThongKe_panelTop.setOpaque(true);
		
		this.view.contentPane.removeAll();
		this.view.contentPane.add(this.view.panel_top);
		this.view.contentPane.add(this.view.panel_ThongKe());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}

	public void logOut() {
		loginView viewLogin = new loginView();
		this.view.setVisible(false);
		viewLogin.setVisible(true);
	}

	public void datSach() {
		JPanel panelCalendar = new JPanel();
		panelCalendar.setLayout(null);
		panelCalendar.setPreferredSize(new Dimension(400,180));
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 0, 400, 180);
		calendar.getDayChooser().setDayBordersVisible(false);
		calendar.setWeekOfYearVisible(false);
		panelCalendar.add(calendar);
		
		int i = JOptionPane.showConfirmDialog(this.view, panelCalendar, "Chọn lịch", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			int day = calendar.getDayChooser().getDay();
			int month = calendar.getMonthChooser().getMonth();
			int year = calendar.getYearChooser().getYear();
			
			Date date = new Date(year - 1900, month, day);
			Date date1 = new Date(year, month, day, month, i, year);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateClone = sdf.format(date);
			
			user u = new user();
			u.setUsername("daoducdung2000@gmail.com");
			
			sach s = new sach();
			s.setMaSach("MS01");
			
			phieuMuonSach pms = new phieuMuonSach("PM09", date, date, u, s, dateClone);
//			phieuMuonSachDAO.getphieuMuonSachDAO().insertX(pms);
		}
	}

	public void chooseQLDatsach() {
		int row_s = view.tblQuanLyDatSach.getSelectedRow();
		view.txtEmail_panelCTUS_dkDS.setText((String) view.tblQuanLyDatSach.getValueAt(row_s, 0));
		view.txtMaSach_panelCTUS_dkDS.setText((String) view.tblQuanLyDatSach.getValueAt(row_s, 1));
		view.txtNgayMuon_panelCTUS_dkDS.setText((view.tblQuanLyDatSach.getValueAt(row_s, 2)+"").substring(0, 10));
		view.txtTrangThai_panelCTUS_dkDS.setText( view.tblQuanLyDatSach.getValueAt(row_s, 3)+"");
	}
	
	public void chooseQLYeuCau() {
		int row_s = view.tblQuanLyYeuCau.getSelectedRow();
		view.txtEmail_panelCTUS_dkYC.setText(view.tblQuanLyYeuCau.getValueAt(row_s, 0)+"");
		view.txtLoaiSach_panelCTUS_dkYC.setText(view.tblQuanLyYeuCau.getValueAt(row_s, 1)+"");
		view.txtTenSach_panelCTUS_dkYC.setText(view.tblQuanLyYeuCau.getValueAt(row_s, 2)+"");
		view.txtMoTa_panelCTUS_dkYC.setText(view.tblQuanLyYeuCau.getValueAt(row_s, 3)+"");
		
	}
	
	public void chooseQlDangMuon() {
		int row_s = view.tblQuanLyDangMuon.getSelectedRow();
		view.txtEmail_panelCTUS_dkDM.setText(view.tblQuanLyDangMuon.getValueAt(row_s, 0)+"");
		view.txtMaSach_panelCTUS_dkDM.setText(view.tblQuanLyDangMuon.getValueAt(row_s, 1)+"");
		view.txtNgayMuon_panelCTUS_dkDM.setText((view.tblQuanLyDangMuon.getValueAt(row_s, 2)+"").substring(0, 10));
		view.txtNgayTra_panelCTUS_dkDM.setText((view.tblQuanLyDangMuon.getValueAt(row_s, 3)+"").substring(0, 10));

	}
	
	public void chooseQLQuaHan() {
		int row_s = view.tblQuanLyQuaHan.getSelectedRow();
		view.txtEmail_panelCTUS_dkQH.setText(view.tblQuanLyQuaHan.getValueAt(row_s, 0)+"");
		view.txtMaSach_panelCTUS_dkQH.setText(view.tblQuanLyQuaHan.getValueAt(row_s, 1)+"");
		view.txtNgayMuon_panelCTUS_dkQH.setText((view.tblQuanLyQuaHan.getValueAt(row_s, 2)+"").substring(0, 10));
		view.txtNgayTra_panelCTUS_dkQH.setText((view.tblQuanLyQuaHan.getValueAt(row_s, 3)+"").substring(0, 10));
		
	}
	
	public void btnNewuser() {
		view.txtEmail_panelCTUS.setText("");
		view.txtPassword_panelCTUS.setText("");
		view.txtHoten_panelCTUS.setText("");
		view.txtSDT_panelCTUS.setText("");
		this.view.imgUser_panelCTUS.setIcon(null);
		this.view.imgUser_panelCTUS.setText("Nhấn để tải hình ảnh");
	}
	
	public void btnNewYeuCau() {
		view.txtEmail_panelCTUS_dkYC.setText("");
		view.txtLoaiSach_panelCTUS_dkYC.setText("");
		view.txtTenSach_panelCTUS_dkYC.setText("");
		view.txtMoTa_panelCTUS_dkYC.setText("");
	}
	
	public void btnNewDangMuon() {
		view.txtEmail_panelCTUS_dkDM.setText("");
		view.txtMaSach_panelCTUS_dkDM.setText("");
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String ngayMuon = sdf.format(d);
		view.txtNgayMuon_panelCTUS_dkDM.setText(ngayMuon);
		d.setMonth(d.getMonth() + 1);
		String ngayTra = sdf.format(d);
		view.txtNgayTra_panelCTUS_dkDM.setText(ngayTra);
	}
	
	public void btnNewQuaHan() {
		view.txtEmail_panelCTUS_dkQH.setText("");
		view.txtMaSach_panelCTUS_dkQH.setText("");
		view.txtNgayMuon_panelCTUS_dkQH.setText("");
		view.txtNgayTra_panelCTUS_dkQH.setText("");
	}

	public void deleteUser() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn muốn xóa người dùng này", "ConfirmDialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(i == JOptionPane.YES_OPTION) {
			if(this.view.txtEmail_panelCTUS.getText().equals("")) {
				JOptionPane.showMessageDialog(this.view, "Vui lòng chọn dòng cần xóa");
			} else {
				String email = view.txtEmail_panelCTUS.getText();
				String password = view.txtPassword_panelCTUS.getText();
				String hoten = view.txtHoten_panelCTUS.getText();
				String sdt = view.txtSDT_panelCTUS.getText();
				user us = new user();
				us.setUsername(email);
				us.setPassword(password);
				us.setRole("Đọc giả");
				
				int selectRow = this.view.tblQuanLyUser.getSelectedRow();
				userDAO.getuserDAO().deletaX(us);
				JOptionPane.showMessageDialog(this.view, "Xóa thành công");
				
				if(this.view.tblQuanLyUser.getRowCount() == 0) {
					
				} else {
					if(this.view.tblQuanLyUser.getRowCount() - 1 == this.view.tblQuanLyUser.getSelectedRow()) {
						this.loadUser();
						if(this.view.tblQuanLySach.getRowCount() != 0) {
							this.view.tblQuanLyUser.setRowSelectionInterval(this.view.tblQuanLyUser.getRowCount() - 1, this.view.tblQuanLyUser.getRowCount() - 1);
						}
					} else {
						if(this.view.tblQuanLyUser.getSelectedRow() == 0) {
							this.loadUser();
							this.view.tblQuanLyUser.setRowSelectionInterval(0, 0);
						} else {
							this.loadUser();
							this.view.tblQuanLyUser.setRowSelectionInterval(selectRow, selectRow);
						}
					}
					if(this.view.tblQuanLyUser.getRowCount() != 0) {
						this.choseQLUser();
					}
				}
			}
		}
	}
	
	public void changeAvatar_panelCTUS() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png"));
		int i = fc.showOpenDialog(this.view);
		if(i == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ImageIcon imgI_AvatarUs = new ImageIcon(Paths.get(file.getAbsolutePath().toString()).toAbsolutePath().toString());
			Image img_AvatarUs = imgI_AvatarUs.getImage();
			Image image_AvatarUs = img_AvatarUs.getScaledInstance(this.view.imgUser_panelCTUS.getWidth(), this.view.imgUser_panelCTUS.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon_AvatarUs = new ImageIcon(image_AvatarUs);
			this.view.imgUser_panelCTUS.setText("");
			this.view.imgUser_panelCTUS.setIcon(imageIcon_AvatarUs);
			this.view.fileClone = file;
		}
	}
	
	public void addOrUpdateUser() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			// luu hinh anh vao file
			String duoi = this.view.fileClone.getName().substring(this.view.fileClone.getName().indexOf(".")+1);
			String name = this.view.fileClone.getName().trim();
			try {
				BufferedImage bi = ImageIO.read(this.view.fileClone);
				ImageIO.write(bi, duoi, new File(Paths.get("src\\main\\java\\icon\\" + name).toAbsolutePath().toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String userName = this.view.txtEmail_panelCTUS.getText();
			String passWord = this.view.txtPassword_panelCTUS.getText();
			
			thongTinCaNhan ttcn = new thongTinCaNhan();
			ttcn.setHinh(name);
			ttcn.setSoDienThoai(this.view.txtSDT_panelCTUS.getText());
			ttcn.setTen(this.view.txtHoten_panelCTUS.getText());
			
			try {
				user u = new user(userName, passWord, "Đọc giả", "Tồn tại");
				if(this.view.txtEmail_panelCTUS.getText().equals("") || this.view.txtPassword_panelCTUS.getText().equals("") 
						|| this.view.txtSDT_panelCTUS.getText().equals("") || this.view.txtHoten_panelCTUS.getText().equals("") 
						|| this.view.imgUser_panelCTUS.getText().equals("Nhấn để tải hình ảnh")) 
				{				
					JOptionPane.showMessageDialog(this.view, "Vùi lòng nhập đầy đủ thông tin");
				} else {
					user uclone = userDAO.getuserDAO().selectG(u);
					Boolean b = uclone == null;
					if(b) {
						userDAO.getuserDAO().insertX(u);
						ttcn.setDiaChi("...");
						ttcn.setEmail(u);
						ttcn.setTrangThai("Tồn tại");
						thongTinCaNhanDAO.getthongTinCaNhanDAO().insertX(ttcn);
						JOptionPane.showMessageDialog(this.view, "Thêm mới thành công");
						this.loadUser();
						for (int j = 0; j < this.view.tblQuanLyUser.getRowCount(); j++) {
							if(this.view.tblQuanLyUser.getValueAt(j, 0).equals(u.getUsername())) {
								this.view.tblQuanLyUser.setRowSelectionInterval(j,j);
							}
						}
					} else {
						userDAO.getuserDAO().updateX(u);
						
						ttcn.setMaTTCN(uclone.getTtcn().getMaTTCN());
						ttcn.setDiaChi(uclone.getTtcn().getDiaChi());
						ttcn.setEmail(uclone);
						ttcn.setTrangThai(uclone.getTrangThai());
						
						thongTinCaNhanDAO.getthongTinCaNhanDAO().updateX(ttcn);
						
						JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
						this.loadUser();
						for (int j = 0; j < this.view.tblQuanLyUser.getRowCount(); j++) {
							if(this.view.tblQuanLyUser.getValueAt(j, 0).equals(uclone.getUsername())) {
								this.view.tblQuanLyUser.setRowSelectionInterval(j,j);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void loadUser(){
		DefaultTableModel tableModel_User = (DefaultTableModel)this.view.tblQuanLyUser.getModel();
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
	}
	
	public void chuyenTrangThaiPhieuThanhDangMuon() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			String userName = this.view.txtEmail_panelCTUS_dkDS.getText();
			user u = new user(); u.setUsername(userName);
			user uDAO = userDAO.getuserDAO().selectG(u);
			
			String maSach = this.view.txtMaSach_panelCTUS_dkDS.getText();
			sach s = new sach(); s.setMaSach(maSach);
			sach sDAO = sachDAO.getsachDAO().selectG(s);
			
			try {
				phieuMuonSach pms = phieuMuonSachDAO.getphieuMuonSachDAO().selectDangDat(sDAO, uDAO);
				pms.setNgayTra(new Date(pms.getNgayMuon().getYear(), pms.getNgayMuon().getMonth() + 1, pms.getNgayMuon().getDay() - 1));
				pms.setTrangThaiPhieu("Đang mượn");
				phieuMuonSachDAO.getphieuMuonSachDAO().updateX(pms);
				JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
				loadTableDatSach();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void loadTableDatSach() {
		DefaultTableModel tableModel_DatSach = (DefaultTableModel)this.view.tblQuanLyDatSach.getModel();
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
	}

	public void deleteDatSach() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			String userName = this.view.txtEmail_panelCTUS_dkDS.getText();
			user u = new user(); u.setUsername(userName);
			user uDAO = userDAO.getuserDAO().selectG(u);
			
			String maSach = this.view.txtMaSach_panelCTUS_dkDS.getText();
			sach s = new sach(); s.setMaSach(maSach);
			sach sDAO = sachDAO.getsachDAO().selectG(s);
			
			try {
				phieuMuonSach pms = phieuMuonSachDAO.getphieuMuonSachDAO().selectDangDat(sDAO, uDAO);
				pms.setNgayTra(new Date(pms.getNgayMuon().getYear(), pms.getNgayMuon().getMonth(), pms.getNgayMuon().getDay() - 1));
				pms.setTrangThaiPhieu("Đang đặt");
				phieuMuonSachDAO.getphieuMuonSachDAO().deletaX(pms);
				JOptionPane.showMessageDialog(this.view, "Xóa thành công");
				loadTableDatSach();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public void chuyenTrangThaiPhieuThanhDaTra_DangMuon() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			String userName = this.view.txtEmail_panelCTUS_dkDM.getText();
			user u = new user(); u.setUsername(userName);
			user uDAO = userDAO.getuserDAO().selectG(u);
			
			String maSach = this.view.txtMaSach_panelCTUS_dkDM.getText();
			sach s = new sach(); s.setMaSach(maSach);
			sach sDAO = sachDAO.getsachDAO().selectG(s);
			
			try {
				phieuMuonSach pms = phieuMuonSachDAO.getphieuMuonSachDAO().selectDangMuon(sDAO, uDAO);
				pms.setNgayTra(Calendar.getInstance().getTime());
				pms.setTrangThaiPhieu("Đã trả");
				phieuMuonSachDAO.getphieuMuonSachDAO().updateX(pms);
				JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
				loadTableDangMuon();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void loadTableDangMuon() {
		DefaultTableModel tableModel_DangMuon = (DefaultTableModel)this.view.tblQuanLyDangMuon.getModel();
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
	}

	public void chuyenTrangThaiPhieuThanhDaTra_QuaHan() {
		int i = JOptionPane.showConfirmDialog(this.view, "Bạn có chắc chắn với quyết định này?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			String userName = this.view.txtEmail_panelCTUS_dkQH.getText();
			user u = new user(); u.setUsername(userName);
			user uDAO = userDAO.getuserDAO().selectG(u);
			
			String maSach = this.view.txtMaSach_panelCTUS_dkQH.getText();
			sach s = new sach(); s.setMaSach(maSach);
			sach sDAO = sachDAO.getsachDAO().selectG(s);
			
			try {
				phieuMuonSach pms = phieuMuonSachDAO.getphieuMuonSachDAO().selectQuaHan(sDAO, uDAO);
				pms.setNgayTra(Calendar.getInstance().getTime());
				pms.setTrangThaiPhieu("Đã trả");
				phieuMuonSachDAO.getphieuMuonSachDAO().updateX(pms);
				JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
				loadTableQuaHan();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void loadTableQuaHan() {
		DefaultTableModel tableModel_QuaHan = (DefaultTableModel)this.view.tblQuanLyQuaHan.getModel();
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
	}
	
	public void saveDangMuon(){
		String email = this.view.txtEmail_panelCTUS_dkDM.getText();
		user u = new user();
		u.setUsername(email);
		user uDAO = userDAO.getuserDAO().selectG(u);
		if(uDAO == null) {
			JOptionPane.showMessageDialog(this.view, "Email không tồn tại");
		} else {
			String maSach = this.view.txtMaSach_panelCTUS_dkDM.getText();
			sach s = new sach();
			s.setMaSach(maSach);
			sach sDAO = sachDAO.getsachDAO().selectG(s);
			if(sDAO == null) {
				JOptionPane.showMessageDialog(this.view, "Mã sách không đúng");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				try {
					Date ngayMuon = sdf.parse(this.view.txtNgayMuon_panelCTUS_dkDM.getText());
					Date ngayTra = sdf.parse(this.view.txtNgayTra_panelCTUS_dkDM.getText());
					
					phieuMuonSach pms = new phieuMuonSach(null, ngayMuon, ngayTra, uDAO, s, "Đang mượn", "Tồn tại");
					phieuMuonSachDAO.getphieuMuonSachDAO().insertX(pms);
					JOptionPane.showMessageDialog(this.view, "Thêm mới thành công");
					this.loadTableDangMuon();
					this.view.tblQuanLyDangMuon.setRowSelectionInterval(this.view.tblQuanLyDangMuon.getRowCount() - 1, this.view.tblQuanLyDangMuon.getRowCount() - 1);
					this.chooseQlDangMuon();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

	public void timUserTheoCBX() {
		String email = this.view.txtTimKiem_panelDieuKhienUser.getText();
		user u = new user(); u.setUsername(email);
		
		String cbx = this.view.cbxLoc_panelDieuKhienUser.getSelectedItem() + "";
		String vietTac = cbx.equals("Email") ? "email" : (cbx.equals("Họ và tên") ? "ten" : "soDienThoai");
		List<thongTinCaNhan> list = null;
		
		if(vietTac.equals("email")) {
			list = thongTinCaNhanDAO.getthongTinCaNhanDAO().selectTheoObj(u);
			System.out.println(list.size());
		} else {
			list = thongTinCaNhanDAO.getthongTinCaNhanDAO().selectTheoString(vietTac, this.view.txtTimKiem_panelDieuKhienUser.getText());
		}
		
		DefaultTableModel tableModel_User = (DefaultTableModel)this.view.tblQuanLyUser.getModel();
		tableModel_User.setRowCount(0);
		for (thongTinCaNhan ttcn : list) {
			tableModel_User.addRow(new Object[] {
					ttcn.getEmail().getUsername(),
					ttcn.getEmail().getPassword(),
					ttcn.getTen(),
					ttcn.getSoDienThoai()
			});
		}
	}
	
	public void timPMSTheoCBX_panelDangDat() {
		String email = this.view.txtTimKiem_panelDieuKhienUser_dkDS.getText();
		user u = new user(); u.setUsername(email);
		
		String cbx = this.view.cbxLoc_panelDieuKhienUser_dkDS.getSelectedItem() + "";
		String vietTac = cbx.equals("Email") ? "email.username" : "maSach.maSach";
		List<phieuMuonSach> list = null;
		
		if(vietTac.equals("email.username")) {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoObj(u, "Đang đặt");
		} else {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoString(vietTac, this.view.txtTimKiem_panelDieuKhienUser_dkDS.getText(), "Đang đặt");
		}
		
		DefaultTableModel tableModel_DatSach = (DefaultTableModel)this.view.tblQuanLyDatSach.getModel();
		tableModel_DatSach.setRowCount(0);
		for (phieuMuonSach phieuMuonSach : list) {
			tableModel_DatSach.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().subSequence(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
			});
		}
	}
	
	public void timPMSTheoCBX_panelDangMuon() {
		String email = this.view.txtTimKiem_panelDieuKhienUser_dkDM.getText();
		user u = new user(); u.setUsername(email);
		
		String cbx = this.view.cbxLoc_panelDieuKhienUser_dkDM.getSelectedItem() + "";
		String vietTac = cbx.equals("Email") ? "email.username" : "maSach.maSach";
		List<phieuMuonSach> list = null;
		
		if(vietTac.equals("email.username")) {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoObj(u, "Đang mượn");
		} else {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoString(vietTac, this.view.txtTimKiem_panelDieuKhienUser_dkDM.getText(), "Đang mượn");
		}
		
		DefaultTableModel tableModel_DangMuon = (DefaultTableModel)this.view.tblQuanLyDangMuon.getModel();
		tableModel_DangMuon.setRowCount(0);
		for (phieuMuonSach phieuMuonSach : list) {
			tableModel_DangMuon.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().substring(0, 10),
					phieuMuonSach.getNgayTra().toString().substring(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
			});
		}
	}

	public void timPMSTheoCBX_panelQuaHan() {
		String email = this.view.txtTimKiem_panelDieuKhienUser_dkQH.getText();
		user u = new user(); u.setUsername(email);
		
		String cbx = this.view.cbxLoc_panelDieuKhienUser_dkQH.getSelectedItem() + "";
		String vietTac = cbx.equals("Email") ? "email.username" : "maSach.maSach";
		List<phieuMuonSach> list = null;
		
		if(vietTac.equals("email.username")) {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoObj(u, "Đã quá hạn");
		} else {
			list = phieuMuonSachDAO.getphieuMuonSachDAO().selectTheoString(vietTac, this.view.txtTimKiem_panelDieuKhienUser_dkQH.getText(), "Đã quá hạn");
		}
		
		DefaultTableModel tableModel_QuaHan = (DefaultTableModel)this.view.tblQuanLyQuaHan.getModel();
		tableModel_QuaHan.setRowCount(0);
		for (phieuMuonSach phieuMuonSach : list) {
			tableModel_QuaHan.addRow(new Object[] {
					phieuMuonSach.getEmail().getUsername(),
					phieuMuonSach.getMaSach().getMaSach(),
					phieuMuonSach.getNgayMuon().toString().substring(0, 10),
					phieuMuonSach.getNgayTra().toString().substring(0, 10),
					phieuMuonSach.getTrangThaiPhieu()
			});
		}
	}

	public void timYCTheoCBX_panelYC() {
		String email = this.view.txtTimKiem_panelDieuKhienUser_dkYC.getText();
		user u = new user(); u.setUsername(email);
		
		String cbx = this.view.cbxLoc_panelDieuKhienUser_dkYC.getSelectedItem() + "";
		String vietTac = cbx.equals("Email") ? "email.username" : "";
		List<yeuCau> list = null;
		
		if(vietTac.equals("email.username")) {
			list = yeuCauDAO.getyeuCauDAO().selectTheoObj(u);
		} else {
			
		}
		
		DefaultTableModel tableModel_YeuCau = (DefaultTableModel)this.view.tblQuanLyYeuCau.getModel();
		tableModel_YeuCau.setRowCount(0);
		for (yeuCau yeuCau : list) {
			tableModel_YeuCau.addRow(new Object[] {
					yeuCau.getEmail().getUsername(),
					yeuCau.getLoaiSach(),
					yeuCau.getSach(),
					yeuCau.getMoTa()				
			});
		}
	}

	public void addOrUpdateYeuCau() {
		
	}

	public void changeToChiTietUser() {
		if(this.view.txtEmail_panelCTUS.getText().equals("")) {
			JOptionPane.showMessageDialog(this.view, "Vui lòng chọn user");
		} else {
			this.view.emailClone = this.view.txtEmail_panelCTUS.getText();
			this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
			this.view.imgHome_panelTop.setOpaque(false);
			
			this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
			this.view.imgMyBook_panelTop.setOpaque(false);
			
			this.view.imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
			this.view.imgBookManager_panelTop.setOpaque(false);
			
			this.view.imgUserManager_panelTop.setBackground(new Color(255, 255, 255));
			this.view.imgUserManager_panelTop.setOpaque(true);
			
			this.view.imgThongKe_panelTop.setBackground(new Color(244, 244, 244));
			this.view.imgThongKe_panelTop.setOpaque(false);
			
			this.view.contentPane.removeAll();
			this.view.contentPane.add(this.view.panel_top);
			this.view.contentPane.add(this.view.panel_TTCTUser());
			this.view.contentPane.repaint();
			this.view.contentPane.revalidate();
		}
	}

	public void updatePassWord_panelTTCTUser() {
		String email = this.view.lblEmailUser_panelTop.getText();
		String passowrd = this.view.txtMatKhauUser_panelTop.getText();
		String role = "Đọc giả";
		user u = new user(email, passowrd, role, "Tồn tại");
		userDAO.getuserDAO().updateX(u);
		JOptionPane.showMessageDialog(this.view, "Cập nhật thành công");
	}

	public void xuatFileUser() {
		String[] listBTN = {"EXCEL", "PDF"};
		int option = JOptionPane.showOptionDialog(this.view, "Bạn muốn xuất ra gì?", "Lựa Chọn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listBTN, listBTN[0]);
		if (option == 0) {
			exportToExcel(this.view.tblQuanLyUser, "Quản lý User");
		} else if(option == 1) {
			exportToPDF(this.view.tblQuanLyUser, "Quản lý User");
		}
		JOptionPane.showMessageDialog(this.view, "Xuất File thành công");
	}

	public void xuatFileDatSach() {
		String[] listBTN = {"EXCEL", "PDF"};
		int option = JOptionPane.showOptionDialog(this.view, "Bạn muốn xuất ra gì?", "Lựa Chọn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listBTN, listBTN[0]);
		if (option == 0) {
			exportToExcel(this.view.tblQuanLyDatSach, "Quản lý đặt sách");
		} else if(option == 1) {
			exportToPDF(this.view.tblQuanLyDatSach, "Quản lý đặt sách");
		}
		JOptionPane.showMessageDialog(this.view, "Xuất File thành công");
	}

	public void xuatFileYeuCau() {
		String[] listBTN = {"EXCEL", "PDF"};
		int option = JOptionPane.showOptionDialog(this.view, "Bạn muốn xuất ra gì?", "Lựa Chọn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listBTN, listBTN[0]);
		if (option == 0) {
			exportToExcel(this.view.tblQuanLyYeuCau, "Quản lý yêu cầu");
		} else if(option == 1) {
			exportToPDF(this.view.tblQuanLyYeuCau, "Quản lý yêu cầu");
		}
		JOptionPane.showMessageDialog(this.view, "Xuất File thành công");
	}

	public void xuatFileDangMuon() {
		String[] listBTN = {"EXCEL", "PDF"};
		int option = JOptionPane.showOptionDialog(this.view, "Bạn muốn xuất ra gì?", "Lựa Chọn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listBTN, listBTN[0]);
		if (option == 0) {
			exportToExcel(this.view.tblQuanLyDangMuon, "Quản lý sách đang mượn");
		} else if(option == 1) {
			exportToPDF(this.view.tblQuanLyDangMuon, "Quản lý sách đang mượn");
		}
		JOptionPane.showMessageDialog(this.view, "Xuất File thành công");
	}

	public void xuatFileQuaHan() {
		String[] listBTN = {"EXCEL", "PDF"};
		int option = JOptionPane.showOptionDialog(this.view, "Bạn muốn xuất ra gì?", "Lựa Chọn", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listBTN, listBTN[0]);
		if (option == 0) {
			exportToExcel(this.view.tblQuanLyQuaHan, "Quản lý sách đã quá hạn");
		} else if(option == 1) {
			exportToPDF(this.view.tblQuanLyQuaHan, "Quản lý sách đã quá hạn");
		}
		JOptionPane.showMessageDialog(this.view, "Xuất File thành công");
	}
}
