-- Migration: V52__create_chat_escalation_status_history_table.sql
create table chat_escalation_status_history (
  id uuid primary key default gen_random_uuid(),
  escalation_id uuid not null,
  escalation_status_id uuid not null,
  created_at timestamp not null default now(),
  changed_at timestamp not null
);
