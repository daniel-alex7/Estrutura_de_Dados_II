package br.com.livraria.repository;

import br.com.livraria.model.Livro;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    void inserir(Livro livro) throws SQLException;
    List<Livro> listar() throws SQLException;
    Optional<Livro> buscarPorId(int id) throws SQLException;
    boolean atualizar(Livro livro) throws SQLException;
    boolean excluir(int id) throws SQLException;
}
