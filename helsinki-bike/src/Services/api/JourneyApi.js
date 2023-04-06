import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import { IProduct } from "../../types/types";

export const journeyApi = createApi({
  reducerPath: "journeyApi",
  baseQuery: fetchBaseQuery({ baseUrl: "https://localhost:8080/journey" }),
  endpoints: (builder) => ({
    getJourneys: builder.query({
      query: () => `/`,
    }),
    getJourneysSorted: builder.query({
      query: (column) => `/sorted?sortedBy=` + column,
    }),
    getSearchedDepartureJourneys: builder.query({
      query: (search) => `/search_departure?search=` + search,
    }),
    getSearchedArrivalJourneys: builder.query({
      query: (search) => `/search_arrival?search=` + search,
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

export const { useGetJourneysQuery, useUploadJourneysMutation } = journeyApi;
