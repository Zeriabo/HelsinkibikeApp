import React, { useState } from "react";
import { useContext } from "react";
import { ReactReduxContext, useDispatch } from "react-redux";
import { fetchAsemat } from "../../Services/Reducers/AsemaSlice";
import { useGetAsematQuery } from "../../Services/api/AsemaApi";
import { loadAsemat } from "../../Services/Reducers/AsemaSlice";
import AsematList from "../../Components/AsematList";
import { Pagination } from "@mui/material";
function Asemat() {
  return (
    <div className="Asemat">
      <h3>Asemat: </h3>
      <AsematList />
    </div>
  );
}

export default Asemat;
