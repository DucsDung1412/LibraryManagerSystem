# LibraryManagerSystem
	public JPanel panel_Home() {
//		panel home
		JPanel panel_home = new JPanel();
		panel_home.setBackground(new Color(255, 255, 255));
		panel_home.setBounds(-1, 147, 1286, 616);
		panel_home.setLayout(null);
		contentPane.add(panel_home);

//		panel top home
		JPanel panel_topHome = new JPanel();
		panel_topHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_topHome.setBackground(new Color(240, 240, 240));
		panel_topHome.setBounds(75, 15, 1136, 60);
		panel_home.add(panel_topHome);
		panel_topHome.setLayout(null);

//		panel sap xep
		JPanel panel_sapXep = new JPanel();
		panel_sapXep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_sapXep.setVisible(false);
			}
		});
		panel_sapXep.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sapXep.setBounds(160, 100, 159, 90);
		panel_home.add(panel_sapXep);
		panel_sapXep.setLayout(null);
		panel_sapXep.setVisible(false);
		panel_sapXep.setBackground(Color.white);

		JLabel lbltang_panelsapXep = new JLabel("Tên sách A-Z");
		lbltang_panelsapXep.setFont(new Font("Arial", Font.PLAIN, 18));
		lbltang_panelsapXep.setBounds(20, 10, 110, 30);
		panel_sapXep.add(lbltang_panelsapXep);

		JLabel lblgiam_panelsapXep = new JLabel("Tên sách Z-A");
		lblgiam_panelsapXep.setBackground(Color.WHITE);
		lblgiam_panelsapXep.setFont(new Font("Arial", Font.PLAIN, 18));
		lblgiam_panelsapXep.setBounds(20, 50, 110, 32);
		panel_sapXep.add(lblgiam_panelsapXep);

//		JScrollPane the loai
		JScrollPane scrollPane_theLoai = new JScrollPane();
		scrollPane_theLoai.setBounds(75, 100, 270, 150);
		scrollPane_theLoai.setBackground(Color.white);
		scrollPane_theLoai.setVisible(false);

//		panel the loai
		JPanel panel_theLoai = new JPanel();
		panel_theLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_theLoai.setVisible(false);
			}
		});
		panel_theLoai.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_theLoai.setBackground(new Color(255, 255, 255));
		panel_theLoai.setBounds(75, 90, 270, 150);
		scrollPane_theLoai.setViewportView(panel_theLoai);
		panel_theLoai.setLayout(new GridLayout(0, 1, 10, 10));

//		JScrollPane main home
		JScrollPane scrollPane_mainHome = new JScrollPane();
		scrollPane_mainHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane_theLoai.setVisible(false);
			}
		});
		scrollPane_mainHome.setBounds(75, 100, 1136, 506);

