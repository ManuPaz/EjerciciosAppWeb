import {TypedUseSelectorHook, useDispatch, useSelector} from 'react-redux';
import type {AppDispatch, RootState} from '../../app/redux/store';
import React, {useMemo} from "react";
import logo from "../../assets/images/iconoeditar.png";
import logo2 from "../../assets/images/iconoeliminar.png";

export const useAppDispatch = () => useDispatch<AppDispatch>();
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;

//clean code: eliminar funciones que no se usan
export function useColumnsPaginacion() {
    return useMemo(
        () => [
            {
                Header: "Nombre de ciudad",
                accessor: "nombre_ciudad"
            },
            {
                Header: "ID de ciudad",
                accessor: "id_ciudad"
            },
            {
                Header: "Nombre de pais",
                accessor: "nombre_pais"
            },
            {
                Header: "ID de pais",
                accessor: "id_pais"
            },
            {
                Header: "Tipo de sede",
                accessor: "descripcion_tipo_jjoo"
            },
            {
                Header: "Numero de veces sede",
                accessor: "numero_veces_sede"
            },
            {
                Header: "Valor",
                accessor: "valor"
            },
            {
                Header: "Editar",
                Cell: (_row: any) => {
                    return <button className='button1'><img className='img1' src={logo}/></button>
                },
                id: "editar"
            },
            {
                Header: "Eliminar",
                Cell: (_row) => {
                    return <button className='button2'><img className='img2' src={logo2}/></button>
                },
                id: "eliminar"
            }
        ],
        []
    );
}


