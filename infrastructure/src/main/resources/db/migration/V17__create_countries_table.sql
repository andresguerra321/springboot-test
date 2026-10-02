-- Migration: V17__create_countries_table.sql
create table countries (
  id uuid primary key default gen_random_uuid(),
  name_country varchar(50) not null,
  code_country varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  telephone_prefix varchar(5),
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
