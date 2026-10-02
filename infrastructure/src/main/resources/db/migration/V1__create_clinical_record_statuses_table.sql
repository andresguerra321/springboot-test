-- Migration: V1__create_clinical_record_statuses_table.sql
-- Asegurar soporte para gen_random_uuid() en PostgreSQL
CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table clinical_record_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
