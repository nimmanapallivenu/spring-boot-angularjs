package com.venu.boot.dto;

public class UserDTO {

	private long id;

	private String name;

	private String password;

	private AddressDTO address;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public UserDTO(long id, String name, String password, AddressDTO address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
	}



	public UserDTO(String name, String password, AddressDTO address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}
