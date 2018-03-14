package com.venu.boot.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.venu.boot.dto.UserDTO;
import com.venu.boot.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public UserDTO createUser(@RequestBody UserDTO userDTO) {

		return userService.createUser(userDTO);
	}

	@RequestMapping(value = "/{userid}", method = RequestMethod.PUT)
	public UserDTO updateUser(@PathVariable long userid,@RequestBody UserDTO userDTO) {

		return userService.updateUser(userid, userDTO);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<UserDTO> getUserList() {

		return userService.getUsers();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public UserDTO getUserByName(@PathVariable(name="username") String username) {
		return userService.getUser(username);
	}

	@RequestMapping(value = "/{userid}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long userid) {
		userService.deleteUser(userid);
	}

}
