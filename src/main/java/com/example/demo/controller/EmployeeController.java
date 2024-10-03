package com.example.demo.controller;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.APIResponse;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeSaveDto;
import com.example.demo.dto.EmployeeUpdateDto;
import com.example.demo.service.EmployeeServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee")
public class EmployeeController {

	    @Autowired
	    private EmployeeServiceImpl employeeServiceImpl;
	    @PostMapping(path = "/save")
	    public String saveCustomer(@RequestBody EmployeeSaveDto employeeSaveDTO)
	    {
	        String id = employeeServiceImpl.addEmployee(employeeSaveDTO);
	        return id;
	    }
	    
	    @GetMapping(path = "/getAllCustomer")
	    public List <EmployeeDto> getAllCustomer()
	    {
	       List<EmployeeDto> allEmployees = employeeServiceImpl.getAllEmployee();
	       return allEmployees;
	    }
	    

	    @PutMapping(path = "/update")
	    public String updateCustomer(@RequestBody EmployeeUpdateDto employeeUpdateDTO)
	    {
	        String id = employeeServiceImpl.updateEmployee(employeeUpdateDTO);
	        return id;
	    }
	    
	    
	    @DeleteMapping(path = "/deleteemployee/{id}")
	    public String deleteCustomer(@PathVariable(value = "id") int id)
	    {   System.out.println("deleyte");
	        boolean deletecustomer = employeeServiceImpl.deleteEmployee(id);
	        return "deleted";
	    }
	    
	    @DeleteMapping(path = "/deleteAllemployee")
	    public String deleteAllCustomer()
	    {   System.out.println("deleyte");
	        boolean deletecustomer = employeeServiceImpl.deleteAllEmployee();
	        return "deleted";
	    }
	    
	    
	    @DeleteMapping(path = "/deleteMultipleemployee")
	    public String deleteMultipleCustomer(@RequestParam(value="userId")  List<Integer >userId)
	    {   System.out.println("deleyte.....................");
	        boolean deletecustomer = employeeServiceImpl.deleteMultipleEmployee(userId);
	        return "deleted";
	    }

	    
	    @GetMapping(path = "/getAllCustomerid/{id}")
	    public EmployeeDto getAllCustomerid( @PathVariable("id") int userId)
	    {System.out.println("deleyte");
	    	EmployeeDto Employeedto = employeeServiceImpl.getAllEmployeeId(userId);
	        return Employeedto;
	    }
	    
	    
	    @GetMapping(path = "/getAllCustomers")
	    public List <EmployeeDto> getIndividualCustomer(@RequestParam(value="percentage",required=false)String percentage)
	    {
	       List<EmployeeDto> allEmployees = employeeServiceImpl.getIndividualCustomer(percentage);
	       return allEmployees;
	    }
	    
	    @GetMapping(path = "/getAllCustomerss/multipleparams")
	    public List <EmployeeDto> getIndividualCustomermultipleparams(@RequestParam(value="percentage",required=false)Set<String> percentage)
	    {
	       List<EmployeeDto> allEmployees = employeeServiceImpl.getIndividualCustomermultipleparams(percentage);
	       return allEmployees;
	    }
	    
	     @GetMapping("/caughtException")
	     public APIResponse getCaughtException(@RequestParam(value = "number") Integer id) {
	        return employeeServiceImpl.getCaughtException(id);
	     }
	     
	     //findbycolumn1andcoulmn2
	     @GetMapping("/getAllUsernameAndEmails")
		  public List <EmployeeDto> getUsernameAndEmail(@RequestParam(value = "name") String name,@RequestParam(value = "email") String email)
		    {
	    	 System.out.println("controller");
		       List<EmployeeDto> allEmployees = employeeServiceImpl.findByEmployeeuserNameAndemail(name,email);
		       return allEmployees;
		    }
	     
	    // findByColumnNameLike
	     @GetMapping(path = "/getEmployeeNameLikes")
		  public List <EmployeeDto> getEmployeeNameLike(@RequestParam("username") String username)
		    {
	    	 System.out.println("controller");
		       List<EmployeeDto> allEmployees = employeeServiceImpl.findByEmployeeNameLike(username);
		       return allEmployees;
		    }
	     
	     
	  // // findByUsernameIn
	     @GetMapping(path = "/getEmployeeByUsernameIn")
		  public List <EmployeeDto> getEmployeeByUsernameIn(@RequestParam("username") List<String> username)
		    {
	    	 System.out.println("controller");
		       List<EmployeeDto> allEmployees = employeeServiceImpl.findByEmployeenameIn(username);
		       return allEmployees;
		    }
	     
	     //findByAgeBetween
	     @GetMapping(path = "/getEmployeeByAgeBetween")
		  public List <EmployeeDto> getEmployeeByAgeBetween(@RequestParam("percentage1") int percentage1,@RequestParam("percentage2") int percentage2)
		    {
	    	 System.out.println("controller");
		       List<EmployeeDto> allEmployees = employeeServiceImpl.findByEmployeeAgeBetween(percentage1,percentage2);
		       return allEmployees;
		    }
	     
}

