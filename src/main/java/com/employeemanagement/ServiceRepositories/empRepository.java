package com.employeemanagement.ServiceRepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employeemanagement.model.employee;

@Repository
public interface empRepository 
{
	public List<employee> getAllEmployee();
	
	public employee getEmployeeById(int id);
	
	public employee addemp(employee emp);

	public employee updateEmp(employee emp);
	public void deleteEmp(int id);
}
