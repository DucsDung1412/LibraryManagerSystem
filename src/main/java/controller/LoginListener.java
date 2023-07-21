package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.user;
import view.LoginView;
import view.libraryManagerSystemView;
import view.registerView;

public class LoginListener {
	private LoginView loginView;
	
	public LoginListener (LoginView loginView)
	{
		this.loginView = loginView;
	}

	public void forgottenPassword()
	{
		// new quenMK();
	}

	public void logIn(user user , user u)
	{
		if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword()))
		{
			JOptionPane.showMessageDialog(loginView, "Dang nhap thanh cong");
			new libraryManagerSystemView();
		}
	}
	
	public void creatAccount()
	{
		new registerView();
	}
}
