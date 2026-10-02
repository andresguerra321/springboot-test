-- Migration: V30__create_clinical_notes_table.sql
create table clinical_notes (
  id uuid primary key default gen_random_uuid(),
  encounter_id uuid not null,
  professional_id uuid not null,
  subjective text,
  objective text,
  assessment text,
  plan text,
  additional_notes text,
  signed_at timestamp,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
