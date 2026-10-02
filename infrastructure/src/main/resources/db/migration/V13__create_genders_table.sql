-- Migration: V13__create_genders_table.sql
create table genders (
  id uuid primary key default gen_random_uuid(),
  description varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
