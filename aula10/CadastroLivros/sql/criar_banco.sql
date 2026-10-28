CREATE DATABASE IF NOT EXISTS livraria_db;
USE livraria_db;

CREATE TABLE IF NOT EXISTS livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    autor VARCHAR(120) NOT NULL,
    ano_lancamento INT NOT NULL,
    edicao INT NOT NULL DEFAULT 1,
    editora VARCHAR(120) NOT NULL DEFAULT 'Não informada',
    numero_unidades INT NOT NULL DEFAULT 0,
    CONSTRAINT ck_livros_edicao CHECK (edicao >= 1),
    CONSTRAINT ck_livros_unidades CHECK (numero_unidades >= 0)
);