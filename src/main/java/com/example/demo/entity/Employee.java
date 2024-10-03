package com.example.demo.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table 
public class Employee {
	
	@Id  
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@Column
	private String email;

	private String collegeName;
	@Column
	private String percentage;
	@Column
	private String phoneNumber;
	@Column
	private String employeeId;
	@Column
	private String designation;
	@Column
	private String department;
	@Column
	private String address;
	@Column
	private String gender;
	@Column
	private String dob;
	@Column
	private String role;
	@Column
	private String bloodGroup;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updateOn;
	private String isActive;
	
	
	public Employee(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup, String createdBy, Date date, String updatedBy,
			Date date2, String isActive) {
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
		this.createdBy = createdBy;
		this.createdOn = date;
		this.updatedBy = updatedBy;
		this.updateOn = date2;
		this.isActive = isActive;
	}
	public Employee(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup, Date updateOn, String updatedBy, String isActive) {
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
		this.updateOn = updateOn;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
	}
	public Employee(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup, String createdBy, Date createdOn, String isActive) {
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
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Employee(int userId, String userName, String email, String collegeName, String percentage,
			String phoneNumber, String employeeId, String designation, String department, String address, String gender,
			String dob, String role, String bloodGroup) {
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
	}
	public Employee() {
		super();
	}
	public Employee(int userId2, String userName2, String email2, String collegeName2, String percentage2,
			String phoneNumber2, String employeeId2, String designation2, String department2, String address2,
			String gender2, String dob2, String role2, String bloodGroup2, String createdBy2, long utc,
			String isActive2) {
		// TODO Auto-generated constructor stub
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

