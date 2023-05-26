import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrincipalPageComponent } from './pages/principal-page/principal-page.component';
import { MenuComponent } from './pages/menu/menu.component';



@NgModule({
  declarations: [
    PrincipalPageComponent,
    MenuComponent
  ],
  imports: [
    CommonModule
  ]
})
export class RestaurantModule { }
