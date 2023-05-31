import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';
import { Usuario } from 'src/app/core/models/usuario.model';
import { DespachadorServices } from '../service-despachador/despachador.service';
import { PedidoResponse } from 'src/app/core/models/pedidoResponse';
import { PagoRequest } from 'src/app/core/models/pagoResponse.model';
import { Mesa } from 'src/app/core/models/mesa.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {


  ip = this.localStorage.get(this.localStorage.get('restauranteSesion'));//busco la IP asoaciada a ese restaurante en sesion

  url = 'http://'+this.ip+'/api/restaurante/pedido';
  URL_agregar= this.url+'/agregar';
  URL_mesas= 'http://'+this.ip+'/api/restaurante/mesa/listAll';

  URL_agregarPago= 'http://'+this.ip+'/api/restaurante/pago/agregar';

  constructor(private http: HttpClient, private localStorage: LocalStorageService, private despachador : DespachadorServices) {
    this.despachador.getUrlDespachador(this.localStorage.get('restauranteSesion'));
  }

    agregarPedido(pedido: PedidoResponse): Observable<any> {
      const token: string= 'Bearer '+ this.localStorage.get('token');
      const headers = new HttpHeaders({
        'Authorization': token
      });
      alert("Pedido Creado");
       return this.http.post<any>(this.URL_agregar, pedido, { headers });
    }


    agregarPago(pago: PagoRequest):Observable<any> {
      const token: string= 'Bearer '+ this.localStorage.get('token');
      const headers = new HttpHeaders({
        'Authorization': token
      });
      alert("Pago Creado");
      return this.http.post<any>(this.URL_agregarPago, pago, { headers });
    }

    getMesas(): Observable<Mesa[]> {
      return this.http.get<Mesa[]>(this.URL_mesas);
    }

    /**
     * Implementacion WS
    */




}
