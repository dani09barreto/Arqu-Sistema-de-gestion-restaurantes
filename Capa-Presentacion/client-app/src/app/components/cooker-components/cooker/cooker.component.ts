import { Component, OnDestroy } from '@angular/core';
import { LoginPopupComponent } from '../../auth-components/login-popup/login-popup.component';
import { GeneralService } from 'src/app/services/service-general/general.service';
import { MatDialogRef, MatDialog } from '@angular/material/dialog';
import { WebSocketService } from 'src/app/services/web-socket/web-socket.service';

@Component({
  selector: 'app-cooker',
  templateUrl: './cooker.component.html',
  styleUrls: ['./cooker.component.css']
})
export class CookerComponent implements OnDestroy {

  message = '';
  externalEvents: any[] = [];

  dialogRefLogin: MatDialogRef<LoginPopupComponent> | undefined;
  constructor(public dialog: MatDialog,
    public webSocketService: WebSocketService) {
    this.webSocketService.connect();
  }

  sendMessage(message: string) {
    this.webSocketService.sendMessage(message);
  }

  ngOnDestroy() {
    this.webSocketService.close();
  }

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
