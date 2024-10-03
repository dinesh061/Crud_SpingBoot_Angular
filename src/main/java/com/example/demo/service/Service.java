package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeSaveDto;
import com.example.demo.dto.EmployeeUpdateDto;
import com.example.demo.entity.Employee;

public interface Service {

	
	 String addEmployee(EmployeeSaveDto customerSaveDTO);
	 
	 List<EmployeeDto> getAllEmployee();
	 
	 String updateEmployee(EmployeeUpdateDto customerUpdateDTO);
	 
	 boolean deleteEmployee(int id);

	List<EmployeeDto> getIndividualCustomer(String percentage);

	
	List<EmployeeDto> getIndividualCustomermultipleparams(Set<String> percentage);
	
	List<Employee> findAllById(int userId);
}
