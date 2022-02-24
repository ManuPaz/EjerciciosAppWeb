import { Component, OnInit } from '@angular/core';
import { Juego } from '../juego';
import { Sede } from '../sede';
import {JUEGOS } from '../mock-juegos';
import { JuegoService } from '../juego.service';
import { MessageService } from '../message.service';
import { asLiteral } from '@angular/compiler/src/render3/view/util';
@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {
  juegos:Juego[];
  columnsToDisplay = ['editar','id_ciudad','nombre_ciudad','id_pais','nombre_pais','numero_veces_sede','descripcion_tipo_jjoo','valor','eliminar'];
  

  constructor(private juegoService: JuegoService,private messageService: MessageService) { }

  ngOnInit(): void {
    this.getJuegos();
  }
  eliminar(juego: Juego): void {
    let sedes:Sede[];
    this.juegoService.getJuego(juego.id_ciudad,juego.descripcion_tipo_jjoo).subscribe(
      eliminadas=>{sedes=eliminadas;
      sedes.forEach(element => {
      
        this.juegoService.eliminarJuego(element).subscribe(mensaje=>{
          this.messageService.add(mensaje);
          this.getJuegos();
        })
        
      });


    })

    
  }
  
  
  getJuegos(): void {
    this.juegoService.getJuegos()
        .subscribe(juegos => this.juegos=juegos);
  }
 

}
