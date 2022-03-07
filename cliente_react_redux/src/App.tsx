import React from 'react';
import logo from './logo.svg';

import './App.css';
import { useSelector, useDispatch } from 'react-redux';
import {Tabla} from './features/tabla/Tabla';
import {AddJuego} from './features/añadirJuego/AddJuego';
import {EditJuego} from './features/editarJuego/EditJuego';
import {
  cancel,
  add,
 added
} from './app/redux/adderSlice'
function App() {
  

  
  return (
    <div className="App">
      <header className="App-header">
      
        <EditJuego />
        <AddJuego />
        <Tabla />
      
      </header>
    </div>
  );
}

export default App;
