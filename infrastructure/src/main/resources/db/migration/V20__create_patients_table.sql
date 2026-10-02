-- Migration: V20__create_patients_table.sql
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
