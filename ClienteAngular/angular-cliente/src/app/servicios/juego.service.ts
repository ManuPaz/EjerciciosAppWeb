import { Injectable } from '@angular/core';
import { Juego } from '../intefaces/juego';
import { JuegoAñadido } from '../intefaces/juegoAñadido';
import { Sede } from '../intefaces/sede';
import { JUEGOS } from '../intefaces/mock-juegos';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class JuegoService {
  private juegosUrl = 'http://localhost:8080/juegos';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic ' + btoa('admin:manuel')
    })
  };
  getJuegos(): Observable<Juego[]> {
    this.messageService.add('JuegoService: fetched juegos');

   

   
    return this.http.get<Juego[]>(this.juegosUrl,this.httpOptions).pipe(
        catchError(this.handleError<Juego[]>('getJuegos', []))
      );;
  }
  eliminarJuego( sede:Sede):Observable<string>{
    const params = new HttpParams()
          .set('año',sede.ano)
          .set("tipoSede",sede.descripcion_tipo_jjoo);
       
            let options={params:params,headers:this.httpOptions.headers};
            return this.http.delete<string>(this.juegosUrl+"/eliminar",options).pipe(
              catchError(this.handleError<string>('getJuegos'))
            );

    
   
  }
  editarJuego( sede:Sede, nuevoAño , nuevoTipoSede ,nuevaCiudad):Observable<JuegoAñadido>{

   
    let params = new HttpParams()
    .set('año',sede.ano).set("tipoSede",sede.descripcion_tipo_jjoo);
   if (nuevoAño!=null){
    params=params.set("nuevoAño",nuevoAño);
   }
   if (nuevoTipoSede!=null && nuevoTipoSede!=""){
    params=params.set("nuevoTipoSede",nuevoTipoSede);
    //this.messageService.add("Sede: "+nuevoTipoSede);
   }
   if (nuevaCiudad!=null && nuevaCiudad!=""){
    params=params.set("ciudad",nuevaCiudad);
   }
    
            let options={params:params,headers:this.httpOptions.headers};
            return this.http.put<JuegoAñadido>(this.juegosUrl+"/modificar",params,options).pipe(
              catchError(this.handleError<JuegoAñadido>('getJuegos'))
            );
  


}
añadirJuego(  nuevoAño , nuevaSede ,nuevaCiudad):Observable<JuegoAñadido> {
  
  const params = new HttpParams()
  .set('año',nuevoAño ).set("tipoSede",nuevaSede )
  .set("ciudad",nuevaCiudad);
  let options={params:params,headers:this. httpOptions .headers};
  return this.http.post<JuegoAñadido>(this.juegosUrl+"/anadir",params,options).pipe(
    catchError(this.handleError<JuegoAñadido>('anadirJuego'))
  );



}
  getJuego (id_ciudad: number, tipo_sede:string): Observable<Sede[]> {
    let headers= new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic ' + btoa('admin:manuel')
    });
  
    let params ={'ciudad':id_ciudad,"tipo":tipo_sede};
    this.messageService.add('JuegoService: eliminando juegos');

   
    let options={params:params,headers:this.httpOptions.headers}
   
     
    return this.http.get<Sede[]>(this.juegosUrl+"/ciudad",options).pipe(
        catchError(this.handleError<Sede[]>('getJuego', []))
      );
    
  }
  private log(message: string) {
    this.messageService.add(`JuegoService: ${message}`);
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  constructor(
    private messageService: MessageService,
    private http: HttpClient
  ) {}
}
