-- Migration: V21__create_patient_contacts_table.sql
create table patient_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  patient_id uuid not null,
  is_primary_contact boolean,
  is_emergency_contact boolean,
  relationship_type_id uuid
);
