package com.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "information")
public class AddressBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation specifies the
	private long id; // generation strategies for the values of primary key

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "phone")
	private String phone;
 
	@Column(name = "zip")
	private String zip;
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.ANY)
//	@CreationTimestamp
//	@Column(name = "createDate")
//	private LocalDate createDate;
//
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.ANY)
//	@UpdateTimestamp
//	@Column(name = "updateDate")
//	private LocalDate updateDate;

	public AddressBook() {
		
	}
	public AddressBook(long id, String name, String address, String city, String state, String phone, String zip,
			LocalDate createDate, LocalDate updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.zip = zip;
//		this.createDate = createDate;
//		this.updateDate = updateDate;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

//	public LocalDate getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(LocalDate createDate) {
//		this.createDate = createDate;
//	}
//
//	public LocalDate getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(LocalDate updateDate) {
//		this.updateDate = updateDate;
//	}

}
