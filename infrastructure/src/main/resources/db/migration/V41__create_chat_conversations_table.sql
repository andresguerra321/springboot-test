-- Migration: V41__create_chat_conversations_table.sql
create table chat_conversations (
  id uuid primary key default gen_random_uuid(),
  conversation_status_id uuid not null,
  priority_id uuid not null,
  last_message_at timestamp,
  closed boolean,
  closed_at timestamp,
  closed_by uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
