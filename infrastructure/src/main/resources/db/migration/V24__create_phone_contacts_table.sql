-- Migration: V24__create_phone_contacts_table.sql
create table phone_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  phone varchar(30) not null,
  notes text
);
