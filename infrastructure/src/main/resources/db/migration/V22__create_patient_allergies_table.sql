-- Migration: V22__create_patient_allergies_table.sql
create table patient_allergies (
  id uuid primary key default gen_random_uuid(),
  patient_id uuid not null,
  substance varchar(200) not null,
  reaction text,
  severity varchar(20),
  active boolean,
  recorded_at timestamp,
  recorded_by uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
