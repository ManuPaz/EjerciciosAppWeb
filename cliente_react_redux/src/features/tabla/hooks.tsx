import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux';
import type { RootState, AppDispatch } from '../../app/redux/store';
import Juego from "../../app/entidades/juegos.type";
import { useTable,Column,Row } from 'react-table';
import { useMemo } from "react";
import {getJuegos} from "../../app/services/juegos";
import React, { useState,useEffect} from 'react';
import logo from "../../assets/images/iconoeditar.png";
import logo2 from "../../assets/images/iconoeliminar.png";
import {  juegosChanged,jugar } from "../../app/redux/juegosSlice";
// Use throughout your app instead of plain `useDispatch` and `useSelector`
export const useAppDispatch = () => useDispatch<AppDispatch>();
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;

export function useColumns() {

    function handleDelete() {
    alert("hola");
    
  }
 const columns:Array<Column<{ nombre_ciudad: string; id_ciudad: number; nombre_pais: string; id_pais: number; descripcion_tipo_jjoo: string; numero_veces_sede: number; valor: number, }>> = useMemo(
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
        Cell: (row:any) => {
          
          return <button  className='button1' ><img className='img1' src={logo} /></button>
        },
        id: "editar"
      },
      {
        Header: "Eliminar",
        Cell: (row) => {
          const data1=row.original;
          return <button onClick={ handleDelete} className='button2' ><img className='img2'  src={logo2}/></button>
        },
        id: "eliminar"
      }
   ],
   []
 );

 return columns;
}




export  function useRows() {
    const dispatch = useDispatch();
    const adde = useSelector(jugar);
    var data:any;
    let [responseData, setResponseData] = React.useState<Juego[]>([]);
    const fetchData = React.useCallback(() => {
        getJuegos().then((response) => {
            setResponseData(response.data)
            
          })
          .catch((error) => {
            console.log(error)
          })
        }, [])
      
    React.useEffect(() => {
            fetchData()
          }, [fetchData])
          dispatch(juegosChanged(responseData))
          
         
      
      return adde;
    
   

}