//		panel main home
		JPanel panel_mainHome = new JPanel();
		panel_mainHome.setBackground(new Color(240, 240, 240));
		scrollPane_mainHome.setViewportView(panel_mainHome);
		panel_mainHome.setLayout(new GridLayout(0, 3, 25, 25));

		JLabel lblsapXep_paneltopHome = new JLabel("Sắp xếp");
		lblsapXep_paneltopHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_sapXep.setVisible(true);
				scrollPane_theLoai.setVisible(false);
			}
		});
		lblsapXep_paneltopHome.setFont(new Font("Arial", Font.BOLD, 17));
		lblsapXep_paneltopHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblsapXep_paneltopHome.setBounds(120, 0, 90, 60);
		panel_topHome.add(lblsapXep_paneltopHome);

		JLabel lbltheLoai_paneltopHome = new JLabel("Thể loại");
		lbltheLoai_paneltopHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane_theLoai.setVisible(true);
				panel_sapXep.setVisible(false);
			}
		});

		lbltheLoai_paneltopHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbltheLoai_paneltopHome.setFont(new Font("Arial", Font.BOLD, 17));
		lbltheLoai_paneltopHome.setBounds(10, 0, 90, 60);
		panel_topHome.add(lbltheLoai_paneltopHome);

		JLabel lblyeuCau_paneltopHome = new JLabel("Yêu cầu sách mới");
		lblyeuCau_paneltopHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblyeuCau_paneltopHome.setFont(new Font("Arial", Font.BOLD, 17));
		lblyeuCau_paneltopHome.setBounds(230, 0, 165, 60);
		panel_topHome.add(lblyeuCau_paneltopHome);

		JLabel imgtimKiem_paneltopHome = new JLabel("");
		imgtimKiem_paneltopHome.setBounds(1080, 15, 30, 30);
		// imgtimKiem_panelTopHome.setIcon(new ImageIcon(
		// "C:\\Users\\men\\eclipse-workspace\\LibraryManagerSystem\\LibraryManagerSystem\\src\\main\\java\\icon\\iconSearch.png"));
		ImageIcon imgiconTK = new ImageIcon(Paths.get("src/main/java/icon/iconSearch.png").toAbsolutePath().toString());
		Image imgTK = imgiconTK.getImage();
		Image imgsearch = imgTK.getScaledInstance(imgtimKiem_paneltopHome.getWidth(),
				imgtimKiem_paneltopHome.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imgicon = new ImageIcon(imgsearch);
		imgtimKiem_paneltopHome.setIcon(imgicon);
		panel_topHome.add(imgtimKiem_paneltopHome);
		imgtimKiem_paneltopHome.setHorizontalAlignment(SwingConstants.CENTER);
		imgtimKiem_paneltopHome.setFont(new Font("Calibri", Font.PLAIN, 18));
		panel_topHome.add(imgtimKiem_paneltopHome);

		JTextField txttimKiem_paneltopHome = new JTextField();
		txttimKiem_paneltopHome.setBounds(786, 15, 284, 30);
		panel_topHome.add(txttimKiem_paneltopHome);

		JLabel lblTimKiem_paneltopHome = new JLabel("Tìm kiếm");
		lblTimKiem_paneltopHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem_paneltopHome.setFont(new Font("Arial", Font.BOLD, 17));
		lblTimKiem_paneltopHome.setBounds(671, 0, 105, 60);
		panel_topHome.add(lblTimKiem_paneltopHome);

		int temp = -1;
		int xx = 0;

		ArrayList<sach> listSach = (ArrayList<sach>) sachDAO.getsachDAO().selectAll();

		for (sach ds : listSach) {
			temp++;
			if (temp > 8 && temp % 3 == 0) {
				xx++;
				panel_mainHome.setPreferredSize(
						new Dimension(scrollPane_mainHome.getWidth() - 22, scrollPane_mainHome.getHeight() + 730 * xx));
			} else if (temp <= 8 && temp >= 6) {
				panel_mainHome.setPreferredSize(
						new Dimension(scrollPane_mainHome.getWidth() - 22, scrollPane_mainHome.getHeight() + 450));
			} else if (temp <= 5) {
				panel_mainHome.setPreferredSize(
						new Dimension(scrollPane_mainHome.getWidth() - 22, scrollPane_mainHome.getHeight() + 120));
			}

			JPanel panel_sach = new JPanel();
			panel_sach.setBackground(new Color(255, 255, 255));
			panel_sach.setForeground(new Color(255, 255, 255));
			panel_sach.setLayout(null);
			panel_mainHome.add(panel_sach);

			JLabel lbltenSach_panelsach = new JLabel(ds.getTenSach());
			lbltenSach_panelsach.setHorizontalAlignment(SwingConstants.CENTER);
			lbltenSach_panelsach.setFont(new Font("Arial", Font.BOLD, 16));
			lbltenSach_panelsach.setBounds(20, 215, 289, 33);
			panel_sach.add(lbltenSach_panelsach);

			JButton btnxemThem_panelsach = new JButton("Xem thêm");
			btnxemThem_panelsach.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnxemThem_panelsach.setBackground(new Color(255, 255, 255));
			btnxemThem_panelsach.setFont(new Font("Arial", Font.BOLD, 14));
			btnxemThem_panelsach.setForeground(Color.blue);
			btnxemThem_panelsach.setBounds(115, 255, 110, 27);
			btnxemThem_panelsach.setFocusPainted(false);
			btnxemThem_panelsach.setOpaque(false);
			btnxemThem_panelsach.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					controller.choseSachCT();
				}
			});
			panel_sach.add(btnxemThem_panelsach);

			JLabel imghinhSach_panelsach = new JLabel("");
			imghinhSach_panelsach.setBounds(0, 0, 360, 205);

			ImageIcon imgiconSach = new ImageIcon((Paths.get("src/main/java/icon/" + ds.getHinhSach())).toString());
			Image imgsach = imgiconSach.getImage();
			Image img = imgsach.getScaledInstance(imghinhSach_panelsach.getWidth(), imghinhSach_panelsach.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(img);
			imghinhSach_panelsach.setIcon(imgIcon);
			panel_sach.add(imghinhSach_panelsach);

//			ImageIcon imgiconTK1 = new ImageIcon(Paths.get("src/main/java/icon/MS07.png").toAbsolutePath().toString());
//			Image imgTK1 = imgiconTK1.getImage();
//			Image imgsearch1 = imgTK1.getScaledInstance(imghinhSach_panelsach.getWidth(),
//					imghinhSach_panelsach.getHeight(), Image.SCALE_SMOOTH);
//			ImageIcon imgicon1 = new ImageIcon(imgsearch1);
//			imghinhSach_panelsach.setIcon(imgicon1);
//			panel_sach.setName(btnxemThem_panelsach.getText());
		}

		ArrayList<loaiSach> listLoai = (ArrayList<loaiSach>) loaiSachDAO.getloaiSachDAO().selectAll();

		for (loaiSach loai : listLoai) {
			JLabel loaiSach_paneltheLoai = new JLabel(loai.getTenLoaiSach());
			loaiSach_paneltheLoai.setHorizontalAlignment(SwingConstants.CENTER);
			loaiSach_paneltheLoai.setFont(new Font("Arial", Font.PLAIN, 18));
			loaiSach_paneltheLoai.setBounds(0, 30, 100, 30);
			panel_theLoai.add(loaiSach_paneltheLoai);

			loaiSach_paneltheLoai.addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					panel_home.removeAll();
					panel_home.validate();
					panel_home.repaint();
					panel_mainHome.removeAll();

					int temp = -1;
					int xx = 0;

					String theLoai = ((JLabel) e.getSource()).getText();
					loaiSach lss = loaiSachDAO.getloaiSachDAO().selectTheoTenLS(theLoai);
					ArrayList<sach> listS = (ArrayList<sach>) sachDAO.getsachDAO().selectTheoLS(lss);

					for (sach ds : listSach) {
						if (ds.getMaLoaiSach().getMaLoaiSach().equals(lss.getMaLoaiSach())) {
//							System.out.println(ds.getMaLoaiSach().getMaLoaiSach());
//							System.out.println(lss.getMaLoaiSach());
							temp++;
							if (temp > 8 && temp % 3 == 0) {
								xx++;
								panel_mainHome.setPreferredSize(new Dimension(scrollPane_mainHome.getWidth() - 22,
										scrollPane_mainHome.getHeight() + 730 * xx));
							} else if (temp <= 8 && temp >= 6) {
								panel_mainHome.setPreferredSize(new Dimension(scrollPane_mainHome.getWidth() - 22,
										scrollPane_mainHome.getHeight() + 450));
							} else if (temp <= 5) {
								panel_mainHome.setPreferredSize(new Dimension(scrollPane_mainHome.getWidth() - 22,
										scrollPane_mainHome.getHeight() + 120));
							}

							JPanel panel_sach = new JPanel();
							panel_sach.setBackground(new Color(255, 255, 255));
							panel_sach.setForeground(new Color(255, 255, 255));
							panel_sach.setLayout(null);

							JLabel lbltenSach_panelsach = new JLabel(ds.getTenSach());
							lbltenSach_panelsach.setHorizontalAlignment(SwingConstants.CENTER);
							lbltenSach_panelsach.setFont(new Font("Arial", Font.BOLD, 16));
							lbltenSach_panelsach.setBounds(20, 215, 289, 33);
							panel_sach.add(lbltenSach_panelsach);

							JButton btnxemThem_panelsach = new JButton("Xem thêm");
							btnxemThem_panelsach.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							btnxemThem_panelsach.setBackground(new Color(255, 255, 255));
							btnxemThem_panelsach.setFont(new Font("Arial", Font.BOLD, 14));
							btnxemThem_panelsach.setForeground(Color.blue);
							btnxemThem_panelsach.setBounds(115, 255, 110, 27);
							btnxemThem_panelsach.setFocusPainted(false);
							btnxemThem_panelsach.setOpaque(false);
							btnxemThem_panelsach.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent e) {
									controller.choseSachCT();
								}
							});
							panel_sach.add(btnxemThem_panelsach);

							JLabel imghinhSach_panelsach = new JLabel("");
							imghinhSach_panelsach.setBounds(0, 0, 360, 205);

							ImageIcon imgiconSach = new ImageIcon(
									(Paths.get("src/main/java/icon/" + ds.getHinhSach())).toString());
							Image imgsach = imgiconSach.getImage();
							Image img = imgsach.getScaledInstance(imghinhSach_panelsach.getWidth(),
									imghinhSach_panelsach.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imgIcon = new ImageIcon(img);
							imghinhSach_panelsach.setIcon(imgIcon);
							panel_sach.add(imghinhSach_panelsach);
							panel_mainHome.add(panel_sach);

							panel_home.add(scrollPane_theLoai);
							panel_home.add(panel_sapXep);
							panel_home.add(panel_topHome);
							panel_home.add(scrollPane_mainHome);
							scrollPane_mainHome.setViewportView(panel_mainHome);
							scrollPane_theLoai.setVisible(false);
						}

					}
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}

		panel_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_theLoai.setVisible(false);
				panel_sapXep.setVisible(false);
			}
		});

		panel_home.setLayout(null);

		panel_home.add(scrollPane_theLoai);
		panel_home.add(scrollPane_mainHome);
		// panel_Home.setBackground(new Color(255, 255, 255));

		return panel_home;

	}



