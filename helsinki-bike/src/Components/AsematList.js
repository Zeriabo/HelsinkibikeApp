import React, { useEffect, useState } from "react";
import { Pagination } from "@mui/material";
import { useGetAsematQuery } from "../Services/api/AsemaApi";
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

  const [numberOfElements, setNumberOfElements] = useState(0);
  const [searchTitle, setsearchTitle] = useState("");

  useEffect(() => {
    setNumberOfElements(data.numberOfElements);
    setContent(data.content);
    setTotalPages(data.totalPages - 1);
  });

  const onChangeSearchTitle = (e) => {
    setsearchTitle(e.target.value);
    setContent(data.content);
  };

  const setActiveTutorial = (event) => {
    console.log(event);
  };
  const handlePageChange = (event, value) => {
    setPage(value);
  };
  const handlePageSizeChange = (event) => {
    console.log(event);
    // this.setState(
    //   {
    //     pageSize: event.target.value,
    //     page: this.props.page,
    //   },
    //   () => {
    //     this.retrieveAsemat();
    //   }
    // );
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
            value={page ? page : 0}
            onChange={onChangeSearchTitle}
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              type="button"
              onClick={() => console.log("")}
            >
              Search
            </button>
          </div>
        </div>
      </div>
      <div className="col-md-6">
        <h4>Asemat List</h4>

        <div className="mt-3">
          {"Items per Page: "}
          <select
            onChange={handlePageSizeChange}
            value={numberOfElements}
          ></select>
        </div>

        <ul className="list-group">
          {content &&
            content.map((tutorial, index) => (
              <li
                onClick={() => setActiveTutorial(tutorial, index)}
                key={index}
              >
                {tutorial.name}
              </li>
            ))}
        </ul>
      </div>
    </div>
  );
}
export default AsematList;
