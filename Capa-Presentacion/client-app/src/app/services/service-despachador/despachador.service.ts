import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import axios from 'axios';
import { Observable, map } from 'rxjs';
import { DestServer } from '../../core/models/destServer.model';
import { LocalStorageService } from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})
export class DespachadorServices {

  urlDespachador = 'http://localhost:1000/api/dispatcher';

  constructor(private http: HttpClient,private localStorage: LocalStorageService) { }
  getUrlDespachador(destination : string) {
      console.log('Obteniendo URL del despachador');
      this.http.get<DestServer>(
        this.urlDespachador
         + '/dest='
         + destination
         + '/server').subscribe((response) =>      this.localStorage.set(destination,response.direccion));
  }
}
