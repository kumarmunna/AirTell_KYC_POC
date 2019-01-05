package com.example.Spring_Eureka_Client_Zuul_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * This project is using zuul api gateway.
 * 1. By using this URL: http://localhost:8084/student/getSchoolDetails/abcschool
 * we have configured the student url in Spring_Eureka_Client_Zuul_Service.
 * in zuul service, we have given the school service name to access the getSchoolDetails mapping in Spring_Eureka,Xlient_School_Service.
 * 3. In School service, we have added the RestTemplate to call the student service.
 * 4. After calling student service url, we get the response internally.
 * 
 * We use following microservices:
 * Spring_Eureka_Client_School_Service
 * Spring_Eureka_Client_Student_Service
 * Spring_Eureka_Client_Zuul_Service
 * SpringEurekaServer
 * @see student,school service
 * @author santoshkumar_si
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringEurekaClientZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientZuulServiceApplication.class, args);
	}
	
	

}

