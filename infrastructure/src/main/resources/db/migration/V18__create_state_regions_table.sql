-- Migration: V18__create_state_regions_table.sql
create table state_regions (
  id uuid primary key default gen_random_uuid(),
  name_region varchar(50) not null,
  code_region varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  country_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
