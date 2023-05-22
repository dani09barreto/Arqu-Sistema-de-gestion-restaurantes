import { Component } from '@angular/core';

@Component({
  selector: 'app-place-selector',
  templateUrl: './place-selector.component.html',
  styleUrls: ['./place-selector.component.css']
})
export class PlaceSelectorComponent {
  lugares: string[] = ["21","21","21","21"];
  selectedPlace: string = "jesus";

  agregarLugar() {
    if (this.selectedPlace) {
      alert(this.selectedPlace);
      //this.lugares.push({ nombre: this.selectedPlace });
      this.selectedPlace = '';
    }
  }
}
