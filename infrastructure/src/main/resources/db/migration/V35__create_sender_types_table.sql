-- Migration: V35__create_sender_types_table.sql
create table sender_types (
  id uuid primary key default gen_random_uuid(),
  name_type varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
