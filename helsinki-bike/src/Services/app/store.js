import { configureStore } from "@reduxjs/toolkit";
import { setupListeners } from "@reduxjs/toolkit/dist/query";
import rootReducer from "../Reducers/rootReducer";
import logger from "redux-logger";
import AsemaSlice, { asematSlice } from "../Reducers/AsemaSlice";
import { apiAsema } from "../api/AsemaApi";
// convert object to string and store in localStorage
function saveToLocalStorage(state) {
  try {
    const serialisedState = JSON.stringify(state);
    localStorage.setItem("persistantState", serialisedState);
  } catch (e) {
    console.warn(e);
  }
}

export function loadFromLocalStorage() {
  try {
    const serialisedState = localStorage.getItem("persistantState");
    if (serialisedState === null) return undefined;
    return JSON.parse(serialisedState);
  } catch (e) {
    console.warn(e);
    return undefined;
  }
}
const preloadedState = loadFromLocalStorage();
export const store = configureStore({
  reducer: {
    [apiAsema.reducerPath]: apiAsema.reducer,
  },
  preloadedState,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(apiAsema.middleware), //.concat(logger)
  devTools: process.env.NODE_ENV !== "production",
});
store.subscribe(() => saveToLocalStorage(store.getState()));
setupListeners(store.dispatch);
