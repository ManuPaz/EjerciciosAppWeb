import React from 'react';
import './App.css';
import {useDispatch, useSelector} from 'react-redux';
import {TablaPaginacion} from './features/tabla/TablaPaginacion';
import {AddJuego} from './features/añadirJuego/AddJuego';
import {EditJuego} from './features/editarJuego/EditJuego';
import {BuscarJuego} from './features/buscar/BuscarJuego';
import {logged, loguear, salir, user} from "./app/redux/tokenSlice";
import {Login, setCookie} from "./app/login/LogIn";

function App() {
    const logueado = useSelector(logged);
    const username = useSelector(user);
    const dispatch = useDispatch();

    function logOut() {
        setCookie("user", username, -10);
        dispatch(salir());
    }

    if (document.cookie.search("user=.*") == 0) {
        dispatch(loguear(document.cookie.split("=")[1]))
    }
    if (logueado) {
        return (<div className="App">
                <header className="App-header">
                    <div className="user">
                        <label>{username} </label>
                        <button onClick={logOut}>Log out</button>
                    </div>

                    <BuscarJuego/>
                    <EditJuego/>
                    <AddJuego/>
                    <TablaPaginacion/>

                </header>
            </div>);
    } else {
        return (<div className="App">
                <header className="App-header">

                    <Login/>

                </header>
            </div>)
    }
}

export default App;
