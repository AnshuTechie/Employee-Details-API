package com.employees.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.employees.api.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	
	public Employee findById( int Id);

}
// Check