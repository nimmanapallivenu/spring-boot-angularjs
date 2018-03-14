package com.venu.boot.user;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.venu.boot.dto.AddressDTO;
import com.venu.boot.dto.UserDTO;
import com.venu.boot.service.UserService;

@SpringBootApplication
@ComponentScan(value="com.venu.boot")
@EntityScan("com.venu.boot.entity")
@EnableJpaRepositories("com.venu.boot.repo")
public class UserApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserApplication.class, args);
	}

	
	@Bean
	CommandLineRunner init(UserService userService) {
		return (evt) -> Arrays.asList(
				"ram,john,venu".split(","))
				.forEach(
						user -> {
							AddressDTO address = new AddressDTO("SIPCOT","CHENNAI","INDIA",603103);
							UserDTO userDto = new UserDTO(user,"password",address);
							userService.createUser(userDto);
						});
	}
}
