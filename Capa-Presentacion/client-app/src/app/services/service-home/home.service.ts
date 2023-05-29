import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  url = 'http://localhost:100';
  urlSelector= '/general/restaurantes/listar/nombres';

  private restaurantes: string[] = [];

  constructor(private http: HttpClient) { }

  getDatos(): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url, { observe: 'response' });
  }

  getRestaurantes(): string[] {
    return this.restaurantes;
  }

  loadRestaurantes(): void {
    this.http.get<string[]>(this.urlSelector).subscribe(
      (data) => {
        this.restaurantes = data;
      },
      (error) => {
        console.error('Error al cargar los restaurantes', error);
      }
    );
  }
}