# libraryManagerSystemController
	public void choseSachCT() {
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
		this.view.contentPane.add(this.view.panel_TTS());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}
	
	
	
	public void choseHome() {
		this.view.imgHome_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgHome_panelTop.setOpaque(true);

		this.view.imgMyBook_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgMyBook_panelTop.setOpaque(false);

		this.view.imgBookManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgBookManager_panelTop.setOpaque(false);

		this.view.imgUserManager_panelTop.setBackground(new Color(244, 244, 244));
		this.view.imgUserManager_panelTop.setOpaque(false);

		this.view.imgThongKe_panelTop.setBackground(new Color(255, 255, 255));
		this.view.imgThongKe_panelTop.setOpaque(false);

		this.view.contentPane.removeAll();
		this.view.contentPane.add(this.view.panel_top);
		this.view.contentPane.add(this.view.panel_Home());
		this.view.contentPane.repaint();
		this.view.contentPane.revalidate();
	}


 # sachDao
 public List<sach> selectTheoLS(loaiSach ls) {
		List<sach> list = new ArrayList<>();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					String hql = "FROM sach s WHERE s.maLoaiSach.maLoaiSach = :maLoaiSach";
					Query query = s.createQuery(hql);
					query.setParameter("maLoaiSach", ls.getMaLoaiSach());
					list = query.getResultList();
					
					List<phieuMuonSach> listPM_sach = new ArrayList<>();
					for (sach sach : list) {
						List<phieuMuonSach> listPM = phieuMuonSachDAO.getphieuMuonSachDAO().selectAll();
						for (phieuMuonSach pms : listPM) {
							if(pms.getMaSach().getMaSach().equals(sach.getMaSach())) {
								listPM_sach.add(pms);
							}
						}
						sach.setListPM(listPM_sach);
					}
					
					ts.commit();
				} finally {
					s.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


 # loaiSachDao
 public loaiSach selectTheoTenLS(String string) {
		loaiSach ls = new loaiSach();
		List<loaiSach> list = new ArrayList<loaiSach>();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					String hql = "FROM loaiSach ls WHERE ls.tenLoaiSach = :string";
					Query query = s.createQuery(hql);
					query.setParameter("string", string);
					list = query.getResultList();
					
					ls = list.get(0);
					
					List<sach> listS_LS = new ArrayList<>();
					for (loaiSach lsach : list) {
						List<sach> listS = sachDAO.getsachDAO().selectAll();
						for (sach sach : listS) {
							if(sach.getMaLoaiSach().getMaLoaiSach().equals(lsach.getMaLoaiSach())) {
								listS_LS.add(sach);
							}
						}
						lsach.setListSach(listS_LS);
					}
					
					ts.commit();
				} finally {
					s.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}
 
