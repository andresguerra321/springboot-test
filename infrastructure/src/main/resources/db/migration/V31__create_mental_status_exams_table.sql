-- Migration: V31__create_mental_status_exams_table.sql
create table mental_status_exams (
  id uuid primary key default gen_random_uuid(),
  encounter_id uuid not null,
  appearance text,
  behavior text,
  attitude text,
  consciousness text,
  orientation text,
  attention text,
  memory text,
  speech text,
  mood text,
  affect text,
  thought_process text,
  thought_content text,
  perception text,
  judgment text,
  insight text,
  psychomotor_activity text,
  observations text,
  created_at timestamp not null default now(),
  created_by uuid
);
