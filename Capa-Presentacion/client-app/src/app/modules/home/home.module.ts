import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PlaceSelectorComponent } from './pages/place-selector/place-selector.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import { HomeService } from './services/home.service';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    PlaceSelectorComponent,
    HomePageComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule
  ],
  exports: [
    HomePageComponent
  ],
  providers:[
    HomeService,
  ]
})
export class HomeModule { }
