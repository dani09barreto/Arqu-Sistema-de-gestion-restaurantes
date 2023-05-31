import { Component } from '@angular/core';
import { PedidoRequest } from 'src/app/core/models/pedidoRequest.model';

@Component({
  selector: 'app-estados-cooker',
  templateUrl: './estados-cooker.component.html',
  styleUrls: ['./estados-cooker.component.css']
})
export class EstadosCookerComponent {

  pedidos: PedidoRequest[] = []; // Asigna los pedidos recibidos por websockets a esta propiedad


}
