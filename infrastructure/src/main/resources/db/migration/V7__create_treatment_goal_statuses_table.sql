-- Migration: V7__create_treatment_goal_statuses_table.sql
create table treatment_goal_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
