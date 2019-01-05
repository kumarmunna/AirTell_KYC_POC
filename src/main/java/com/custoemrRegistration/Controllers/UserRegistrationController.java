package com.custoemrRegistration.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.custoemrRegistration.beans.UserBean;
import com.custoemrRegistration.databaseConfig.DatabaseConfiguration;
import com.custoemrRegistration.service.UserRegistrationService;

@RefreshScope
@EnableEurekaClient
@RestController
public class UserRegistrationController {

	/*
	 * @Autowired DataRepository dataRepository;
	 */
	@Autowired
	UserRegistrationService userRegistrationService;

	Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	@Value("${msg:Hello world - Config Server is not working..pelase check}")
	private String msg;
	public String spring_datasource_driverclassname;
	public String DBNAME;
    public String spring_datasource_url;
    public String spring_datasource_username;
    public String spring_datasource_password;
    
    
	/**
	 * This method give the latest msg from the properties file based on the
	 * profile.
	 * 
	 * @return
	 */
	@RequestMapping("/msg")
	String getMsg() {
		System.out.println("Going to get msg from server...");
		System.out.println("msg: "+this.msg + " DRIVER: "+ this.spring_datasource_driverclassname +" JDBC_URL: "+ this.spring_datasource_url
				+ " UserName: "+ this.spring_datasource_username);
		return this.msg;
	}

	@GetMapping("/home")
	public String getMessage() {
		System.out.println(" in msg ...");
		return " msg from controller ...";
	}

	@GetMapping("/index")
	public ModelAndView getIndex(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("In index method ....");
		}
		model.addAttribute("userbean", new UserBean());
		ModelAndView mv = new ModelAndView();

		mv.setViewName("userRegistration");
		return mv;
	}

	@PostMapping("/registration")
	public ModelAndView saveUserData(@ModelAttribute UserBean userBean, Model model) {

		if (logger.isDebugEnabled()) {
			logger.debug(" User data: " + userBean);
		}
		System.out.println(" Database name: " + this.msg);
		// new DatabaseConfiguration(msg);
		int userId = userRegistrationService.saveUser(userBean);
		model.addAttribute("userId", userId);
		model.addAttribute("userbean", new UserBean());
//		jdbc:h2:mem:testdb
		return new ModelAndView("userRegistration");
	}
	
	@GetMapping("/getUser")
	public List<UserBean> getAllUser(){
		List<UserBean> userList = userRegistrationService.getAllUsers();
		return userList;
		
	}
	
	
	/*@PostMapping("/appAction")
	public ModelAndView approveApplication(@RequestBody UserBean userBean) {

		if (logger.isDebugEnabled()) {
			logger.debug(" User data: " + userBean);
		}
		System.out.println(" Database name: " + this.msg);
		// new DatabaseConfiguration(msg);
		userRegistrationService.updateApplication(userBean);
		//		jdbc:h2:mem:testdb
		return new ModelAndView("userRegistration");
	}*/
	
	@RequestMapping("/updateStatus/{id}")
	public String fetchKYCStatus (@PathVariable("id") int id) {
		String status = userRegistrationService.updateKYCStatus(id);
		return status;
	}
	
	@RequestMapping("/getStatus/id/{id}")
	public String getKYCStatus (@PathVariable("id") Long id) {
		String status = userRegistrationService.getKYCStatus(id.intValue());
		System.out.println(" KYC Status of given id: "+id+" is: "+ status);
		return status;
	}
}
