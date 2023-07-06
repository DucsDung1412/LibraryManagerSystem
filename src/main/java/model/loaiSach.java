package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class loaiSach {
	@Id
	private String maLoaiSach;
	private String tenLoaiSach, moTa;
	
	@OneToMany(mappedBy = "maLoaiSach", cascade = CascadeType.ALL)
	private List<sach> listSach;

	public loaiSach(String maLoaiSach, String tenLoaiSach, String moTa) {
		this.maLoaiSach = maLoaiSach;
		this.tenLoaiSach = tenLoaiSach;
		this.moTa = moTa;
	}
	
	public loaiSach() {

	}

	public String getMaLoaiSach() {
		return maLoaiSach;
	}

	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}

	public String getTenLoaiSach() {
		return tenLoaiSach;
	}

	public void setTenLoaiSach(String tenLoaiSach) {
		this.tenLoaiSach = tenLoaiSach;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<sach> getListSach() {
		return listSach;
	}

	public void setListSach(List<sach> listSach) {
		this.listSach = listSach;
	}
	
	public String getSach() {
		String s = "";
		for (sach sach : listSach) {
			s += sach.getMaSach();
			s += " ";
		}
		return s;
	}

//	@Override
//	public String toString() {
//		return "loaiSach [maLoaiSach=" + maLoaiSach + ", tenLoaiSach=" + tenLoaiSach + ", moTa=" + moTa + ", listSach="
//				+ listSach.size() + "]";
//	}

	
}
