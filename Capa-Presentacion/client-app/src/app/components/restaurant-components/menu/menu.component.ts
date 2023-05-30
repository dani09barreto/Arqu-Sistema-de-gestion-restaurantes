import { Component,Output, EventEmitter, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from 'src/app/core/models/menu.model';
import { Plato } from 'src/app/core/models/plato.model';
import { GeneralService } from 'src/app/services/service-general/general.service';
import { CartService } from 'src/app/shared/cart.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router,private menuService: GeneralService ,private cartService: CartService) {}
  ngOnInit(): void {
    this.menuService.getMenus().subscribe(
      (menus) => {
        this.menus = menus;
      },
      (error) => {
        console.error('Error al obtener los restaurantes', error);
      }
    )
  };

/*
    this.menuService.getMenus().subscribe(menus => {
      this.menus = menus;
    });*/


  menus: Menu[] = [];

  @Output() agregarAlCarritoEvent = new EventEmitter<Plato>();

  agregarAlCarrito(plato: Plato): void {
    this.agregarAlCarritoEvent.emit(plato);
    this.cartService.agregarProducto(plato);
    console.log('Plato agregado al carrito:', plato);

  }
}
