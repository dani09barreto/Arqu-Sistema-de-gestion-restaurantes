import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-principal-local',
  templateUrl: './principal-local.component.html',
  styleUrls: ['./principal-local.component.css']
})
export class PrincipalLocalComponent {
  reloadPage() {
    console.log("Navegando...");
    this.router.navigate(['']);
  }

  constructor(private router: Router) {}

}
