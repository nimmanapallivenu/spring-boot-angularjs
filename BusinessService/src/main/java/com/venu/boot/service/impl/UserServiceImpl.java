package com.venu.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;

	
	 @Autowired
	    public UserServiceImpl(final UserRepository repository) {
	        this.userRepository = repository;
	    }
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public UserDTO getUser(String name) {

		UserDetails user = userRepository.findByName(name);
		return convertEntityToDto(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDTO getUser(long userid) {
		UserDetails user = userRepository.findOne(userid);
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
		userDetail.setPassword(userDto.getPwd());
		userDetail.setEmail(userDto.getEmail());
		Address address = new Address();
		address.setStreet(userDto.getStreet());
		address.setCity(userDto.getCity());
		address.setContry(userDto.getContry());
		address.setPincode(userDto.getPincode());
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
		userDto.setEmail(userDetails.getEmail());
		userDto.setStreet(userDetails.getAddress().getStreet());
		userDto.setCity(userDetails.getAddress().getCity());
		userDto.setContry(userDetails.getAddress().getContry());
		userDto.setPincode(userDetails.getAddress().getPincode());
	
		return userDto;
	}

}







