-- Migration: V15__create_professional_types_table.sql
create table professional_types (
  id uuid primary key default gen_random_uuid(),
  name varchar(40) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
