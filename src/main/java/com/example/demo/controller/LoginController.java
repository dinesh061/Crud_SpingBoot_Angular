package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.APIResponse;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.SignUpRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.utils.JwtUtils;


@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;
	
	  @Autowired
	 private LoginService loginService;
	  
	  
	  @Autowired
	  private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO ){

        APIResponse apiResponse = loginService.signUp(signUpRequestDTO);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    
    @PostMapping("/login")
    public APIResponse login(@RequestBody LoginRequestDTO loginRequestDTO) {
    	System.out.print("login");
    	  APIResponse apiResponse = loginService.login(loginRequestDTO);


        return apiResponse;
    }
    
    @GetMapping("/privateApi")
    public ResponseEntity<APIResponse> privateApi(@RequestHeader(value = "authorizaDineshtion", defaultValue = "") String auth) throws Exception {
        APIResponse apiResponse =new APIResponse();

        jwtUtils.verify(auth);

        apiResponse.setData("this is private api");
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
