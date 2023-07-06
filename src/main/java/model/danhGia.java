package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class danhGia {
	@Id
	private String maDanhGia;
	private String danhGia;
	
	@ManyToOne
	@JoinColumn(name = "email")
	private user email;
	
	@ManyToOne
	@JoinColumn(name = "maPhieuMuon")
	private phieuMuonSach maPhieuMuon;

	public danhGia(String maDanhGia, String danhGia, user email, phieuMuonSach maPhieuMuon) {
		this.maDanhGia = maDanhGia;
		this.danhGia = danhGia;
		this.email = email;
		this.maPhieuMuon = maPhieuMuon;
	}

	public danhGia() {

	}

	public String getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(String maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	public user getEmail() {
		return email;
	}

	public void setEmail(user email) {
		this.email = email;
	}

	public phieuMuonSach getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(phieuMuonSach maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	@Override
	public String toString() {
		return "danhGia [maDanhGia=" + maDanhGia + ", danhGia=" + danhGia + ", email=" + email + ", maPhieuMuon="
				+ maPhieuMuon + "]";
	}
}
