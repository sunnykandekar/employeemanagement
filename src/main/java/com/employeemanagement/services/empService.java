package com.employeemanagement.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employeemanagement.ServiceRepositories.empRepository;
//import com.employeemanagement.model.employee;
import com.employeemanagement.model.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//@Service
@Repository
@Transactional
public class empService implements empRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<employee> getAllEmployee() {
		try {

			List<employee> result = entityManager.createQuery("select e from employeedetails e", employee.class)
					.getResultList();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public employee getEmployeeById(int id) {

		return entityManager.find(employee.class, id);
	};

	public employee addemp(employee emp) {
		try {
			entityManager.persist(emp);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public employee updateEmp(employee emp) {
		employee Result = null;
		try {
			employee existingEmp = entityManager.find(employee.class, emp.getId());

			if (existingEmp != null) {
				existingEmp.setName(emp.getName());
				existingEmp.setEmail(emp.getEmail());
				existingEmp.setDepartment(emp.getDepartment());
				existingEmp.setSalary(emp.getSalary());

				Result = entityManager.merge(existingEmp);
				return Result;
			} else {
				 throw new RuntimeException("ID not Found :-" + emp.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;

	}
	
	public void deleteEmp(int id)
    { 
	employee existEmp=	entityManager.find(employee.class, id);
		
      if(existEmp !=null)
      {
    	  
    	  entityManager.remove(existEmp);
      }
      else {
    	  throw new RuntimeException("Id doesn't Exits :-"+id);
    	  
      }
 	
	}
	
	
}
