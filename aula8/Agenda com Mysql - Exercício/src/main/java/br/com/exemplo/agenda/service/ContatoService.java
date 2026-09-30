package br.com.exemplo.agenda.service;

import br.com.exemplo.agenda.model.Contato;
import br.com.exemplo.agenda.repository.ContatoRepository;
import java.sql.SQLException;
import java.util.List;

public class ContatoService {
    private final ContatoRepository repository;
    public ContatoService(ContatoRepository repository) { this.repository = repository; }

    public long cadastrar(String nome, String telefone, int idade) throws SQLException {
        validar(nome, telefone, idade);
        return repository.inserir(new Contato(null, nome.trim(), telefone.trim(), idade));
    }

    public List<Contato> listar() throws SQLException { return repository.listar(); }

    public Contato buscar(long id) throws SQLException {
        validarId(id);
        return repository.buscarPorId(id);
    }

    public boolean alterar(long id, String nome, String telefone, int idade) throws SQLException {
        validarId(id);
        validar(nome, telefone, idade);
        return repository.atualizar(new Contato(id, nome.trim(), telefone.trim(), idade));
    }

    public boolean excluir(long id) throws SQLException {
        validarId(id);
        return repository.excluir(id);
    }

    private void validarId(long id) {
        if (id <= 0) throw new IllegalArgumentException("O ID deve ser positivo.");
    }

    private void validar(String nome, String telefone, int idade) {
        if (nome == null || nome.trim().isEmpty() || nome.trim().length() > 100)
            throw new IllegalArgumentException("O nome deve ter de 1 a 100 caracteres.");
        if (telefone == null || telefone.trim().isEmpty() || telefone.trim().length() > 20)
            throw new IllegalArgumentException("O telefone deve ter de 1 a 20 caracteres.");
        if (idade < 0 || idade > 130)
            throw new IllegalArgumentException("A idade deve estar entre 0 e 130 anos.");
    }
}
