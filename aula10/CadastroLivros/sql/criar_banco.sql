CREATE DATABASE IF NOT EXISTS livraria_db
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE livraria_db;

CREATE TABLE IF NOT EXISTS livros (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    autor VARCHAR(120) NOT NULL,
    ano_lancamento SMALLINT UNSIGNED NOT NULL,
    edicao INT NOT NULL DEFAULT 1,
    editora VARCHAR(120) NOT NULL DEFAULT 'Não informada',
    numero_unidades INT NOT NULL DEFAULT 0,
    CONSTRAINT pk_livros PRIMARY KEY (id),
    CONSTRAINT ck_livros_ano CHECK (ano_lancamento BETWEEN 1 AND 9999),
    CONSTRAINT ck_livros_edicao CHECK (edicao >= 1),
    CONSTRAINT ck_livros_unidades CHECK (numero_unidades >= 0)
);

-- Consulta para conferir os registros:
SELECT id, nome, autor, ano_lancamento, edicao, editora, numero_unidades
FROM livros ORDER BY nome, id;

