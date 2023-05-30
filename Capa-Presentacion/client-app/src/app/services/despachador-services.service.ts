import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import axios from 'axios';
import { Observable, map } from 'rxjs';
import { DestServer } from '../core/models/destServer.model';

@Injectable({
  providedIn: 'root'
})
export class DespachadorServicesService {

  urlDespachador = 'http://192.168.10.8:8280/api/dispatcher';
  

  constructor(private http: HttpClient) { }

  getUrlDespachador(destination : string) :void {
    console.log('Obteniendo URL del despachador');
    this.http.get<DestServer>(this.urlDespachador + '/dest=' + destination + '/server').subscribe((response) => console.log(response));
  }
}
