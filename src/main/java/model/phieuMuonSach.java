package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class phieuMuonSach {
	@Id
	private String maPhieu;
	private Date ngayMuon, ngayTra;
	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "email")
	private user email;
	
	@ManyToOne
	@JoinColumn(name = "maSach")
	private sach maSach;
	
	@OneToMany(mappedBy = "maPhieuMuon", cascade = CascadeType.ALL)
	private List<danhGia> listDG;

	public phieuMuonSach(String maPhieu, Date ngayMuon, Date ngayTra, user email, sach maSach, String trangThai) {
		this.maPhieu = maPhieu;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.email = email;
		this.maSach = maSach;
		this.trangThai = trangThai;
	}
	
	public phieuMuonSach() {

	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public user getEmail() {
		return email;
	}

	public void setEmail(user email) {
		this.email = email;
	}

	public sach getMaSach() {
		return maSach;
	}

	public void setMaSach(sach maSach) {
		this.maSach = maSach;
	}

	public List<danhGia> getListDG() {
		return listDG;
	}

	public void setListDG(List<danhGia> listDG) {
		this.listDG = listDG;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
