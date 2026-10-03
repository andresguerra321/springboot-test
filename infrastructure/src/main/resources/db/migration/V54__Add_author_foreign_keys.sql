ALTER TABLE patients ADD CONSTRAINT fk_patients_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);
ALTER TABLE patients ADD CONSTRAINT fk_patients_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);

ALTER TABLE contacts ADD CONSTRAINT fk_contacts_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);
ALTER TABLE encounters ADD CONSTRAINT fk_encounters_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);
