import React from "react";

function FiveArrival(obj) {
  let stations = [];
  if (obj.journeys.length > 0) {
    stations = obj.journeys;
  }

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
