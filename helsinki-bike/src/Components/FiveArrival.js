import React from "react";

function FiveArrival(obj) {
  let stations = [];
  console.log(obj);
  if (obj.journeys.length > 0) {
    stations = obj.journeys;
  }
  console.log(stations);

  return (
    <div className="arrival-info">
      <ul>
        {stations.map(function (name, index) {
          return <p>{name}</p>;
        })}
      </ul>
    </div>
  );
}

export default FiveArrival;
