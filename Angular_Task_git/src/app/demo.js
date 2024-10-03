import { Component, Input, AfterViewInit, ViewChild,DoCheck } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CdkDragDrop, CdkDropList, CdkDrag, moveItemInArray } from '@angular/cdk/drag-drop';
import { ValidationComponent } from '../validation/validation.component';
import { AppComponent, student } from '../app.component';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CdkDropList, CdkDrag,ValidationComponent,AppComponent],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    throw new Error('Method not implemented.');
  }
  displayedColumns: string[] = ['name', 'email', 'address', 'blood','college', 'department', 'designation', 'employid','gender', 'percentage', 'phnumber', 'role'];
  @Input('data') student!: student;
  dataSource: any;

  student2 = new student1();
  usernamevalue!: string;
  emailvalue!: string;
  percentagevalue!: string;
  employidvalue!: string;
  designationvalue!: string;
  addressvalue!: string;
  rolevalue!: string;
  departmentvalue!: string;
  gendervalue!: string;
  bloodvalue!: string;

  phnumbervalue!: string;
  collegenamevalue!: string;
  dobvalue!: string;
  val:any;

  
ngDocheck(){
  if(this.student.usernamevalue!='' && this.student.addressvalue!='' && this.student.bloodvalue!=''
    && this.student.collegenamevalue!='' && this.student.departmentvalue!='' && this.student.designationvalue!=''
    && this.student.dobvalue!='' && this.student.emailvalue!='' && this.student.employidvalue!='' && this.student.gendervalue!=''
    && this.student.percentagevalue!='' && this.student.phnumbervalue!='' && this.student.rolevalue!=''){
      
     
      this.usernamevalue=this.student.usernamevalue;
      this.emailvalue=this.student.usernamevalue;
      this.percentagevalue=this.student.usernamevalue;
      this.employidvalue=this.student.usernamevalue;
      this.designationvalue=this.student.usernamevalue;
      this.addressvalue=this.student.usernamevalue;
      this.rolevalue=this.student.usernamevalue;
      this.departmentvalue=this.student.usernamevalue;
      this.gendervalue=this.student.usernamevalue;
      this.bloodvalue=this.student.usernamevalue;
    
      this.phnumbervalue=this.student.usernamevalue;
      this.collegenamevalue=this.student.usernamevalue;
      this.dobvalue=this.student.usernamevalue;

      this.val={ 'name':this.usernamevalue, 'address':this.addressvalue, 'blood':this.bloodvalue,
        'department': this.departmentvalue, 'college':this.collegenamevalue, 
        'designation': this.designationvalue, 'dob':this.dobvalue, 
        'email':this.emailvalue,'employid':this.employidvalue, 'gender':this.gendervalue, 
        'percentage':this.percentagevalue,'phnumber':this.phnumbervalue, 'role':this.rolevalue}
    
        this.dataSource = new MatTableDataSource<any>([
          this.val
        ]);
    }
     }
  }


  
 

  



  @ViewChild(MatPaginator) paginator!: MatPaginator;

 
  ngAfterViewInit() {
    this.dataSource.paginator = paginator;
    console.log("hshshshs",)
  }

 




   


}}

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
export class student1{
  
 

  
}

function ngDoCheck() {
  throw new Error('Function not implemented.');
}


function ngAfterViewInit() {
  throw new Error('Function not implemented.');
}


function add() {
  throw new Error('Function not implemented.');
}




<tr>
    <td><input type="search" /></td>
   <td><button (click)="multipleDelete()">Delete</button></td>
</tr>
<tr >
<th><input type="checkbox" (click)="multipleindexall(this)" [(ngModel)]="checkboxvalue"></th>
<th   cdkDrag cdkDropList [cdkDropListData]="displayedColumns" (cdkDropListDropped)="dropColumn($event)"> Name </th>
<th > Email </th>
<th> College </th>
<th > Phone Number </th>
<th > Percentage </th>
<th > EmployeeId </th>
<th > Designation </th>
<th > Address </th>
<th > Role </th>
<th > Department </th>
<th > Gender </th>
<th > Blood Group </th>
<th>Action</th>
</tr>


