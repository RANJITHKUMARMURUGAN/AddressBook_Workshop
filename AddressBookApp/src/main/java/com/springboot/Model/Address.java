package com.springboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="info")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation specifies the 
	private long id;                                //generation strategies for the values of primary key 
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="sate")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="phone")
	private String phone;
}
