package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * This project uses spring cloud config server and client to share data. Following steps to run this application.
 * 1. Create folder on Desktop with name: config-server-repo and add three properties file namely:config-server-client,
 * config-server-client-development,config-server-client-production with msg. Please see the desktop folder, i have created
 * 2. Commit this file on local git repository by using git add . cmd and commit.
 * 3. Run the Spring-config-server. and check on localhost:8888(Configured in property file of this project.
 * 4. Check the URL:http://localhost:8888/config-server-client/development and http://localhost:8888/config-server-client/production
 * also by changing the value of msg variable in property file on desktop location.
 * 5. Run client microservice app namely: Spring-config-client
 * 6. Check the localhost:8080/msg and also by changing the value of msg variable in git repository file.
 * 
 * NOTE: This example is taken from: https://howtodoinjava.com/spring-cloud/spring-cloud-config-server-git/
 * 
 * @author santoshkumar_si
 *
 */
@EnableConfigServer
@SpringBootApplication
public class SpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerApplication.class, args);
	}

}

