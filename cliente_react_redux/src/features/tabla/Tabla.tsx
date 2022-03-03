import React, { useState } from "react";
import { useTable } from "react-table";
import { useAppSelector, useAppDispatch, useRows, useColumns } from "./hooks";
import './Tabla.css';
import { useSelector } from "react-redux";
import { juegosChanged,jugar } from "../../app/redux/juegosSlice";
import { useDispatch } from "react-redux";
import {getJuegos} from "../../app/services/juegos";
export function Tabla() {
  
  const dispatch = useAppDispatch();
  const [incrementAmount, setIncrementAmount] = useState("2");
  const juegos = useSelector(jugar);
  const incrementValue = Number(incrementAmount) || 0;
  const columns = useColumns();
  const data = juegos;
  const table = useTable({ columns, data });
  const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } =
    table;


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
            <tr {...row.getRowProps()} onClick={() => alert(row.original.nombre_ciudad)}>
              {row.cells.map((cell) => {
                return <td {...cell.getCellProps()}>{cell.render("Cell")}</td>;
              })}
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
