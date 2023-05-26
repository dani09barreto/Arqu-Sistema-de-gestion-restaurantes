import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './modules/home/pages/home-page/home-page.component';
import { PrincipalPageComponent } from './modules/restaurant/pages/principal-page/principal-page.component';


const routes: Routes  = [ //TODO: router-outlet (Padre)
/*{
  path: 'auth', //TODO (Public) Login, Register, Forgot...
  loadChildren: () => import(`./modules/auth/auth.module`).then(m => m.AuthModule)
},*/
{
  path: '',//TODO (Private) 🔴🔴
  component: HomePageComponent,
  loadChildren: () => import(`./modules/home/home.module`).then(m => m.HomeModule)
  //,  canActivate: [SessionGuard]
},
{
  path: 'principal',
  component: PrincipalPageComponent,
  loadChildren: () => import('./modules/restaurant/restaurant.module').then(m => m.RestaurantModule)
 },
  //{ path: 'modulo2', loadChildren: () => import('./modulo2/modulo2.module').then(m => m.Modulo2Module) },


];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
