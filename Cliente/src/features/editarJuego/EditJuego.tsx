import React, {useState} from "react";
import "./EditJuego.css";
import Sede from "../../app/entidades/sede.type";
import {useDispatch, useSelector} from "react-redux";
import {ano, cancelEdit, ciudad, editted, sedes, setAno, tipo} from "../../app/redux/editSlice";
import {juegosChanged} from "../../app/redux/juegosSlice";
import {modifyJuego} from "../../app/services/juegos";

//clean code: eliminar variables que no se usan
//clean code: renombrer variables
export function EditJuego() {
    const dispatch = useDispatch();
    const [ciudadText, setCiudad] = useState("");
    const [ano_input, setAno_input] = useState(0);
    const [tipoText, setTipo] = useState("VERANO");

    function removeComponents() {
        setCiudad("");
        dispatch(cancelEdit());
    }

    function handleCiudadChange(event: any) {
        setCiudad(event.target.value);
    }

    function handleAñoChange(event: any) {
        setAno_input(event.target.value);
    }

    function handleTipoChange(event: any) {
        setTipo(event.target.value);
    }

    const anadirSede = useSelector(editted);
    const sedesPosibles: Sede[] = useSelector(sedes);
    const ciudad1 = useSelector(ciudad);
    const tipo1 = useSelector(tipo);
    const an = useSelector(ano);

    function handleAñoSedeChange(event: any) {
        dispatch(setAno(event.target.value));
    }

    function modificar() {
        modifyJuego(an, tipo1, ano_input, tipoText, ciudadText).then((response) => {
            dispatch(juegosChanged(response.data))
            setCiudad("");
            dispatch(cancelEdit());
        })
            .catch((error) => {
                console.log(error);
                alert("No se ha modificado la sede");
            })
        //
    }

    if (anadirSede) return (<div>
        <h2> Editar sede: {ciudad1}-{tipo1}</h2>
        <form>
            <div>
                <label>
                    Sede :
                    <select name="sede" value={an} onChange={handleAñoSedeChange}>
                        {sedesPosibles.map((item: Sede) => {
                            return (<option key={item.ano} value={item.ano}>{item.ano}</option>);
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
                    value={ano_input}
                    min="1896"
                    max="2050"
                    onChange={handleAñoChange}
                ></input>
            </label>
            <button type="button" onClick={modificar}>
                ENVIAR
            </button>
        </form>
        <div>
            <button type="button" onClick={removeComponents}>
                Cancelar
            </button>
        </div>
    </div>); else return (<div></div>)
}
