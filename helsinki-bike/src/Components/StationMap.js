import React, { useState } from "react";
import {
  withGoogleMap,
  withScriptjs,
  GoogleMap,
  Marker,
} from "react-google-maps";

const StationMap = withScriptjs(
  withGoogleMap((props) => {
    const [x, setX] = useState(props.station.x);
    const [y, setY] = useState(props.station.y);

    const [map, setMap] = useState(null);

    const handleMapLoad = (map) => {
      setMap(map);
    };

    const handleMarkerClick = (event) => {
      console.log("Marker clicked:", event.latLng.lat(), event.latLng.lng());
    };

    return (
      <GoogleMap
        ref={handleMapLoad}
        defaultZoom={12}
        defaultCenter={{
          lat: x,
          lng: y,
        }}
        onClick={handleMarkerClick}
      >
        <Marker
          position={{
            lat: x,
            lng: y,
          }}
        />
      </GoogleMap>
    );
  })
);

export default StationMap;
