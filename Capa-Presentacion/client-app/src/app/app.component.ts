import { Component} from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'client-app';
  constructor(private localStorage: LocalStorageService){
    this.localStorage.remove('username');
  }
}
