package com.springboot.service;

import com.springboot.Model.Address;
import java.util.List;
public interface AddressService {
	Address saveAddress(Address address);
	List<Address>getAllAddress();
	Address getAddressById(long id);
	Address updateAddress(Address address, long id);
	void deleteAddress(long id);
}
