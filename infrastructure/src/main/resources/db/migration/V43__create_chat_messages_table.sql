-- Migration: V43__create_chat_messages_table.sql
create table chat_messages (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  message_type_id uuid not null,
  participant_id uuid not null,
  content text,
  metadata jsonb,
  created_at timestamp not null default now()
);
