package br.com.livraria.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.livraria.config.Conexao;
import br.com.livraria.model.Livro;

public class LivroMySqlRepository implements LivroRepository {
    private final Conexao conexao;
    public LivroMySqlRepository(Conexao conexao) { this.conexao = conexao; }

    @Override
    public void inserir(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (nome, autor, ano_lancamento, edicao, editora, numero_unidades) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = conexao.abrir(); PreparedStatement ps = c.prepareStatement(sql)) {
            preencher(ps, livro);
            ps.executeUpdate();
        }
    }
    @Override
    public List<Livro> listar() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT id, nome, autor, ano_lancamento, edicao, editora, numero_unidades FROM livros ORDER BY nome, id";
        try (Connection c = conexao.abrir(); PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) livros.add(mapear(rs));
        }
        return livros;
    }
    @Override
    public Optional<Livro> buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, autor, ano_lancamento, "
        + "edicao, editora, numero_unidades "
         + "FROM livros WHERE id = ?";

        try (Connection c = conexao.abrir(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        }
    }
    @Override
    public boolean atualizar(Livro livro) throws SQLException {
        String sql = "UPDATE livros SET nome = ?, autor = ?, ano_lancamento = ?, "
        + "edicao = ?, editora = ?, numero_unidades = ? WHERE id = ?";

        try (Connection c = conexao.abrir(); PreparedStatement ps = c.prepareStatement(sql)) {
            preencher(ps, livro);
            ps.setInt(7, livro.getId());
            return ps.executeUpdate() > 0;
        }
    }
    @Override
    public boolean excluir(int id) throws SQLException {
        try (Connection c = conexao.abrir();
             PreparedStatement ps = c.prepareStatement("DELETE FROM livros WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
    private void preencher(PreparedStatement ps, Livro livro) throws SQLException {
        ps.setString(1, livro.getNome());
        ps.setString(2, livro.getAutor());
        ps.setInt(3, livro.getAnoLancamento());
        ps.setInt(4, livro.getEdicao());
        ps.setString(5, livro.getEditora());
        ps.setInt(6, livro.getNumeroUnidades());
    }
    private Livro mapear(ResultSet rs) throws SQLException {
       return new Livro(rs.getInt("id"), rs.getString("nome"),
       rs.getString("autor"), rs.getInt("ano_lancamento"),
       rs.getInt("edicao"), rs.getString("editora"),
       rs.getInt("numero_unidades"));

    }
}
