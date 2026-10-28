package br.com.livraria.view;

import java.util.List;
import java.util.Scanner;

import br.com.livraria.model.Livro;

public class LivroView {
    private final Scanner scanner;
    public LivroView(Scanner scanner) { this.scanner = scanner; }
    public void menu() {
        System.out.println("\n=== CADASTRO DE LIVROS ===");
        System.out.println("1 - Cadastrar\n2 - Listar\n3 - Buscar por código");
        System.out.println("4 - Alterar\n5 - Excluir\n0 - Sair");
    }
    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        if (!scanner.hasNextLine()) throw new java.util.NoSuchElementException();
        return scanner.nextLine();
    }
    public int lerInteiro(String mensagem) {
        while (true) {
            try { return Integer.parseInt(lerTexto(mensagem).trim()); }
            catch (NumberFormatException e) { mostrar("Digite um número inteiro válido."); }
        }
    }
    public void mostrar(String mensagem) { System.out.println(mensagem); }
    public void mostrar(Livro livro) {
    if (livro == null) {
        System.out.println("Livro não encontrado.");
        return;
    }
    System.out.println("----------------------------------------");
    System.out.println("Código: " + livro.getId());
    System.out.println("Nome: " + livro.getNome());
    System.out.println("Autor: " + livro.getAutor());
    System.out.println("Ano de lançamento: " + livro.getAnoLancamento());
    System.out.println("Edição: " + livro.getEdicao());
    System.out.println("Editora: " + livro.getEditora());
    System.out.println("Número de unidades: " + livro.getNumeroUnidades());
    System.out.println("----------------------------------------");
}
    public void listar(List<Livro> livros) {
        if (livros.isEmpty()) mostrar("Nenhum livro cadastrado.");
        else livros.forEach(this::mostrar);
    }
}
