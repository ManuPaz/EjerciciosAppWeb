import React, { useState } from "react";
import "./EditJuego.css";
import Sede  from "../../app/entidades/sede.type";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { useAppSelector, useAppDispatch } from "../tabla/hooks";
import { cancelEdit, edit, editted,sedes,ciudad,tipo,ano,setAno } from "../../app/redux/editSlice";
import Select from 'react-select';
import { juegosChanged, jugar } from "../../app/redux/juegosSlice";
import { addJuego,modifyJuego } from "../../app/services/juegos";
import { nanoid } from "@reduxjs/toolkit";
import App from "../../App";
import ReactDOM from "react-dom";
import { useRows } from "../tabla/hooks";
export function EditJuego() {
  const dispatch = useDispatch();
  const [ciudadText, setCiudad] = useState("");
  const [año, setAño] = useState(0);
  const [tipoText, setTipo] = useState("VERANO");
  
  function removeComponents() {
    setCiudad("");
    dispatch(cancelEdit());
  }
  function handleCiudadChange(event: any) {
    setCiudad(event.target.value);
  }
  function handleAñoChange(event: any) {
    setAño(event.target.value);
  }
  function handleTipoChange(event: any) {
    setTipo(event.target.value);
  }
  const juegos = useSelector(jugar);
   // Declara una nueva variable de estado, la cual llamaremos “count”  const [count, setCount] = useState(0);
   const [count, setCount] = useState(0);
   const adde = useSelector(editted);
   const sedesPosibles:Sede[] = useSelector(sedes);
   const ciudad1 = useSelector(ciudad);
   const tipo1 = useSelector(tipo);
   const an= useSelector(ano);
   
   
   function handleAñoSedeChange(event: any) {
    dispatch(setAno(event.target.value));
    
  }
 
  function modificar(){
    modifyJuego(an,tipo1,año,tipoText,ciudadText).then((response) => {
      dispatch(juegosChanged(response.data))
      //alert(juegos[0]);
      setCiudad("");
      dispatch(cancelEdit());
     
     
    })
    .catch((error) => {
      console.log(error);
      alert("No se ha modificado la sede");
      //dispatch(cancelEdit());
    })

   //



  }


  

  if (adde)
    return (
      <div>
        <h2> Editar sede: {ciudad1}-{tipo1}</h2>
        
        <form>
          <div>
        <label>
            Sede :
            <select name="sede" value={an}  onChange={handleAñoSedeChange} >
            {sedesPosibles.map((item:Sede) => {
              return (<option key={item.ano}  value={item.ano}>{item.ano}</option>);
          })}

            </select>
              
        
          </label>
          </div>
          <label>
            Nueva ciudad:
            <input
              type="text"
              name="ciudad"
              value={ciudadText}
              onChange={handleCiudadChange}
            ></input>
          </label>
          <div>
          <label>
            Nuevo tipo de juegos:
            <select name="tipoSede" value={tipoText} onChange={handleTipoChange}>
              <option value="VERANO">VERANO</option>
              <option value="INVIERNO">INVIERNO</option>
            </select>
          </label>
          </div>
          <label>
            Nuevo año:
            <input
              type="number"
              placeholder=""
              name="ano"
              value={año}
              min="1896"
              max="2050"
              onChange={handleAñoChange}
            ></input>
          </label>
         
          <button type="button"onClick={modificar} >
            ENVIAR
          </button>
        </form>

        <div>
          <button type="button" onClick={removeComponents}>
            Cancelar
          </button>
        </div>
      </div>
    );
    else 
    return (<div></div>)
}
