package com.example.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee,Integer>{
	
	@Query(allowFiltering = true)
	List<Employee> findBydestination(String destination);

}
