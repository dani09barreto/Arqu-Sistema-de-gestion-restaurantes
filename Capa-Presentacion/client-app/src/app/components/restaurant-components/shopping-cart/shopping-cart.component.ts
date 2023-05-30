import { Component, OnInit, ViewChild } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Plato } from 'src/app/core/models/plato.model';
import { CartService } from 'src/app/shared/cart.service';
@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit{

  cantidadProductos=0;

  ngOnInit(): void {
    this.cartService.cantidadProductosSubject.subscribe(cantidad => {
      this.cantidadProductos = cantidad;
    });

    this.cartService.platosEnCarritoSubject.subscribe(platos => {
      this.cartItems = platos;
    });
    this.cartService.update();
  }

  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<ShoppingCartComponent>
     //private authService: AuthService,
     ,private router: Router,private cartService: CartService,

     )
     {    this.cartService.update();
     }

  cartItems: Plato[] = [];

  removeFromCart(item: Plato): void {
    const index = this.cartItems.indexOf(item);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
    this.cantidadProductos--;
    this.cartService.removeProducto();
    this.ngOnInit();
  }

  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + item.precio, 0);
  }

  goToPayment(): void {
    // Realizar la navegación hacia el componente de pago
   // Emitir evento para mostrar el contenido de pago
    this.cartService.mostrarContenidoPago(true);
    this.dialogRef.close();
    console.log("Cierra Carrito")


  }
}
