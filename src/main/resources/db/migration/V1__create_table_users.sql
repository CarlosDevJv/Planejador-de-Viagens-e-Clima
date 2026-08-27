CREATE TABLE users(
    id VARCHAR(150) PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    data_cadastro TIMESTAMP with time zone DEFAULT NULL
);