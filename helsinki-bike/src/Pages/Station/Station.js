import React, { useState } from "react";
import { useCreateAsemaMutation } from "../../Services/api/AsemaApi";
import axios from "axios";
const Station = () => {
  const [kapasiteet, setKapasiteet] = useState("");
  const [id, setId] = useState(null);
  const [name, setName] = useState("");
  const [namn, setNamn] = useState("");
  const [nimi, setNimi] = useState("");
  const [osoite, setOsoite] = useState("");
  const [adres, setAdres] = useState("");
  const [kaupunki, setKaupunki] = useState("");
  const [stad, setStad] = useState("");
  const [operator, setOperator] = useState("");
  const [x, setX] = useState(null);
  const [y, setY] = useState(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    const newStation = {
      id: id,
      name: name,
      namn: namn,
      nimi: nimi,
      osoite: osoite,
      adres: adres,
      kaupunki: kaupunki,
      kapasiteet: kapasiteet,
      stad: stad,
      operator: operator,
      x: x,
      y: y,
    };
    axios
      .post("http://localhost:8080/asema/", newStation)
      .then((data) => console.log(data))
      .catch((error) => console.log(error));
  };
  return (
    <div>
      <h2>Station creation</h2>
      <center>
        <form onSubmit={handleSubmit}>
          <br />
          <label for="id">ID:</label>

          <input
            type="text"
            id="id"
            onChange={(e) => setId(e.target.value)}
            name="ID"
          />
          <br />
          <label for="name">name:</label>

          <input
            type="text"
            id="name"
            onChange={(e) => setName(e.target.value)}
            name="name"
          />
          <br />
          <label for="namn">namn:</label>

          <input
            type="text"
            id="namn"
            onChange={(e) => setNamn(e.target.value)}
            name="namn"
          />
          <br />
          <label for="nimi">nimi:</label>

          <input
            type="text"
            id="nimi"
            onChange={(e) => setNimi(e.target.value)}
            name="nimi"
          />
          <br />
          <label for="osoite">osoite:</label>

          <input
            type="text"
            id="osoite"
            onChange={(e) => setOsoite(e.target.value)}
            name="osoite"
          />
          <br />
          <label for="adres">adres:</label>

          <input
            type="text"
            id="adres"
            onChange={(e) => setAdres(e.target.value)}
            name="adres"
          />
          <br />
          <label for="kaupunki">kaupunki:</label>

          <input
            type="text"
            id="kaupunki"
            onChange={(e) => setKaupunki(e.target.value)}
            name="kaupunki"
          />
          <br />
          <label for="stad">stad:</label>

          <input
            type="text"
            id="stad"
            onChange={(e) => setStad(e.target.value)}
            name="stad"
          />
          <br />
          <label for="operator">Operator:</label>

          <input
            type="text"
            id="operator"
            onChange={(e) => setOperator(e.target.value)}
            name="Operator"
          />

          <br />
          <label for="kapasiteet">kapasiteet:</label>

          <input
            type="text"
            id="kapasiteet"
            name="kapasiteet"
            onChange={(e) => setKapasiteet(e.target.value)}
          />
          <br />
          <label for="x">x:</label>
          <input
            type="number"
            id="x"
            onChange={(e) => setX(e.target.value)}
            name="X"
          />

          <br />
          <label for="y">y:</label>
          <input
            type="number"
            id="y"
            onChange={(e) => setY(e.target.value)}
            name="Y"
          />
          <br />
          <input type="submit" value="Submit" />

          <input type="reset" value="Reset" />
        </form>
      </center>
    </div>
  );
};

export default Station;
