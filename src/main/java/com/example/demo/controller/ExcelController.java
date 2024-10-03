package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.APIResponse;
import com.example.demo.entity.Employee;
import com.example.demo.service.ExcelServiceImpl;


@RestController
@RequestMapping("/upload")
public class ExcelController {

	@Autowired
	private ExcelServiceImpl studentService;
	
	@PostMapping("/upload")
	public List<Employee> uploadExcel(@RequestParam("file") MultipartFile file)
			throws Exception {
		
		List<Employee> employee =studentService.save(file);
		return employee;
		
	}

	
}
