import { Component, OnInit } from '@angular/core';
import { PlaceSelectorComponent } from '../place-selector/place-selector.component';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { HttpResponse } from '@angular/common/http';
import { GeneralService  } from 'src/app/services/service-general/general.service';
import { LoginPopupComponent } from '../../auth-components/login-popup/login-popup.component';
import { DespachadorServicesService } from 'src/app/services/service-despachador/despachador.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  providers: [GeneralService]
})
export class HomePageComponent{

  dialogRefLogin: MatDialogRef<LoginPopupComponent> | undefined;
  constructor(public dialog: MatDialog,private servicio: GeneralService) {}
  onInit(): void {
    console.log('Iniciando... a');
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

  reloadPage() {
    location.reload();
  }
}
