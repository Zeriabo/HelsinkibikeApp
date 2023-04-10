import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

export const apiJourney = createApi({
  reducerPath: "journeyApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/journey" }),
  endpoints: (builder) => ({
    getJourneys: builder.query({
      query: () => `/`,
    }),
    getJourneysSorted: builder.query({
      query: (column) => `/sorted?sortedBy=` + column,
    }),
    getJourneysSortedPaged: builder.query({
      //here
      query: (column, page) => `/sorted?sortedBy=` + column + `&page=` + page,
    }),
    getSearchedDepartureJourneys: builder.query({
      query: (id) => `/search_departure?id=` + id,
    }),
    getSearchedArrivalJourneys: builder.query({
      query: (id) => `/search_arrival?id=` + id,
    }),
    getAVGDepartureJourneys: builder.query({
      query: (id) => `/avg_departure?id=` + id,
    }),
    getAVGArrivalJourneys: builder.query({
      query: (id) => `/avg_arrival?id=` + id,
    }),
    uploadJourneys: builder.mutation({
      query: () => ({
        url: `/upload`,
        method: "POST",
      }),
    }),
    createJourney: builder.mutation({
      query: (body) => ({
        url: `/`,
        method: "POST",
        body,
      }),
    }),
  }),
});

export const {
  useGetJourneysQuery,
  useGetJourneysSortedQuery,
  useGetJourneysSortedPagedQuery,
  useUploadJourneysMutation,
  useGetSearchedArrivalJourneysQuery,
  useGetSearchedDepartureJourneysQuery,
} = apiJourney;
