import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Plato } from 'src/app/core/models/plato.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cantidadProductos = 0;
  cantidadProductosSubject = new Subject<number>();

  private mostrarContenidoPagoSubject = new Subject<boolean>();
  mostrarContenidoPago$ = this.mostrarContenidoPagoSubject.asObservable();

  mostrarContenidoPago(mostrar: boolean): void {
    this.mostrarContenidoPagoSubject.next(mostrar);
  }

  getCantidadProducto(): number {
    return this.cantidadProductos;
  }

  private platosEnCarrito: Plato[] = [];
  platosEnCarritoSubject = new Subject<Plato[]>();

  getPlatosEnCarrito(): Plato[] {
    return this.platosEnCarrito;
  }

  update():void{
    this.cantidadProductosSubject.next(this.cantidadProductos);
    this.platosEnCarritoSubject.next(this.platosEnCarrito);
  }

  removeProducto():void{
    this.cantidadProductos--;
    this.update();
  }

  agregarProducto(plato: Plato): void {
    this.cantidadProductos++;
    this.platosEnCarrito.push(plato);
    this.update();
  }
}
