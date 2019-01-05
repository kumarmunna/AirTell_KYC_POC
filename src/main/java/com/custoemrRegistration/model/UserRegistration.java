package com.custoemrRegistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRegistration {

	@Id
	@GeneratedValue
	private int id;
	@Column( name = "firstname")
	private String firstname;
	@Column( name = "lastname")
	private String lastname;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private long phone;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	@Column(name = "kycstatus")
	private String kycstatus;
	@Column(name = "aadharno")
	private long aadharno;
	@Column(name = "panno")
	private String panno;
	
	
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
	public String getGender() {
		return gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String isGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getKycstatus() {
		return kycstatus;
	}
	public void setKycstatus(String kycstatus) {
		this.kycstatus = kycstatus;
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
		return "UserRegistration [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", address=" + address + ", phone=" + phone + ", email=" + email + ", gender=" + gender
				+ ", kycstatus=" + kycstatus + ", aadharno=" + aadharno + ", panno=" + panno + "]";
	}
	
	
	
	
	
	
}
