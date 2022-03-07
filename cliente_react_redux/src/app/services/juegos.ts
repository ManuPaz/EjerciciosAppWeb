import http from "./http-common";
import Juego from "../entidades/juegos.type";
import JuegoAdded from "../entidades/juegoAdded.type";
import Sede from "../entidades/sede.type";
import { disposeEmitNodes } from "typescript";
export function  getJuegos() {
    return http.get<Array<Juego>>("")
  }
export function getJuegoCiudad(idCiudad:string,descripcionTipo:string){
    return http.get<Array<Sede>>("ciudad", { params: { ciudad: idCiudad,tipo:descripcionTipo }});


}
export function addJuego(nombreCiudad:string,descripcionTipo:string,ano:number){
    //return http.get<Array<Juego>>("")
    return http.post<Juego>("anadir",null, { params: { ciudad:nombreCiudad,tipoSede:descripcionTipo,año:ano }});


}
export function removeJuego(sede:Sede){
  

    return http.delete<Array<Juego>>("/eliminar", { params: { año: sede.ano,tipoSede:sede.descripcion_tipo_jjoo }});


}
export function modifyJuego( año:number,tipo:string, nuevoAño:number , nuevoTipoSede:string ,nuevaCiudad:string){
    let params: {[key: string]: string|number}={}
     params["año"]=año;
     params["tipoSede"]=tipo;
    if (nuevoAño!=0){
        params["nuevoAño"]=nuevoAño;
    }
    
    if (nuevoTipoSede!=null && nuevoTipoSede!=""){
        params["nuevoTipoSede"]=nuevoTipoSede;
    }
    if (nuevaCiudad!=null && nuevaCiudad!=""){
        params["ciudad"]=nuevaCiudad;
    
    }
    return http.put<Array<Juego>>("/modificar",null, { params: params});


}
