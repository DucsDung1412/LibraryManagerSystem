package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.phieuMuonSach;
import model.sach;
import util.hibernateUtil;

public class sachDAO implements daoInterface<sach>{
	public static sachDAO getsachDAO() {
		return new sachDAO();
	}

	@Override
	public boolean insertX(sach sachS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.save(sachS);
					
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
	public boolean deletaX(sach sachS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					sach sachClone = this.selectG(sachS);
					if(!sachClone.getListPM().isEmpty()) {
						for (phieuMuonSach pms : sachClone.getListPM()) {
							phieuMuonSachDAO.getphieuMuonSachDAO().deletaX(pms);
						}
					}
					s.remove(sachS);
					
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
	public boolean updateX(sach sachS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.update(sachS);
					
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
	public sach selectG(sach sachS) {
		sach sa = new sach();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					sa = s.get(sach.class, sachS.getMaSach());
					sa.getListPM().size();
					
					ts.commit();
				} finally {
					s.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sa;
	}

	@Override
	public List<sach> selectAll() {
		List<sach> list = new ArrayList<>();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					String hql = "FROM sach";
					Query query = s.createQuery(hql);
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
	
}
