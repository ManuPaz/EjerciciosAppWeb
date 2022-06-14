import http from "./http-common";
import Juego from "../entidades/juegos.type";
import JuegoAdded from "../entidades/juegoAdded.type";
import Sede from "../entidades/sede.type";
import { disposeEmitNodes } from "typescript";
var sha256 = require('js-sha256');

export function  getJuegos() {
    return http.get<Array<Juego>>("")
  }
export function getJuegoCiudad(idCiudad:string,descripcionTipo:string){
    return http.get<Array<Sede>>("buscar", { params: { ciudad: idCiudad,tipo:descripcionTipo }});


}
export function addJuego(nombreCiudad:string,descripcionTipo:string,ano:number){
    //return http.get<Array<Juego>>("")
    
    return http.post<Juego>("anadir", { ciudad:nombreCiudad,tipo:descripcionTipo,ano:ano });


}
export function removeJuego(sede:Sede){
  
    
    return http.post<Array<Juego>>("/eliminar", { ano: sede.ano,tipo:sede.descripcion_tipo});


}
export function modifyJuego( año:number,tipo:string, nuevoAño:number , nuevoTipoSede:string ,nuevaCiudad:string){
    let params: {[key: string]: string|number}={}
     params["ano"]=año;
     params["tipo"]=tipo;
    if (nuevoAño!=0){
        params["nuevoAno"]=nuevoAño;
    }
    
    if (nuevoTipoSede!=null && nuevoTipoSede!=""){
        params["nuevoTipo"]=nuevoTipoSede;
    }
    if (nuevaCiudad!=null && nuevaCiudad!=""){
        params["ciudad"]=nuevaCiudad;
    
    }
    return http.post<Array<Juego>>("/modificar",params);


}
export function buscarJuego(parametro:string){
    
    return http.post<Array<Juego>>("filtrar", {filtro:parametro});


}
export function login(userName:string,password:string){
    var hash=sha256(password);
    

    return http.post<Boolean>("/login", {user:userName,password:hash});
     
    
   


}
