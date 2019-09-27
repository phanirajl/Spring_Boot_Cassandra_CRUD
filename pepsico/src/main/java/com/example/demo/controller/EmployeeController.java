package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImp;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImp employeeService;
	
	@PostMapping("/create/emp")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeService.save(emp), HttpStatus.OK);
	}
	
	@GetMapping("/get/emp")
	public ResponseEntity<List<Employee>> getAllemp()
	{
		
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/get/emp/{id}")
	public ResponseEntity<Employee> getEmpbyId(@PathVariable(name="id") Integer id)
	{
		return new ResponseEntity<Employee>(employeeService.getbyId(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> UpdateEmployee(@PathVariable(name="id") Integer id,@RequestBody Employee emp)
	{
		Employee empData = employeeService.getbyId(id);
		
		if(empData==null)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		emp.setId(id);
		employeeService.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable(name="id") Integer id)
	{
		employeeService.delete(id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
}
