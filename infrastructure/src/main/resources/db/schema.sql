-- PostgreSQL 13+ (gen_random_uuid nativo)

create table clinical_record_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table encounter_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table encounter_modalities (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table encounter_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table risk_levels (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  severity integer,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table treatment_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table treatment_goal_statuses (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table medication_routes (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table assessment_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table consent_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  description text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table diagnostic_systems (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  version varchar(20),
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table document_types (
  id uuid primary key default gen_random_uuid(),
  code varchar(20) not null unique,
  name varchar(50) not null unique,
  active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table genders (
  id uuid primary key default gen_random_uuid(),
  description varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table relationship_types (
  id uuid primary key default gen_random_uuid(),
  description varchar(50) not null
);

create table professional_types (
  id uuid primary key default gen_random_uuid(),
  name varchar(40) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table studies (
  id uuid primary key default gen_random_uuid(),
  name varchar(40) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table countries (
  id uuid primary key default gen_random_uuid(),
  name_country varchar(50) not null,
  code_country varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  telephone_prefix varchar(5),
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table state_regions (
  id uuid primary key default gen_random_uuid(),
  name_region varchar(50) not null,
  code_region varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  country_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table city_municipalities (
  id uuid primary key default gen_random_uuid(),
  name_city varchar(50) not null,
  code_city varchar(10),
  description varchar(100),
  is_active boolean not null default true,
  region_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table patients (
  id uuid primary key default gen_random_uuid(),
  document_type_id uuid not null,
  document_number varchar(30) not null,
  first_name varchar(50) not null,
  middle_name varchar(50),
  last_name varchar(50) not null,
  second_last_name varchar(50),
  birth_date date,
  biological_sex_id uuid not null,
  gender_identity uuid,
  email varchar(150),
  phone varchar(30),
  address varchar(250),
  active boolean not null default true,
  created_at timestamp not null default now(),
  created_by uuid,
  updated_at timestamp default now(),
  updated_by uuid,
  city_id uuid,
  unique (document_type_id, document_number)
);

create table patient_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  patient_id uuid not null,
  is_primary_contact boolean,
  is_emergency_contact boolean,
  relationship_type_id uuid
);

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

create table contacts (
  id uuid primary key default gen_random_uuid(),
  full_name varchar(200) not null,
  email varchar(150),
  notes text,
  city_id uuid,
  created_at timestamp not null default now(),
  created_by uuid,
  updated_at timestamp default now(),
  updated_by uuid
);

create table phone_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  phone varchar(30) not null,
  notes text
);

create table email_contacts (
  id uuid primary key default gen_random_uuid(),
  contact_id uuid not null,
  email varchar(150) not null,
  notes text,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table professionals (
  id uuid primary key default gen_random_uuid(),
  document_type_id uuid not null,
  document_number varchar(30) not null,
  first_name varchar(60) not null,
  last_name varchar(60) not null,
  professional_type uuid not null,
  license_number varchar(100),
  active boolean not null default true,
  city_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now(),
  unique (document_type_id, document_number)
);

create table professional_studies (
  id uuid primary key default gen_random_uuid(),
  study_id uuid not null,
  professional_id uuid not null,
  title varchar(100) not null,
  university varchar(100),
  is_valid boolean,
  resolution_number varchar(60),
  country_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

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

create table treatment_plans (
  id uuid primary key default gen_random_uuid(),
  encounter_id uuid not null,
  professional_id uuid not null,
  title varchar(200) not null,
  description text,
  start_date date,
  end_date date,
  treatment_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table treatment_goals (
  id uuid primary key default gen_random_uuid(),
  treatment_plan_id uuid not null,
  description text not null,
  target_date date,
  completed_at timestamp,
  notes text,
  treatment_goal_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table sender_types (
  id uuid primary key default gen_random_uuid(),
  name_type varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table priorities (
  id uuid primary key default gen_random_uuid(),
  name_priority varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table conversations_statuses (
  id uuid primary key default gen_random_uuid(),
  name_status varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table message_types (
  id uuid primary key default gen_random_uuid(),
  name_type varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table ai_runs_statuses (
  id uuid primary key default gen_random_uuid(),
  name_status varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table escalations_statuses (
  id uuid primary key default gen_random_uuid(),
  name_status varchar(50) not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table chat_conversations (
  id uuid primary key default gen_random_uuid(),
  conversation_status_id uuid not null,
  priority_id uuid not null,
  last_message_at timestamp,
  closed boolean,
  closed_at timestamp,
  closed_by uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table chat_participants (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  participant_type_id uuid not null,
  patient_id uuid,
  professional_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table chat_messages (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  message_type_id uuid not null,
  participant_id uuid not null,
  content text,
  metadata jsonb,
  created_at timestamp not null default now()
);

create table chat_conversation_ai_settings (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  ai_enabled boolean not null,
  default_model_id uuid,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table provider_models_ai (
  id uuid primary key default gen_random_uuid(),
  name_provider_ai varchar(100) not null,
  razon_social text,
  sitio_web text,
  is_active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table ai_models (
  id uuid primary key default gen_random_uuid(),
  provider_model_id uuid not null,
  name_model varchar(100) not null,
  model_key varchar(120) not null,
  input_token_price numeric(12,8),
  output_token_price numeric(12,8),
  max_tokens integer,
  context_window integer,
  is_active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table chat_ai_runs (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  message_id uuid not null,
  model_id uuid not null,
  ai_run_status_id uuid not null,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);

create table chat_ai_run_metrics (
  id uuid primary key default gen_random_uuid(),
  ai_run_id uuid not null,
  prompt_tokens integer,
  completion_tokens integer,
  total_tokens integer,
  cost numeric(10,6),
  created_at timestamp not null default now()
);

create table chat_ai_run_errors (
  id uuid primary key default gen_random_uuid(),
  ai_run_id uuid not null,
  error_message text,
  error_code varchar(80),
  provider_error_id varchar(120),
  created_at timestamp not null default now()
);

create table chat_escalations (
  id uuid primary key default gen_random_uuid(),
  conversation_id uuid not null,
  status_id uuid not null,
  from_ai boolean,
  reason text,
  created_at timestamp not null default now()
);

create table chat_escalation_assignments (
  id uuid primary key default gen_random_uuid(),
  escalation_id uuid not null,
  professional_id uuid not null,
  assigned_at timestamp not null
);

create table chat_escalation_status_history (
  id uuid primary key default gen_random_uuid(),
  escalation_id uuid not null,
  escalation_status_id uuid not null,
  created_at timestamp not null default now(),
  changed_at timestamp not null
);

alter table state_regions add constraint fk_state_regions_country_id foreign key (country_id) references countries(id);
alter table city_municipalities add constraint fk_city_municipalities_region_id foreign key (region_id) references state_regions(id);
alter table patients add constraint fk_patients_document_type_id foreign key (document_type_id) references document_types(id);
alter table patients add constraint fk_patients_biological_sex_id foreign key (biological_sex_id) references genders(id);
alter table patients add constraint fk_patients_gender_identity foreign key (gender_identity) references genders(id);
alter table patients add constraint fk_patients_city_id foreign key (city_id) references city_municipalities(id);
alter table patient_contacts add constraint fk_patient_contacts_contact_id foreign key (contact_id) references contacts(id);
alter table patient_contacts add constraint fk_patient_contacts_patient_id foreign key (patient_id) references patients(id);
alter table patient_contacts add constraint fk_patient_contacts_relationship_type_id foreign key (relationship_type_id) references relationship_types(id);
alter table patient_allergies add constraint fk_patient_allergies_patient_id foreign key (patient_id) references patients(id);
alter table patient_allergies add constraint fk_patient_allergies_recorded_by foreign key (recorded_by) references professionals(id);
alter table contacts add constraint fk_contacts_city_id foreign key (city_id) references city_municipalities(id);
alter table contacts add constraint fk_contacts_created_by foreign key (created_by) references professionals(id);
alter table phone_contacts add constraint fk_phone_contacts_contact_id foreign key (contact_id) references contacts(id);
alter table email_contacts add constraint fk_email_contacts_contact_id foreign key (contact_id) references contacts(id);
alter table professionals add constraint fk_professionals_document_type_id foreign key (document_type_id) references document_types(id);
alter table professionals add constraint fk_professionals_professional_type foreign key (professional_type) references professional_types(id);
alter table professionals add constraint fk_professionals_city_id foreign key (city_id) references city_municipalities(id);
alter table professional_studies add constraint fk_professional_studies_study_id foreign key (study_id) references studies(id);
alter table professional_studies add constraint fk_professional_studies_professional_id foreign key (professional_id) references professionals(id);
alter table professional_studies add constraint fk_professional_studies_country_id foreign key (country_id) references countries(id);
alter table clinical_records add constraint fk_clinical_records_patient_id foreign key (patient_id) references patients(id);
alter table clinical_records add constraint fk_clinical_records_status_id foreign key (status_id) references clinical_record_statuses(id);
alter table clinical_records add constraint fk_clinical_records_created_by foreign key (created_by) references professionals(id);
alter table encounters add constraint fk_encounters_clinical_record_id foreign key (clinical_record_id) references clinical_records(id);
alter table encounters add constraint fk_encounters_professional_id foreign key (professional_id) references professionals(id);
alter table encounters add constraint fk_encounters_encounter_type_id foreign key (encounter_type_id) references encounter_types(id);
alter table encounters add constraint fk_encounters_modality_id foreign key (modality_id) references encounter_modalities(id);
alter table encounters add constraint fk_encounters_status_id foreign key (status_id) references encounter_statuses(id);
alter table clinical_notes add constraint fk_clinical_notes_encounter_id foreign key (encounter_id) references encounters(id);
alter table clinical_notes add constraint fk_clinical_notes_professional_id foreign key (professional_id) references professionals(id);
alter table mental_status_exams add constraint fk_mental_status_exams_encounter_id foreign key (encounter_id) references encounters(id);
alter table mental_status_exams add constraint fk_mental_status_exams_created_by foreign key (created_by) references professionals(id);
alter table risk_assessments add constraint fk_risk_assessments_encounter_id foreign key (encounter_id) references encounters(id);
alter table risk_assessments add constraint fk_risk_assessments_risk_level_id foreign key (risk_level_id) references risk_levels(id);
alter table risk_assessments add constraint fk_risk_assessments_assessed_by foreign key (assessed_by) references professionals(id);
alter table treatment_plans add constraint fk_treatment_plans_encounter_id foreign key (encounter_id) references encounters(id);
alter table treatment_plans add constraint fk_treatment_plans_professional_id foreign key (professional_id) references professionals(id);
alter table treatment_plans add constraint fk_treatment_plans_treatment_status_id foreign key (treatment_status_id) references treatment_statuses(id);
alter table treatment_goals add constraint fk_treatment_goals_treatment_plan_id foreign key (treatment_plan_id) references treatment_plans(id);
alter table treatment_goals add constraint fk_treatment_goals_treatment_goal_status_id foreign key (treatment_goal_status_id) references treatment_goal_statuses(id);
alter table chat_conversations add constraint fk_chat_conversations_conversation_status_id foreign key (conversation_status_id) references conversations_statuses(id);
alter table chat_conversations add constraint fk_chat_conversations_priority_id foreign key (priority_id) references priorities(id);
alter table chat_participants add constraint fk_chat_participants_conversation_id foreign key (conversation_id) references chat_conversations(id);
alter table chat_participants add constraint fk_chat_participants_participant_type_id foreign key (participant_type_id) references sender_types(id);
alter table chat_participants add constraint fk_chat_participants_patient_id foreign key (patient_id) references patients(id);
alter table chat_participants add constraint fk_chat_participants_professional_id foreign key (professional_id) references professionals(id);
alter table chat_messages add constraint fk_chat_messages_conversation_id foreign key (conversation_id) references chat_conversations(id);
alter table chat_messages add constraint fk_chat_messages_message_type_id foreign key (message_type_id) references message_types(id);
alter table chat_messages add constraint fk_chat_messages_participant_id foreign key (participant_id) references chat_participants(id);
alter table chat_conversation_ai_settings add constraint fk_chat_conversation_ai_settings_conversation_id foreign key (conversation_id) references chat_conversations(id);
alter table chat_conversation_ai_settings add constraint fk_chat_conversation_ai_settings_default_model_id foreign key (default_model_id) references ai_models(id);
alter table ai_models add constraint fk_ai_models_provider_model_id foreign key (provider_model_id) references provider_models_ai(id);
alter table chat_ai_runs add constraint fk_chat_ai_runs_conversation_id foreign key (conversation_id) references chat_conversations(id);
alter table chat_ai_runs add constraint fk_chat_ai_runs_message_id foreign key (message_id) references chat_messages(id);
alter table chat_ai_runs add constraint fk_chat_ai_runs_model_id foreign key (model_id) references ai_models(id);
alter table chat_ai_runs add constraint fk_chat_ai_runs_ai_run_status_id foreign key (ai_run_status_id) references ai_runs_statuses(id);
alter table chat_ai_run_metrics add constraint fk_chat_ai_run_metrics_ai_run_id foreign key (ai_run_id) references chat_ai_runs(id);
alter table chat_ai_run_errors add constraint fk_chat_ai_run_errors_ai_run_id foreign key (ai_run_id) references chat_ai_runs(id);
alter table chat_escalations add constraint fk_chat_escalations_conversation_id foreign key (conversation_id) references chat_conversations(id);
alter table chat_escalations add constraint fk_chat_escalations_status_id foreign key (status_id) references escalations_statuses(id);
alter table chat_escalation_assignments add constraint fk_chat_escalation_assignments_escalation_id foreign key (escalation_id) references chat_escalations(id);
alter table chat_escalation_assignments add constraint fk_chat_escalation_assignments_professional_id foreign key (professional_id) references professionals(id);
alter table chat_escalation_status_history add constraint fk_chat_escalation_status_history_escalation_id foreign key (escalation_id) references chat_escalations(id);
alter table chat_escalation_status_history add constraint fk_chat_escalation_status_history_escalation_status_id foreign key (escalation_status_id) references escalations_statuses(id);
