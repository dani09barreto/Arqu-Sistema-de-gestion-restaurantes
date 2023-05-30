import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ShoppingCartComponent } from '../shopping-cart/shopping-cart.component';
import { CartService } from 'src/app/shared/cart.service';
import { LoginPopupComponent } from '../../auth-components/login-popup/login-popup.component';

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
  mostrarContenidoPago = false;

  constructor(public dialog: MatDialog, private router: Router,private cartService: CartService) {}


  ngOnInit(){

    this.cartService.cantidadProductosSubject.subscribe(cantidad => {
      this.cantidadProductos = cantidad;
    });

    this.cartService.mostrarContenidoPago$.subscribe(mostrar => {
      this.mostrarContenidoPago = mostrar;
      window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });

    });
  }

  scrollPlease(){
    window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });
  }

  reloadPage() {
    console.log("Navegando...");
    if (this.dialogRef && this.dialogRef.componentInstance) {
      // El carrito ya está abierto, forzar cierre}
      this.abrirCarrito();
    }
    if (this.dialogRefLogin && this.dialogRefLogin.componentInstance) {
      this.openPopup();
    }
    this.router.navigate(['']);
  }

  abrirCarrito(){
    this.cartService.update();
    this.ngOnInit();
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
