package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class sach {
	@Id
	private String maSach;
	private String tenSach, tacGia, hinhSach, moTa, nhaXuatBan;
	private Integer namXB, soLuong, soLanTaiBan;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiSach")
	private loaiSach maLoaiSach;
	
	@OneToMany(mappedBy = "maSach", cascade = CascadeType.ALL)
	private List<phieuMuonSach> listPM;

	public sach(String maSach, String tenSach, String tacGia, String hinhSach, String moTa, String nhaXuatBan,
			Integer namXB, Integer soLuong, Integer soLanTaiBan, loaiSach maLoaiSach) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.hinhSach = hinhSach;
		this.moTa = moTa;
		this.nhaXuatBan = nhaXuatBan;
		this.namXB = namXB;
		this.soLuong = soLuong;
		this.soLanTaiBan = soLanTaiBan;
		this.maLoaiSach = maLoaiSach;
	}

	public sach() {

	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public Integer getNamXB() {
		return namXB;
	}

	public void setNamXB(Integer namXB) {
		this.namXB = namXB;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getSoLanTaiBan() {
		return soLanTaiBan;
	}

	public void setSoLanTaiBan(Integer soLanTaiBan) {
		this.soLanTaiBan = soLanTaiBan;
	}

	public loaiSach getMaLoaiSach() {
		return maLoaiSach;
	}

	public void setMaLoaiSach(loaiSach maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	
	public List<phieuMuonSach> getListPM() {
		return listPM;
	}

	public void setListPM(List<phieuMuonSach> listPM) {
		this.listPM = listPM;
	}

	public String getHinhSach() {
		return hinhSach;
	}

	public void setHinhSach(String hinhSach) {
		this.hinhSach = hinhSach;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

}
