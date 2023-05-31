import {MatDialog} from '@angular/material/dialog';
import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import {MatDialogRef} from '@angular/material/dialog';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';
//import { AuthService } from '@modules/auth/services/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/service-auth/auth.service';
import { GeneralService } from 'src/app/services/service-general/general.service';



@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['./login-popup.component.css']
})
export class LoginPopupComponent implements OnInit {

  errorSession: boolean = false
  formLogin: UntypedFormGroup = new UntypedFormGroup({});
  username: string = "";
  password: string = "";

  @Output() private update = new EventEmitter<string>();
  constructor(
    //private service:ServicioService,
     public dialogRef: MatDialogRef<LoginPopupComponent>
     //private authService: AuthService,
     ,private authService: AuthService,
     private generalService: GeneralService


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


    login(): void {
      console.log("Enviando LoginUser..")
      /*
      if (this.formLogin.invalid) {
        return;
      }*/
      const username = this.username ;
      const password = this.password;
      this.authService.login(username, password).subscribe(
        (respo) => {
          console.log(respo);
          this.generalService.saveUser(username);
          this.dialogRef.close();
        },
        () => {
          this.errorSession = true;
          alert("Contraseña Incorrecta")
        }
      );
    }




  onNoClick(): void{
    this.dialogRef.close();
  }


}
