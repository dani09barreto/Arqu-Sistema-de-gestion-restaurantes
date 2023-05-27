import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginPopupComponent } from '../auth/pages/login-popup/login-popup.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PlaceSelectorComponent } from './pages/place-selector/place-selector.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';



@NgModule({
  declarations: [
    PlaceSelectorComponent,
    HomePageComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MatDialogModule
  ],
  exports: [
    HomePageComponent
  ]
})
export class HomeModule { }
