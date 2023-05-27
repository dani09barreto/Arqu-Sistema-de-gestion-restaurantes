import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrincipalPageComponent } from './pages/principal-page/principal-page.component';
import { MenuComponent } from './pages/menu/menu.component';
import { ShoppingCartComponent } from './pages/shopping-cart/shopping-cart.component';
import {MatDialogModule} from '@angular/material/dialog';
import { LoginPopupComponent } from '../auth/pages/login-popup/login-popup.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PrincipalPageComponent,
    MenuComponent,
    ShoppingCartComponent,
    LoginPopupComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MatDialogModule
  ],
  exports: [
    PrincipalPageComponent
  ]
})
export class RestaurantModule { }
