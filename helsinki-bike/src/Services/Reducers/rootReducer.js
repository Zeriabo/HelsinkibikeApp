import { combineReducers } from "@reduxjs/toolkit";
import { asematSlice } from "./AsemaSlice";
import { apiAsema } from "../api/AsemaApi";
const rootReducer = combineReducers({
  asemat: asematSlice.reducer,
  [apiAsema.reducerPath]: apiAsema.reducer,
});

export default rootReducer;
