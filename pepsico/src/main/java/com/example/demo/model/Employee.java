package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table("employee")
public class Employee {
	
	@PrimaryKey
	@Column(value="id")
	private Integer id;
	@Column(value="name")
	private String name;
	@Column(value="salary")
	private float salary;
	@Column(value="destination")
	private String destination;
	@Column(value="home_manager")
	private String homeManager;
	
}
