package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		System.out.println("welcome");
		SpringApplication.run(AddressBookAppApplication.class, args);
		System.out.println("Spring Boot is Rinning Successfully..!");
	}
}
