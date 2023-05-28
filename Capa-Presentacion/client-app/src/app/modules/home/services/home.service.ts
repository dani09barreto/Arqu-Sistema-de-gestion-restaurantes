import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  url = 'http://localhost:100';
  constructor(private http: HttpClient) { }

  getDatos(): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url, { observe: 'response' });
  }
}
