import { Component, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent{

  constructor(private router: Router){}

  mesaDestino: number = 0;
  metodoPago: string = "";

  mesas: number[] = [1, 2, 3, 4, 5]; // Lista de números de mesa

  goToPayment(): void {
    // Lógica para ir a la página de pago
  }

  register(): void {
    // Lógica para registro de usuario
  }
}
