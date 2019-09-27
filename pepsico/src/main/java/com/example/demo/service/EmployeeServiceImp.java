package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee emp) {
		System.out.println(emp.toString());
		return employeeRepository.save(emp);
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> emp = new ArrayList<>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;
	}

	@Override
	public Employee getbyId(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findEmpByDestination(String dest) {
		
		return employeeRepository.findBydestination(dest);
	}

	
}
