import { Component, Input, AfterViewInit, ViewChild,DoCheck, Output, EventEmitter, ElementRef, Host } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { ValidationComponent } from '../validation/validation.component';
import { AppComponent, buttonClass, student } from '../app.component';
import { StudentDataService } from '../service/student-data.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {CdkDragDrop, CdkDropList, CdkDrag, moveItemInArray, CdkDragStart} from '@angular/cdk/drag-drop';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [MatIconModule,MatTableModule, MatPaginatorModule,ValidationComponent,AppComponent,CommonModule,FormsModule,CdkDropList, CdkDrag],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent  {

  
  
  constructor(private userService: StudentDataService,private http: HttpClient) {}
 
 
  displayedColumns: string[] = ['name', 'email', 'college', 'percentage','employid','phnumber','designation','address','role','department',    'gender',  'dob','isActive'];

  private dragStartIndex: number | null = null;
  @Input('buttonupdate') buttonObj!: buttonClass;

  onDragStart(event: DragEvent, index: number): void {
    this.dragStartIndex = index;
    event.dataTransfer!.effectAllowed = "move";
  }

  onDragOver(event: DragEvent): void {
    event.preventDefault(); // Allow drop
  }

  onDrop(event: DragEvent, dropIndex: number): void {
    event.preventDefault();
    if (this.dragStartIndex !== null && this.dragStartIndex !== dropIndex) {
      this.swapColumns(this.dragStartIndex, dropIndex);
    }
  }

  onDragEnd(event: DragEvent): void {
    this.dragStartIndex = null;
  }

  swapColumns(fromIndex: number, toIndex: number): void {
    // Swap columns in the header
    const columns = [...this.displayedColumns];
    const fromColumn = columns[fromIndex];
    const toColumn = columns[toIndex];
    columns[fromIndex] = toColumn;
    columns[toIndex] = fromColumn;
    this.displayedColumns = columns;

    // Swap column data in each row
    this.rows.forEach((row: any) => {
      const rowData = { ...row };
      const fromValue = rowData[fromColumn];
      const toValue = rowData[toColumn];
      rowData[fromColumn] = toValue;
      rowData[toColumn] = fromValue;
      Object.keys(rowData).forEach(key => {
        if (key === fromColumn) {
          rowData[toColumn] = rowData[key];
        } else if (key === toColumn) {
          rowData[fromColumn] = rowData[key];
        }
      });
      Object.keys(rowData).forEach(key => {
        if (key === fromColumn) {
          delete rowData[key];
        } else if (key === toColumn) {
          delete rowData[key];
        }
      });
      this.rows[this.rows.indexOf(row)] = rowData;
    });
  }

  users:any[]=[];



 @Input('data') student!: student;
 @Output() editDatastatus = new EventEmitter<any>();
 @Output() editRowUserIdStatus = new EventEmitter<any>();
editarr:any=[];
  datalength!: number;
  checkboxvalue:boolean=false;
  checkboxvalue1:boolean=false;
 

  ngOnInit(): void {
    console.log("table..............")
    
    this.userService.getUsers().subscribe(usersdata => {
      this.users = usersdata;
 
     console.log(this.users)
      console.log("table", this.users)
    });
   
  }

  reloadWindow() {
    window.location.reload();
  }

  // ngOnChanges(changes: any) {
  //   if (changes.data) {
  //     this.userService.getUsers().subscribe(usersdata => {
  //       this.users = usersdata;
   
  //      console.log(this.users)
  //       console.log("table", this.users)
  //     });
  //   }
  // }
  // ngDoCheck(){
  //   console.log("table Docheck..............")
  //   this.userService.getUsers().subscribe(usersdata => {
  //     this.users = usersdata;
 
  //    console.log(this.users)
  //     console.log("table", this.users)
  //   });
  // }

  deleteData(row: any): void {
    console.log(row)
 
    // const index = this.users.indexOf(row);
    // if (index >= 0) {
    //   // this.users.splice(index, 1);
    // }

    this.http.delete("http://localhost:8084/employee/deleteemployee"+ "/"+ row.userId,{responseType: 'text'}).subscribe((resultData: any)=>
      {
      
          console.log(resultData);
          alert("Employee Deleted")
          console.log("table..............")
          this.userService.getUsers().subscribe(usersdata => {
            this.users = usersdata;
        
           console.log(this.users)
            console.log("table", this.users)
          });
      });
   
    
  }

