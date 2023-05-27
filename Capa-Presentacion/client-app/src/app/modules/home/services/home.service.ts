import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private http: HttpClient) { }
  url: string = 'http://localhost:100';

  getData():void {
    this.http.get(this.url, { observe: 'response', responseType: 'text' }).subscribe(
      (response: HttpResponse<string>) => {
        // Obtener los encabezados de la respuesta
        const headers: HttpHeaders = response.headers;

        // Obtener un encabezado específico por su nombre
        const serverHeader: string | null = headers.get('Server');
        const dateHeader: string | null = headers.get('Date');
        const contentTypeHeader: string | null = headers.get('Content-Type');
        const contentLengthHeader: string | null = headers.get('Content-Length');
        const connectionHeader: string | null = headers.get('Connection');
        const accessControlAllowOriginHeader: string | null = headers.get('Access-Control-Allow-Origin');
        const upstreamHeader: string | null = headers.get('X-Upstream');

        // Imprimir los valores de los encabezados
        console.log('Server:', serverHeader);
        console.log('Date:', dateHeader);
        console.log('Content-Type:', contentTypeHeader);
        console.log('Content-Length:', contentLengthHeader);
        console.log('Connection:', connectionHeader);
        console.log('Access-Control-Allow-Origin:', accessControlAllowOriginHeader);
        console.log('X-Upstream:', upstreamHeader);

        console.log('Body:', response.body);
      },
      (error) => {
        console.error(error); // Manejo de errores
      }
    );




  }

}
/*
    return this.http.get(this.url, { responseType: 'text', observe: 'response' })
    .subscribe(
      (response: HttpResponse<string>) => {
        console.log('Respuesta desde Nginix:', response.body);

        // Obtener el encabezado "Date" de la respuesta
        const dateHeader = response.headers.get('Date');
        console.log('Valor del encabezado "Date":', dateHeader);
      },
      error => {
        console.error('Error:', error);
      }
    );*/
