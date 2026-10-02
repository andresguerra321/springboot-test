-- Migration: V46__create_ai_models_table.sql
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
