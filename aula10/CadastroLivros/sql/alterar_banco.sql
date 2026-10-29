USE livraria_db;
-- Execute uma única vez sobre a tabela do projeto original.
ALTER TABLE livros
 ADD COLUMN edicao INT NOT NULL DEFAULT 1,
 ADD COLUMN editora VARCHAR(120) NOT NULL DEFAULT 'Não informada',
 ADD COLUMN numero_unidades INT NOT NULL DEFAULT 0,
 ADD CONSTRAINT ck_livros_edicao CHECK (edicao >= 1),
 ADD CONSTRAINT ck_livros_unidades CHECK (numero_unidades >= 0);

SELECT id, nome, autor, ano_lancamento, edicao, editora, numero_unidades
FROM livros ORDER BY nome, id;