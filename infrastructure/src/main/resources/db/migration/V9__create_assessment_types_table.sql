-- Migration: V9__create_assessment_types_table.sql
create table assessment_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
