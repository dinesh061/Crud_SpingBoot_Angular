import { CommonModule} from '@angular/common';
import { ChangeDetectionStrategy, Component,ElementRef,ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ValidationComponent } from './validation/validation.component';
import { DOCUMENT } from '@angular/common';
import { response } from 'express';
import { TableComponent } from './table/table.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { StudentDataService } from './service/student-data.service';
import { CradComponent } from './crad/crad.component';
import { HttpClient } from '@angular/common/http';






@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CradComponent,RouterOutlet,RouterOutlet,RouterModule,FormsModule,CommonModule,ValidationComponent,TableComponent,MatInputModule,MatDatepickerModule],
  providers: [provideNativeDateAdapter(),StudentDataService],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})


export class AppComponent {
  show:any=false;
  GlobalStudent!: Object;
  title = 'Angular_Task';
  studentObj : student = new student();
  buttonObj : buttonClass = new buttonClass();

  element: any;
   
  constructor(private elementRef: ElementRef,public dataService:StudentDataService,private http: HttpClient) { }
 username!: HTMLElement;



 duplicatedata:any={
  "position":"dk",
  "name":"1"
,

  "weight":"1"
,

  "symbol":"1"

    
};

  @ViewChild('username')
  username1!: ElementRef;

  ngAfterViewInit() {
     this.username = this.username1.nativeElement.parentNode;
     console.log("ngAfterViewInit",this.username)
    }

  @ViewChild(TableComponent)
   tableData!:TableComponent;

   editdatacopy:any;
   editdataRowIdcopy:any;

   editvalues(event:any){
    this.editdatacopy=event;
    console.log("editapp",this.editdatacopy)
   }

   editRowIdvalues(event:any){
    this.editdataRowIdcopy=event;
    console.log("editapp",this.editdataRowIdcopy)
   }
   
 count=0;
    // findError(){
    //   for ( const [key, value] of Object.entries(this.GlobalStudent)) {
    //     if(!String(value).toLowerCase().includes("success")){
          
    //     }
    //     else{
    //      this.count++;
    //       this.setsuccess(key)
    //     }
    //   }
    // }

    reloadWindow() {
      window.location.reload();
    }
  

    onFormSubmit(){
    

   if(this.count >=13){
    
   
    if(this.editdatacopy==true ){

    this.show=true;
      console.log("edit true")
   
    
      this.dataService.updateUser({
        userId:this.editdataRowIdcopy,
        usernamevalue: this.studentObj.usernamevalue,
        emailvalue: this.studentObj.emailvalue,
        percentagevalue: this.studentObj.percentagevalue,
        employidvalue: this.studentObj.employidvalue,
        designationvalue: this.studentObj.designationvalue,
        addressvalue: this.studentObj.addressvalue,
        rolevalue:this.studentObj.rolevalue,
        departmentvalue: this.studentObj.departmentvalue,
        gendervalue: this.studentObj.gendervalue,
        bloodvalue: this.studentObj.bloodvalue,
        experiencevalue:this.studentObj.experiencevalue,
        phnumbervalue: this.studentObj.phnumbervalue,
        collegenamevalue: this.studentObj.collegenamevalue,
        dobvalue: this.studentObj.dobvalue
      })
     
      this.editdatacopy=false;
      this.clearInputs();
      this.buttonObj.buttonText="submit";
  }


   else{
   
    this.show=true;
    console.log(this.show)
    this.dataService.addUser({
     
      usernamevalue: this.studentObj.usernamevalue,
      emailvalue: this.studentObj.emailvalue,
      percentagevalue: this.studentObj.percentagevalue,
      employidvalue: this.studentObj.employidvalue,
      designationvalue: this.studentObj.designationvalue,
      addressvalue: this.studentObj.addressvalue,
      rolevalue:this.studentObj.rolevalue,
      departmentvalue: this.studentObj.departmentvalue,
      gendervalue: this.studentObj.gendervalue,
      bloodvalue: this.studentObj.bloodvalue,
      experiencevalue:this.studentObj.experiencevalue,
      phnumbervalue: this.studentObj.phnumbervalue,
      collegenamevalue: this.studentObj.collegenamevalue,
      dobvalue: this.studentObj.dobvalue
    })
this.clearInputs();
   }
   }

 }




