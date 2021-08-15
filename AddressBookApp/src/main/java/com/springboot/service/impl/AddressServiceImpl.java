package com.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.Model.Address;
import com.springboot.repository.AddressRepository;
import com.springboot.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
//setter based injecting // constructor based injecting 
	private AddressRepository addressRepository;
	
	public AddressServiceImpl(AddressRepository addressRepository) {
	super();
	this.addressRepository = addressRepository;
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(long id) {
//		Optional<Address> address =addressRepository.findById(id);
//		if(address.isPresent()) {
//			return address.get(); // get method is basically return content of Optional object 
//		}else {
//			throw new ResourceNotFoundException("Address", "Id", id);
//		}
		return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("address", "Id", id));
	}

	@Override
	public Address updateAddress(Address address, long id) {
		// now first we will check the data will be existing or Not //
		Address existingAddress =addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("address", "Id", id));
		existingAddress.setName(address.getName());
		existingAddress.setCity(address.getCity());
		existingAddress.setState(address.getState());
		existingAddress.setZip(address.getZip());
		existingAddress.setPhone(address.getPhone());
		//once set the address AFTER we are Save to DB//
		addressRepository.save(existingAddress);
		return existingAddress;
	}

	@Override
	public void deleteAddress(long id) {
		//check whether a address exist an DB or NOT ? //
		addressRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		addressRepository.deleteById(id);
	}
	
}
