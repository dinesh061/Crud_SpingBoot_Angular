package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import com.example.demo.common.APIResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repo.ExcelRepo;




@Service
public class ExcelServiceImpl {
	@Autowired
	private ExcelRepo  studentRepository;
	int id = 0;
	ArrayList <Employee> list = new ArrayList<>();
	
	
	 Date d = new Date();
	public List<Employee> save(MultipartFile file) throws EncryptedDocumentException, IOException {
		APIResponse response = new APIResponse();	
		List<Employee> errorList = new ArrayList<>();
		List<Employee> successList = new ArrayList<>();
		 List<List<String>> rows = new ArrayList<>();

		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		
		Sheet sheet = workbook.getSheetAt(2);
		// Iterator<Row> rowIterator = sheet.iterator();
		rows = StreamSupport.stream(sheet.spliterator(), false)
				.map(row -> StreamSupport
				.stream(row.spliterator(), false)
				.map(this::getCellStringValue)
				.collect(Collectors.toList()))
				.collect(Collectors.toList());
		System.out.println("rows :: " + rows);
		
		// Save data to the database
		List<Employee> excelDataList = rows.stream().map(row -> {
		
//			Employee excelData = new Employee(row.get(1),row.get(2),row.get(3),row.get(4).toString(),row.get(5).toString(),row.get(6).toString(),row.get(7).toString(),row.get(8),row.get(9),row.get(10),row.get(11),row.get(12),row.get(13),row.get(14),d,row.get(15),d,row.get(16));
			Employee excelData = new Employee();
//			excelData.setUserName(row.get(1));
//			excelData.setEmail(row.get(2));
//			excelData.setCollegeName(row.get(3));
//			excelData.setPhoneNumber(row.get(4));
//			excelData.setPercentage(row.get(5));
//			excelData.setEmployeeId(row.get(6));
//			excelData.setDesignation(row.get(7));
//			excelData.setAddress(row.get(8));
//			excelData.setRole(row.get(9));
//			excelData.setDepartment(row.get(10));
//			excelData.setGender(row.get(11));
//			excelData.setBloodGroup(row.get(12));
//			
//			excelData.setCreatedBy(row.get(14));
//			excelData.setUpdatedBy(row.get(15));
//			
//			excelData.setIsActive(row.get(16));
//			int number = 0 ;
//			try {
//			     number = (int) Double.parseDouble(row.get(0));
//			    System.out.println(number); // prints 1055.0
//			} catch (NumberFormatException e) {
//			    System.out.println("Invalid number input");
//			}
//			int id= Integer.valueOf();
//			excelData.setUserId(number);
			excelData.setUserName(row.get(0));
			excelData.setEmail(row.get(1));
			excelData.setCollegeName(row.get(2));
			excelData.setPhoneNumber(row.get(3));
			excelData.setPercentage(row.get(4));
			excelData.setEmployeeId(row.get(5));
			excelData.setDesignation(row.get(6));
			excelData.setAddress(row.get(7));
			excelData.setRole(row.get(8));
			excelData.setDepartment(row.get(9));
			excelData.setGender(row.get(10));
			excelData.setBloodGroup(row.get(11));
			excelData.setCreatedBy(row.get(12));
			excelData.setCreatedOn(d);
			excelData.setUpdatedBy(row.get(13));
			excelData.setUpdateOn(d);
       		excelData.setIsActive("TRUE");
			
			return excelData;
			
		}).collect(Collectors.toList());
		
		System.out.println("excelDataList"+excelDataList);
		
		List<String> employeeIdList = studentRepository.findAllByEmployeeId();
		System.out.println("employeeIdList"+employeeIdList);
		
		ArrayList <String> list = new ArrayList<>();
		for(Employee l : excelDataList) {
			System.out.println(list);
			System.out.println(l.getEmployeeId());
			
		 if(!employeeIdList.contains(l.getEmployeeId()) ) {
			 list.add(l.getEmployeeId());
			 
				studentRepository.save(l);
				employeeIdList = studentRepository.findAllByEmployeeId();
				
				Employee errorSuccess = new Employee();
				
//				int id= Integer.valueOf();
//				errorSuccess.setUserId(l.getUserId());
				errorSuccess.setUserName(l.getUserName());
				errorSuccess.setEmail(l.getEmail());
				errorSuccess.setCollegeName(l.getCollegeName());
				errorSuccess.setPhoneNumber(l.getPhoneNumber());
				errorSuccess.setPercentage(l.getPercentage());
				errorSuccess.setEmployeeId(l.getEmployeeId());
				errorSuccess.setDesignation(l.getDesignation());
				errorSuccess.setAddress(l.getAddress());
				errorSuccess.setRole(l.getRole());
				errorSuccess.setDepartment(l.getDepartment());
				errorSuccess.setGender(l.getGender());
				errorSuccess.setBloodGroup(l.getBloodGroup());
				errorSuccess.setCreatedBy(l.getCreatedBy());
				errorSuccess.setCreatedOn(d);
				errorSuccess.setUpdatedBy(l.getUpdatedBy());
				errorSuccess.setUpdateOn(d);
				errorSuccess.setIsActive("TRUE");
				
				successList.add(errorSuccess);
				System.out.println("saved");
				response.setData(" User Inserted successFully : "+successList);
				
//                return response;
			}
			else {
				
	           Employee errorData = new Employee();
				
//				int id= Integer.valueOf();
//				errorData.setUserId(l.getUserId());
				errorData.setUserName(l.getUserName());
				errorData.setEmail(l.getEmail());
				errorData.setCollegeName(l.getCollegeName());
				errorData.setPhoneNumber(l.getPhoneNumber());
				errorData.setPercentage(l.getPercentage());
				errorData.setEmployeeId(l.getEmployeeId());
				errorData.setDesignation(l.getDesignation());
				errorData.setAddress(l.getAddress());
				errorData.setRole(l.getRole());
				errorData.setDepartment(l.getDepartment());
				errorData.setGender(l.getGender());
				errorData.setBloodGroup(l.getBloodGroup());
				errorData.setCreatedBy(l.getCreatedBy());
				errorData.setCreatedOn(d);
				errorData.setUpdatedBy(l.getUpdatedBy());
				errorData.setUpdateOn(d);
				errorData.setIsActive("TRUE");
				
				errorList.add(errorData);
				
				response.setError("Already Exists : "+errorList);
			
//				return response;
				
			}
		}
		return errorList ;
	}
//		response.setData("Not");
		
//		return response;
	
	
	
	private String getCellStringValue(Cell cell) {
		CellType cellType = cell.getCellType();

		if (cellType == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cellType == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cellType == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}

		return null;
	}
}
