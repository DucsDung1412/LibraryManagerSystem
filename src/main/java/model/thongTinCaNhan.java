package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class thongTinCaNhan {
	@Id
	private String maTTCN;
	
	@OneToOne
	@JoinColumn(name = "email")
	private user email;
	
	private String ten, soDienThoai, diaChi, hinh;
	
	public thongTinCaNhan(String maTTCN, user email, String ten, String soDienThoai, String diaChi, String hinh) {
		this.maTTCN = maTTCN;
		this.email = email;
		this.ten = ten;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.hinh = hinh;
	}

	public thongTinCaNhan() {

	}

	public String getMaTTCN() {
		return maTTCN;
	}

	public void setMaTTCN(String maTTCN) {
		this.maTTCN = maTTCN;
	}

	public user getEmail() {
		return email;
	}

	public void setEmail(user email) {
		this.email = email;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	@Override
	public String toString() {
		return "thongTinCaNhan [maTTCN=" + maTTCN + ", email=" + email + ", ten=" + ten + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + ", hinh=" + hinh + "]";
	}
	
}
