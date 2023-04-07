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
const AsemaPage = () => {
  const location = useLocation();
  const data = location.state;
  console.log(data);
  const [showInfoWindow, setShowInfoWindow] = useState(false);

  const [props, setProps] = useState([]);

  const handleMarkerClick = () => {
    setShowInfoWindow(true);
  };
  const handleInfoWindowCloseClick = () => {
    setShowInfoWindow(false);
  };
  //setProps(x, y, data.name, data.osoite);
  return (
    <div>
      <h2>{data.name}</h2>
      <p>{data.osoite}</p>
      <StationMap
        station={data}
        googleMapURL={`https://maps.googleapis.com/maps/api/js?key=AIzaSyAwnbwCN2ipDC54NnJFVj_OvBcVnwD5OFQ`}
        loadingElement={<div style={{ height: "100%" }} />}
        containerElement={<div style={{ height: "400px" }} />}
        mapElement={<div style={{ height: "100%" }} />}
      />
    </div>
  );
};
export default AsemaPage;
