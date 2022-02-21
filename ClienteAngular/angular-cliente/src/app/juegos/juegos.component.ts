import { Component, OnInit } from '@angular/core';
import { Juego } from '../juego';
import {JUEGOS } from '../mock-juegos';
import { JuegoService } from '../juego.service';
import { MessageService } from '../message.service';
@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {
  juegos = JUEGOS;
  selectedJuego!: Juego;
  

  constructor(private juegoService: JuegoService,private messageService: MessageService) { }

  ngOnInit(): void {
    this.getJuegos();
  }
  onSelect(juego: Juego): void {
    this. selectedJuego = juego;
    this.messageService.add(`JuegosComponent: Selected juego nombre_ciudad=${juego.nombre_ciudad}`);
  }
  getJuegos(): void {
    this.juegoService.getJuegos()
        .subscribe(juegos => this.juegos=juegos);
  }
 

}
