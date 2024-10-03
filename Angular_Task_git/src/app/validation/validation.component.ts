import { Component, DoCheck, EventEmitter, Input, OnChanges, Output, SimpleChanges ,} from '@angular/core';
import { student } from '../app.component';
import { TableComponent } from '../table/table.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-validation',
  standalone: true,
  imports: [TableComponent,FormsModule,CommonModule],
  templateUrl: './validation.component.html',
  styleUrl: './validation.component.css'
})
export class ValidationComponent implements DoCheck{
  
  head='kl'
  @Input('data') student!: student;
  @Output() arroutput = new EventEmitter<Object>();

  duplicatedata:any={
    "position":"dk",
  
    "name":"1"
  ,
  
    "weight":"1"
  ,
  
    "symbol":"1"
  
      
  };
  

   arr:any={

  "username":""
,

  "email":""
,

  "collegename":""
,

  "phnumber":""
,

  "Percentage":""
,

  "employid":""
,

  "designation":""
,

  "address":""
,

  "role":""
,

  "department":""
,

  "gender":""
,

  "blood":""
,
"dob":""
    
};
  constructor(){
   
  }

 count=0;
 success=true;

  ngDoCheck(): void {


    if(this.student.usernamevalue === ''){
      this.arr.username="username is required";
      console.log("username is required")
      this.count--;
     
 }
 else{
  this.count++;
  this.arr.username="success";
     console.log("username is valid")
 }


 let emaillength =this.student.emailvalue.length
 if(this.student.emailvalue === ''){
  this.arr.email="Email is required ";
  console.log("Email is required error")
  this.count--;
 }

 else if(!this.student.emailvalue.includes("@") ){
  this.arr.email="Email id must contain @";
  console.log("Email id is weak")
  this.count--;
 }
 else if(emaillength <= 11){
  this.arr.email="error";
  console.log("Email id is less than 11 characters")
  this.count--;
 }
 
 else {
  this.count++;
  this.arr.email="success";
  console.log("Email id is valid")
 }


  let college = String(this.student.collegenamevalue).toLowerCase().includes("college")
 if(this.student.collegenamevalue === ''){
  this.arr.collegename="College name is required";
       console.log("College name is required")
       this.count--;
 }
 else if(!college){
  this.arr.collegename="College name is not valid";
 console.log(" name must contain college word")
 this.count--;
}
 else{
  this.count++;
 this.arr.collegename="success";
  console.log("College name is  valid")
 }


 let phonenumberlength = String(this.student.phnumbervalue).length;
 console.log(phonenumberlength)
  if(this.student.phnumbervalue === ''){
    this.arr.phnumber="Phone number is required";
     console.log("Phone number is required")
     this.count--;
 }
 
 else if( phonenumberlength != 10){
  this.arr.phnumber="Phone number is less than 10 character";
  console.log("Phone number is less than 10 character")
  this.count--;
 }
 else {
  this.count++;
  this.arr.phnumber="success";
  console.log("Phone number is success")
 }



  if(this.student.percentagevalue === '' || this.student.percentagevalue === null){
    this.arr.Percentage="Percentage is required";
      console.log("Percentage is required")
      this.count--;
     
 }   
 else if(Number(this.student.percentagevalue) > 100){
  this.arr.Percentage="Percentage is greater than 100";

  console.log("Percentage is greater than 100")
  this.count--;
 }
 else {
  this.count++;
  this.arr.Percentage="success";
  
  console.log("Percentage is success")
 }


  
  if(this.student.employidvalue === '' || this.student.employidvalue ==null){
    this.arr.employid="Employee id is required";
     console.log("Employee id is required")
     console.log(this.student.employidvalue)
     this.count--;
 }
 
 else if(Number(this.student.employidvalue.length) < 5){
  this.arr.employid="Employee id must contain 5 Digits";
 console.log("Employee id is Invalid")
 console.log()
 console.log(this.student.employidvalue)
 this.count++;
 } 
 else {
  this.count++;
  this.arr.employid="success";
  console.log("Employee id is valid")
  console.log(this.student.employidvalue)
 }



  if(this.student.designationvalue === ''){
    this.arr.designation="Designation is required";
  console.log(" Designation is required")
  this.count--;
 }
 else {
  this.count++;
  this.arr.designation="success";
   console.log("Designation is success")
 }



  if(this.student.addressvalue === ''){
    this.arr.address="Address is required";
  console.log("Address is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.address="success";
  console.log("address success")
 }
 if(this.student.gendervalue === ''){
  this.arr.gender=" Gender is required";
  console.log(" Gender is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.gender="success";
  console.log("Gender is not required")
 }

 if(this.student.departmentvalue === ''){
  this.arr.department=" Department is required";
  console.log("  Department is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.department="success";
  console.log("Department is not required")
 }


 if(this.student.rolevalue === ''){
  this.arr.role=" Role is required";
  console.log(" Role is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.role="success";
  console.log("Role is not required")
 }

 if(this.student.bloodvalue === ''){
  this.arr.blood=" Blood group is required";
  console.log("  Blood group is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.blood="success";
  console.log("Blood group is not required")

 }


 if(this.student.dobvalue === '' || this.student.dobvalue == null){
  this.arr.dob=" Blood group is required ";
  console.log(" Blood group is required")
  this.count--;
 }
 else{
  this.count++;
  this.arr.dob="success";
  console.log("Blood group is not required")
 }

 console.log(this.arr)
 this.arroutput.emit(this.arr)
 console.log("..............................validation end.....................")
  }

}
