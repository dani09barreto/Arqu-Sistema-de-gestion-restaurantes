import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrincipalPageComponent } from './components/restaurant-components/principal-page/principal-page.component';
import { MenuComponent } from './components/restaurant-components/menu/menu.component';
import { ShoppingCartComponent } from './components/restaurant-components/shopping-cart/shopping-cart.component';
import { PaymentGatewayComponent } from './components/restaurant-components/payment-gateway/payment-gateway.component';
import { PlaceSelectorComponent } from './components/home-components/place-selector/place-selector.component';
import { LoginPopupComponent } from './components/auth-components/login-popup/login-popup.component';
import { HomePageComponent } from './components/home-components/home-page/home-page.component';
import { CookerComponent } from './components/cooker-components/cooker/cooker.component';
import { EstadosCookerComponent } from './components/cooker-components/webSocketPublic/estados-cooker/estados-cooker.component';
import { WaiterComponent } from './components/restaurant-components/webSocketSubs/waiter/waiter.component';
import { SignPopupComponent } from './components/auth-components/signin-popup/sign-popup/sign-popup.component';

@NgModule({
  declarations: [
    AppComponent,
    PrincipalPageComponent,
    MenuComponent,
    ShoppingCartComponent,
    PaymentGatewayComponent,
    PlaceSelectorComponent,
    LoginPopupComponent,
    HomePageComponent,
    CookerComponent,
    EstadosCookerComponent,
    WaiterComponent,
    SignPopupComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule
  ],

  /**PONER LO DE COOKIESS */
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
