package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.common.APIResponse;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeSaveDto;
import com.example.demo.dto.EmployeeUpdateDto;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Component
public class EmployeeDao {

	
	 @Autowired
	  private EmployeeRepo employeeRepo;
	 
	public String addEmployeeDao(EmployeeSaveDto employeeSaveDTO) {
		  java.util.Date date = new java.util.Date(); 
			Employee employee = new Employee(
					employeeSaveDTO.getUserId(),
					employeeSaveDTO.getUserName(),
					employeeSaveDTO.getEmail(),
					employeeSaveDTO.getCollegeName(),
					employeeSaveDTO.getPercentage(),
					employeeSaveDTO.getPhoneNumber(),
					employeeSaveDTO.getEmployeeId(),
					employeeSaveDTO.getDesignation(),
					employeeSaveDTO.getDepartment(),
					employeeSaveDTO.getAddress(),
					employeeSaveDTO.getGender(),
					employeeSaveDTO.getDob(),
					employeeSaveDTO.getRole(),
					employeeSaveDTO.getBloodGroup(),
					employeeSaveDTO.getCreatedBy(),
					date,
					employeeSaveDTO.getIsActive()
					
		        );
			employeeRepo.save(employee);
		 return employee.getUserName();

	}

	public List<EmployeeDto> getAllEmployeeDao() {
		 List<Employee> getEmployee = employeeRepo.findAll();
	       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	       for(Employee a:getEmployee)
	       {
	    	   EmployeeDto employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                 
	                  
	           );
	    	   employeeDTOList.add(employeeDto);
	       }
	     
