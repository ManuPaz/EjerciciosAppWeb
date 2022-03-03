import React from 'react';
import logo from './logo.svg';

import './App.css';
import { useSelector, useDispatch } from 'react-redux';
import {Tabla} from './features/tabla/Tabla';
import {AddJuego} from './features/añadirJuego/AddJuego';
import {
  cancel,
  add,
 added
} from './app/redux/adderSlice'
function App() {
  

  
  return (
    <div className="App">
      <header className="App-header">
      

        <AddJuego />
        <Tabla />
      
      </header>
    </div>
  );
}

export default App;
