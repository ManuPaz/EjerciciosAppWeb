import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from './store';
import Juego from "../entidades/juegos.type";

const initialState={value:[]}



export const juegosSlice= createSlice({
  name: 'juegos',
  initialState,
  // The `reducers` field lets us define reducers and generate associated actions
  reducers: {
    juegosChanged(state, action) {
      state.value=(action.payload)
    }
  },
});

export const { juegosChanged } = juegosSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.counter.value)`
export const jugar = (state: RootState) => state.juegos.value;

// We can also write thunks by hand, which may contain both sync and async logic.
// Here's an example of conditionally dispatching actions based on current state.


export default juegosSlice.reducer;
