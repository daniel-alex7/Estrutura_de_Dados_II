package br.com.livraria.model;

public class Livro {
    private final int id;
    private final String nome;
    private final String autor;
    private final int anoLancamento;
    private final int edicao;
    private final String editora;
    private final int numeroUnidades;

    public Livro(int id, String nome, String autor, int anoLancamento, int edicao, String editora, int numeroUnidades) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.edicao = edicao;
        this.editora = editora;
        this.numeroUnidades = numeroUnidades;
    }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getAutor() { return autor; }
    public int getAnoLancamento() { return anoLancamento; }
    public int getEdicao() { return edicao; }
    public String getEditora() { return editora; }
    public int getNumeroUnidades() { return numeroUnidades; }
}
