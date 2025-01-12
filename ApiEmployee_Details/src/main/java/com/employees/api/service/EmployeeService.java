package com.employees.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employees.api.dao.EmployeeRepository;
import com.employees.api.entities.Employee;

public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees()
	{
		List<Employee> list = (List<Employee>) this.employeeRepository.findAll(); 
		return list;
    }

	public Employee addEmployee(Employee b) 
	{
        Employee result=this.employeeRepository.save(b); 
		return result;
    }

	public void deleteEmployee(int bid)
	{
       employeeRepository.deleteById(bid);
    }
	
	public void updateEmployee (Employee employee, int employeeId) 
	{
      employee.setId(employeeId); 
      employeeRepository.save(employee);
    }

}
