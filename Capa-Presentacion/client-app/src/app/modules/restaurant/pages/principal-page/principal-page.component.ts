import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { LoginPopupComponent } from '../../../auth/pages/login-popup/login-popup.component';
import { Router } from '@angular/router';
import { ShoppingCartComponent } from '../shopping-cart/shopping-cart.component';

@Component({
  selector: 'app-principal-page',
  templateUrl: './principal-page.component.html',
  styleUrls: ['./principal-page.component.css']
})
export class PrincipalPageComponent implements OnInit{
  dialogRef: MatDialogRef<ShoppingCartComponent> | undefined;
  dialogRefLogin: MatDialogRef<LoginPopupComponent> | undefined;

  isCartOpen: boolean = false;
  cantidadProductos: number = 0;
  constructor(public dialog: MatDialog, private router: Router) {}


  ngOnInit(){
    console.log("Que pasaa");
  }

  reloadPage() {
    console.log("Navegando...");
    this.router.navigate(['']);
  }

  abrirCarrito(){
    if (this.dialogRef && this.dialogRef.componentInstance) {
      // El carrito ya está abierto, forzar cierre
      this.dialogRef.close();
    } else {
      // El carrito no está abierto, abrir diálogo
      this.dialogRef = this.dialog.open(ShoppingCartComponent, {
        width: '250px',
        height: '100%',
        data: {},
      });
    }
  }
 /**
  * Abrir Popup de Login desde Restaurante.
  */
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
