package com.employees.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.api.entities.Employee;
import com.employees.api.service.EmployeeService;


@RestController
@RequestMapping("/check") 
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;

   @GetMapping("/getployees") 
   public ResponseEntity<List<Employee>> getEmployees ()
   { 

		List<Employee> list=employeeService.getAllEmployees();

        if(list.size()<=0)
        {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
            }
        return ResponseEntity.status(HttpStatus.CREATED). body (list);
   }
   
   @PostMapping("/postemployees")
   public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee)
   {

      Employee b=null;
      try
      {
        b=this.employeeService.addEmployee (employee);
        System.out.println(employee); 
        return ResponseEntity.of(Optional.of(b));
      } 
      catch (Exception e)
      {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
   
   @DeleteMapping("/employees/{employeeld)")
   public ResponseEntity<Void> deleteEmployee (@PathVariable("employeeld")int employeeld)
   {
    try
    {
      this.employeeService.deleteEmployee (employeeld); 
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    } 
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   }
   
   @PutMapping("/employees/{employeeld)")
   public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee,@PathVariable("employeeld")int employeeld)
   {
     try {
     this.employeeService.updateEmployee (employee, employeeld);
     return ResponseEntity.ok().build();
     } 
   catch(Exception e)
    {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus. INTERNAL_SERVER_ERROR).build();
    }
   }
   

}


