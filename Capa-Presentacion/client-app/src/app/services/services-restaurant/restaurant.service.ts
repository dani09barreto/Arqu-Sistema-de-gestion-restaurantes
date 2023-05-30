import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private menusUrl = 'http://'; // Reemplaza "tu-url-del-api" con la URL de tu API


  private menus: Menu[] = [];

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
