package com.custoemrRegistration.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.custoemrRegistration.Controllers.UserRegistrationController;
import com.custoemrRegistration.beans.UserBean;
import com.custoemrRegistration.model.UserRegistration;
import com.custoemrRegistration.repository.DataRepository;
import com.custoemrRegistration.service.UserRegistrationService;

@Service("UserRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {

	Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	@Autowired
	DataRepository datareposiroy;
	
	@Autowired
	Environment env;
	
	@Override
	public int saveUser(UserBean userBean) {
		// TODO Auto-generated method stub
		logger.debug(" in service impl method .... ");
		
		System.out.println(" Driver: "+ env.getProperty("spring_datasource_driverclassname"));
		System.out.println(" URL: "+ env.getProperty("spring_datasource_url"));
		System.out.println(" Username: "+ env.getProperty("spring_datasource_username"));
		System.out.println(" Password: "+ env.getProperty("spring_datasource_password"));
		
		
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.setFirstname(userBean.getFirstname());
		userRegistration.setLastname(userBean.getLastname());
		userRegistration.setAddress(userBean.getAddress());
		userRegistration.setPhone(userBean.getPhone());
		userRegistration.setEmail(userBean.getEmail());
		//userRegistration.setPassword(userBean.getPassword());
		userRegistration.setGender(userBean.getGender());
		userRegistration.setKycstatus("Pending");
		userRegistration.setAadharno(userBean.getAadharno());
		userRegistration.setPanno(userBean.getPanno());

		UserRegistration response = datareposiroy.save(userRegistration);
		System.out.println(" response from resp: "+ response.getId());
		logger.info(" in service impl method .... info");
		return response.getId();
	}
	
	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserRegistration> ls = datareposiroy.findAll();
		List<UserBean> ubean = new ArrayList<>();
		UserBean bean = null;
		
		System.out.println(" Driver1: "+ env.getProperty("spring_datasource_driverclassname"));
		System.out.println(" URL1: "+ env.getProperty("spring_datasource_url"));
		System.out.println(" Username1: "+ env.getProperty("spring_datasource_username"));
		System.out.println(" Password1: "+ env.getProperty("spring_datasource_password"));
		
		
		for (UserRegistration userRegistration : ls) {
			bean = new UserBean();
			bean.setId(userRegistration.getId());
			bean.setFirstname(userRegistration.getFirstname());
			bean.setLastname(userRegistration.getLastname());
			//bean.setPassword(userRegistration.getPassword());
			bean.setGender(userRegistration.getGender());
			bean.setEmail(userRegistration.getEmail());
			bean.setAddress(userRegistration.getAddress());
			bean.setPhone(userRegistration.getPhone());
			bean.setKycstatus(userRegistration.getKycstatus());
			ubean.add(bean);
		}
		
		return ubean;
	}

	@Override
	public String updateKYCStatus(int id) {
		// TODO Auto-generated method stub
		UserRegistration regis = datareposiroy.findById(id).get();
		regis.setKycstatus("Approved");
		datareposiroy.saveAndFlush(regis);
		return "Approved";
	}

	@Override
	public String getKYCStatus(int id) {
		// TODO Auto-generated method stub
		//UserRegistration regis = datareposiroy.findById(id).get();
		Optional<UserRegistration> regis = datareposiroy.findById(id);
		String kycStatus = null;
		if(regis.isPresent()) {
			kycStatus = regis.get().getKycstatus();
		}else {
			kycStatus = "Data Not Found";
		}
		
		return kycStatus;
	}

}

