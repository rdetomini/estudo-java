CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade int
);

CREATE TABLE contatos (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    celular VARCHAR(100) NOT NULL,
    usuarioId bigint not null,
    FOREIGN KEY (usuarioId) REFERENCES usuarios(id)
);
