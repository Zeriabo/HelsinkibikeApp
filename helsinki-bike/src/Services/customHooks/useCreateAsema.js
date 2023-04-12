import { useState, useEffect } from "react";
import { useCreateAsemaMutation } from "../api/AsemaApi";
const useCreateAsema = (asema) => {
  const [data, setData] = useState(null);

  useCreateAsemaMutation(asema)
    .then((res) => res.json())
    .then((data) => setData(data));

  return [data];
};

export default useCreateAsema;
