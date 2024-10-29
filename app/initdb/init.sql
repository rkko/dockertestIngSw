-- init.sql

-- Crear la base de datos solo si no existe
DO $$ 
BEGIN 
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'test') THEN
        EXECUTE 'CREATE DATABASE test';
    END IF;
END $$;

-- Conectar a la base de datos 'test'
\c test;

-- Crear la tabla solo si no existe
DO $$ 
BEGIN 
    IF NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'test_table') THEN
        EXECUTE 'CREATE TABLE test_table (
            id SERIAL PRIMARY KEY,
            name VARCHAR(50) NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )';
    END IF;
END $$;

