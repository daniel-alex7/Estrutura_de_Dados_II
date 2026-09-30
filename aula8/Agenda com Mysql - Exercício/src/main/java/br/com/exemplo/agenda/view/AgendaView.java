package br.com.exemplo.agenda.view;

import br.com.exemplo.agenda.model.Contato;
import java.util.List;
import java.util.Scanner;

public class AgendaView {
    private final Scanner entrada = new Scanner(System.in);

    public String lerOpcao() {
        System.out.println("\n=== AGENDA DE CONTATOS ===");
        System.out.println("1 - Cadastrar\n2 - Listar\n3 - Buscar por ID");
        System.out.println("4 - Alterar\n5 - Excluir\n0 - Sair");
        return ler("Escolha: ");
    }

    public String lerNome() { return ler("Nome: "); }
    public String lerTelefone() { return ler("Telefone: "); }
    public int lerIdade() { return lerInt("Idade: "); }
    public long lerId() { return lerLong("ID do contato: "); }
    public String lerNovoNome() { return ler("Novo nome: "); }
    public String lerNovoTelefone() { return ler("Novo telefone: "); }
    public int lerNovaIdade() { return lerInt("Nova idade: "); }

    public void mostrarMensagem(String mensagem) { System.out.println(mensagem); }

    public void mostrarContatos(List<Contato> contatos) {
        if (contatos.isEmpty()) { mostrarMensagem("Nenhum contato cadastrado."); return; }
        for (Contato contato : contatos) mostrarContato(contato);
    }

    public void mostrarContato(Contato contato) {
        System.out.println("ID: " + contato.getId() + " | Nome: " + contato.getNome()
                + " | Telefone: " + contato.getTelefone() + " | Idade: " + contato.getIdade());
    }

    private String ler(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine();
    }

    private int lerInt(String mensagem) {
        try { return Integer.parseInt(ler(mensagem).trim()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Informe um número inteiro válido."); }
    }

    private long lerLong(String mensagem) {
        try { return Long.parseLong(ler(mensagem).trim()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Informe um ID numérico válido."); }
    }
}
