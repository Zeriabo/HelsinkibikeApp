import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

export const apiAsema = createApi({
  reducerPath: "asemaApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }),
  tagTypes: ["Asema"],
  endpoints: (builder) => ({
    getAsemat: builder.query({
      query: () => `asema/`,
    }),
    getSingleAsemat: builder.query({
      query: (id) => `/asema/single/` + id,
    }),
    getAsematCapacity: builder.query({
      query: (capacity) => `/asema/` + capacity,
    }),
    getAsematLocation: builder.query({
      query: (id) => `/asema/location` + id,
    }),
    getMostFiveReturn: builder.query({
      query: () => `/asema/fivereturn`,
    }),
    getMostFiveDdeparture: builder.query({
      query: () => `/asema/fivedeparture`,
    }),
    createAsema: builder.mutation({
      query: (body) => ({
        url: `/asema/`,
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

export const { useGetAsematQuery, useGetSingleAsematQuery } = apiAsema;
