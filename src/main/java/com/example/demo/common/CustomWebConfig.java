package com.example.demo.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.config.JwtInterceptor;

@Configuration
public class CustomWebConfig  implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

//    @Bean
//    @RequestScope
//    public RequestMeta getRequestMeta(){
//        return new RequestMeta();
//    }
//
//    @Bean
//    public JwtInterceptor jwtInterceptor(){
//        return new JwtInterceptor(getRequestMeta());
//    }
}
