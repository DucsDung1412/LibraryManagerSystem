package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.loaiSach;
import model.phieuMuonSach;
import model.sach;
import util.hibernateUtil;

public class loaiSachDAO implements daoInterface<loaiSach>{
	public static loaiSachDAO getloaiSachDAO() {
		return new loaiSachDAO();
	}

	@Override
	public boolean insertX(loaiSach loaiS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.save(loaiS);
					
					ts.commit();
				} finally {
					s.close();
				}
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletaX(loaiSach loaiS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					loaiSach lsClone = this.selectG(loaiS);
					if(!lsClone.getListSach().isEmpty()) {
						for (sach sach : lsClone.getListSach()) {
							sachDAO.getsachDAO().deletaX(sach);
						}
					}
					s.remove(loaiS);
					
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
	public boolean updateX(loaiSach loaiS) {
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					s.update(loaiS);
					
					ts.commit();
				} finally {
					s.close();
				}
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public loaiSach selectG(loaiSach loaiS) {
		loaiSach ls = new loaiSach();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
				 	ls = ((s.get(loaiSach.class, loaiS.getMaLoaiSach())));
					int i = (ls.getListSach().size());
//					ls = s.get(loaiSach.class, loaiS.getMaLoaiSach());
					
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

	@Override
	public List<loaiSach> selectAll() {
		List<loaiSach> list = new ArrayList<loaiSach>();
		
		try {
			SessionFactory sf = hibernateUtil.getSessionFactory();
			if(sf != null) {
				Session s = sf.openSession();
				try {
					Transaction ts = s.beginTransaction();
					
					String hql = "FROM loaiSach";
					Query query = s.createQuery(hql);
					list = query.getResultList();
					
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
		
		return list;
	}
	
	
}
