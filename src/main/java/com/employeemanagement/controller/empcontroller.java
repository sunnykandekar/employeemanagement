package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.ServiceRepositories.empRepository;
import com.employeemanagement.model.employee;

@RestController
@CrossOrigin
public class empcontroller {

	@Autowired
	private empRepository empRepo;

	@GetMapping("/getAllEmployee")
	public List<employee> getAllEmployee() {
		try {
			return empRepo.getAllEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getEmployeeById/{id}")
	public employee getEmployeeById(@PathVariable int id) {
		try {
			return empRepo.getEmployeeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	};

	@PostMapping("/addEmployee")
	public employee addEmp(@RequestBody employee emp) {
		try {
			return empRepo.addemp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@PutMapping("/updateEmp")
	public employee updateEmp(@RequestBody employee updateEmp) {
		try {

			employee result = empRepo.updateEmp(updateEmp);
			return result;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return updateEmp;
	}

	@DeleteMapping("deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id) {
		try {
		 empRepo.deleteEmp(id);
		  return "Employee with ID " + id + " deleted successfully.";
		} catch (Exception e) {
			e.printStackTrace();

		}
		  return "Failed to delete employee with ID :-" + id;
	}
}
