import { Component, Input } from '@angular/core';
import { AppComponent } from '../app.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crad',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './crad.component.html',
  styleUrl: './crad.component.css'
})
export class CradComponent {
  hs=true;
 
  @Input('showmethod') showing !: AppComponent;
  shows(){
    this.hs=false
  console.log(this.showing);
  }
}
