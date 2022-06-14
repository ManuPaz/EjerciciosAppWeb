import React, { useState } from "react";
import "./BuscarJuego.css";
import Sede  from "../../app/entidades/sede.type";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { useAppSelector, useAppDispatch } from "../tabla/hooks";
import { cancelEdit, edit, editted,sedes,ciudad,tipo,ano,setAno } from "../../app/redux/editSlice";
import Select from 'react-select';
import { juegosChanged, jugar } from "../../app/redux/juegosSlice";
import { addJuego,buscarJuego,getJuegos,modifyJuego } from "../../app/services/juegos";
import { nanoid } from "@reduxjs/toolkit";
import { cancel, add, added } from "../../app/redux/adderSlice";
import App from "../../App";
import ReactDOM from "react-dom";
import { useRows } from "../tabla/hooks";
export function BuscarJuego() {
  const dispatch = useDispatch();
  const [buscarText, setBuscarText] = useState("");
  

  
 
  const juegos = useSelector(jugar);
   // Declara una nueva variable de estado, la cual llamaremos “count”  const [count, setCount] = useState(0);
   const [count, setCount] = useState(0);
   const edi = useSelector(editted);
   const adde = useSelector(added);
   const sedesPosibles:Sede[] = useSelector(sedes);
   const ciudad1 = useSelector(ciudad);
   const tipo1 = useSelector(tipo);
   const an= useSelector(ano);
   
   
   function handleBuscarChange(event: any) {
    setBuscarText(event.target.value);
    
  }
 
  function filtrar(){
  
    buscarJuego(buscarText).then((response:any) => {
      dispatch(juegosChanged(response.data));
      setBuscarText("");
      })
      .catch((error:any) => {
        console.log(error);
        setBuscarText("");
      })
     
    }

    function cancealarfiltrar(){
      getJuegos().then((response:any) => {
        dispatch(juegosChanged(response.data))
          
        })
        .catch((error:any) => {
          console.log(error)
        })
        setBuscarText("");
      };


  

  if (adde && !edi)
    return (
      <div>
        <h2> Filtrar juegos:</h2>
        
        <form>
          <div>
       
          <label>
           Buscar:
            <input
              type="text"
              name="ciudad"
              value={buscarText}
              onChange={handleBuscarChange}
            ></input>
          </label>
          
         
          <button type="button"onClick={filtrar} >
            ENVIAR
          </button>
          <button type="button"onClick={cancealarfiltrar} >
           LIMPIAR
          </button>
          </div>
        </form>
        
        </div>
    );
    else 
    return (<div></div>)
}
