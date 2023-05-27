import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import { Router } from '@angular/router';


interface Product {
  name: string;
  description: string;
  price: number;
}

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent {

  @Output() private update = new EventEmitter<string>();
  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<ShoppingCartComponent>
     //private authService: AuthService,
     ,
      private router: Router

     ) { }



  cartItems: Product[] = [
    {
      name: 'Product 1',
      description: 'Description of Product 1',
      price: 10.99
    },
    {
      name: 'Product 2',
      description: 'Description of Product 2',
      price: 19.99
    },
    {
      name: 'Product 3',
      description: 'Description of Product 3',
      price: 8.99
    }
  ];

  removeFromCart(item: Product): void {
    const index = this.cartItems.indexOf(item);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
  }

  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + item.price, 0);
  }
}