//multiple delete
 deleteElementArray:any=[]
  deleteAllData(): void {

   if(this.deleteAllElement == true){
    alert("deleteAll")
    this.http.delete("http://localhost:8084/employee/deleteAllemployee")
    
      .subscribe((resultData: any)=>
      {
         console.log(resultData)
      });
      window.location.reload();
   }
   else{
    alert(this.deleteElementArray)
      // if(this.users[i].isActive == true){
      //     this.deleteElementArray.push(i);
      // }
      // const params = new HttpParams()
      // .set('userId', this.deleteElementArray)

      // const options = {
      //   headers: new HttpHeaders({
      //     'Content-Type': 'application/json',
      //   }),
      //   params: params,
      // };

      const params = new HttpParams().set('userId', this.deleteElementArray);
      
        this.http.delete("http://localhost:8084/employee/deleteMultipleemployee",{ params: params ,responseType: 'text'}).subscribe((resultData: any)=>
          {
           
           
          console.log(this.deleteElementArray);
              console.log(resultData);
              alert("Employee Deleted")
              console.log("table..............")
              this.userService.getUsers().subscribe(usersdata => {
                this.users = usersdata;
            
               console.log(this.users)
                console.log("table", this.users)
              });
          });
       
      
   
  }
  }
 



   deleteAllElement=false;
   parentCheckbox=false;
  toggleSelectAll(event: any) {
   this.parentCheckbox=!this.parentCheckbox;
    length = this.users.length;
    for(let i=0;i<length;i++){
     
      this.users[i].isActive=this.parentCheckbox;
    }
   
    this.deleteAllElement=true;
  }
  


  toggleSelectAll2(row: any) {
    let userId=row.userId;
    this.deleteElementArray.push(userId);
    this.deleteAllElement=false;
  
   }
   


  multipleindexarr:any[]=[];
  multipleindex(row:any){
    const index = this.users.indexOf(row);
    alert(row)
    this.multipleindexarr.push(index);
  }


  multipleDelete(){
   
  }


  multipleindexall(row:any){
  
    this.checkboxvalue=!this.checkboxvalue;
    this.checkboxvalue1= this.checkboxvalue;
    this.datalength=this.users.length;
    alert( this.datalength)
   
  
  for(let i=0;i<this.datalength;i++){
    this.multipleindexarr[i].push(i);
    }
}

  editstatus:any=false;
  editRowUserId:any=0;
rows:any
usernamevalue!:string;



  editData(row: any): void {
    alert(this.buttonObj.buttonText)
    this.buttonObj.buttonText="Update";
    alert(this.buttonObj.buttonText) 
   
    this.editstatus=true;
    this.editRowUserId=row.userId;
    this.rows=row;
    console.log("edit",row)
    const index = this.users.indexOf(row);
    this.editarr.push(index)
    this.editarr.push(this.editstatus)
this.editDatastatus.emit(this.editstatus);
this.editRowUserIdStatus.emit(this.editRowUserId);

     console.log("edit")
     console.log(row,"edit")
    this.student.emailvalue=row.email;
    alert(row.emailvalue);
    this.student.addressvalue=row.address;
    this. student.bloodvalue=row.blood;
    this. student.collegenamevalue=row.collegeName    ;
    this. student.departmentvalue=row.department
    this. student.designationvalue=row.designation;
    this. student.dobvalue=row.dob;
    this. student.emailvalue=row.email;
    this. student.employidvalue=row.employeeId    ;
    this. student.experiencevalue=row.experience;
    this. student.gendervalue=row.gender;
    this. student.percentagevalue=row.percentage;
    this. student.phnumbervalue=row.phoneNumber    ;
    this. student.rolevalue=row.role;
    this. student.usernamevalue=row.userName;
   
    
    // const updatedUser={
    //   "usernamevalue": this.student.usernamevalue,
    //   "emailvalue": this.student.emailvalue,
    //   "percentagevalue": this.student.percentagevalue,
    //   "employidvalue": this.student.employidvalue,
    //   "designationvalue": this.student.designationvalue,
    //   "addressvalue": this.student.addressvalue,
    //   "rolevalue": this.student.rolevalue,
    //   "departmentvalue": this.student.departmentvalue,
    //   "gendervalue": this.student.gendervalue,
    //   "bloodvalue": this.student.bloodvalue,
    //   "experiencevalue":this.student.experiencevalue,
    //   "phnumbervalue": this.student.phnumbervalue,
    //   "collegenamevalue": this.student.collegenamevalue,
    //   "dobvalue": this.student.dobvalue
    // }
    
    // this.users[index] = updatedUser;

 
  }
  
   
  isSelected=false;

  ArrayElement: any[] = [
    { FormName: '', Gender: '', percent: '', formDepartment: '', formRole: '', formClgName: '', formPhoneNumber: '', formEmployeeId: '', formDesignation: '', formEmail: '', formDOB: '', formAddress: '', isSelected: false },
  ];
  

  

  deleteSelectedRows() {
    this.ArrayElement = this.ArrayElement.filter(employee => !employee.isSelected);
  }
  @ViewChild(MatPaginator) paginator!: MatPaginator;




}


 

  

