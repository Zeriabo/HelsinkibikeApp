import React, { useState } from "react";
import {
  withGoogleMap,
  withScriptjs,
  GoogleMap,
  Marker,
} from "react-google-maps";
import {
  useGetSearchedArrivalJourneysQuery,
  useGetSearchedDepartureJourneysQuery,
} from "../Services/api/JourneyApi";
import DepartureJourneys from "./DepartureJourneys";
import ArrivalJourneys from "./ArrivalJourneys";
const StationMap = withScriptjs(
  withGoogleMap((props) => {
    console.log(props.station);
    const [x, setX] = useState(props.station.x);
    const [y, setY] = useState(props.station.y);
    const [map, setMap] = useState(null);

    const handleMapLoad = (map) => {
      setMap(map);
    };

    return (
      <div>
        <GoogleMap
          ref={handleMapLoad}
          defaultZoom={15}
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
        <div></div>
      </div>
    );
  })
);

export default StationMap;
