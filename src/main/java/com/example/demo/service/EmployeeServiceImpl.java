package com.example.demo.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.APIResponse;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeSaveDto;
import com.example.demo.dto.EmployeeUpdateDto;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Transactional
@Service

public class EmployeeServiceImpl implements Service{

	  @Autowired
	  private EmployeeRepo employeeRepo;
	  @Autowired
	  private EmployeeDao employeeDao;
	  
	 Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	 
	 ///add method
	public String addEmployee(EmployeeSaveDto employeeSaveDTO) {
	
	   logger.debug("In service addEmployee debug");
	  return  employeeDao.addEmployeeDao(employeeSaveDTO);
	  
	     	}
	
	
    ///get all method
	public List<EmployeeDto> getAllEmployee() {
		
	     
	       return  employeeDao.getAllEmployeeDao();
	}

	
	//update method
	public String updateEmployee(EmployeeUpdateDto employeeUpdateDTO) {
		
	                return employeeDao.updateEmployeeDao(employeeUpdateDTO);
	}

	
	//delete method
	public boolean deleteEmployee(int id) {
		
        return employeeDao.deleteEmployeeDao(id) ;
	}


	//deleteAll
	public boolean deleteAllEmployee() {
		
		 return employeeDao.deleteAllEmployeeDao() ;
	}
	
	
   //deleteMultiple
	public boolean deleteMultipleEmployee(List<Integer> userId) {
		
		 return employeeDao.deleteMultipleEmployeeDao(userId) ;
	}

	
	
	//geteEmployeeUsingSingleParams
	public List<EmployeeDto> getIndividualCustomer(String percentage) {
	
	      return employeeDao.getIndividualCustomerDao(percentage);
	      
	}
	
	
	//geteEmployeeUsingMultipleParams
	public List<EmployeeDto> getIndividualCustomermultipleparams(Set<String> percentage) {
		
			      
	     return employeeDao.getIndividualCustomermultipleparamsDao(percentage);
	
	}
	

    //getEmployeeUsingId
	public  EmployeeDto getAllEmployeeId(int userId) {
		
		return employeeDao.getAllEmployeeIdDao(userId);
		
	}

	
	
	//exception
	public APIResponse getCaughtException(Integer id) {

        return employeeDao.getCaughtExceptionDao(id);
    }
	
	
	//findByEmployeeuserNameAndemail
	 public List<EmployeeDto> findByEmployeeuserNameAndemail(String username ,String email) {
		
	       return employeeDao.findByEmployeeuserNameAndemailDao(username,email);
	 }

	 
	 //findByEmployeeNameLike
	public List<EmployeeDto> findByEmployeeNameLike(String username) {
		 
	       return employeeDao.findByEmployeeNameLike(username);
	}

	

	//findByEmployeenameIn
	public List<EmployeeDto> findByEmployeenameIn(List<String> username) {
		
	       return employeeDao.findByEmployeenameIn(username);
	}

	
	//findByEmployeeAgeBetween
	public List<EmployeeDto> findByEmployeeAgeBetween(int percentage1,int percentage2) {
		
	       return employeeDao.findByEmployeeAgeBetweenDao(percentage1,percentage2);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	/////////////unwanted//////////////////
	
	public List<Employee> findAllById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String value() {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
}
