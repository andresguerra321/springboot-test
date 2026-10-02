-- Migration: V51__create_chat_escalation_assignments_table.sql
create table chat_escalation_assignments (
  id uuid primary key default gen_random_uuid(),
  escalation_id uuid not null,
  professional_id uuid not null,
  assigned_at timestamp not null
);
