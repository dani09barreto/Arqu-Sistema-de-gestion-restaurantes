import { Component, OnInit } from '@angular/core';
import { PlaceSelectorComponent } from '../place-selector/place-selector.component';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { LoginPopupComponent } from '../../../auth/pages/login-popup/login-popup.component';
import { HomeService } from '../../services/home.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit{
  dialogRefLogin: MatDialogRef<LoginPopupComponent> | undefined;

  reloadPage() {
    location.reload();
  }

  constructor(public dialog: MatDialog,private myService: HomeService) {}
  ngOnInit(): void {
    this.myService.getData();
  }

  openPopup(): void {
    if (this.dialogRefLogin && this.dialogRefLogin.componentInstance) {
      // El popup de login ya está abierto, forzar cierre
      this.dialogRefLogin.close();
    } else {
      // El popup de login no está abierto, abrir diálogo
      this.dialogRefLogin = this.dialog.open(LoginPopupComponent, {
        width: '250px',
        height: '100%',
        data: {},
      });
    }
  }

}
