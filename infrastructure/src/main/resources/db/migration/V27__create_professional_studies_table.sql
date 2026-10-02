-- Migration: V27__create_professional_studies_table.sql
create table professional_studies (
  id uuid primary key default gen_random_uuid(),
  study_id uuid not null,
  professional_id uuid not null,
  title varchar(100) not null,
  university varchar(100),
  is_valid boolean,
  resolution_number varchar(60),
  country_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
