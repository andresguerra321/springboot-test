-- Migration: V34__create_treatment_goals_table.sql
create table treatment_goals (
  id uuid primary key default gen_random_uuid(),
  treatment_plan_id uuid not null,
  description text not null,
  target_date date,
  completed_at timestamp,
  notes text,
  treatment_goal_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
