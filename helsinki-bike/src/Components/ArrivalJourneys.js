import React from "react";

function ArrivalJourneys(journeys) {
  let trips = [];
  if (journeys.data != undefined) {
    trips = journeys.data.content;
  }
  return (
    <div>
      <div>
        <h3>Arrival Journeys</h3>
        <h4>Number: {trips.length} </h4>
      </div>
      {trips.map((trip, index) => {
        const arrivalTime = new Date(trip.arrival).toLocaleTimeString("en-US", {
          hour: "numeric",
          minute: "numeric",
        });
        const departureTime = new Date(trip.departure).toLocaleTimeString(
          "en-US",
          { hour: "numeric", minute: "numeric" }
        );

        const durationHours = Math.floor(trip.duration / 60);
        const durationMinutes = trip.duration % 60;

        return (
          <div>
            <div key={index} className="arrival-info">
              <div key={trip.id}>
                <h2>{trip.departureStationName}</h2>
                <p>duration: {trip.duration}</p>
                <p>arrival time :{arrivalTime}</p>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
}

export default ArrivalJourneys;
