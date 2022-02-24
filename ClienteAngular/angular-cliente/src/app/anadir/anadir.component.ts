
import { Component, OnInit,Input } from '@angular/core';
import { Juego } from '../intefaces/juego';
import { NuevoJuego } from '../intefaces/nuevoJuego';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { JuegoService } from '../servicios/juego.service';
import { MessageService } from '../servicios/message.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-anadir',
  templateUrl: './anadir.component.html',
  styleUrls: ['./anadir.component.css']
})

export class AnadirComponent implements OnInit {

  
  
  nuevoJuego:FormGroup;
 
  ano;
  tipoSede;
  ciudad1=null;
  constructor(private route: ActivatedRoute,
    private juegoService: JuegoService,
    private location: Location,
    private messageService: MessageService) { }

    goBack(): void {
      this.location.back();
    }
  onSubmit(){
    
    this.ano=this.nuevoJuego.get("ano").value;
    this.ciudad1=this.nuevoJuego.get("ciudad").value;
    this.tipoSede=this.nuevoJuego.get("tipoSede").value;
    
      
      


    
   
      this.juegoService.añadirJuego(this.ano,this.tipoSede,this.ciudad1).subscribe(resultado=>{
        if (resultado!=null && resultado.ciudad.nombreciudad){
          this.messageService.add(resultado.ciudad.nombreciudad);
          alert("Se han guardado los camnbios");
        this.back();
        }else{
          alert("No se han guardado los cambios");
        }
      });
    
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
