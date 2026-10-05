-- Migration: V55__add_unique_constraints.sql

-- Añadir restricción UNIQUE para los códigos de países, regiones y ciudades
-- para evitar Race Conditions que no puedan ser frenadas a nivel de código (existsByCode).

ALTER TABLE countries ADD CONSTRAINT uq_countries_code UNIQUE (code_country);
ALTER TABLE state_regions ADD CONSTRAINT uq_state_regions_code UNIQUE (code_region);
ALTER TABLE city_municipalities ADD CONSTRAINT uq_city_municipalities_code UNIQUE (code_city);
