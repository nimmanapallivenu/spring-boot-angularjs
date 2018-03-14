package com.venu.boot.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDetails implements Serializable {

	private static final long serialVersionUID = -1585348329520517785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private long id;

	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@Column(name = "PASSWORD", nullable = false, length = 50)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	

	public UserDetails() {
		super();

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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	
}
