-- Migration: V25__create_email_contacts_table.sql
create table email_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  email varchar(150) not null,
  notes text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
