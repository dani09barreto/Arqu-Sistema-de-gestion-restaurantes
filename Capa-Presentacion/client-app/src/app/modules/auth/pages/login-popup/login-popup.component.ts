import {MatDialog} from '@angular/material/dialog';
import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import {MatDialogRef} from '@angular/material/dialog';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';
//import { AuthService } from '@modules/auth/services/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['./login-popup.component.css']
})
export class LoginPopupComponent implements OnInit {

  errorSession: boolean = false
  formLogin: UntypedFormGroup = new UntypedFormGroup({});

  @Output() private update = new EventEmitter<string>();
  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<LoginPopupComponent>
     //private authService: AuthService,
     ,private cookie: CookieService,
      private router: Router

     ) { }

     ngOnInit(): void {
      this.formLogin = new UntypedFormGroup(
        {
          email: new UntypedFormControl('', [
            Validators.required,
            Validators.email
          ]),
          password: new UntypedFormControl('',
            [
              Validators.required,
              Validators.minLength(6),
              Validators.maxLength(12)
            ])
        }
      )
    }


    sendLogin(): void {
      /*
      const { email, password } = this.formLogin.value
      this.authService.sendCredentials(email, password)
        //TODO: 200 <400
        .subscribe(responseOk => { //TODO: Cuando el usuario credenciales Correctas ✔✔
          console.log('Session iniciada correcta', responseOk);
          const { tokenSession, data } = responseOk
          this.cookie.set('token', tokenSession, 4, '/') //TODO:📌📌📌📌
          this.router.navigate(['/', 'tracks'])
        },
          err => {//TODO error 400>=
            this.errorSession = true
            console.log('⚠⚠⚠⚠Ocurrio error con tu email o password');
          })
*/
    }




  onNoClick(): void{
    this.dialogRef.close();
  }


}