<tr *ngFor="let row of users" >
<td><input type="checkbox" (click)="multipleindex(this)" [(ngModel)]="checkboxvalue1"></td>
<td > {{row.usernamevalue}} </td>
<td > {{row.emailvalue}} </td>
<td> {{row.collegevalue}} </td>
<td  > {{row.phnumber}} </td>
<td  > {{row.percentagevalue}} </td>
<td  > {{row.employidvalue}} </td>
<td  > {{row.designationvalue}} </td>
<td>{{row.addressvalue}}</td>
<td  > {{row.rolevalue}} </td>
<td> {{row.departmentvalue}} </td>
<td  > {{row.gendervalue}} </td>
<td>{{row.dobvalue}}</td>
<td>
  <button   (click)="editData(row)">Edit</button>
  <button (click)="deleteData(row)">Delete</button>
</td>
</tr>



<tr>
    <td><input type="search" /></td>
   <td><button (click)="multipleDelete()">Delete</button></td>
</tr>
<tr >

    <th cdkDrag [cdkDragData]="displayedColumns[0]" (cdkDragStarted)="dragStarted($event, 0)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 0)"> Username </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayeddisplayedColumns[1]" (cdkDragStarted)="dragStarted($event, 1)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 1)"> Email </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[2]" (cdkDragStarted)="dragStarted($event, 2)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 2)"> College </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[3]" (cdkDragStarted)="dragStarted($event, 3)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 3)"> Phone Number </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[4]" (cdkDragStarted)="dragStarted($event, 4)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 4)"> Percentage </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[5]" (cdkDragStarted)="dragStarted($event, 5)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 5)"> Employee ID </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[6]" (cdkDragStarted)="dragStarted($event, 6)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 6)"> Designation </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[7]" (cdkDragStarted)="dragStarted($event, 7)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 7)"> Address </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[8]" (cdkDragStarted)="dragStarted($event, 8)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 8)"> Role </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[9]" (cdkDragStarted)="dragStarted($event, 9)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 9)"> Department </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[10]" (cdkDragStarted)="dragStarted($event, 10)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 10)"> Gender </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[11]" (cdkDragStarted)="dragStarted($event, 11)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 11)"> DOB </th>
    <th cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[12]" (cdkDragStarted)="dragStarted($event, 12)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 12)"> DOB </th>
    <th > Action </th>
</tr>


<tr *ngFor="let row of users" >

<td   cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[0]" (cdkDragStarted)="dragStarted($event, 0)"> {{row.usernamevalue}} </td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayeddisplayedColumns[1]" (cdkDragStarted)="dragStarted($event, 1)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 1)"> {{row.emailvalue}} </td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[2]" (cdkDragStarted)="dragStarted($event, 2)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 2)"> {{row.collegevalue}} </td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[3]" (cdkDragStarted)="dragStarted($event, 3)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 3)">   {{row.phnumber}} </td>
<td   cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[4]" (cdkDragStarted)="dragStarted($event, 4)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 4)"> {{row.percentagevalue}} </td>
<td   cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[5]" (cdkDragStarted)="dragStarted($event, 5)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 5)"> {{row.employidvalue}} </td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[6]" (cdkDragStarted)="dragStarted($event, 6)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 6)" > {{row.designationvalue}} </td>
<td cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[7]" (cdkDragStarted)="dragStarted($event, 7)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 7)">{{row.addressvalue}}</td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[8]" (cdkDragStarted)="dragStarted($event, 8)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 8)" > {{row.rolevalue}} </td>
<td   cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[9]" (cdkDragStarted)="dragStarted($event, 9)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 9)"> {{row.departmentvalue}} </td>
<td cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[10]" (cdkDragStarted)="dragStarted($event, 10)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 10)" > {{row.gendervalue}} </td>
<td  cdkDrag [cdkDragData]="displayeddisplayeddisplayedColumns[11]" (cdkDragStarted)="dragStarted($event, 11)" cdkDropList [cdkDropListData]="displayeddisplayeddisplayedColumns" (cdkDropListDropped)="dropColumn($event, 11)">{{row.dobvalue}}</td>
<th cdkDrag [cdkDragData]="displayedColumns[12]" (cdkDragStarted)="dragStarted($event, 12)" cdkDropList [cdkDropListData]="displayedColumns" (cdkDropListDropped)="dropColumn($event, 12)"> DOB </th>
<td > 
  <button   (click)="editData(row)">Edit</button>
  <button (click)="deleteData(row)">Delete</button>
</td>
</tr>

