import React from "react";

function DepartureJourneys(journeys) {
  let trips = [];

  if (journeys.data.content != undefined || journeys.data.content != {}) {
    trips = journeys.data.content;
  }
  return (
    <div>
      <div>
        <h3>Departure Journeys</h3>
        <h4>Number: {journeys.totalPages} </h4>
      </div>
      {trips != undefined
        ? trips.map((trip, index) => {
            const arrivalTime = new Date(trip.arrival).toLocaleTimeString(
              "en-US",
              {
                hour: "numeric",
                minute: "numeric",
              }
            );
            const departureTime = new Date(trip.departure).toLocaleTimeString(
              "en-US",
              { hour: "numeric", minute: "numeric" }
            );

            const durationHours = Math.floor(trip.duration / 60);
            const durationMinutes = trip.duration % 60;

            return (
              <div key={index} className="departure-info">
                <div key={trip.id}>
                  <h2>{trip.arrivalStationName}</h2>
                  <p>duration: {trip.duration}</p>
                  <p>departure time :{departureTime}</p>
                </div>
              </div>
            );
          })
        : null}
    </div>
  );
}

export default DepartureJourneys;
