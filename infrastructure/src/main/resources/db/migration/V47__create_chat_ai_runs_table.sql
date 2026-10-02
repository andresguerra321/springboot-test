-- Migration: V47__create_chat_ai_runs_table.sql
create table chat_ai_runs (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  message_id uuid not null,
  model_id uuid not null,
  ai_run_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
