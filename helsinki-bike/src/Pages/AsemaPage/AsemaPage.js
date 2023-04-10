import React, { useEffect } from "react";
import { useLocation } from "react-router-dom";
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
import { useGetSearchedArrivalJourneysQuery } from "../../Services/api/JourneyApi";
const AsemaPage = () => {
  const location = useLocation();
  const asemaData = location.state;
  console.log(asemaData);
  const { data, error, isLoading, isFetching } =
    useGetSearchedDepartureJourneysQuery(asemaData.id);
  const {
    data: arrivalData,
    error: arrivalError,
    isLoading: arrivalisLoading,
    isFetching: arrivalisFetching,
  } = useGetSearchedArrivalJourneysQuery(asemaData.id);
  console.log(data);
  console.log(arrivalData);
  const [showInfoWindow, setShowInfoWindow] = useState(false);

  const handleMarkerClick = () => {
    setShowInfoWindow(true);
  };
  const handleInfoWindowCloseClick = () => {
    setShowInfoWindow(false);
  };
  //setProps(x, y, data.name, data.osoite);
  return (
    <div>
      <h2>{asemaData.name}</h2>
      <p>{asemaData.osoite}</p>

      <StationMap
        station={asemaData}
        googleMapURL={`https://maps.googleapis.com/maps/api/js?key=AIzaSyAwnbwCN2ipDC54NnJFVj_OvBcVnwD5OFQ`}
        loadingElement={<div style={{ height: "100%" }} />}
        containerElement={<div style={{ height: "400px" }} />}
        mapElement={<div style={{ height: "100%" }} />}
      />
      <div>
        <table>
          <tr>
            <td>
              <DepartureJourneys data={data} />
            </td>
            <td>
              <ArrivalJourneys data={arrivalData} />
            </td>
          </tr>
        </table>
      </div>
    </div>
  );
};
export default AsemaPage;
