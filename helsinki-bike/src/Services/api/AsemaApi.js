import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

export const apiAsema = createApi({
  reducerPath: "asemaApi",
  baseQuery: fetchBaseQuery({ baseUrl: "http://localhost:8080/" }), //needs params a number of page
  tagTypes: ["Asema"],
  endpoints: (builder) => ({
    getAsemat: builder.query({
      query: (arg) => {
        console.log("arg: ", arg);
        return {
          url: "asema/",
          params: { page: arg },
        };
      },
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
