-- Migration: V49__create_chat_ai_run_errors_table.sql
create table chat_ai_run_errors (
  id uuid primary key default gen_random_uuid(),
  ai_run_id uuid not null,
  error_message text,
  error_code varchar(80),
  provider_error_id varchar(120),
  created_at timestamp not null default now()
);
