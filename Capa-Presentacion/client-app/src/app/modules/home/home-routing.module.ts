import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrincipalPageComponent } from '../restaurant/pages/principal-page/principal-page.component';

const routes: Routes = [
  {
  path: 'principal',
  component: PrincipalPageComponent,
  loadChildren: () => import('../restaurant/restaurant.module').then(m => m.RestaurantModule)
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
