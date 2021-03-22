package kr.co.domain;

import lombok.Data;

@Data
public class UserVO {
	
	private int user_number;
    private String user_id;
    private String user_pw;
    private String user_pw2;
    private String user_name;
    private String user_hp1;
    private String user_hp2;
    private String user_hp3;
    private String user_email;
    private String user_zipcode;
    private String user_roadAddress;
    private String user_jibunAddress;
    private String user_namujiAddress;
    private String user_birthY;
    private String user_birthM;
    private String user_birthD;
    private String user_joinDate;
    private int user_del_yn;
    
	public int getUser_number() {
		return user_number;
	}
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_hp1() {
		return user_hp1;
	}
	public void setUser_hp1(String user_hp1) {
		this.user_hp1 = user_hp1;
	}
	public String getUser_hp2() {
		return user_hp2;
	}
	public void setUser_hp2(String user_hp2) {
		this.user_hp2 = user_hp2;
	}
	public String getUser_hp3() {
		return user_hp3;
	}
	public void setUser_hp3(String user_hp3) {
		this.user_hp3 = user_hp3;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	public String getUser_roadAddress() {
		return user_roadAddress;
	}
	public void setUser_roadAddress(String user_roadAddress) {
		this.user_roadAddress = user_roadAddress;
	}
	public String getUser_jibunAddress() {
		return user_jibunAddress;
	}
	public void setUser_jibunAddress(String user_jibunAddress) {
		this.user_jibunAddress = user_jibunAddress;
	}
	public String getUser_namujiAddress() {
		return user_namujiAddress;
	}
	public void setUser_namujiAddress(String user_namujiAddress) {
		this.user_namujiAddress = user_namujiAddress;
	}
	public String getUser_birthY() {
		return user_birthY;
	}
	public void setUser_birthY(String user_birthY) {
		this.user_birthY = user_birthY;
	}
	public String getUser_birthM() {
		return user_birthM;
	}
	public void setUser_birthM(String user_birthM) {
		this.user_birthM = user_birthM;
	}
	public String getUser_birthD() {
		return user_birthD;
	}
	public void setUser_birthD(String user_birthD) {
		this.user_birthD = user_birthD;
	}
	public String getUser_joinDate() {
		return user_joinDate;
	}
	public void setUser_joinDate(String user_joinDate) {
		this.user_joinDate = user_joinDate;
	}
	public int getUser_del_yn() {
		return user_del_yn;
	}
	public void setUser_del_yn(int user_del_yn) {
		this.user_del_yn = user_del_yn;
	}
    
    
}
