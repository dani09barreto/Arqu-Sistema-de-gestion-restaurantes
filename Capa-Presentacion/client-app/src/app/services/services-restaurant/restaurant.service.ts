import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';
import { Usuario } from 'src/app/core/models/usuario.model';
import { DespachadorServices } from '../service-despachador/despachador.service';
import { PedidoResponse } from 'src/app/core/models/pedidoResponse';
import { PagoRequest } from 'src/app/core/models/pagoResponse.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  ip = this.localStorage.get(this.localStorage.get('restauranteSesion'));//busco la IP asoaciada a ese restaurante en sesion

  url = 'http://'+this.ip+'/api/restaurante/pedido';
  URL_agregar= this.url+'/agregar';

  constructor(private http: HttpClient, private localStorage: LocalStorageService, private despachador : DespachadorServices) {
    this.despachador.getUrlDespachador(this.localStorage.get('restauranteSesion'));
  }

  getTotalApagar(pago: PagoRequest): number {
    
    return 0;
  }

  agregarPedido(pedido: PedidoResponse): Observable<any> {
    return this.http.post<any>(this.URL_agregar, pedido);
  }
}
