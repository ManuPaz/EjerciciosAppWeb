import React from "react";
import {usePagination, useTable} from "react-table";
import {useAppDispatch, useColumnsPaginacion} from "./hooks";
import './Tabla.css';
import {useSelector} from "react-redux";
import {juegosChanged, jugar} from "../../app/redux/juegosSlice";
import {setSede} from "../../app/redux/editSlice";
import {added} from "../../app/redux/adderSlice";
import {getJuegoCiudad, getJuegos, removeJuego} from "../../app/services/juegos";
import {animateScroll as scroll} from "react-scroll";

//clean code: eliminar estados que no se usan
export function TablaPaginacion() {
    const dispatch = useAppDispatch();
    const data = useSelector(jugar);
    const columns = useColumnsPaginacion();
    const add = useSelector(added);

    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        prepareRow,
        page,
        canPreviousPage,
        canNextPage,
        pageOptions,
        pageCount,
        gotoPage,
        nextPage,
        previousPage,
        setPageSize,
        state: {pageIndex, pageSize},
    } = useTable(
        {
            columns,
            data,
            initialState: {pageIndex: 0},
        },
        usePagination
    )

    function handleEditar(cell: any, row: any) {
        if (cell.column.id == "eliminar") {
            getJuegoCiudad(row.original.id_ciudad, row.original.descripcion_tipo_jjoo).then(response => {
                response.data.forEach(element => {
                    removeJuego(element).then(response1 => {
                        dispatch(juegosChanged(response1.data))
                    })
                })
            })
            //
        }
        if (cell.column.id == "editar" && add) {
            scroll.scrollToTop();
            getJuegoCiudad(row.original.id_ciudad, row.original.descripcion_tipo_jjoo).then(response => {
                dispatch(setSede({
                    historia: response.data,
                    ciudad: row.original.nombre_ciudad,
                    tipo: row.original.descripcion_tipo_jjoo
                }));
            })
        }
    }

    const fetchData = React.useCallback(() => {
        getJuegos().then((response: any) => {
            dispatch(juegosChanged(response.data))
        })
            .catch((error: any) => {
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
                {page.map((row, _i) => {
                    prepareRow(row);
                    return (
                        <tr {...row.getRowProps()} >
                            {row.cells.map((cell) => {
                                return <td {...cell.getCellProps()} onClick={() => {
                                    handleEditar(cell, row);
                                }}>{cell.render("Cell")}</td>;
                            })}
                        </tr>
                    );
                })}
                </tbody>
            </table>
            <div className="pagination">
                <button onClick={() => gotoPage(0)} disabled={!canPreviousPage}>
                    {'<<'}
                </button>
                {' '}
                <button onClick={() => previousPage()} disabled={!canPreviousPage}>
                    {'<'}
                </button>
                {' '}
                <button onClick={() => nextPage()} disabled={!canNextPage}>
                    {'>'}
                </button>
                {' '}
                <button onClick={() => gotoPage(pageCount - 1)} disabled={!canNextPage}>
                    {'>>'}
                </button>
                {' '}
                <span>
          Page{' '}
                    <strong>
            {pageIndex + 1} of {pageOptions.length}
          </strong>{' '}
        </span>
                <span>
          | Go to page:{' '}
                    <input
                        type="number"
                        defaultValue={pageIndex + 1}
                        onChange={e => {
                            const page_aux = e.target.value ? Number(e.target.value) - 1 : 0
                            gotoPage(page_aux)
                        }}
                        style={{width: '100px'}}
                    />
        </span>{' '}
                <select
                    value={pageSize}
                    onChange={e => {
                        setPageSize(Number(e.target.value))
                    }}
                >
                    {[5,  10].map(pageSizeAux => (
                        <option key={pageSizeAux} value={pageSizeAux}>
                            Show {pageSizeAux}
                        </option>
                    ))}
                </select>
            </div>
        </>
    );
}
