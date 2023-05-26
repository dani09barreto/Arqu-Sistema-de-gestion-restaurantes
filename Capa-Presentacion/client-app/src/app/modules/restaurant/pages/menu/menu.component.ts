import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private router: Router) {}

  platos = [
    {
      nombre: 'Plato 1',
      imagen: 'https://salcedocatering.com/wp-content/uploads/2019/05/3341-1080x675.jpg',
      descripcion: 'Descripción del plato 1',
      precio: 9.99
    },
    {
      nombre: 'Plato 2',
      imagen: 'https://thumbs.dreamstime.com/b/un-plato-de-comida-sobre-una-mesa-madera-foto-alta-calidad-186030752.jpg',
      descripcion: 'Descripción del plato 2',
      precio: 12.99
    },
    {
      nombre: 'Plato 3',
      imagen: 'https://jumboalacarta.com.ar/wp-content/uploads/2019/06/shutterstock_521741356.jpg',
      descripcion: 'Descripción del plato 3',
      precio: 8.99
    },
    {
      nombre: 'Plato 4',
      imagen: 'https://jumboalacarta.com.ar/wp-content/uploads/2019/06/shutterstock_521741356.jpg',
      descripcion: 'Descripción del plato 4',
      precio: 50.000
    }
    // Agrega más objetos de platos si es necesario
  ];

  agregarAlCarrito(plato: any) {
    // Lógica para agregar el plato al carrito
    console.log('Plato agregado al carrito:', plato);
  }

}
