package com.airtel.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
class CustomerController {

	@Value("${msg:Hello world - Config Server is not working..pelase check}")
	private String msg;

	@Autowired
    RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String index () {
		return "Hello....";
	}
	
	@GetMapping("msg")
	public String getmsg() {
		return this.msg;
	}	
	/*
	 * @RequestMapping("/addCustomer") public void saveDetails (Customer customer) {
	 * customerService.addCustomer(customer); }
	 */
	
	/*
	 * @RequestMapping("/findById/id/{id}") public CustomerDto findById
	 * (@PathVariable("id") Long id) { CustomerDto customer =
	 * customerService.getCustomerById(id).get(); return customer; }
	 */
	
	@RequestMapping("/getStatus/id/{id}")
	public String fetchKYCStatus (@PathVariable("id") Long id) {
		
		System.out.println("Getting School details for " + id);
		 
        String response = restTemplate.exchange("http://user-registration/getStatus/id/{id}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, id).getBody();
        System.out.println("Response Received from getkycstatus: " + response);
		
		return response;
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
