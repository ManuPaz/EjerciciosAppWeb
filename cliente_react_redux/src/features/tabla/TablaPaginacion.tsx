import React, { useState } from "react";
import { useTable,usePagination } from "react-table";
import { useAppSelector, useAppDispatch, useRows, useColumns,useColumnsPaginacion } from "./hooks";
import './Tabla.css';
import { useSelector } from "react-redux";
import { juegosChanged,jugar } from "../../app/redux/juegosSlice";
import { editted,edit,setSede } from "../../app/redux/editSlice";
import { added} from "../../app/redux/adderSlice";
import { useDispatch } from "react-redux";
import {getJuegos,removeJuego,getJuegoCiudad} from "../../app/services/juegos";
import { animateScroll as scroll} from "react-scroll";
export function TablaPaginacion() {
  
  const dispatch = useAppDispatch();
  const [incrementAmount, setIncrementAmount] = useState("2");
  const juegos = useSelector(jugar);
  const incrementValue = Number(incrementAmount) || 0;
  const columns = useColumnsPaginacion();
  const data = juegos;
  const add=useSelector(added);
;
const {
  getTableProps,
  getTableBodyProps,
  headerGroups,
  prepareRow,
  page, // Instead of using 'rows', we'll use page,
  // which has only the rows for the active page

  // The rest of these things are super handy, too ;)
  canPreviousPage,
  canNextPage,
  pageOptions,
  pageCount,
  gotoPage,
  nextPage,
  previousPage,
  setPageSize,
  state: { pageIndex, pageSize },
} = useTable(
  {
    columns,
    data,
    initialState: { pageIndex: 0 },
  },
  usePagination
)
   
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
      scroll.scrollToTop();
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
          fetchData();
        
        }, [fetchData])
        

  return (
    <>
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
        {page.map((row, i) => {
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
      
      <div className="pagination">
        <button onClick={() => gotoPage(0)} disabled={!canPreviousPage}>
          {'<<'}
        </button>{' '}
        <button onClick={() => previousPage()} disabled={!canPreviousPage}>
          {'<'}
        </button>{' '}
        <button onClick={() => nextPage()} disabled={!canNextPage}>
          {'>'}
        </button>{' '}
        <button onClick={() => gotoPage(pageCount - 1)} disabled={!canNextPage}>
          {'>>'}
        </button>{' '}
        <span>
          Page{' '}
          <strong>
            {pageIndex+1 } of {pageOptions.length}
          </strong>{' '}
        </span>
        <span>
          | Go to page:{' '}
          <input
            type="number"
            defaultValue={pageIndex+1}
            onChange={e => {
              const page = e.target.value ? Number(e.target.value) - 1 : 0
              gotoPage(page)
            }}
            style={{ width: '100px' }}
          />
        </span>{' '}
        <select
          value={pageSize}
          onChange={e => {
            setPageSize(Number(e.target.value))
          }}
        >
          {[5, , 10].map(pageSize => (
            <option key={pageSize} value={pageSize}>
              Show {pageSize}
            </option>
          ))}
        </select>
      </div>
      </>
    
  );
}
