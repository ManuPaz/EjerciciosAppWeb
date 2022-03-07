import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
//import counterReducer from '../features/selectorJuego/counterSlice';
import adderReducer from './adderSlice';
import juegosReducer from './juegosSlice';
import editerReducer from './editSlice';
export const store = configureStore({
  reducer: {
    
    adder: adderReducer,
    juegos: juegosReducer,
    editer:editerReducer
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;

