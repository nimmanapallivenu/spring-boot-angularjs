package com.venu.boot.service.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.venu.boot.repo.UserRepository;

@Configuration
public class DaoTestConfig1 {
	
	@Bean
	public UserRepository userRepository() {
		return Mockito.mock(UserRepository.class);
	}
}
