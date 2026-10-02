-- Migration: V33__create_treatment_plans_table.sql
create table treatment_plans (
  id uuid primary key default gen_random_uuid(),
  encounter_id uuid not null,
  professional_id uuid not null,
  title varchar(200) not null,
  description text,
  start_date date,
  end_date date,
  treatment_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
