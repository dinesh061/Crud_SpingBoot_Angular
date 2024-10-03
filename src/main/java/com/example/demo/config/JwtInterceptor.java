package com.example.demo.config;

import com.example.demo.utils.JwtUtils;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@Component
public class JwtInterceptor extends WebRequestHandlerInterceptorAdapter {

    public JwtInterceptor(WebRequestInterceptor requestInterceptor) {
		super(requestInterceptor);
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private JwtUtils jwtUtils;

//    private RequestMeta requestMeta;

//    public JwtInterceptor(RequestMeta requestMeta){
//        this.requestMeta = requestMeta;
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String auth = request.getHeader("authorization");
        System.out.println(request.getRequestURI());
        if( !(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))){
            jwtUtils.verify(auth);

//            requestMeta.setUserName(claims.get("name").toString());
//////            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
//////            requestMeta.setUserType(claims.get("type").toString());
//////            requestMeta.setEmailId(claims.get("emailId").toString());
////
      }
//
        return super.preHandle(request, response, handler);
   }
    
//    @Bean
//    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{
//    	
//    	http.oauth2Login(Customizer.withDefaults());
//    	return http.build();
//    }
}
