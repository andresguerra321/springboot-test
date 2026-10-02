-- Migration: V19__create_city_municipalities_table.sql
create table city_municipalities (
  id uuid primary key default gen_random_uuid(),
  name_city varchar(50) not null,
  code_city varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  region_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
