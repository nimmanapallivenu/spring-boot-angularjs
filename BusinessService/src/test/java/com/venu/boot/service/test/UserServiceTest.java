package com.venu.boot.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.venu.boot.dto.UserDTO;
import com.venu.boot.entity.Address;
import com.venu.boot.entity.UserDetails;
import com.venu.boot.repo.UserRepository;
import com.venu.boot.service.UserService;
import com.venu.boot.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private UserService userService;

	@Mock
	private UserRepository userRepository;

	
	@Before
	public void setup() {
		
		userService = new UserServiceImpl(userRepository);
		
		List<UserDetails> returnList = new ArrayList<UserDetails>();
		UserDetails userDetails1 = new UserDetails(1,"test1", "Password", "user@gmail.com",new Address(1l,"SiPCOT", "CHENNAI", "INDIA", 603103));
		returnList.add(userDetails1);

		UserDetails userDetails2 = new UserDetails(2,"test2", "Password","user@gmail.com",new Address(2l,"SiPCOT1", "CHENNAI1", "INDIA", 603103));
		returnList.add(userDetails2);

		// Repo Save
		Mockito.when(userRepository.save(any(UserDetails.class))).thenReturn(userDetails1);
		
		// user by name
		Mockito.when(userRepository.findByName(any(String.class))).thenReturn(userDetails2);

		// getting list of users
		Mockito.when(userRepository.findAll()).thenReturn(returnList);

		
		
	}

	@Test
	public void createUser_Success() {
		// user Create Service
		UserDTO userDTO = new UserDTO("test1", "Password","user@gmail.com", "SiPCOT", "CHENNAI", "INDIA", 603103);
		userDTO = userService.createUser(userDTO);
		assertNotNull(userDTO.getId());
		assertEquals("test1", userDTO.getName());
	}

	@Test
	public void updateUser_Success() {
		UserDTO userDTO = userService.updateUser(100,
				new UserDTO(1, "test1", "Password", "user@gmail.com","SiPCOT", "CHENNAI", "INDIA", 603103));
		assertEquals(userDTO.getId(), 1);
		assertEquals("test1", userDTO.getName());
	}

	@Test
	public void getUsers_Success() {
		List<UserDTO> userList = userService.getUsers();
		assertNotNull(userList);
		assertEquals(userList.size(), 2);
	}

	@Test
	public void getUser() {
		UserDTO userDTO = userService.getUser("test2");
		assertEquals(userDTO.getId(), 2);
		assertEquals("test2", userDTO.getName());
	}

	@Test
	public void deleteUser() {
		userService.deleteUser(100l);
		assertNotNull(true);
	}




}
