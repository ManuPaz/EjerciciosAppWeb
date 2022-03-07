import React, { useState } from "react";
import { useTable } from "react-table";
import { useAppSelector, useAppDispatch, useRows, useColumns } from "./hooks";
import './Tabla.css';
import { useSelector } from "react-redux";
import { juegosChanged,jugar } from "../../app/redux/juegosSlice";
import { editted,edit,setSede } from "../../app/redux/editSlice";
import { added} from "../../app/redux/adderSlice";
import { useDispatch } from "react-redux";
import {getJuegos,removeJuego,getJuegoCiudad} from "../../app/services/juegos";
export function Tabla() {
  
  const dispatch = useAppDispatch();
  const [incrementAmount, setIncrementAmount] = useState("2");
  const juegos = useSelector(jugar);
  const incrementValue = Number(incrementAmount) || 0;
  const columns = useColumns();
  const data = juegos;
  const add=useSelector(added);
  
  const table = useTable({ columns, data });
  const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } =
    table;
   
    function handleEditar(cell:any,row:any){
      if(cell.column.id=="eliminar"){
        //alert(row.original.nombre_ciudad+" "+cell.column.id);
        
        getJuegoCiudad(row.original.id_ciudad,row.original.descripcion_tipo_jjoo).
        then(response=>{
         
          response.data.forEach(element => {
           
            
            removeJuego(element).then(response1=>{dispatch(juegosChanged(response1.data))})
          })})
        //
      }

    
    if(cell.column.id=="editar" && add==true){
      //alert(row.original.nombre_ciudad+" "+cell.column.id);
      getJuegoCiudad(row.original.id_ciudad,row.original.descripcion_tipo_jjoo).
        then(response=>{
      dispatch(setSede({historia:response.data,ciudad:row.original.nombre_ciudad,tipo:row.original.descripcion_tipo_jjoo}));
      //dispatch(edit());

    })

    }
  }


    

    const fetchData = React.useCallback(() => {
      getJuegos().then((response:any) => {
        dispatch(juegosChanged(response.data))
          
        })
        .catch((error:any) => {
          console.log(error)
        })
      }, [])
    
  React.useEffect(() => {
          fetchData()
        }, [fetchData])
        

  return (
    <table {...getTableProps()}>
      <thead>
        {headerGroups.map((headerGroup) => (
          <tr {...headerGroup.getHeaderGroupProps()} >
            {headerGroup.headers.map((column) => (
              <th {...column.getHeaderProps()}>{column.render("Header")}</th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {rows.map((row, i) => {
          prepareRow(row);
          return (
            <tr {...row.getRowProps()} >
              {row.cells.map((cell) => {
                return <td {...cell.getCellProps()} onClick={() => { handleEditar(cell,row);}}>{cell.render("Cell")}</td>;
              })}
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
