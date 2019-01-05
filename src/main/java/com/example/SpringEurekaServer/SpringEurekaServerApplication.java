package com.example.SpringEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * After successfull runing application, use URL "http://localhost:9098//getSchoolDetails/abcschool" to get the
 * response. Internally, this call controller and call the student service microservice and get the response and
 * return as json data.
 * 
 * In this project, we have include three project means microservices
 * 1. SpringEurekaServer
 * 2.Spring_Eureka_Studen_Client_Service
 * 3.Spring_Eureka_SchoolL_Service
 * 
 * @author santoshkumar_si
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServerApplication.class, args);
	}

}

