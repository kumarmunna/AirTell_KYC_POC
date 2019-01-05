package com.custoemrRegistration.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@EnableEurekaClient
@RestController
public class KYCController {

	@Autowired
	RestTemplate restTemmplate;
	
	@GetMapping("/details")
	public String getName() {
		return "Santosh Singh";
	}
	
	@GetMapping("newPage")
	public ModelAndView getNewPage() {
		System.out.println(" going to get new page...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserDetails");
		return mv;
		
	}
	
	@RequestMapping("/updateStatus/{id}")
	public String updateKYCStatus (@PathVariable("id") int id) {
		System.out.println("Getting School details for " + id);
		 
        String response = restTemmplate.exchange("http://user-registration/updateStatus/{id}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, id).getBody();
        System.out.println("Response Received from getkycstatus: " + response);
		
		return response;
	}
}
