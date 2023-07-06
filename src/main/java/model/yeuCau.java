package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class yeuCau {
	@Id
	private String maYeuCau;
	private String loaiSach;
	private String sach;
	private String moTa;
	
	@ManyToOne
	@JoinColumn(name = "email")
	private user email;

	public yeuCau(String maYeuCau, String loaiSach, String sach, String moTa, user email) {
		this.maYeuCau = maYeuCau;
		this.loaiSach = loaiSach;
		this.sach = sach;
		this.moTa = moTa;
		this.email = email;
	}

	public yeuCau() {

	}

	public String getMaYeuCau() {
		return maYeuCau;
	}

	public void setMaYeuCau(String maYeuCau) {
		this.maYeuCau = maYeuCau;
	}

	public String getLoaiSach() {
		return loaiSach;
	}

	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}

	public String getSach() {
		return sach;
	}

	public void setSach(String sach) {
		this.sach = sach;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public user getEmail() {
		return email;
	}

	public void setEmail(user email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "yeuCau [maYeuCau=" + maYeuCau + ", loaiSach=" + loaiSach + ", sach=" + sach + ", moTa=" + moTa
				+ ", email=" + email + "]";
	}
}
