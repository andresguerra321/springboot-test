-- Migration: V36__create_priorities_table.sql
create table priorities (
  id uuid primary key default gen_random_uuid(),
  name_priority varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
