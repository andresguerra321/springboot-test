-- Migration: V44__create_chat_conversation_ai_settings_table.sql
create table chat_conversation_ai_settings (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  ai_enabled boolean not null,
  default_model_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
