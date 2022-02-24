import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Juego } from '../intefaces/juego';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
  const juegos = [
    { id_pais: 11,nombre_ciudad:"Madrid",id_ciudad:3,nombre_pais:"España",valor:10,numero_veces_sede:20,descripcion_tipo_jjoo:"verano",año:1 },
    { id_pais: 11,nombre_ciudad:"Barcelona",id_ciudad:1,nombre_pais:"España",valor:10,numero_veces_sede:20,descripcion_tipo_jjoo:"invierno",año:1 }];
    return {juegos};
  }


  
}
