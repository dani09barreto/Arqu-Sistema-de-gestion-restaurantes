import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { Observable, map } from 'rxjs';
import { LoginUser } from 'src/app/core/models/loginUser.model';
import { environment } from 'src/environments/environment';
import { DespachadorServices } from '../service-despachador/despachador.service';
import { Token } from 'src/app/core/models/token.model';
import { Usuario } from 'src/app/core/models/usuario.model';
import { UserRegister } from 'src/app/core/models/userRegister.model';


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  ip = this.localStorage.get('auth');
  url = 'http://'+this.ip+'/api';
  urlAuth= '/auth';
  URL= this.url+this.urlAuth;

  constructor(private http: HttpClient,private localStorage: LocalStorageService, private despachaService: DespachadorServices) {
    this.despachaService.getUrlDespachador("auth");
  }

  loginUser: LoginUser | undefined;

  login(user: string, pass: string): Observable<Token> {
    // Realiza la solicitud HTTP para autenticar al usuario
    this.loginUser = {
      username: user,
      password: pass
    };
    console.log(this.loginUser);
    const response = this.http.post<Token>(`${this.URL}/login`, this.loginUser).pipe(
      map((data: Token) => {
        this.localStorage.set('token', data.token);
        console.log(this.localStorage.get('token'));
        this.localStorage.set('username',user);
        return data;
      })
    );
    return response;
  }

  signIn(registro: UserRegister):Observable<any> {
    return this.http.post<any>(`${this.URL}/singUp`, registro);
  }

}

