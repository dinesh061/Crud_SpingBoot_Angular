package com.example.demo.dto;

public class EmployeeUpdateDto {

	private int userId;
	
	private String userName;
	
	private String email;
	
	private String collegeName;
	
	private String percentage;
	
	private String phoneNumber;
	
	private String employeeId;
	
	private String designation;
	
	private String department;
	
	private String address;
	
	private String gender;
	
	private String dob;
	
	private String role;

	private String bloodGroup;
	
	private String updatedBy;
	
	private String updatedOn;
	
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	private String isActive;
	
	
	
	public EmployeeUpdateDto(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup, String updatedBy, String isActive) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.collegeName = collegeName;
		this.percentage = percentage;
		this.phoneNumber = phoneNumber;
		this.employeeId = employeeId;
		this.designation = designation;
		this.department = department;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.bloodGroup = bloodGroup;
		this.updatedBy = updatedBy;
		this.updatedOn=updatedOn;
		this.isActive = isActive;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public EmployeeUpdateDto(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup) {
	
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.collegeName = collegeName;
		this.percentage = percentage;
		this.phoneNumber = phoneNumber;
		this.employeeId = employeeId;
		this.designation = designation;
		this.department = department;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.bloodGroup = bloodGroup;
	}
	public EmployeeUpdateDto() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
