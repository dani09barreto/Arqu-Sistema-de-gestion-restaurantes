import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { UserRegister } from 'src/app/core/models/userRegister.model';
import { AuthService } from 'src/app/services/service-auth/auth.service';
import { RestaurantService } from 'src/app/services/services-restaurant/restaurant.service';

@Component({
  selector: 'app-sign-popup',
  templateUrl: './sign-popup.component.html',
  styleUrls: ['./sign-popup.component.css']
})
export class SignPopupComponent {
  usuario: string="";
  password: string="";
  nombre: string="";
  correo: string="";
  telefono: number=0;
  rol: string="USER";

  constructor(private miServicio: AuthService, public dialogRef: MatDialogRef<SignPopupComponent> ) {}

  registro() {
    const registro: UserRegister = {
      usuario: this.usuario,
      password: this.password,
      nombre: this.nombre,
      correo: this.correo,
      telefono: this.telefono,
      rol: this.rol
    };

    // Aquí puedes realizar las acciones necesarias al registrar el usuario
    this.miServicio.signIn(registro).subscribe(
      response => {
        console.log('Registro exitoso:', response);
        this.dialogRef.close();
        // Realizar otras acciones en caso de éxito
      },
      error => {
        alert("Revisa los campos");
        console.error('Error al registrar:', error);
        // Realizar acciones en caso de error
      }
    );


  }
}
