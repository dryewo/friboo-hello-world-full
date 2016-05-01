CREATE SCHEMA fh_data;
SET search_path TO fh_data;

CREATE TABLE greeting (
  g_id       TEXT NOT NULL PRIMARY KEY,
  g_template TEXT NOT NULL
);
