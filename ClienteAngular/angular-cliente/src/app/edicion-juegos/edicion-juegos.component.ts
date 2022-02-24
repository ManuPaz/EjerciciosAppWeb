import { Component, OnInit,Input } from '@angular/core';
import { Juego } from '../juego';
import { NuevoJuego } from '../nuevoJuego';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { JuegoService } from '../juego.service';
import { MessageService } from '../message.service';

import { Sede } from '../sede';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-edicion-juegos',
  templateUrl: './edicion-juegos.component.html',
  styleUrls: ['./edicion-juegos.component.css']
})
export class EdicionJuegosComponent implements OnInit {
  @Input() sede:Sede;
  @Input() ocultar:boolean;
  nuevoJuego:FormGroup;
  @Input() ciudad:string;
  ano;
  tipoSede;
  ciudad1=null;
  constructor(private route: ActivatedRoute,
    private juegoService: JuegoService,
    private location: Location,
    private messageService: MessageService) { }


  onSubmit(){
    
    this.ano=this.nuevoJuego.get("ano").value;
    this.messageService.add("Ano"+this.ano);
    this.ciudad1=this.nuevoJuego.get("ciudad").value;
    this.tipoSede=this.nuevoJuego.get("tipoSede").value;
    if (!this.ocultar){
      this.juegoService.editarJuego(this.sede,this.ano,this.tipoSede,this.ciudad1).subscribe(resultado=>this.messageService.add(resultado));
      


    }
    else{
      this.juegoService.añadirJuego(this.ano,this.tipoSede,this.ciudad1).subscribe(resultado=>this.messageService.add(resultado));
      

    }
   


  }
  back(): void {
    this.location.back()
  }

  ngOnInit(): void {
   
    this.nuevoJuego=new FormGroup({
      ano:new FormControl(""),
      tipoSede:new FormControl(""),
      ciudad:new FormControl("")

    });
  }

}
