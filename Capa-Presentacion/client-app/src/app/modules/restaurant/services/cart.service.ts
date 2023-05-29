import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cantidadProductos = 0;
  cantidadProductosSubject = new Subject<number>();
/*
  get cantidadProducto(): number {
    return this.cantidadProductos;
  }
*/
  agregarProducto(): void {
    this.cantidadProductos++;
    this.cantidadProductosSubject.next(this.cantidadProductos);
  }
}
