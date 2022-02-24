import { AnadirComponent } from './anadir/anadir.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JuegosComponent } from './juegos/juegos.component';
import { JuegoDetailComponent } from './juego-detail/juego-detail.component';

const routes: Routes = [
  { path: 'juegos', component: JuegosComponent },
  { path: 'detail/:id_ciudad/:tipo/:nombre_ciudad', component: JuegoDetailComponent },
  { path: 'anadir', component: AnadirComponent },
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
