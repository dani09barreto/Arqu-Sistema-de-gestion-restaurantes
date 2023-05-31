import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-components/home-page/home-page.component';
import { PrincipalPageComponent } from './components/restaurant-components/principal-page/principal-page.component';
import { PrincipalLocalComponent } from './components/restaurantAdmin-components/principal-local/principal-local.component';
import { CookerComponent } from './components/cooker-components/cooker/cooker.component';


const routes: Routes  = [ //TODO: router-outlet (Padre)
/*{
  path: 'auth', //TODO (Public) Login, Register, Forgot...
  loadChildren: () => import(`./modules/auth/auth.module`).then(m => m.AuthModule)
},*/
{
  path: '',//TODO (Private) 🔴🔴
  component: HomePageComponent,
  //,  canActivate: [SessionGuard]
},
{
  path: 'principal',
  //component: CookerComponent,

  component: PrincipalPageComponent,

  //component: PrincipalLocalComponent,
  //loadChildren: () => import('./modules/restaurant/restaurant.module').then(m => m.RestaurantModule)
 },
  //{ path: 'modulo2', loadChildren: () => import('./modulo2/modulo2.module').then(m => m.Modulo2Module) },


];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
