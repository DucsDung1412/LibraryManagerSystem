package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
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
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.thongTinCaNhanDAO;
import dao.userDAO;
import model.thongTinCaNhan;
import model.user;
import view.libraryManagerSystemView;

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
}
