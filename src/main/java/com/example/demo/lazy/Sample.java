package com.example.demo.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class Sample {

	public Sample() {
		System.out.println("lazy");
	}

	
	
}
