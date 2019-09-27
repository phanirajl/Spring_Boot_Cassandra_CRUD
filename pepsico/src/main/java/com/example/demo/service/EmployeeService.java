package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee emp);
	void delete(Integer id);
	List<Employee> getEmployees();
	Employee getbyId(Integer id);
	List<Employee> findEmpByDestination(String dest);
	
}
