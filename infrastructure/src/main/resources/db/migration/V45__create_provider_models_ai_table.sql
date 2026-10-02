-- Migration: V45__create_provider_models_ai_table.sql
create table provider_models_ai (
  id uuid primary key default gen_random_uuid(),
  name_provider_ai varchar(100) not null,
  razon_social text,
  sitio_web text,
  is_active boolean not null default true,
  created_at timestamp not null default now(),
  updated_at timestamp not null default now()
);
