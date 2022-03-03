import http from "./http-common";
import Juego from "../entidades/juegos.type";
import JuegoAdded from "../entidades/juegoAdded.type";
import Sede from "../entidades/sede.type";
import { disposeEmitNodes } from "typescript";
export function  getJuegos() {
    return http.get<Array<Juego>>("")
  }
export function getJuegoCiudad(nombreCiudad:string,descripcionTipo:string){
    return http.get<Array<JuegoAdded>>("/ciudad", { params: { ciudad: nombreCiudad,tipo:descripcionTipo }});


}
export function addJuego(nombreCiudad:string,descripcionTipo:string,ano:number){
    //return http.get<Array<Juego>>("")
    return http.post<Juego>("anadir",null, { params: { "ciudad":nombreCiudad,"tipoSede":descripcionTipo,"año":ano }});


}
export function removeJuego(sede:Sede){
  

    return http.delete<Array<JuegoAdded>>("/modificar", { params: { año: sede.ano,tipoSede:sede.descripcion_tipo_jjoo }});


}
export function modifyJuego( sede:Sede, nuevoAño:number , nuevoTipoSede:string ,nuevaCiudad:string){
    let params = {año:sede.ano,tipoSede:sede.descripcion_tipo_jjoo,nuevoTipoSede:nuevoTipoSede,nuevoAño:nuevoAño,ciudad:nuevaCiudad};
    if (nuevoAño!=null){
    
    }
    if (nuevoTipoSede!=null && nuevoTipoSede!=""){
  
    }
    if (nuevaCiudad!=null && nuevaCiudad!=""){
    
    }
    return http.put<Array<JuegoAdded>>("/ciudad", { params: params});


}
