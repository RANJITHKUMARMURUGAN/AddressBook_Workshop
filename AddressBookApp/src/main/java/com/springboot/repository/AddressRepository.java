package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
