import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/services/service-home/home.service';
@Component({
  selector: 'app-place-selector',
  templateUrl: './place-selector.component.html',
  styleUrls: ['./place-selector.component.css']
})
export class PlaceSelectorComponent implements OnInit{
  restaurantes: string[] = ["Villa Lucero","La Colina","Fontanar","Salitre"];
  selectedPlace: string = "";

  constructor(private router: Router, private homeService: HomeService ) {}
  ngOnInit(): void {
    //this.readAvailableRestaurants();
  }

  agregarLugar() {
    if (this.selectedPlace) {
      alert(this.selectedPlace);
      //this.lugares.push({ nombre: this.selectedPlace });
      this.selectedPlace = '';
    }
  }

  onPlaceSelected(){
    console.log("Navegando...");
    this.router.navigate(['principal']);
  }

  readAvailableRestaurants(){
    this.homeService.loadRestaurantes();
    this.restaurantes = this.homeService.getRestaurantes();
  }
}
