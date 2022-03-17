import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from './store';
import Juego from "../entidades/juegos.type";
import Sede  from "../entidades/sede.type";
const initialState={value:false};



export const buscadorSlice= createSlice({
  name: 'buscador',
  initialState,
  // The `reducers` field lets us define reducers and generate associated actions
  reducers: {
    buscar: state => {
      state.value =true;
    },
    noBuscar: (state) => {
      state.value=false;
    },     
    
    
   
  },
});

export const { buscar,   noBuscar } = buscadorSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.counter.value)`
export const editted = (state: RootState) => state.editer.value;
export const sedes= (state: RootState) => state.editer.sedes;
export const ciudad= (state: RootState) => state.editer.ciudad;
export const tipo= (state: RootState) => state.editer.tipo;
export const ano= (state: RootState) => state.editer.ano;
// We can also write thunks by hand, which may contain both sync and async logic.
// Here's an example of conditionally dispatching actions based on current state.


export default buscadorSlice.reducer;
