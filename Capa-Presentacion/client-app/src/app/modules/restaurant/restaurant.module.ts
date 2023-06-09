import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrincipalPageComponent } from './pages/principal-page/principal-page.component';
import { MenuComponent } from './pages/menu/menu.component';
import { ShoppingCartComponent } from './pages/shopping-cart/shopping-cart.component';



@NgModule({
  declarations: [
    PrincipalPageComponent,
    MenuComponent,
    ShoppingCartComponent
  ],
  imports: [
    CommonModule
  ]
})
export class RestaurantModule { }
