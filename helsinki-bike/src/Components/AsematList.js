import React, { useEffect, useState } from "react";
import { Pagination } from "@mui/material";
import { useGetAsematQuery } from "../Services/api/AsemaApi";
import { useNavigate } from "react-router-dom";
import { findAllByAltText } from "@testing-library/react";

function AsematList() {
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [search, setsearch] = useState("");
  const navigate = useNavigate();

  const { data, error, isLoading, isFetching } = useGetAsematQuery(page);
  const [currentPage, setCurrentPage] = useState(0);
  const [content, setContent] = useState({
    content: [],
    totalPages: 0,
  });

  useEffect(() => {
    fetch("http://localhost:8080/asema/")
      .then((responseData) => responseData.json())
      .then((rdata) => setContent(rdata))
      .catch((err) => console.log(err));
  }, []);

  async function handlePreviousPageChange(page) {
    if (page > 0) {
      const prevPage = page - 1;
      setCurrentPage(prevPage);

      let response = fetch(
        "http://localhost:8080/asema/sorted?sortedBy=id&page=" + prevPage
      );
      response
        .then((response) => response.json())
        .then((data) => setContent(data));
    }
  }
  function handlePageChange(page) {
    setCurrentPage(page);
    let newData = fetch(
      "http://localhost:8080/asema/sorted?sortedBy=id&page=" + page
    );
    newData
      .then((response) => response.json())
      .then((data) => setContent(data));
  }
  function setActiveAsema(event) {
    navigate("/asema", { state: event });
  }
  const onChangeSearchTitle = (e) => {
    setsearch(e.target.value);

    var filteredData = { content: [] };

    filteredData.content = content.content.filter((item) =>
      item.name.toLowerCase().includes(search.toLowerCase())
    );

    if (e.target.value.length == 0) {
      setContent(data);
    } else {
      setContent(filteredData);
    }
  };

  return (
    <div className="list row">
      <div className="col-md-8">
        <Pagination
          className="my-asemat"
          count={totalPages}
          page={page ? page : 0}
          siblingCount={1}
          boundaryCount={1}
          variant="outlined"
          shape="rounded"
          onChange={handlePageChange}
        />
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Search by title"
            onChange={onChangeSearchTitle}
          />
        </div>
      </div>
      <div className="col-md-6">
        <h4>Asemat List</h4>

        <ul className="list-group">
          {content.content &&
            content.content.map((asema, index) => (
              <li onClick={() => setActiveAsema(asema, index)} key={index}>
                {asema.name}
              </li>
            ))}
        </ul>
      </div>
    </div>
  );
}
export default AsematList;
