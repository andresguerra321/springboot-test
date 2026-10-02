-- Migration: V32__create_risk_assessments_table.sql
create table risk_assessments (
  id uuid primary key default gen_random_uuid(),
  encounter_id uuid not null,
  risk_level_id uuid not null,
  suicidal_ideation boolean,
  suicide_plan boolean,
  suicide_intent boolean,
  self_harm boolean,
  harm_to_others boolean,
  protective_factors text,
  risk_factors text,
  clinical_actions text,
  observations text,
  assessed_at timestamp,
  assessed_by uuid
);
