package com.venu.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venu.boot.dto.AddressDTO;
import com.venu.boot.dto.UserDTO;
import com.venu.boot.entity.Address;
import com.venu.boot.entity.UserDetails;
import com.venu.boot.repo.UserRepository;
import com.venu.boot.service.UserService;

/**
 * @author venu.nimmanapalli
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.venu.boot.service.UserService#createUser(com.venu.boot.dto.UserDTO)
	 */
	@Override
	public UserDTO createUser(UserDTO userDTO) {

		UserDetails userDetails = convertDtoToEntity(userDTO);
		userDetails = userRepository.save(userDetails);
		return convertEntityToDto(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.venu.boot.service.UserService#updateUser(long, com.venu.boot.dto.UserDTO)
	 */
	@Override
	public UserDTO updateUser(long id, UserDTO userDTO) {
		UserDetails userDetails = convertDtoToEntity(userDTO);
		userDetails = userRepository.save(userDetails);
		return convertEntityToDto(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.venu.boot.service.UserService#getUsers()
	 */
	@Override
	public List<UserDTO> getUsers() {

		List<UserDetails> userList = userRepository.findAll();
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (UserDetails userDetail : userList) {
			userDTOList.add(convertEntityToDto(userDetail));
		}
		return userDTOList;
	}

	/* (non-Javadoc)
	 * @see com.venu.boot.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public UserDTO getUser(String name) {

		UserDetails user = userRepository.findByName(name);
		return convertEntityToDto(user);
	}

	/* (non-Javadoc)
	 * @see com.venu.boot.service.UserService#deleteUser(long)
	 */
	@Override
	public void deleteUser(long userId) {
		this.userRepository.delete(userId);
	}

	/**
	 * @param userDto
	 * @return
	 */
	private UserDetails convertDtoToEntity(UserDTO userDto) {

		if (userDto == null) {
			return null;
		}

		UserDetails userDetail = new UserDetails();
		userDetail.setName(userDto.getName());
		userDetail.setPassword(userDto.getPassword());
		Address address = new Address();
		address.setStreet(userDto.getAddress().getStreet());
		address.setCity(userDto.getAddress().getCity());
		address.setContry(userDto.getAddress().getContry());
		address.setPincode(userDto.getAddress().getPincode());
		userDetail.setAddress(address);
		return userDetail;
	}

	/**
	 * @param userDetails
	 * @return
	 */
	private UserDTO convertEntityToDto(UserDetails userDetails) {
		if (userDetails == null) {
			return null;
		}
		UserDTO userDto = new UserDTO();
		userDto.setName(userDetails.getName());
		userDto.setId(userDetails.getId());
		AddressDTO address = new AddressDTO();
		address.setId(userDetails.getAddress().getId());
		address.setStreet(userDetails.getAddress().getStreet());
		address.setCity(userDetails.getAddress().getCity());
		address.setContry(userDetails.getAddress().getContry());
		address.setPincode(userDetails.getAddress().getPincode());
		userDto.setAddress(address);
		return userDto;
	}

}
