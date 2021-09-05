package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.AddressBook;
import com.springboot.repository.AddressRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class AddressBookController {

	@Autowired
	private AddressRepository addressRepository;

	// get AllAddress
	@GetMapping("/addressbook")
	public List<AddressBook> getAllAddressBook() {
		return addressRepository.findAll();
	}

	// create Address rest API
	@PostMapping("/addressbook")
	public AddressBook createAddressBook(@RequestBody AddressBook addressBook) {
		return addressRepository.save(addressBook);
	}

	// getAddressById
	@GetMapping("/addressbook/{id}")
	public ResponseEntity<AddressBook> getAddressBookById(@PathVariable long id) {
		AddressBook addressBook = addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address Not Existing by id :" + id));
		return ResponseEntity.ok(addressBook);
	}

	// update AddressBook rest API
	@PutMapping("/addressbook/{id}")
	public ResponseEntity<AddressBook> updateAddressBook(@PathVariable long id,
			@RequestBody AddressBook addressDetails) {
		AddressBook addressBook = addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address NOT Existing with id :" + id));

		addressBook.setName(addressDetails.getName());
		addressBook.setAddress(addressDetails.getAddress());
		addressBook.setCity(addressDetails.getCity());
		addressBook.setState(addressDetails.getState());
		addressBook.setPhone(addressDetails.getPhone());
		addressBook.setZip(addressDetails.getZip());
//		addressBook.setCreateDate(addressDetails.getCreateDate());
//		addressBook.setUpdateDate(addressDetails.getUpdateDate());

		AddressBook updateAddressBook = addressRepository.save(addressBook);
		return ResponseEntity.ok(updateAddressBook);
	}

	@DeleteMapping("/addressbook/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAddressBook(@PathVariable Long id) {
		AddressBook addressBook = addressRepository.findById(id) // retrieve the employee with id, and particular id
																	// with database
				.orElseThrow(() -> new ResourceNotFoundException("AddressBook not exist with id :" + id));
		addressRepository.delete(addressBook);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
