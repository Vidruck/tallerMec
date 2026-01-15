SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname='taller';

DROP DATABASE IF EXISTS "taller";

CREATE DATABASE "taller";

\c taller
BEGIN;
\i create.sql
\i catalogos.sql
COMMIT;