import React, { useState } from "react";

function Table({ data }) {
  const currentItems = data.content;

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Departure station </th>
            <th>Return station</th>
            <th>covered distance (km)</th>
            <th>duration (m)</th>
          </tr>
        </thead>
        <tbody>
          {currentItems.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.departureStationName}</td>
              <td>{item.arrivalStationName}</td>
              <td>{item.coveredDistance}</td>
              <td>{item.duration}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Table;
