-- Migration: V5__create_risk_levels_table.sql
create table risk_levels (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  severity integer,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
