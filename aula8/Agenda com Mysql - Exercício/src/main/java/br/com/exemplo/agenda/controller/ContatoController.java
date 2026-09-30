package br.com.exemplo.agenda.controller;

import br.com.exemplo.agenda.model.Contato;
import br.com.exemplo.agenda.service.ContatoService;
import br.com.exemplo.agenda.view.AgendaView;
import java.sql.SQLException;
import java.util.List;

public class ContatoController {
    private final ContatoService service;
    private final AgendaView view;

    public ContatoController(ContatoService service, AgendaView view) {
        this.service = service;
        this.view = view;
    }

    // O controller coordena o fluxo. A view apenas lê e mostra informações.
    public void iniciar() {
        boolean executando = true;
        while (executando) {
            String opcao = view.lerOpcao();
            try {
                switch (opcao) {
                    case "1": cadastrar(); break;
                    case "2": listar(); break;
                    case "3": buscar(); break;
                    case "4": alterar(); break;
                    case "5": excluir(); break;
                    case "0": executando = false; break;
                    default: view.mostrarMensagem("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                view.mostrarMensagem("Dados inválidos: " + e.getMessage());
            } catch (SQLException e) {
                view.mostrarMensagem("Erro ao acessar o MySQL: " + e.getMessage());
            }
        }
        view.mostrarMensagem("Agenda encerrada.");
    }

    private void cadastrar() throws SQLException {
        String nome = view.lerNome();
        String telefone = view.lerTelefone();
        int idade = view.lerIdade();
        long id = service.cadastrar(nome, telefone, idade);
        view.mostrarMensagem("Contato cadastrado com ID " + id + ".");
    }

    private void listar() throws SQLException {
        List<Contato> contatos = service.listar();
        view.mostrarContatos(contatos);
    }

    private void buscar() throws SQLException {
        long id = view.lerId();
        Contato contato = service.buscar(id);
        if (contato == null) view.mostrarMensagem("Contato não encontrado.");
        else view.mostrarContato(contato);
    }

    private void alterar() throws SQLException {
        long id = view.lerId();
        Contato atual = service.buscar(id);
        if (atual == null) {
            view.mostrarMensagem("Contato não encontrado.");
            return;
        }
        view.mostrarContato(atual);
        String nome = view.lerNovoNome();
        String telefone = view.lerNovoTelefone();
        int idade = view.lerNovaIdade();
        view.mostrarMensagem(service.alterar(id, nome, telefone, idade)
                ? "Contato atualizado." : "Contato não encontrado.");
    }

    private void excluir() throws SQLException {
        long id = view.lerId();
        view.mostrarMensagem(service.excluir(id)
                ? "Contato excluído." : "Contato não encontrado.");
    }
}
