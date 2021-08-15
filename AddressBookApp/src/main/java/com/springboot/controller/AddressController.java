package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.Address;
import com.springboot.service.AddressService;

import java.util.*;
@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	private AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	//build create Address REST API
//	@PostMapping
//	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
//		return new ResponseEntity<Address>(addressService.saveAddress(address), HttpStatus.CREATED);
//	}
	
	@PostMapping
	public ResponseEntity<Address>saveAddress(@RequestBody Address address){
		return new ResponseEntity<Address>(addressService.saveAddress(address), HttpStatus.OK);
	}
	
	//build to get All Address from Rest API
	@GetMapping
	public List<Address> getAllAddress(){
		return addressService.getAllAddress();
	}
	
	//Build get Address by id Rest API
	//http://localhost:8080/api/address/1    like that
	@GetMapping("{id}")
	public  ResponseEntity<Address> getAddressById(@PathVariable("id") long addressId){
		return new ResponseEntity<Address>(addressService.getAddressById(addressId), HttpStatus.OK);
	}
	
	//build a Update address to Rest API//
	//http://localhost:8080/api/address/1
	@PutMapping("{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") long id,@RequestBody Address address){
		return new ResponseEntity<Address>(addressService.updateAddress(address, id),HttpStatus.OK);
	}
	
	//build a Delete address Rest API//
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteAddress(@PathVariable("id") long id){
		addressService.deleteAddress(id);
		return new ResponseEntity<String>("Address deleted Successfully..!", HttpStatus.OK);
	}
}

