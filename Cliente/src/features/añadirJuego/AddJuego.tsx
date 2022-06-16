import React, {useState} from "react";
import "./AddJuego.css";
import {useDispatch, useSelector} from "react-redux";
import {add, added, cancel} from "../../app/redux/adderSlice";
import {editted} from "../../app/redux/editSlice";
import {juegosChanged} from "../../app/redux/juegosSlice";
import {addJuego} from "../../app/services/juegos";

//clean code: eliminar estados que no se usan
//clean code: renombrar variables
export function AddJuego() {
    const dispatch = useDispatch();
    const [ciudad, setCiudad] = useState("");
    const [año, setAño] = useState(2000);
    const [tipo, setTipo] = useState("VERANO");

    function addComponents() {
        dispatch(add());
    }

    function removeComponents() {
        dispatch(cancel());
        setCiudad("");
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

    function anadir() {
        addJuego(ciudad, tipo, año).then((response) => {
            dispatch(juegosChanged(response.data));
            dispatch(cancel());
            setCiudad("");
        })
            .catch((error) => {
                console.log(error);
                alert("No se ha añadido la sede");
            })
    }

    const anadir_sede = useSelector(added);
    const editar_sede = useSelector(editted)
    if (!editar_sede) {
        if (anadir_sede) {
            return (
                <div>
                    <button className="boton2" type="button" onClick={addComponents}>
                        Añadir sede
                    </button>
                    {anadir_sede}
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

                        <button type="button" onClick={anadir}>ENVIAR</button>
                    </form>

                    <div>
                        <button type="button" onClick={removeComponents}>
                            Cancelar
                        </button>
                    </div>
                </div>
            );
        }
    } else {
        return (<div></div>)
    }
}
