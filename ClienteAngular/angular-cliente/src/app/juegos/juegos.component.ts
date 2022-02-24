import { Component, OnInit ,ViewChild} from '@angular/core';
import { Juego } from '../intefaces/juego';
import { Sede } from '../intefaces/sede';
import {JUEGOS } from '../intefaces/mock-juegos';
import { JuegoService } from '../servicios/juego.service';
import { MessageService } from '../servicios/message.service';
import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {
  juegos:Juego[];
  columnsToDisplay = ['id_ciudad','nombre_ciudad','id_pais','nombre_pais','numero_veces_sede','descripcion_tipo_jjoo','valor','editar','eliminar'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  dataSource:any;
  constructor(private juegoService: JuegoService,private messageService: MessageService) { }

  ngOnInit(): void {
    this.getJuegos();
   

  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
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
        .subscribe(juegos => {this.juegos=juegos   ;this.dataSource = new MatTableDataSource<Juego>(this.juegos);
          this.dataSource.paginator = this.paginator;
          })
  }
 

}
