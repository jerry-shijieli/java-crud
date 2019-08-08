CREATE TABLE killrvideo.advocates (
  first_name    TEXT,
  last_name     TEXT,
  region        TEXT,
  city          TEXT,
  super_power   TEXT,
  PRIMARY KEY ((region, city), last_name, first_name)
);