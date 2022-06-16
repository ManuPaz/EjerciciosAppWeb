import React, {useState} from "react";
import "./BuscarJuego.css";
import {useDispatch, useSelector} from "react-redux";
import {editted} from "../../app/redux/editSlice";
import {juegosChanged} from "../../app/redux/juegosSlice";
import {buscarJuego, getJuegos} from "../../app/services/juegos";
import {added} from "../../app/redux/adderSlice";

//clean code: eliminar variables que no se usan
export function BuscarJuego() {
    const dispatch = useDispatch();
    const [buscarText, setBuscarText] = useState("");
    const edi = useSelector(editted);
    const adde = useSelector(added);

    function handleBuscarChange(event: any) {
        setBuscarText(event.target.value);
    }

    function filtrar() {
        buscarJuego(buscarText).then((response: any) => {
            dispatch(juegosChanged(response.data));
            setBuscarText("");
        })
            .catch((error: any) => {
                console.log(error);
                setBuscarText("");
            })
    }

    function cancealarfiltrar() {
        getJuegos().then((response: any) => {
            dispatch(juegosChanged(response.data))
        })
            .catch((error: any) => {
                console.log(error)
            })
        setBuscarText("");
    }

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
                        <button type="button" onClick={filtrar}>
                            ENVIAR
                        </button>
                        <button type="button" onClick={cancealarfiltrar}>
                            LIMPIAR
                        </button>
                    </div>
                </form>
            </div>
        );
    else
        return (<div></div>)
}
