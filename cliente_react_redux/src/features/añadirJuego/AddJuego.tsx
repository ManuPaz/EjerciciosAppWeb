import React, { useState } from "react";
import "./AddJuego.css";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { useAppSelector, useAppDispatch } from "../tabla/hooks";
import { cancel, add, added } from "../../app/redux/adderSlice";
import { juegosChanged,jugar } from "../../app/redux/juegosSlice";
import { addJuego } from "../../app/services/juegos";
import { nanoid } from "@reduxjs/toolkit";
import App from "../../App";
import ReactDOM from "react-dom";
import {useRows} from "../tabla/hooks";
export function AddJuego() {
  const dispatch = useDispatch();
  const [ciudad, setCiudad] = useState("Barcelona");
  const [año, setAño] = useState(2000);
  const [tipo, setTipo] = useState("VERANO");
  
  function addComponents() {
    dispatch(add());
  }
  function removeComponents() {
    dispatch(cancel());
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
  
  function anadir() {
 
   
    addJuego(ciudad,tipo,año).then((response) => {
      dispatch(juegosChanged(response.data))
      //alert(juegos[0]);
      dispatch(cancel());
     
     
    })
    .catch((error) => {
      console.log(error);
      dispatch(cancel());
    })
    
  }

  // Declara una nueva variable de estado, la cual llamaremos “count”  const [count, setCount] = useState(0);
  const [count, setCount] = useState(0);
  const adde = useSelector(added);
  if (adde) {
    return (
      <div>
        <button className="boton2" type="button" onClick={addComponents}>
          Añadir sede
        </button>
        {adde}
      </div>
    );
  } else {
    return (
      <div>
        <h2> Añadir sede</h2>
        <form>
          <label>
            Ciudad:
            <input
              type="text"
              name="ciudad"
              value={ciudad}
              onChange={handleCiudadChange}
            ></input>
          </label>

          <label>
            Tipo de juegos:
            <select name="tipoSede" value={tipo} onChange={handleTipoChange}>
              <option value="VERANO">VERANO</option>
              <option value="INVIERNO">
                INVIERNO
              </option>
            </select>
          </label>
          <label>
            Año:
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

          <button type="button"  onClick={anadir}>ENVIAR</button>
        </form>

        <div>
          <button type="button" onClick={removeComponents}>
            Cancelar
          </button>
        </div>
      </div>
    );
  }
}
