import { NumberValueAccessor } from "@angular/forms";

export interface JuegoAñadido{

    id:{año:number,tipo:number}
    ciudad:{id_ciudad:number,valor_ciudad:number,nombreciudad:string,pais:{id_pais:number,nombrepais:string,codigo_pais:string,valor_pais:string}}
    tipo_jjoo:{id_tipo_jjoo:number,descripciontipo:string}
}