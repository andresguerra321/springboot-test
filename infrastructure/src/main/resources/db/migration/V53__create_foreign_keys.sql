-- Migration: V53__create_foreign_keys.sql
-- Restricciones de integridad referencial (Foreign Keys) para las 52 tablas

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
