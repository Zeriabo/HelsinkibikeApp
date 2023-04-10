import React, { useEffect, useState } from "react";
import { useGetJourneysQuery } from "../../Services/api/JourneyApi";
import { useGetJourneysSortedPagedQuery } from "../../Services/api/JourneyApi";
import Table from "../../Components/Table";
export default function Journeys() {
  const [currentPage, setCurrentPage] = useState(0);
  const [journeysData, setJourneysData] = useState({
    content: [],
    totalPages: 0,
  });

  const { data, error, isLoading, isFetching } = useGetJourneysQuery();
  useEffect(() => {
    setJourneysData(data);
  }, []);

  async function handlePreviousPageChange(page) {
    if (page > 0) {
      const prevPage = page - 1;
      setCurrentPage(prevPage);

      let response = fetch(
        "http://localhost:8080/journey/sorted?sortedBy=id&page=" + prevPage
      );
      response
        .then((response) => response.json())
        .then((data) => setJourneysData(data));
    }
  }
  function handlePageChange(page) {
    setCurrentPage(page);
    let newData = fetch(
      "http://localhost:8080/journey/sorted?sortedBy=id&page=" + page
    );
    newData
      .then((response) => response.json())
      .then((data) => setJourneysData(data));
  }
  const startIndex = currentPage * 100;
  const endIndex = (currentPage + 1) * 100;

  return (
    <div>
      <center>
        <h1>Journeys</h1>
        <Table data={journeysData} />
        <div>
          <button onClick={() => handlePreviousPageChange(currentPage)}>
            previous page
          </button>
          <button onClick={() => handlePageChange(currentPage + 1)}>
            next page
          </button>
        </div>
      </center>
    </div>
  );
}
