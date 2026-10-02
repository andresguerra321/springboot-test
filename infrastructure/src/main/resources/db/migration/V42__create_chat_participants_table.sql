-- Migration: V42__create_chat_participants_table.sql
create table chat_participants (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  participant_type_id uuid not null,
  patient_id uuid,
  professional_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
