-- Migration: V23__create_contacts_table.sql
create table contacts (
  id uuid primary key default gen_random_uuid(),
  full_name varchar(200) not null,
  email varchar(150),
  notes text,
  city_id uuid,
  created_at timestamp not null default now(),
  created_by uuid,
  updated_at timestamp default now(),
  updated_by uuid
);
