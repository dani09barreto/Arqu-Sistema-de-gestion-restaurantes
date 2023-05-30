import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private menusUrl = 'http://'; // Reemplaza "tu-url-del-api" con la URL de tu API


  private menus: Menu[] = [
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

  constructor(private http: HttpClient) { }

  getMenus(): Menu[] {
    return this.menus;
  }
/*
  getMenus(): Observable<Menu[]> {
    return this.http.get<Menu[]>(this.menusUrl);
  }
*/
}
