import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showFiller = false;
  hide = true;
  @Input() Logado : boolean = true; 
  title = 'Exam-inator';
}
