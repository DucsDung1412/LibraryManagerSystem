package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import view.registerView;

public class controllerRegister implements ActionListener {
	private registerView v_reg;

	public controllerRegister(registerView v_reg) {
		this.v_reg = v_reg;
	}

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if (src.equals("CANCEL")) {
			this.v_reg.setVisible(false);
			return;
		} else {

			String chkName = "^[a-zA-Z]+$";
			String chkEmail = "^[A-Za-z0-9-\\+]+([A-Za-z0-9-]+)*@" + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			// Ten
			if (this.v_reg.txtName.getText().equals("")) {
				JOptionPane.showMessageDialog(v_reg, "Vui lòng nhập tên");
				return;
			}
			if (!this.v_reg.txtName.getText().matches(chkName)) {
				JOptionPane.showMessageDialog(v_reg, "Tên phải là chữ");
				return;
			}

			// Email

			if (this.v_reg.txtEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(v_reg, "Vui lòng nhập Email");
				return;
			}
			if (!this.v_reg.txtEmail.getText().matches(chkEmail)) {
				JOptionPane.showMessageDialog(v_reg, "Email không hợp lệ");
				return;
			}

			// Pass
			if (this.v_reg.txtPass.getText().equals("")) {
				JOptionPane.showMessageDialog(v_reg, "Vui lòng nhập Password");
				return;
			}

			// Confirm
			if (this.v_reg.txtConfirm.getText().equals("")) {
				JOptionPane.showMessageDialog(v_reg, "Vui lòng nhập Confirm Password");
				return;
			}
			if (!new String(this.v_reg.txtPass.getPassword()).equals(new String(this.v_reg.txtConfirm.getPassword()))) {
				JOptionPane.showMessageDialog(v_reg, "Password và Confirm Password không trùng khớp");
				return;
			}

			// chkAgree
			if (!this.v_reg.chkAgree.isSelected()) {
				JOptionPane.showMessageDialog(v_reg, "Vui lòng đọc qua đều khoản");
				return;
			}

		}

		// Ma dang ky

		long maDk = Math.round((Math.random() * 8999) + 1000);

		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");

		final String emailSever = "nguyenthikieutrang171116@gmail.com";
		final String passSever = "bbhrlzwcyylhdetc";
		String email = this.v_reg.txtEmail.getText();

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
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			mess.setSubject("Mã đăng ký");
			mess.setText("Mã đăng ký của bạn là: " + maDk);

			Transport.send(mess);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String ma = JOptionPane.showInputDialog(this.v_reg, "Vui lòng nhập mã đăng ký thông qua Email");
		
		try {

			if (Long.valueOf(ma) == maDk) {
				JOptionPane.showMessageDialog(this.v_reg, "Đăng ký thành công");
			} else {
				JOptionPane.showMessageDialog(this.v_reg, "Mã đăng ký không đúng\nĐăng ký thất bại");
			}
		} catch (NumberFormatException e1) {
			if (ma.equals("")) {
				JOptionPane.showMessageDialog(this.v_reg, "Vui lòng nhập mã đăng ký");
			} else {
				JOptionPane.showMessageDialog(this.v_reg, "Mã đăng kí gồm 4 số");
			}

		} catch (HeadlessException e1) {
			e1.printStackTrace();
		}

	}

}
