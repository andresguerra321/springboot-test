-- Migration: V50__create_chat_escalations_table.sql
create table chat_escalations (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  status_id uuid not null,
  from_ai boolean,
  reason text,
  created_at timestamp not null default now()
);
