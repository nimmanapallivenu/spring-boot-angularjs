package com.venu.boot.dto;

public class UserDTO {

	private long id;

	private String name;

	private String email;

	private String pwd;

	private String street;

	private String city;

	private String contry;

	private long pincode;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(long id, String name, String email, String password, String street, String city, String contry,
			long pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = password;
		this.street = street;
		this.city = city;
		this.contry = contry;
		this.pincode = pincode;
	}

	public UserDTO(String name, String password,String email,  String street, String city, String contry,
			long pincode) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = password;
		this.street = street;
		this.city = city;
		this.contry = contry;
		this.pincode = pincode;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String password) {
		this.pwd = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

}
