package br.com.exemplo.agenda.model;

public class Contato {
    private Long id;
    private String nome;
    private String telefone;
    private int idade;

    public Contato(Long id, String nome, String telefone, int idade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public int getIdade() { return idade; }
}
