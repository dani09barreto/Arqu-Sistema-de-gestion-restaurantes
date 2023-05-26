import { Component } from '@angular/core';
import { PlaceSelectorComponent } from '../place-selector/place-selector.component';
import {MatDialog} from '@angular/material/dialog';
import { LoginPopupComponent } from '../../../auth/pages/login-popup/login-popup.component';



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {
  reloadPage() {
    location.reload();
  }

  constructor(public dialog: MatDialog) {}

  openPopup(): void {
    const dialogRef = this.dialog.open(LoginPopupComponent, {
      width: '250px',
      height:'100%',
      data: {},
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });

  }

}
