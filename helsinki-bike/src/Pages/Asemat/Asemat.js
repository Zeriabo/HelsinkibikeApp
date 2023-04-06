import React from "react";
import { useContext } from "react";
import { ReactReduxContext, useDispatch } from "react-redux";
import { fetchAsemat } from "../../Services/Reducers/AsemaSlice";
import { useGetAsematQuery } from "../../Services/api/AsemaApi";
import { loadAsemat } from "../../Services/Reducers/AsemaSlice";
import AsematList from "../../Components/AsematList";
function Asemat() {
  const { data, error, isLoading, isFetching } = useGetAsematQuery();
  // if (data) {
  //   console.log(data);
  //   // alert("data");
  //   // dispatch(loadAsemat(data));
  // }

  return (
    <div className="Asemat">
      {error ? (
        <>Oh no, there was an error</>
      ) : isLoading ? (
        <>Loading...</>
      ) : data ? (
        <>
          <h3>Asemat: </h3>
          <AsematList asemat={data} />
        </>
      ) : null}
    </div>
  );
}

export default Asemat;
