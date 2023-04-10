import React from "react";
import { Link } from "react-router-dom";

const index = () => {
  return (
    <div>
      <h1>Bicycle Station Management</h1>
      <p>Welcome to the bicycle station management app.</p>
      <p>You can:</p>
      <ul>
        <li>
          <Link to="/asemat">View all stations</Link>
        </li>
        <li>
          <Link to="/journeys">View all journeys</Link>
        </li>
      </ul>
    </div>
  );
};

export default index;
