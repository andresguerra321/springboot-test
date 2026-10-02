-- Migration: V48__create_chat_ai_run_metrics_table.sql
create table chat_ai_run_metrics (
  id uuid primary key default gen_random_uuid(),
  ai_run_id uuid not null,
  prompt_tokens integer,
  completion_tokens integer,
  total_tokens integer,
  cost numeric(10,6),
  created_at timestamp not null default now()
);
