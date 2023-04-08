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

    return (
      <GoogleMap
        ref={handleMapLoad}
        defaultZoom={12}
        defaultCenter={{
          lat: y,
          lng: x,
        }}
      >
        <Marker
          position={{
            lat: y,
            lng: x,
          }}
        />
      </GoogleMap>
    );
  })
);

export default StationMap;
