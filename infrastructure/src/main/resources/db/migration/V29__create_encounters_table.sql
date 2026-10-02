-- Migration: V29__create_encounters_table.sql
create table encounters (
  id uuid primary key default gen_random_uuid(),
  clinical_record_id uuid not null,
  professional_id uuid not null,
  encounter_type_id uuid not null,
  started_at timestamp not null,
  ended_at timestamp,
  reason_for_visit text,
  current_condition text,
  modality_id uuid not null,
  status_id uuid not null,
  created_at timestamp not null default now(),
  created_by uuid,
  updated_at timestamp default now(),
  updated_by uuid
);
