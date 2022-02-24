import { Component, OnInit ,Input} from '@angular/core';
import { Juego } from '../juego';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { JuegoService } from '../juego.service';
import { MessageService } from '../message.service';
import { Sede } from '../sede';
@Component({
  selector: 'app-juego-detail',
  templateUrl: './juego-detail.component.html',
  styleUrls: ['./juego-detail.component.css']
})
export class JuegoDetailComponent implements OnInit {
  sedes!: Sede[];
  nombre_ciudad:string;
  selectedSede: Sede;
  ciudad_añadir:string;
  ocultar_edicion=false;
  constructor(private route: ActivatedRoute,
    private juegoService: JuegoService,
    private location: Location,
    private messageService: MessageService) { }

  ngOnInit(): void {
    this.getSedes();
  }
  getSedes(): void {
    const id = +this.route.snapshot.paramMap.get('id_ciudad');
    const tipo = this.route.snapshot.paramMap.get('tipo');
    this.nombre_ciudad= this.route.snapshot.paramMap.get('nombre_ciudad');
    this.juegoService.getJuego(id,tipo).subscribe(juegos=>this.sedes=juegos);
    this.ocultar_edicion=false;
    
  }
  onSelect(hero: Sede): void {
    this.selectedSede = hero;
    this.ciudad_añadir=null;
    this.ocultar_edicion=false;
  }
  onSelect1(): void {
    this.ciudad_añadir=this.nombre_ciudad;
    this.ocultar_edicion=true;
 
    
  }
  goBack(): void {
    this.location.back();
  }


}
