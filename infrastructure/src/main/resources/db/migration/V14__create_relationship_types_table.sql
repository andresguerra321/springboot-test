-- Migration: V14__create_relationship_types_table.sql
create table relationship_types (
  id uuid primary key default gen_random_uuid(),
  description varchar(50) not null
);
