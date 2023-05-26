import { Component } from '@angular/core';

@Component({
  selector: 'app-principal-page',
  templateUrl: './principal-page.component.html',
  styleUrls: ['./principal-page.component.css']
})
export class PrincipalPageComponent {

  cantidadProductos: number = 0;

  OnInit(){
    console.log("Que pasaa");
  }

  reloadPage() {
    location.reload();
  }

  abrirCarrito(){}

 // constructor(public dialog: MatDialog) {}

  openPopup(): void {

  }
}
