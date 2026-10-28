package br.com.livraria.service;

import java.sql.SQLException;
import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;

public class LivroService {
    private final LivroRepository repository;
    public LivroService(LivroRepository repository) { this.repository = repository; }

    public void cadastrar(String nome, String autor, int ano, int edicao, String editora, int numeroUnidades) throws SQLException {
        repository.inserir(validar(0, nome, autor, ano, edicao, editora, numeroUnidades));

    }
    public List<Livro> listar() throws SQLException { return repository.listar(); }
    public Livro buscar(int id) throws SQLException {
        validarId(id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));
    }
    public void atualizar(int id, String nome, String autor, int ano, int edicao, String editora, int numeroUnidades) throws SQLException {
        validarId(id);
        Livro livro = validar(id, nome, autor, ano, edicao, editora, numeroUnidades);
        if (!repository.atualizar(livro))
            throw new IllegalArgumentException("Livro não encontrado.");
    }
    public void excluir(int id) throws SQLException {
        validarId(id);
        if (!repository.excluir(id))
            throw new IllegalArgumentException("Livro não encontrado.");
    }
    private void validarId(int id) {
        if (id <= 0) throw new IllegalArgumentException("O código deve ser positivo.");
    }
    private Livro validar(int id, String nome, String autor, int ano, int edicao, String editora, int numeroUnidades) {
        if (nome == null || nome.trim().isEmpty() || nome.trim().length() > 150)
            throw new IllegalArgumentException("Nome obrigatório, com até 150 caracteres.");
        if (autor == null || autor.trim().isEmpty() || autor.trim().length() > 120)
            throw new IllegalArgumentException("Autor obrigatório, com até 120 caracteres.");
        if (ano < 1 || ano > 9999)
            throw new IllegalArgumentException("O ano deve estar entre 1 e 9999.");
        if (edicao < 1)
            throw new IllegalArgumentException("A edição deve ser maior ou igual a 1.");
        if (editora == null || editora.trim().isEmpty() || editora.trim().length() > 120)
            throw new IllegalArgumentException( "Editora obrigatória, com até 120 caracteres.");
        if (numeroUnidades < 0)
            throw new IllegalArgumentException( "O número de unidades não pode ser negativo.");
        return new Livro(id, nome.trim(), autor.trim(), ano, edicao, editora, numeroUnidades);
    }
}
