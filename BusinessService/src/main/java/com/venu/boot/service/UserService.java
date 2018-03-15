package com.venu.boot.service;

import java.util.List;

import com.venu.boot.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO updateUser(long id, UserDTO userDTO);

	List<UserDTO> getUsers();

	UserDTO getUser(String name);
	
	UserDTO getUser(long userid);

	void deleteUser(long id);
}
