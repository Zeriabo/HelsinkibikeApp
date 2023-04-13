
-- Role: zeriab
-- DROP ROLE IF EXISTS zeriab;

-- CREATE  ROLE zeriab WITH
--   LOGIN
--   SUPERUSER
--   INHERIT
--   CREATEDB
--   CREATEROLE
--   REPLICATION;
-- DROP DATABASE IF EXISTS  helsinkibike;
-- CREATE DATABASE helsinkibike;
use helsinkibike;
-- Table: public.asemat

-- DROP TABLE IF EXISTS public.asemat;

CREATE TABLE IF NOT EXISTS public.asemat
(
    fid bigint NOT NULL,
    operator character varying(255) COLLATE pg_catalog."default",
    adres character varying(255) COLLATE pg_catalog."default",
    id bigint,
    kapasiteet integer NOT NULL,
    kaupunki character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    namn character varying(255) COLLATE pg_catalog."default",
    nimi character varying(255) COLLATE pg_catalog."default",
    osoite character varying(255) COLLATE pg_catalog."default",
    stad character varying(255) COLLATE pg_catalog."default",
    x double precision NOT NULL,
    y double precision NOT NULL,
    CONSTRAINT asemat_pkey PRIMARY KEY (fid),
    CONSTRAINT uk_j2co4kvy0ph5qm42tf76j1oin UNIQUE (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.asemat
    OWNER to zeriab;

-- Table: public.journey

-- DROP TABLE IF EXISTS public.journey;

CREATE TABLE IF NOT EXISTS public.journey
(
    id bigint NOT NULL,
    arrival timestamp(6) without time zone,
    arrival_station_id integer NOT NULL,
    arrival_station_name character varying(255) COLLATE pg_catalog."default",
    covered_distance double precision NOT NULL,
    departure timestamp(6) without time zone,
    departure_station_id integer NOT NULL,
    departure_station_name character varying(255) COLLATE pg_catalog."default",
    duration double precision NOT NULL,
    CONSTRAINT journey_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.journey
    OWNER to zeriab;
