import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from './store';
import Juego from "../entidades/juegos.type";
import Sede  from "../entidades/sede.type";
const initialState={user:"",password:"",logged:false};



export const tokenSlice= createSlice({
  name: 'token',
  initialState,
  // The `reducers` field lets us define reducers and generate associated actions
  reducers: {
    loguear: (state,action) => {
      state.logged=true;
      state.user=action.payload.user;
      state.password=action.payload.password;
    },
    salir: (state) => {
      state.user=state.password="";
      state.logged=false;
    },     
    
    
   
  },
});

export const { loguear,   salir } = tokenSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.counter.value)`
export const logged = (state: RootState) => state.token.logged;
export const user= (state: RootState) => state.token.user;

// We can also write thunks by hand, which may contain both sync and async logic.
// Here's an example of conditionally dispatching actions based on current state.


export default tokenSlice.reducer;
