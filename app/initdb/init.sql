-- init.sql
CREATE DATABASE test;

\c test;

CREATE TABLE test_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