    clearInputs() {
      this.studentObj.addressvalue='';
      this.studentObj.bloodvalue='';
      this.studentObj.collegenamevalue='';
      this.studentObj.departmentvalue='';
      this.studentObj.designationvalue='';
      this.studentObj.dobvalue='';
      this.studentObj.emailvalue='';
      this.studentObj.employidvalue='';
      this.studentObj.experiencevalue='';
      this.studentObj.gendervalue='';
      this.studentObj.percentagevalue='';
      this.studentObj.phnumbervalue='';
      this.studentObj.rolevalue='';
      this.studentObj.usernamevalue='';
      this.count=0;
    }

    validationresponse(response:object){
      this.GlobalStudent=response;
      console.log("dataservice",this.GlobalStudent)
    
     

     console.log("response",response)
     for ( const [key, value] of Object.entries(response)) {
      if(!String(value).toLowerCase().includes("success")){
        this.seterror( key,value)
      }
      else{
        this.setsuccess(key)
        this.count++;
      }
    }
    }

    
    
     seterror(elementId:string, msg: string){
      console.log(elementId+" "+msg)
      const element: HTMLElement = this.elementRef.nativeElement.querySelector(`#${elementId}`);
      console.log("seterror")
    
      console.log("element"+element+msg)
      
      let parent = element.parentNode as HTMLElement;
      console.log("parent"+parent)
      if (parent) {
        parent.classList.add("err");
        parent.classList.remove("success");
      } else {
        console.log('element not found');
      }
     
  const errorElement = parent.querySelector(".error") as HTMLElement;
  errorElement.innerHTML = msg;
  errorElement.style.color = "darkred";

  errorElement.setAttribute("id", "newele");
  console.log("error finish")
  
  /*
      let newele = document.createElement("h3")
      newele.style.color="darkred"
      newele.innerHTML=msg
      parent.appendChild(newele)
      let pre =newele.previousSibling
      parent.removeChild(pre)
      */
      
  }

   showexperienceInput=false
  showinputyes(){
    this.showexperienceInput=true
  }
  
  showinputno(){
    this.showexperienceInput=false
  }
   setsuccess(elementId:any){
      console.log("setsuccess")
      console.log(elementId+" ")
      const element: HTMLElement = this.elementRef.nativeElement.querySelector(`#${elementId}`);
      let parent = element.parentNode as HTMLElement;
      console.log("parent"+parent)
     if(parent){
      parent.classList.add("success")
      parent.classList.remove("err")
      const errorElement = parent.querySelector(".error") as HTMLElement;
      errorElement.innerHTML=""
     }
     else{
      console.log("parent not found")
     }
  /*
      let errorelement = document.querySelector(".error")
      errorelement.innerText='';
      parent.removeChild(parent.lastElementChild)
   */   
  }


  // file: File | undefined;
  // handleFileInput(files: FileList) {
  //  if(files != null){
  //   this.file = files[0];
  //  }
  //  }

  //  uploadFile() {
  // //   const formData = new FormData();
  // //   formData.append('Excel',this.file);

  //   this.http.post('http://localhost:8080/upload/upload', this.file)
  //     .subscribe(response => {
  //       console.log(response);
  //     }, error => {
  //       console.error(error);
  //     });
  // }
}


export class buttonClass{
  buttonText:string="submit";
  
}


export class student{
  userId:any;
  usernamevalue: string;
  emailvalue: string;
  percentagevalue: string;
  employidvalue: string;
  designationvalue!: string;
  addressvalue: string;
  rolevalue: string;
  departmentvalue: string;
  gendervalue: string;
  bloodvalue: string;
  experiencevalue:string;
  phnumbervalue: string;
  collegenamevalue: string;
  dobvalue: string;
  static collegenamevalue: string;
  constructor(){
    this.userId=this.userId;
    this.usernamevalue = '';
    this.emailvalue = '';
    this.phnumbervalue = '';
    this.percentagevalue = '';
    this.employidvalue = '';
    this.designationvalue = '';
    this.addressvalue = '';
    this.rolevalue = '';
    this.departmentvalue = '';
    this.gendervalue = '';
    this.bloodvalue = '';
    this.experiencevalue = '';
    this.collegenamevalue='';
    this.dobvalue='';
  }
}

