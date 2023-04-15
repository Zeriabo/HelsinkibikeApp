import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { Pagination } from "@mui/material";
import {
  GoogleMap,
  Marker,
  InfoWindow,
  withGoogleMap,
} from "react-google-maps";
import { useState } from "react";
import StationMap from "../../Components/StationMap";
import DepartureJourneys from "../../Components/DepartureJourneys";
import ArrivalJourneys from "../../Components/ArrivalJourneys";
import { useGetSearchedDepartureJourneysQuery } from "../../Services/api/JourneyApi";
import {
  useGetAsematQuery,
  useGetSingleAsematQuery,
  useGetTotalArrivalQuery,
  useGetAsematCapacityQuery,
} from "../../Services/api/AsemaApi";
import FiveArrival from "../../Components/FiveArrival";
import FiveDepartures from "../../Components/FiveDepartures";
const AsemaPage = () => {
  const location = useLocation();
  const [asemaData, setAsemaData] = useState({});
  const [departuresData, setDeparturesData] = useState({});
  const [arrivalsData, setArrivalsData] = useState({});
  const [departurePage, setDeparturePage] = useState(1);
  const [arrivalPage, setArrivalPage] = useState(1);
  const [totalArivals, setTotalArrivals] = useState(0);
  const [totalDepartures, setTotalDepartures] = useState(0);
  const [fiveReturn, setFiveReturn] = useState({});
  const [fiveDeparture, setFiveDepartures] = useState({});

  useEffect(() => {
    setAsemaData(location.state);
    fetchDepartures();
    fetchArrivals();
    fetchTotalArrivals();
    fetchTotalDepartures();
    getFiveDeparture();
    getFiveReturn();
  }, []);
  const getFiveReturn = async () => {
    fetch(
      "http://localhost:8080/asema/fivereturn?idParam=" + location.state.asemaId
    )
      .then((responseData) => responseData.json())
      .then((rdata) => setFiveReturn(rdata))
      .catch((err) => console.log(err));
  };
  const getFiveDeparture = async () => {
    fetch(
      "http://localhost:8080/asema/fivedeparture?idParam=" +
        location.state.asemaId
    )
      .then((responseData) => responseData.json())
      .then((rdata) => setFiveDepartures(rdata))
      .catch((err) => console.log(err));
  };
  const fetchTotalArrivals = async () => {
    fetch(
      "http://localhost:8080/asema/totalarrival?id=" +
        location.state.asemaId +
        "&page=1",
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        setTotalArrivals(data);
      });
  };
  const fetchTotalDepartures = async () => {
    fetch(
      "http://localhost:8080/asema/totaldeparture?id=" +
        location.state.asemaId +
        "&page=1",
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        setTotalDepartures(data);
      });
  };
  const fetchArrivals = async () => {
    fetch(
      "http://localhost:8080/journey/search_arrival?id=" +
        location.state.asemaId +
        "&page=1",
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        setArrivalsData(data);
      });
  };
  const fetchDepartures = async () => {
    fetch(
      "http://localhost:8080/journey/search_departure?id=" +
        location.state.asemaId +
        "&page=1",
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        setDeparturesData(data);
      });
  };
  const handleDepartureListChange = (event, newPage) => {
    setDeparturePage(newPage);
    fetchDepartures();
  };
  const handleArrivalListChange = (event, newPage) => {
    setArrivalPage(newPage);
    fetchArrivals();
  };

  return (
    <div>
      <h2>{asemaData.name}</h2>
      <p>{asemaData.osoite}</p>

      <p>Total number of journeys starting:{totalDepartures} </p>
      <p>Total number of journeys ending:{totalArivals} </p>

      <StationMap
        station={asemaData}
        googleMapURL={`https://maps.googleapis.com/maps/api/js?key=AIzaSyAwnbwCN2ipDC54NnJFVj_OvBcVnwD5OFQ`}
        loadingElement={<div style={{ height: "100%" }} />}
        containerElement={<div style={{ height: "400px" }} />}
        mapElement={<div style={{ height: "100%" }} />}
      />

      <div>
        <table border="0">
          <tr>
            <td valign="top">
              <th>Five most Departures </th>
              <FiveDepartures journeys={fiveDeparture} />
            </td>
            <td valign="top">
              <th>Five most Arrivals </th>
              <FiveArrival journeys={fiveReturn} />
            </td>
            <td>
              <Pagination
                className="my-departure_asemat"
                count={22}
                page={departurePage}
                siblingCount={1}
                boundaryCount={1}
                variant="outlined"
                shape="rounded"
                onChange={handleDepartureListChange}
              />
              <DepartureJourneys data={departuresData} />
            </td>

            <td>
              <Pagination
                className="my-arrival_asemat"
                count={22}
                page={arrivalPage}
                siblingCount={1}
                boundaryCount={1}
                variant="outlined"
                shape="rounded"
                onChange={handleArrivalListChange}
              />
              <ArrivalJourneys data={arrivalsData} />
            </td>
          </tr>
        </table>
      </div>
    </div>
  );
};
export default AsemaPage;
