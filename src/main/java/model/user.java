package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class user {
	
	@Id
	private String username;
	private String password, role;
	
	@OneToOne(mappedBy = "email")
	private thongTinCaNhan ttcn;
	
	@OneToMany(mappedBy = "email", cascade = CascadeType.ALL)
	private List<phieuMuonSach> listPM;
	
	@OneToMany(mappedBy = "email", cascade = CascadeType.ALL)
	private List<danhGia> listDG;
	
	@OneToMany(mappedBy = "email", cascade = CascadeType.ALL)
	private List<yeuCau> listYC;
	
	public user(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public user() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<phieuMuonSach> getListPM() {
		return listPM;
	}

	public void setListPM(List<phieuMuonSach> listPM) {
		this.listPM = listPM;
	}

	public List<danhGia> getListDG() {
		return listDG;
	}
	
	public void setListDG(List<danhGia> listDG) {
		this.listDG = listDG;
	}
	
	public List<yeuCau> getListYC() {
		return listYC;
	}

	public void setListYC(List<yeuCau> listYC) {
		this.listYC = listYC;
	}
	
	public thongTinCaNhan getTtcn() {
		return ttcn;
	}

	public void setTtcn(thongTinCaNhan ttcn) {
		this.ttcn = ttcn;
	}

//	@Override
//	public String toString() {
//		return "user [username=" + username + ", password=" + password + ", role=" + role + ", ttcn=" + ttcn + "]";
//	}

	
}
