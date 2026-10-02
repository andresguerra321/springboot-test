-- Migration: V26__create_professionals_table.sql
create table professionals (
  id uuid primary key default gen_random_uuid(),
  document_type_id uuid not null,
  document_number varchar(30) not null,
  first_name varchar(60) not null,
  last_name varchar(60) not null,
  professional_type uuid not null,
  license_number varchar(100),
  active boolean not null default true,
  city_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now(),
  unique (document_type_id, document_number)
);