	       return  employeeDTOList;
	}

	public String updateEmployeeDao(EmployeeUpdateDto employeeUpdateDTO) {
		
		  java.util.Date date = new java.util.Date(); 
			 if (employeeRepo.existsById(employeeUpdateDTO.getUserId())) {
				 Employee employee = employeeRepo.getById(employeeUpdateDTO.getUserId());
		           
		            employee.setUserName(employeeUpdateDTO.getUserName());
		            employee.setEmail(employeeUpdateDTO.getEmail());
		            employee.setCollegeName(employeeUpdateDTO.getCollegeName());
		            employee.setPercentage(employeeUpdateDTO.getPercentage());
		            employee.setPhoneNumber(employeeUpdateDTO.getPhoneNumber());
		            employee.setEmployeeId(employeeUpdateDTO.getEmployeeId());
		            employee.setDesignation(employeeUpdateDTO.getDesignation());
		            employee.setDepartment(employeeUpdateDTO.getDepartment());
		            employee.setAddress(employeeUpdateDTO.getAddress());
		            employee.setGender(employeeUpdateDTO.getGender());
		            employee.setDob(employeeUpdateDTO.getDob());
		            employee.setRole(employeeUpdateDTO.getRole());
		            employee.setBloodGroup(employeeUpdateDTO.getBloodGroup());
		            employee.setUpdatedBy(employeeUpdateDTO.getUpdatedBy());
		            employee.setUpdateOn(date);
		            employee.setIsActive(employeeUpdateDTO.getIsActive());
		            employeeRepo.save(employee);
		            return "updated";
		            
		        }
		            else
		            {  
		                System.out.println("Customer ID do not Exist");
		                return "ID do not Exist";
		            }
		
	}

	public boolean deleteEmployeeDao(int id) {
	

        if(employeeRepo.existsById(id))
        {
        	employeeRepo.deleteByEmployee(id);
        }
        else
        {
            System.out.println("customer id not found");
        }
        
		return false;
	}
	
	public boolean deleteAllEmployeeDao() {
		
		 employeeRepo.deleteAllEmployee();
		 return false;
	}
	
	
	public boolean deleteMultipleEmployeeDao(List<Integer> userId) {
		
		employeeRepo.deleteMultipleEmployee(userId);
		 return false;
	}


	public List<EmployeeDto> getIndividualCustomerDao(String percentage) {
	
		 if(percentage == null) {
	    	   List<Employee> getEmployee = employeeRepo.findAll();
		       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	    	   for(Employee a:getEmployee)
		       {
		    	   EmployeeDto employeeDto = new EmployeeDto(
		                  a.getUserId(),
		                  a.getUserName(),
		                  a.getEmail(),
		                  a.getCollegeName(),
		                  a.getPercentage(),
		                  a.getPhoneNumber(),
		                  a.getEmployeeId(),
		                  a.getDesignation(),
		                  a.getDepartment(),
		                  a.getAddress(),
		                  a.getGender(),
		                  a.getDob(),
		                  a.getRole(),
		                  a.getBloodGroup()
		                  
		           );
		    	   employeeDTOList.add(employeeDto);
		       }
		       return  employeeDTOList;
		}
	       else {
	    	   
	    	   List<Employee> getEmployee = employeeRepo.findAllBypercentage(percentage);
	    	   List<EmployeeDto> employeeDTOList = new ArrayList<>();
	    	   for(Employee a:getEmployee)
		       {
		    	   EmployeeDto employeeDto = new EmployeeDto(
		                  a.getUserId(),
		                  a.getUserName(),
		                  a.getEmail(),
		                  a.getCollegeName(),
		                  a.getPercentage(),
		                  a.getPhoneNumber(),
		                  a.getEmployeeId(),
		                  a.getDesignation(),
		                  a.getDepartment(),
		                  a.getAddress(),
		                  a.getGender(),
		                  a.getDob(),
		                  a.getRole(),
		                  a.getBloodGroup()
		                  
		           );
		    	   employeeDTOList.add(employeeDto);
	    
	    	   
	       }
	    		 return  employeeDTOList;
	       }
		
	      
	
	}

	public List<EmployeeDto> getIndividualCustomermultipleparamsDao(Set<String> percentage) {
	     if(percentage == null) {
	    	   List<Employee> getEmployee = employeeRepo.findAll();
		       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	    	   for(Employee a:getEmployee)
		       {
		    	   EmployeeDto employeeDto = new EmployeeDto(
		                  a.getUserId(),
		                  a.getUserName(),
		                  a.getEmail(),
		                  a.getCollegeName(),
		                  a.getPercentage(),
		                  a.getPhoneNumber(),
		                  a.getEmployeeId(),
		                  a.getDesignation(),
		                  a.getDepartment(),
		                  a.getAddress(),
		                  a.getGender(),
		                  a.getDob(),
		                  a.getRole(),
		                  a.getBloodGroup()
		                  
		           );
		    	   employeeDTOList.add(employeeDto);
		       }
		       return  employeeDTOList;
		}
	       else {
	    	   
	    	   List<Employee> getEmployee = employeeRepo.findAllBypercentageIn(percentage);
	    	   List<EmployeeDto> employeeDTOList = new ArrayList<>();
	    	   for(Employee a:getEmployee)
		       {
		    	   EmployeeDto employeeDto = new EmployeeDto(
		                  a.getUserId(),
		                  a.getUserName(),
		                  a.getEmail(),
		                  a.getCollegeName(),
		                  a.getPercentage(),
		                  a.getPhoneNumber(),
		                  a.getEmployeeId(),
		                  a.getDesignation(),
		                  a.getDepartment(),
		                  a.getAddress(),
		                  a.getGender(),
		                  a.getDob(),
		                  a.getRole(),
		                  a.getBloodGroup()
		                  
		           );
		    	   employeeDTOList.add(employeeDto);   
	       }
	    	   return  employeeDTOList;

	       }
			   
	}

	public EmployeeDto getAllEmployeeIdDao(int userId) {
		
		EmployeeDto employeeDto = new EmployeeDto();
		 List<Employee> getEmployee = employeeRepo.findAllById(userId);
	       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	       for(Employee a:getEmployee)
	       {
	    	    employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                  
	           );
	    	   
	       }
	       return  employeeDto;
	}

	public APIResponse getCaughtExceptionDao(Integer id) {
		  int result = 100/id;

	        APIResponse response = new APIResponse();
	        response.setData(result);

	        return response;
	}

	public List<EmployeeDto> findByEmployeeuserNameAndemailDao(String username, String email) {
		 List<Employee> getEmployee = employeeRepo.findByuserNameAndemail(username,email);
	       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	       for(Employee a:getEmployee)
	       {
	    	   EmployeeDto employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                  
	           );
	    	   employeeDTOList.add(employeeDto);
	       }
	       return  employeeDTOList;
	}

	public List<EmployeeDto> findByEmployeeNameLike(String username) {
		List<Employee> getEmployee = employeeRepo.findByuserNameLike(username);
	       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	       for(Employee a:getEmployee)
	       {
	    	   EmployeeDto employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                  
	           );
	    	   employeeDTOList.add(employeeDto);
	       }
	       return  employeeDTOList;
	}

	public List<EmployeeDto> findByEmployeenameIn(List<String> username) {
		 List<Employee> getEmployee = employeeRepo.findByUsernameIn(username);
	       List<EmployeeDto> employeeDTOList = new ArrayList<>();
	       for(Employee a:getEmployee)
	       {
	    	   EmployeeDto employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                  
	           );
	    	   employeeDTOList.add(employeeDto);
	       }
	       return  employeeDTOList;
	}

	public List<EmployeeDto> findByEmployeeAgeBetweenDao(int percentage1, int percentage2) {
		 List<Employee> getEmployee = employeeRepo.findByAgeBetween(percentage1,percentage2);
	       List<EmployeeDto> employeeDTOList = new ArrayList<>(); 
	       for(Employee a:getEmployee)
	       {
	    	   EmployeeDto employeeDto = new EmployeeDto(
	                  a.getUserId(),
	                  a.getUserName(),
	                  a.getEmail(),
	                  a.getCollegeName(),
	                  a.getPercentage(),
	                  a.getPhoneNumber(),
	                  a.getEmployeeId(),
	                  a.getDesignation(),
	                  a.getDepartment(),
	                  a.getAddress(),
	                  a.getGender(),
	                  a.getDob(),
	                  a.getRole(),
	                  a.getBloodGroup()
	                  
	           );
	    	   employeeDTOList.add(employeeDto);
	       }
	       return  employeeDTOList;
	}

	
	

	
}
