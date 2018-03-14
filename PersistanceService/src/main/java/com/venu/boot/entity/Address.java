package com.venu.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = -1379769675586289390L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Long id;

	@Column(name = "ADDRESS_STREET", nullable = false, length = 50)
	private String street;

	@Column(name = "ADDRESS_CITY", nullable = false, length = 50)
	private String city;

	@Column(name = "ADDRESS_COUNTRY", nullable = false, length = 10)
	private String contry;

	@Column(name = "ADDRESS_PINCODE", nullable = false, length = 10)
	private long pincode;

	public Address() {
		super();

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
