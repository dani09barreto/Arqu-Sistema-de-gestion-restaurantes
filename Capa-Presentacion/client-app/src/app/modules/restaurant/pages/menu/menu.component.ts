import { Component,Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from 'src/app/core/models/menu.model';
import { Plato } from 'src/app/core/models/plato.model';
import { CartService } from '../../services/cart.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private router: Router,private cartService: CartService) {}

  menus: Menu[] = [
    {
      id: 1,
      nombre: 'Desayunos',
      platos: [
        {
          id: 1,
          nombre: 'Huevos Pericos',
          descripcion: 'Dos Huevos con Cebolla y Tomate',
          precio: 10.99,
          imagen: 'https://salcedocatering.com/wp-content/uploads/2019/05/3341-1080x675.jpg'
        }
      ]
    },
    {
      id: 2,
      nombre: 'Almuerzos',
      platos: [
        {
          id: 2,
          nombre: 'Pastas Yakisova',
          descripcion: 'Pasticas al estilo más Afroasitico',
          precio: 12.99,
          imagen: 'https://thumbs.dreamstime.com/b/un-plato-de-comida-sobre-una-mesa-madera-foto-alta-calidad-186030752.jpg'
        }
      ]
    }
  ];

  @Output() agregarAlCarritoEvent = new EventEmitter<Plato>();

  agregarAlCarrito(plato: Plato): void {
    this.agregarAlCarritoEvent.emit(plato);
    this.cartService.agregarProducto(plato);
    console.log('Plato agregado al carrito:', plato);

  }
}
