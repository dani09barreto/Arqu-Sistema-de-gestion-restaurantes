import { Component, OnInit } from '@angular/core';
import { PlaceSelectorComponent } from '../place-selector/place-selector.component';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { LoginPopupComponent } from '../../../auth/pages/login-popup/login-popup.component';
import { HomeService } from '../../services/home.service';
import { HttpResponse } from '@angular/common/http';



@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  providers: [HomeService]
})
export class HomePageComponent{
  dialogRefLogin: MatDialogRef<LoginPopupComponent> | undefined;
  constructor(public dialog: MatDialog,private servicio: HomeService) {}

  obtenerDatos(): void {
    this.servicio.getDatos().subscribe(
      (response: HttpResponse<any>) => {
        const valorUpstream = response.headers.get('X-Upstream');
        console.log('Valor del encabezado upstream:', valorUpstream);
        // Realiza cualquier otra manipulación con el valor
      },
      error => {
        console.log('Trata de mejorar!')
        // Manejo de errores
      }
    );
  }

  openPopup(): void {
    this.obtenerDatos();
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

  reloadPage() {
    location.reload();
  }
}
