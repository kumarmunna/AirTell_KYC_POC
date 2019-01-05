package com.custoemrRegistration.beans;

public class UserBean {

	private int id;
	private String firstname;
	private String lastname;
	private String address;
	private long phone;
	private String email;
	//private boolean gender;--> boolean type making issue when we bind in controller because from UI, this is coming as string.
	private String gender;
	private long aadharno;
	private String panno;
	private String kycstatus;
	//private boolean isApproved;
	
	public String getKycstatus() {
		return kycstatus;
	}
	public void setKycstatus(String kycstatus) {
		this.kycstatus = kycstatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAadharno() {
		return aadharno;
	}
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname 
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", gender=" + gender
				+ ", aadharno=" + aadharno + ", panno=" + panno + "]";
	}
	
}
