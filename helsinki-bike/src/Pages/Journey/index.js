import React, { useState, useEffect } from "react";
import { useGetAsematQuery } from "../../Services/api/AsemaApi";
import axios from "axios";
export default function Journey() {
  const [departure, setDeparture] = useState("");

  const [arrival, setArrival] = useState("");
  const [departureStationId, setDepartureStationId] = useState(null);
  const [arrivalStationId, setArrivalStationId] = useState(null);
  const [arrivalStationName, setArrivalStationName] = useState("");
  const [departureStationName, setDepartureStationName] = useState("");
  const [coveredDistance, setCoveredDistance] = useState(null);
  const [duration, setDuration] = useState(null);
  const [asematData, setAsematDataata] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8080/asema/")
      .then((responseData) => responseData.json())
      .then((rdata) => setAsematDataata(rdata))
      .catch((err) => console.log(err));
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();

    const newrequest = {
      departure: departure,
      arrival: arrival,
      departureStationId: departureStationId,
      arrivalStationId: arrivalStationId,
      arrivalStationName: arrivalStationName,
      departureStationName: departureStationName,
      coveredDistance: coveredDistance,
      duration: duration,
    };
    const newStation = {
      name: "name",
      namn: "namn",
      nimi: "nimi",
      osoite: "osoite",
      adres: "adres",
      kaupunki: "kaupunki",
      kapasiteet: 1,
      stad: "stad",
      operator: "operator",
      x: 1,
      y: 1,
    };
    axios
      .post("http://localhost:8080/journey/", newrequest)
      .then((data) => console.log(data))
      .catch((error) => console.log(error));
  };
  return (
    <div>
      <h2>Journey creation</h2>
      <center>
        <form onSubmit={handleSubmit}>
          <br />
          <label for="id">Departure date:</label>

          <input
            type="date"
            id="departure"
            onChange={(e) => setDeparture(new Date(e.target.value))}
            name="departure"
          />
          <br />
          <label for="name">Arrival date:</label>

          <input
            type="date"
            id="arrival"
            onChange={(e) => setArrival(new Date(e.target.value))}
            name="arrival"
          />
          <br />
          <label for="departureStationId">departureStationId:</label>

          <input
            type="number"
            id="departureStationId"
            onChange={(e) => setDepartureStationId(parseInt(e.target.value))}
            name="departureStationId"
          />
          <br />
          <label for="arrivalStationId">arrivalStationId:</label>

          <input
            type="number"
            id="arrivalStationId"
            onChange={(e) => setArrivalStationId(parseInt(e.target.value))}
            name="arrivalStationId"
          />
          <br />
          <label for="osoite">arrivalStationName:</label>

          <input
            type="text"
            id="arrivalStationName"
            onChange={(e) => setArrivalStationName(e.target.value)}
            name="arrivalStationName"
          />
          <br />
          <label for="adres">departureStationName:</label>

          <input
            type="text"
            id="departureStationName"
            onChange={(e) => setDepartureStationName(e.target.value)}
            name="departureStationName"
          />

          <br />
          <label for="stad">coveredDistance:</label>

          <input
            type="number"
            id="coveredDistance"
            onChange={(e) => setCoveredDistance(parseInt(e.target.value))}
            name="coveredDistance"
          />
          <br />
          <label for="operator">duration:</label>

          <input
            type="number"
            id="duration"
            onChange={(e) => setDuration(parseInt(e.target.value))}
            name="duration"
          />

          <br />
          <input type="submit" value="Submit" />

          <input type="reset" value="Reset" />
        </form>
      </center>
    </div>
  );
}
