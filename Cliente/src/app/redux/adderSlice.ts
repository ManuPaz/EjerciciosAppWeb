import {createSlice} from '@reduxjs/toolkit';
import {RootState} from './store';

const initialState = {value: true};
export const adderSlice = createSlice({
    name: 'adder',
    initialState,
    // The `reducers` field lets us define reducers and generate associated actions
    reducers: {
        add: state => {
            state.value = false;
        },
        cancel(state) {
            state.value = true;
        },
        juegosChanged(state, action) {
            state.value = (action.payload)
        }
    },
});
export const {add, cancel} = adderSlice.actions;
// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.counter.value)`
export const added = (state: RootState) => state.adder.value;
// We can also write thunks by hand, which may contain both sync and async logic.
// Here's an example of conditionally dispatching actions based on current state.
export default adderSlice.reducer;
