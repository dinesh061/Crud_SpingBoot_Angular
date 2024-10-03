package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.APIResponse;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.SignUpRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.oww;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;



@Service
public class LoginService {

	Date date = new Date();
	
	 static String token ="";
	 static String token1 ="";
	@Autowired
	private oww ww;
	 @Autowired
	    private JwtUtils jwtUtils;
	  @Autowired
	  private UserRepository userRepository;
	  @Autowired
	  private HttpServletRequest request;
	    
	 public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
	        APIResponse apiResponse = new APIResponse();

	        // validation

	        // dto to entity
	        User userEntity = new User();
	        userEntity.setName(signUpRequestDTO.getName());
	        userEntity.setEmailId(signUpRequestDTO.getEmailId());
	        userEntity.setActive(Boolean.TRUE);
	        userEntity.setGender(signUpRequestDTO.getGender());
	        userEntity.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
	        userEntity.setPassword(signUpRequestDTO.getPassword());
	        userEntity.setCreatedAt(date); 
	        userEntity.setLoginAt(date);
	        userEntity.setUpdatedAt(date);
	       
           
           
	        System.out.println("1");
	       
	        
	       
	      
	        String auth = request.getHeader("authorization");
	        System.out.println("auth"+" "+auth);
	        System.out.println("token"+" "+token);
//	        
//	        if(auth.toString() == token.toString()){
//	        	userEntity = userRepository.save(userEntity);
//	        	apiResponse.setData("User Registered Successfully...");
//	        	 return apiResponse;
//	        }
	        if(userRepository.existsByemailId(signUpRequestDTO.getEmailId())) {
	        	apiResponse.setData("User Already Exists");
		        return apiResponse;
	        }
	        else {
	        	
	        	  if(auth==null) {
	  	        	
	  	            
	  	        	User newUser = new User();
	  	        	Long id =(long) 0;
	  	        	newUser.setId(id);
	  	        	newUser.setName(signUpRequestDTO.getName());
	  	        	newUser.setEmailId(signUpRequestDTO.getEmailId());
	  	        	newUser.setActive(Boolean.TRUE);
	  	        	newUser.setGender(signUpRequestDTO.getGender());
	  	        	newUser.setPhoneNumber(signUpRequestDTO.getPhoneNumber());
	  	        	newUser.setPassword(signUpRequestDTO.getPassword());
	  	        	newUser.setCreatedAt(date); 
	  	        	newUser.setLoginAt(date);
	  	        	newUser.setUpdatedAt(date);
	  	        	
	  	        	System.out.println(newUser.getEmailId());
	  	        	
	  	        	token =  jwtUtils.generateJwt(newUser);
	  	        	  ww.sendSimpleEmail(signUpRequestDTO.getEmailId(), "Email Verification", token);
	  	        	 Map<String , Object> data = new HashMap<>();
	  	 	        data.put("accessToken", token);

	  	 	        apiResponse.setData(data);
	  	 	       return apiResponse;
	  	        }
	  	        else {

	  		        if(auth.equalsIgnoreCase(token.toString())){
	  		        	userEntity = userRepository.save(userEntity);
	  		        	apiResponse.setData("User Registered Successfully...");
	  		        	 return apiResponse;
	  		        }
	  		        else {
	  		          apiResponse.setData("Invalid Token");
		  		        return apiResponse;
	  		        }
	  	        }
	        	  
	        	  
	        }
	      
	        // store entity
	        

	        // generate jwt
	      

	       
	       
	        // return
	       

	      
	    }


	public APIResponse login(LoginRequestDTO loginRequestDTO)  {
		
		
		   APIResponse apiResponse = new APIResponse();
		   
        // verify user exist with given email and password
        User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(), loginRequestDTO.getPassword());
      
        // response
        if(user == null){
            apiResponse.setData("User login failed");
            return apiResponse;
        }
       
        // generate jwt
     
        
        
     
        
        String auth = request.getHeader("authorization");
        
        System.out.println(user);
        System.out.println("token1"+token1);
        System.out.println("auth"+auth);
        
       if(auth!=null) {
    	   if(auth.equalsIgnoreCase(token1)) {
         	  apiResponse.setData("User login Successfully.....");
         	  return apiResponse;
         }
    	   else {
    		   apiResponse.setData("Invalid Token");
          	  return apiResponse;
    	   }
       }
        
        else {
        	try {
        		System.out.println("success");
        		  token1 = jwtUtils.generateJwt(user);
        	}
        	catch(Exception e) {
        		System.out.print("exception"+e);
        	}
        	 System.out.println(token1);
       	

       
        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token1);

        apiResponse.setData(data);
        ww.sendSimpleEmail(loginRequestDTO.getEmailId(), "Email Verification", token1);
        return apiResponse;
        }
        	
	}
}
