package aula4.ex3;

public class Agenda {
    String nome;
    String endereco;
    String telefone;

    Agenda(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone;
    }
}
