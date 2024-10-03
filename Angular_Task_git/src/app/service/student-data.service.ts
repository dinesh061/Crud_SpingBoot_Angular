import { Injectable,ViewChild,AfterViewInit,DoCheck} from '@angular/core';
import { AppComponent } from '../app.component';
import { ValidationComponent } from '../validation/validation.component';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentDataService {
  CustomerArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

  constructor(private http: HttpClient) { 
    this.getUsers();
  }
 
private users: any[] = [

];
  private nextId = 1;

  getUsers():Observable< any[]> {

    this.http.get("http://localhost:8084/employee/getAllCustomer")
  
    .subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log("resultData",resultData);
        this.CustomerArray = resultData;
        console.log(".......CustomerArray.................",this.CustomerArray)
    });
    return of( this.CustomerArray);
  }

  addUser(user: any): void {

    let bodyData={
      
      "userName": user.usernamevalue,
      "email": user.emailvalue,
      "collegeName": user.collegenamevalue,
      "percentage": user.percentagevalue,
      "phoneNumber": user.phnumbervalue,
      "employeeId": user.employidvalue,
      "designation": user.designationvalue,
      "department":user.departmentvalue,
      "address": user.addressvalue,
      "gender": user.gendervalue,
      "dob": user.dobvalue,
      "role": user.rolevalue,
      "bloodGroup": user.bloodvalue
      
    }
    this.users.push(user);
    console.log("user",this.users)

    this.http.post("http://localhost:8084/employee/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
  {
    
      console.log(resultData);
      alert("Employee Registered Successfully");
      this.getUsers();
      
  });
  }

  updateUser(user: any): void {
    // const index = this.users.findIndex(user => user.id === updatedUser.id);
    // if (index !== -1) {
    //   this.users[index] = updatedUser;

    let bodyData={
      "userId":user.userId,
      "userName": user.usernamevalue,
      "email": user.emailvalue,
      "collegeName": user.collegenamevalue,
      "percentage": user.percentagevalue,
      "phoneNumber": user.phnumbervalue,
      "employeeId": user.employidvalue,
      "designation": user.designationvalue,
      "department":user.departmentvalue,
      "address": user.addressvalue,
      "gender": user.gendervalue,
      "dob": user.dobvalue,
      "role": user.rolevalue,
      "bloodGroup": user.bloodvalue
    }
    
      this.http.put("http://localhost:8084/employee/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
      
  
        console.log(resultData);
        alert("Employee Updated Successfully");
        this.getUsers();
    });
  }
  

  deleteUser(userId: number): void {
    this.users = this.users.filter(user => user.id !== userId);
  }
}
// 6093 535 846

// import { HttpClient } from '@angular/common/http';
// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-customer',
//   templateUrl: './customer.component.html',
//   styleUrls: ['./customer.component.scss']
// })
// export class CustomerComponent {

//   CustomerArray : any[] = [];
//   isResultLoaded = false;
//   isUpdateFormActive = false;
 
  
//   customername: string ="";
//   customeraddress: string ="";
//   mobile: Number =0;
 
//   currentCustomerID = "";



// constructor(private http: HttpClient )
//   {
//     this.getAllCustomer();
 
//   }

//   getAllCustomer()
//   {
    
//     this.http.get("http://localhost:8084/api/v1/customer/getAllCustomer")
  
//     .subscribe((resultData: any)=>
//     {
//         this.isResultLoaded = true;
//         console.log(resultData);
//         this.CustomerArray = resultData;
//     });
//   }
 
//   register()
//   {
  
//     let bodyData = {
//       "customername" : this.customername,
//       "customeraddress" : this.customeraddress,
//       "mobile" : this.mobile
//     };
 
//     this.http.post("http://localhost:8084/api/v1/customer/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
//     {
//         console.log(resultData);
//         alert("Employee Registered Successfully");
//         this.getAllCustomer();

//         this.customername = '';
//       this.customeraddress = '';
//         this.mobile  = 0;
//     });
//   }
//   setUpdate(data: any)
//   {
//    this.customername = data.customername;
//    this.customeraddress = data.customeraddress;
//    this.mobile = data.mobile;
//    this.currentCustomerID = data.customerid;
//   }
 
//   UpdateRecords()
//   {
//     let bodyData = {
//       "customerid" : this.currentCustomerID,
//       "customername" : this.customername,
//       "customeraddress" : this.customeraddress,
//       "mobile" : this.mobile
//     };
    
//     this.http.put("http://localhost:8084/api/v1/customer/update",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
//     {
//         console.log(resultData);
//         alert("Employee Registered Updateddd")
//         this.getAllCustomer();
//         this.customername = '';
//         this.customeraddress = '';
//         this.mobile  = 0;
//     });
//   }
 
//   save()
//   {
//     if(this.currentCustomerID == '')
//     {
//         this.register();
//     }
//       else
//       {
//        this.UpdateRecords();
//       }      
 
//   }
 
//   setDelete(data: any)
//   {
    
    
//     this.http.delete("http://localhost:8084/api/v1/customer/deletecustomer"+ "/"+ data.customerid,{responseType: 'text'}).subscribe((resultData: any)=>
//     {
//         console.log(resultData);
//         alert("Employee Deletedddd")
//         this.getAllCustomer();

//         this.customername = '';
//       this.customeraddress = '';
//         this.mobile  = 0;
  
//     });
 
//   }
//  }


















// import { Injectable,ViewChild,AfterViewInit,DoCheck} from '@angular/core';
// import { AppComponent } from '../app.component';
// import { ValidationComponent } from '../validation/validation.component';
// import { Observable, of } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class StudentDataService {

  

//   constructor() { }
 
// private users: any[] = [

// ];
//   private nextId = 1;

//   getUsers():Observable< any[]> {
//     return of(this.users);
//   }

//   addUser(user: any): void {
    

    
//     this.users.push(user);
//     console.log(this.users)
//   }

//   updateUser(updatedUser: any): void {
//     const index = this.users.findIndex(user => user.id === updatedUser.id);
//     if (index !== -1) {
//       this.users[index] = updatedUser;
//     }
//   }

//   deleteUser(userId: number): void {
//     this.users = this.users.filter(user => user.id !== userId);
//   }
// }


