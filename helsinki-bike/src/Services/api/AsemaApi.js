import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

export const apiAsema = createApi({
  reducerPath: "asemaApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/asema" }),
  tagTypes: ["Asema"],
  endpoints: (builder) => ({
    getAsemat: builder.query({
      query: () => `/`,
    }),
    getSingleAsemat: builder.query({
      query: (id) => `/single/` + id,
    }),
    getTotalDeparture: builder.query({
      query: (id) => `/totaldeparture?id=` + id,
    }),
    getTotalArrival: builder.query({
      query: (id) => `/totalarrival?id=` + id,
    }),
    getAsematCapacity: builder.query({
      query: (capacity) => `/` + capacity,
    }),
    getAsematLocation: builder.query({
      query: (id) => `/location` + id,
    }),
    getMostFiveReturn: builder.query({
      query: () => `/fivereturn`,
    }),
    getMostFiveDdeparture: builder.query({
      query: () => `/fivedeparture`,
    }),
    createAsema: builder.mutation({
      query: (body) => ({
        url: `/`,
        method: "POST",
        body,
      }),
    }),
    uploadAsemat: builder.mutation({
      query: () => ({
        url: `/asema/upload`,
        method: "POST",
      }),
    }),
  }),
});

export const {
  useGetAsematQuery,
  useGetSingleAsematQuery,
  useGetTotalArrivalQuery,
  useGetTotalDepartureQuery,
  useGetAsematCapacityQuery,
} = apiAsema;
