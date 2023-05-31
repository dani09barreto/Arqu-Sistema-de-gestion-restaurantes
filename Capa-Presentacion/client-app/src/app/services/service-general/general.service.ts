import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/core/models/menu.model';
import { Restaurante } from 'src/app/core/models/restaurante.model';
import { Usuario } from 'src/app/core/models/usuario.model';
import { HttpHeaders } from '@angular/common/http';
import { DespachadorServices } from '../service-despachador/despachador.service';


@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  ipGeneral = this.localStorage.get('general');

  url = 'http://'+this.ipGeneral+'/api';
  urlSelector= '/general/restaurantes/listar';
  urlMenu= '/general/menus/listar';
  urlUser= '/general/usuarios';
  URL= this.url+this.urlSelector;
  URL_= this.url+this.urlMenu;
  URLUsuario= this.url+this.urlUser;

  constructor(private http: HttpClient, private localStorage: LocalStorageService, private despachador : DespachadorServices) {
    this.despachador.getUrlDespachador("general");
  }

  getRestaurantes(): Observable<Restaurante[]> {
        return this.http.get<Restaurante[]>(this.URL);
  }

  getMenus(): Observable<Menu[]> {
    return this.http.get<Menu[]>(this.URL_);
  }

  getUsuario(username: string): Observable<Usuario> {
    const token: string= 'Bearer '+ this.localStorage.get('token');
    const headers = new HttpHeaders({
      'Authorization': token
    });
    return this.http.get<Usuario>(this.URLUsuario+'/usuario='+username,{headers});

  }

  user: Usuario={
    id: 0,
    usuario: '',
    password: '',
    nombre: '',
    correo: '',
    telefono: 0n
  }

  saveUser(username: string) {
    this.getUsuario(username).subscribe(
      (user) => {
        this.user = user;
        console.log(user.nombre);
        localStorage.setItem('usuario', JSON.stringify(this.user));
      },
      (error) => {
        console.error('Error al obtener Usuario', error);
      }
    )
  }

}

/*
const usuarioString = localStorage.getItem('usuario');
if (usuarioString) {
  const usuario: Usuario = JSON.parse(usuarioString);
  console.log(usuario);
} else {
  console.log('No se encontró ningún objeto de usuario en el LocalStorage');
}

*/
