package com.custoemrRegistration.Profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.custoemrRegistration.repository")
@EntityScan("com.custoemrRegistration.model")
@ComponentScan("com.custoemrRegistration")
public class AirTellPocUserRegistrationFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirTellPocUserRegistrationFormApplication.class, args);
	}

}

