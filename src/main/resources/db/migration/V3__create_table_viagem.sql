 CREATE TABLE viagem(
    id VARCHAR(150) PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    descricao VARCHAR(300),
    contratante VARCHAR(150),
    destino VARCHAR(150),
    data_inicio TIMESTAMP with time zone DEFAULT NULL,
    data_fim TIMESTAMP with time zone DEFAULT NULL,
    CONSTRAINT fk_user FOREIGN KEY(contratante) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_destino FOREIGN KEY(destino) REFERENCES destino(id) ON DELETE CASCADE
)