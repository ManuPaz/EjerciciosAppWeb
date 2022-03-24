import React from 'react';
import logo from './logo.svg';

import './App.css';
import { useSelector, useDispatch } from 'react-redux';
import {Tabla} from './features/tabla/Tabla';
import {TablaPaginacion} from './features/tabla/TablaPaginacion';
import {AddJuego} from './features/añadirJuego/AddJuego';
import {EditJuego} from './features/editarJuego/EditJuego';
import {BuscarJuego} from './features/buscar/BuscarJuego';
import { logged,loguear,user, salir } from "./app/redux/tokenSlice";
import {Login} from "./app/login/LogIn";

import {
  cancel,
  add,
 added
} from './app/redux/adderSlice'
function App() {
  const logueado = useSelector(logged);
  const username = useSelector(user);
  const dispatch = useDispatch();
  function logOut() {
    dispatch(salir());

  }
  if (logueado){
  
  return (
    <div className="App">
      <header className="App-header">
        <div className="user">
        <label>{username} </label>
        <button  onClick={logOut}>Log out</button>
        </div>
     
        <BuscarJuego />
        <EditJuego />
        <AddJuego />
        <TablaPaginacion />
      
      </header>
    </div>
  );
}else{
  return(
    <div className="App">
      <header className="App-header">

        <Login/>
      
      </header>
    </div>


  )
}
}

export default App;
