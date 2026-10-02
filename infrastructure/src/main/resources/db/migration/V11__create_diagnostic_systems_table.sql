-- Migration: V11__create_diagnostic_systems_table.sql
create table diagnostic_systems (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  version varchar(20),
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
