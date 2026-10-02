-- Migration: V16__create_studies_table.sql
create table studies (
  id uuid primary key default gen_random_uuid(),
  name varchar(40) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
