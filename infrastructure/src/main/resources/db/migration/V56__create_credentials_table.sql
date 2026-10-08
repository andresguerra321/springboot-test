-- Migration: V56__create_credentials_table.sql
create table credentials (
  id uuid primary key default gen_random_uuid(),
  professional_id uuid not null unique,
  username varchar(100) not null unique,
  password_hash varchar(255) not null,
  role varchar(50) not null,
  enabled boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now(),

  constraint fk_credential_professional
      foreign key (professional_id)
      references professionals (id)
      on delete cascade
);
