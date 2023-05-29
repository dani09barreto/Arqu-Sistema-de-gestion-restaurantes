import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Plato } from 'src/app/core/models/plato.model';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit{

  cantidadProductos = 0;

  @Output() private update = new EventEmitter<string>();
  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<ShoppingCartComponent>
     //private authService: AuthService,
     ,private router: Router,private cartService: CartService
     ){}
  ngOnInit(): void {
    this.cartService.cantidadProductosSubject.subscribe(cantidad => {
      this.cantidadProductos = cantidad;
    });
  }

  cartItems: Plato[] = [];

  removeFromCart(item: Plato): void {
    const index = this.cartItems.indexOf(item);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
  }

  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + item.precio, 0);
  }

  goToPayment(){}

  agregarAlCarrito(plato: Plato): void {
    this.cartItems.push(plato);
    // Opcionalmente, puedes realizar otras acciones relacionadas con agregar el plato al carrito
  }

}
