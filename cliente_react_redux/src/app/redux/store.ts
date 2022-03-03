import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
//import counterReducer from '../features/selectorJuego/counterSlice';
import adderReducer from './adderSlice';
import juegosReducer from './juegosSlice';
export const store = configureStore({
  reducer: {
    
    adder: adderReducer,
    juegos: juegosReducer
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;

