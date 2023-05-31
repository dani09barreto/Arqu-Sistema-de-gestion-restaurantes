import { Component } from '@angular/core';
import { Socket } from 'ngx-socket-io';

@Component({
  selector: 'app-cooker-component',
  templateUrl: './cooker-component.component.html',
  styleUrls: ['./cooker-component.component.css']
})
export class CookerComponentComponent {

  constructor(private socket: Socket) { }

  public listenToWebSocket() {
    this.socket.fromEvent('websocket-event').subscribe((data: any) => {
      // Guarda el contenido del WebSocket en alguna propiedad o arreglo dentro del servicio
      console.log('Datos del WebSocket:', data);
      // Ejemplo de almacenamiento en una propiedad del servicio
      this.guardarDatos(data);
    });
  }

  private guardarDatos(data: any) {
    // Aquí puedes realizar alguna lógica para guardar los datos en una propiedad del servicio
  }
  

}
