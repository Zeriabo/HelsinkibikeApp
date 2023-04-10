import React, { useEffect, useState } from "react";
import { Pagination } from "@mui/material";
import { useGetAsematQuery } from "../Services/api/AsemaApi";
import { useNavigate } from "react-router-dom";
import { findAllByAltText } from "@testing-library/react";

function AsematList() {
  const [page, setPage] = useState(0);
  const { data, error, isLoading, isFetching } = useGetAsematQuery(page);
  const [content, setContent] = useState("");
  const [empty, setEmpty] = useState(false);
  const [first, setFirst] = useState({});
  const [last, setLast] = useState({});
  const [number, setNumber] = useState(0);
  const [pageable, setPagable] = useState(true);
  const [size, setSize] = useState(0);
  const [sort, setSort] = useState(true);
  const [totalElements, setTotalElements] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [search, setsearch] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    if (data) {
      setContent(data.content);
      setTotalPages(data.totalPages - 1);
    }
  }, [page]);

  const onChangeSearchTitle = (e) => {
    setsearch(e.target.value);
    const filteredData = data.content.filter((item) =>
      item.name.toLowerCase().includes(search.toLowerCase())
    );

    setContent(filteredData);
  };
  const handlePageChange = (event, newPage) => {
    setPage(newPage);
    fetch("http://localhost:8080/asemat/sorted?sortedBy=id&page=" + page, {
      headers: {
        "Access-Control-Allow-Origin": "*",
      },
    })
      .then((response) => response.json())
      .then((data) => setContent(data.content))
      .then(() => console.log(content));
  };
  // function handlePageChange(event) {
  //   console.log(event);
  //   console.log(event.target);
  //   setPage(event.target.textContent);
  //   fetch("http://localhost:8080/asemat/sorted?sortedBy=id&page=" + page)
  //     .then((response) => response.json())
  //     .then((data) => setContent(data.content))
  //     .then(() => console.log(content));
  // }
  function setActiveAsema(event) {
    navigate("/asema", { state: event });
  }

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
          {content &&
            content.map((asema, index) => (
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
