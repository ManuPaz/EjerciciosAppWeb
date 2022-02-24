import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JuegosComponent } from './juegos/juegos.component';
import { JuegoDetailComponent } from './juego-detail/juego-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { EdicionJuegosComponent } from './edicion-juegos/edicion-juegos.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import {MatPaginatorModule} from '@angular/material/paginator'
import { MatPaginator } from '@angular/material/paginator';
import { AnadirComponent } from './anadir/anadir.component';


@NgModule({
  declarations: [
    AppComponent,
    JuegosComponent,
    JuegoDetailComponent,
    MessagesComponent,
    EdicionJuegosComponent,
    AnadirComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    
    
   
    
    
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
