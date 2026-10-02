-- Migration: V28__create_clinical_records_table.sql
create table clinical_records (
  id uuid primary key default gen_random_uuid(),
  patient_id uuid not null,
  creation_date timestamp,
  record_number varchar(50) not null,
  opened_at timestamp,
  closed_at timestamp,
  status_id uuid not null,
  created_at timestamp not null default now(),
  created_by uuid
);
