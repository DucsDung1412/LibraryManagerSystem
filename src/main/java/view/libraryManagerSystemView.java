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
		setBounds(100, 100, 1240, 740);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_left = new JPanel();
		panel_left.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_left.setBounds(-1, 0, 194, 740);
		contentPane.add(panel_left);
		panel_left.setLayout(null);
		
		JLabel lblIMG_panelLeft = new JLabel("");
		lblIMG_panelLeft.setBorder(new EmptyBorder(0,0,0,0));
		lblIMG_panelLeft.setVerticalAlignment(SwingConstants.CENTER);
		lblIMG_panelLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG_panelLeft.setBounds(0, 0, panel_left.getWidth()+2, panel_left.getHeight());
//		ImageIcon img_leftIcon = new ImageIcon(Paths.get("src/main/java/icon/main_BG.png").toAbsolutePath().toString());
		ImageIcon img_leftIcon = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\librarySys\\src\\main\\java\\icon\\main_BG.png");
		Image im_leftIcon = img_leftIcon.getImage();
		Image image_leftIcon = im_leftIcon.getScaledInstance(lblIMG_panelLeft.getWidth(), lblIMG_panelLeft.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(image_leftIcon);
		lblIMG_panelLeft.setIcon(imageIcon1);
		panel_left.add(lblIMG_panelLeft);
		
		JPanel panel_top = new JPanel();
		panel_top.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_top.setBackground(new Color(255, 255, 255));
		panel_top.setBounds(196, 0, 1028, 174);
		contentPane.add(panel_top);
		panel_top.setLayout(null);
		
		JLabel imgNoti_panelTop = new JLabel("");
		imgNoti_panelTop.setBounds(683, 30, 58, 45);;
		panel_top.add(imgNoti_panelTop);
		
		JLabel imgSys_panelTop = new JLabel("");
		imgSys_panelTop.setBounds(814, 30, 58, 45);
		panel_top.add(imgSys_panelTop);
		
		JLabel imgInfo_panelTop = new JLabel("");
		imgInfo_panelTop.setBounds(937, 30, 58, 45);
		panel_top.add(imgInfo_panelTop);
		
		JTextPane txtTitle_panelTop = new JTextPane();
		txtTitle_panelTop.setFont(new Font("Arial", Font.BOLD, 32));
		txtTitle_panelTop.setEditable(false);
		txtTitle_panelTop.setText("Hello Sarah\r\nWelcome Library!");
		txtTitle_panelTop.setBounds(10, 44, 295, 78);
		panel_top.add(txtTitle_panelTop);
		
		JSeparator separator_panelTop = new JSeparator();
		separator_panelTop.setForeground(new Color(0, 0, 0));
		separator_panelTop.setBounds(331, 158, 664, 1);
		panel_top.add(separator_panelTop);
		
		JTextPane txtDescribe_panelTop = new JTextPane();
		txtDescribe_panelTop.setEditable(false);
		txtDescribe_panelTop.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDescribe_panelTop.setText("Lorem ipsum dolor sit amet. consectetuer adipiscing elit: sed\r\ndiams nonummy nibh euismod tincidunt");
		txtDescribe_panelTop.setBounds(10, 126, 452, 45);
		panel_top.add(txtDescribe_panelTop);
		
		
		// ao ma atenta
		// zo
		contentPane.add(this.jScrollPane());
	}
	
	public JScrollPane jScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.setBounds(196, 174, 1028, 566);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		// bat dau
		
		
		
		
		// ket thuc
		
		return scrollPane;
	}
}
