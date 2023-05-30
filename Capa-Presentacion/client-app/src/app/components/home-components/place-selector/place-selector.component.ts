import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GeneralService } from 'src/app/services/service-general/general.service';
import { DespachadorServicesService } from 'src/app/services/service-despachador/despachador.service';
import { Restaurante } from 'src/app/core/models/restaurante.model';
import { LocalStorageService } from 'angular-web-storage';
@Component({
  selector: 'app-place-selector',
  templateUrl: './place-selector.component.html',
  styleUrls: ['./place-selector.component.css']
})
export class PlaceSelectorComponent implements OnInit{
  nombresRestaurantes: string[] = [];
  selectedPlace: string = "";
  xUpstreamValue: string = '';
  restaurantes: Restaurante[] = [];


  constructor(
    private router: Router, private generalService: GeneralService
    , private servicioDespacher : DespachadorServicesService
    , private localStorage: LocalStorageService
  ) {}
  ngOnInit(): void {
    console.log("Iniciando...");
    this.obtenerValorXUpstream();

    this.generalService.getRestaurantes().subscribe(
      (restaurantes) => {
        this.restaurantes = restaurantes;
        this.nombresRestaurantes = this.restaurantes.map((restaurante) => restaurante.nombre);
      },
      (error) => {
        console.error('Error al obtener los restaurantes', error);
      }
    );

  }
  obtenerValorXUpstream(): void{
    console.log('Obteniendo URL del despachador');
    this.servicioDespacher.getUrlDespachador('general');
  }

  agregarLugar() {
    if (this.selectedPlace) {
      alert(this.selectedPlace);
      this.selectedPlace = '';
    }
  }

  onPlaceSelected(){
    console.log(this.selectedPlace);
    this.localStorage.set('restauranteSesion',this.selectedPlace)
    console.log("Navegando...");
    this.router.navigate(['principal']);
  }
}
