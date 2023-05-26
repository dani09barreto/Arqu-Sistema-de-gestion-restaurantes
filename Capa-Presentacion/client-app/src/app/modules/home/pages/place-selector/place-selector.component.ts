import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-place-selector',
  templateUrl: './place-selector.component.html',
  styleUrls: ['./place-selector.component.css']
})
export class PlaceSelectorComponent {
  lugares: string[] = ["Villa Lucero","La Colina","Fontanar","Salitre"];
  selectedPlace: string = "";

  constructor(private router: Router) {}

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
}
