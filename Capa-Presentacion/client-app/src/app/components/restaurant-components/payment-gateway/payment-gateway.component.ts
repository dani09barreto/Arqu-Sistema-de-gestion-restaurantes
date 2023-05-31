import { Component, AfterViewInit, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/core/models/plato.model';
import { CartService } from 'src/app/shared/cart.service';
import { PedidoResponse } from 'src/app/core/models/pedidoResponse';
import { PlatoResponse } from 'src/app/core/models/platoResponse.model';
import { Usuario } from 'src/app/core/models/usuario.model';
import { UsuarioResponse } from 'src/app/core/models/usuarioResponse.model';
import { LocalStorageService } from 'angular-web-storage';
import { RestaurantService } from 'src/app/services/services-restaurant/restaurant.service';
import { PagoRequest } from 'src/app/core/models/pagoResponse.model';


@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit{

  cartItems: Plato[] = [];

  constructor(private router: Router,private cartService: CartService, private localStorage: LocalStorageService, private restService: RestaurantService){
     this.cartService.update();
  }

  ngOnInit(): void {
    this.cartService.platosEnCarritoSubject.subscribe(platos => {
      this.cartItems = platos;
    });
    this.cartService.update();
  }

  mesaDestino: number = 0;
  tipoPago: string = "";
  totalAPagar: string = "";
  seleccionarPropina: boolean= false;

  mesas: number[] = [4, 14, 24, 34]; // Lista de números de mesa

  pedir(): void {

    if(this.localStorage.get('username')===null){
      alert("Inicia Sesión Primero");
    }else{
      this.restService.agregarPedido(this.crearPedido()).subscribe(
        response => {
          // Manejar la respuesta del servidor
          console.log(response);
        },
        error => {
          // Manejar errores
          console.error(error);
        }
      );
      alert("Pedido Creado");
    }
    // Lógica para ir a la página de pago
  }

  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + item.precio, 0);
  }

  crearPedido(): PedidoResponse {
    const platosResponse: PlatoResponse[] = [];
    const platosMap = new Map<number, PlatoResponse>(); // Mapa para almacenar los platos por id

    // Recorrer la lista de platos seleccionados
    for (const plato of this.cartItems) {
      if (platosMap.has(plato.id)) {
        // El plato ya existe en el mapa, incrementar la cantidad
        const platoExistente = platosMap.get(plato.id);
        if (platoExistente) {
          platoExistente.cantidad++;
        }
      } else {
        // El plato no existe en el mapa, crear uno nuevo
        const nuevoPlatoResponse: PlatoResponse = {
          id: plato.id,
          cantidad: 1
        };
        platosMap.set(plato.id, nuevoPlatoResponse);
      }
    }

    // Convertir el mapa de platos en un arreglo
    platosMap.forEach((platoResponse) => {
      platosResponse.push(platoResponse);
    });

    let client: UsuarioResponse;
    let clientTemp: Usuario;


    const clientStr = localStorage.getItem('usuario');
    if (clientStr !== null) {
      clientTemp = JSON.parse(clientStr);
      client = {
        usuario: clientTemp.usuario,
        nombre: clientTemp.nombre,
        correo: clientTemp.correo,
        telefono: clientTemp.telefono
      };


      console.log(client);
    }else{
      client = {
        usuario: 'ejemplo',
        nombre: 'John Doe',
        correo: 'johndoe@example.com',
        telefono: BigInt(1234567890)
      };
    }

    // Crear el objeto PedidoResponse
    const pedido: PedidoResponse = {
      mesaId: this.mesaDestino, // Asigna aquí el ID de la mesa correspondiente
      cliente: client,
      platos: platosResponse
    };

    console.log(pedido);

    var valorParcial: number= this.getTotalPrice();

      if (this.seleccionarPropina) {
        var add: string[] = ["IVA", "PROPINA"];
        // Aplicar lógica para incluir la propina en el cálculo del total
        // Puedes usar un valor fijo o calcularlo en base a algún porcentaje
      } else {
        var add: string[] = ["IVA", "PROPINA"];
        // Aplicar lógica para calcular el total sin propina
      }
      const pago: PagoRequest ={
        valor: valorParcial,
        tipoPago: this.tipoPago,
        pedido: pedido,
        adiciones: add
      }
      this.totalAPagar = this.restService.getTotalApagar(pago);


    return pedido;
  }

  register(): void {
    // Lógica para registro de usuario
  }
}



