package com.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages="com.employeemanagement.model")
@RestController
public class EmployeemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);

		System.out.println("EmployeemanagementApplication Run Success");
	}
	
	@GetMapping("/")
	public String home()
	{
	
		return "EmployeemanagementApplication Run Success";
	}

}
