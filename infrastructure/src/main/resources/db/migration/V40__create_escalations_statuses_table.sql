-- Migration: V40__create_escalations_statuses_table.sql
create table escalations_statuses (
  id uuid primary key default gen_random_uuid(),
  name_status varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
