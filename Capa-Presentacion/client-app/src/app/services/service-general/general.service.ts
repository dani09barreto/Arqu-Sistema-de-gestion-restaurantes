import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';
import { Restaurante } from 'src/app/core/models/restaurante.model';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  ipGeneral = this.localStorage.get('ip');

  url = 'http://'+this.ipGeneral+'/api';
  urlSelector= '/general/restaurantes/listar';
  urlMenu= '/general/menus/listar';
  URL= this.url+this.urlSelector;
  URL_= this.url+this.urlMenu;

  constructor(private http: HttpClient, private localStorage: LocalStorageService) {}

  getRestaurantes(): Observable<Restaurante[]> {
        return this.http.get<Restaurante[]>(this.URL);
  }

  getMenus(): Observable<Menu[]> {
    return this.http.get<Menu[]>(this.URL_);
  }

}
