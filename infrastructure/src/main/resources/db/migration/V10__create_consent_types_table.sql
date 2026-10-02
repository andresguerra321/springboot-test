-- Migration: V10__create_consent_types_table.sql
create table consent_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
