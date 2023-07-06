package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.danhGia;
import model.phieuMuonSach;
import util.hibernateUtil;

public class phieuMuonSachDAO implements daoInterface<phieuMuonSach>{
	public static phieuMuonSachDAO getphieuMuonSachDAO() {
		return new phieuMuonSachDAO();
	}

	@Override
	public boolean insertX(phieuMuonSach pms) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.save(pms);
					
					ts.commit();
				} finally {
					s.close();
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletaX(phieuMuonSach pms) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					phieuMuonSach pmsClone = this.selectG(pms);
					if(!pmsClone.getListDG().isEmpty()) {
						for (danhGia dg : pmsClone.getListDG()) {
							danhGiaDAO.getdanhGiaDAO().deletaX(dg);
						}
					}
					s.remove(pms);
					
					ts.commit();
				} finally {
					s.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateX(phieuMuonSach pms) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.update(pms);
					
					ts.commit();
				} finally {
					s.close();
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public phieuMuonSach selectG(phieuMuonSach pms) {
		phieuMuonSach pm = new phieuMuonSach();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					pm = s.get(phieuMuonSach.class, pms.getMaPhieu());
					pm.getListDG().size();
					
					
					ts.commit();
				} finally {
					s.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pm;
	}

	@Override
	public List<phieuMuonSach> selectAll() {
		List<phieuMuonSach> list = new ArrayList<>();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					String hql = "FROM phieuMuonSach";
					Query query = s.createQuery(hql);
					list = query.getResultList();
					
					List<danhGia> listDG_PMS = new ArrayList<>();
					for (phieuMuonSach phieuMuonSach : list) {
						List<danhGia> lsiDG = danhGiaDAO.getdanhGiaDAO().selectAll();
						for (danhGia danhGia : lsiDG) {
							if(danhGia.getMaPhieuMuon().getMaPhieu().equals(phieuMuonSach.getMaPhieu())) {
								listDG_PMS.add(danhGia);
							}
						}
						phieuMuonSach.setListDG(listDG_PMS);
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
}
