package com.custoemrRegistration.service;

import java.util.List;

import com.custoemrRegistration.beans.UserBean;

public interface UserRegistrationService {

	public int saveUser(UserBean userBean);
	public List<UserBean> getAllUsers();
	//public void updateApplication(UserBean userBean) ;
	public String updateKYCStatus(int id) ;
	public String getKYCStatus(int id);
	
}
