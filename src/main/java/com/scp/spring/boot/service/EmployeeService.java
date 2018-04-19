package com.scp.spring.boot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scp.spring.boot.entity.Employee;

@Repository
public interface EmployeeService extends JpaRepository<Employee,Integer>{
	
}
