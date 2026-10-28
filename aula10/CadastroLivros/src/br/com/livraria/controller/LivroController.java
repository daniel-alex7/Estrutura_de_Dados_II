package br.com.livraria.controller;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import br.com.livraria.service.LivroService;
import br.com.livraria.view.LivroView;

public class LivroController {
    private final LivroService service;
    private final LivroView view;
    public LivroController(LivroService service, LivroView view) {
        this.service = service;
        this.view = view;
    }
    public void iniciar() {
        boolean executando = true;
        while (executando) {
            try {
                view.menu();
                int opcao = view.lerInteiro("Opção: ");
                switch (opcao) {
                    case 1: cadastrar(); break;
                    case 2: view.listar(service.listar()); break;
                    case 3: view.mostrar(service.buscar(view.lerInteiro("Código: "))); break;
                    case 4: alterar(); break;
                    case 5: excluir(); break;
                    case 0: executando = false; break;
                    default: view.mostrar("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                view.mostrar(e.getMessage());
            } catch (SQLException e) {
                view.mostrar("Erro ao acessar o MySQL. Confira o banco, as credenciais e o driver.");
                view.mostrar("Detalhe: " + e.getMessage());
            } catch (NoSuchElementException e) {
                executando = false; // Terminal fechado ou fim da entrada.
            }
        }
        view.mostrar("Programa encerrado.");
    }
    private void cadastrar() throws SQLException {
        String nome = view.lerTexto("Nome do livro: ");
        String autor = view.lerTexto("Autor: ");
        int ano = view.lerInteiro("Ano de lançamento: ");
        int edicao = view.lerInteiro("Edição: ");
        String editora = view.lerTexto("Editora: ");
        int numeroUnidades = view.lerInteiro("Número de unidades: ");
        service.cadastrar(nome, autor, ano, edicao, editora, numeroUnidades);
        view.mostrar("Livro cadastrado com sucesso.");
    }
    private void alterar() throws SQLException {
        int id = view.lerInteiro("Código do livro: ");
        view.mostrar(service.buscar(id));
        String nome = view.lerTexto("Novo nome: ");
        String autor = view.lerTexto("Novo autor: ");
        int ano = view.lerInteiro("Novo ano de lançamento: ");
        int edicao = view.lerInteiro("Nova edição: ");
        String editora = view.lerTexto("Nova editora: ");
        int numeroUnidades = view.lerInteiro("Novo número de unidades: ");
        service.atualizar(id, nome, autor, ano, edicao, editora, numeroUnidades);
        view.mostrar("Livro atualizado com sucesso.");
    }
    private void excluir() throws SQLException {
        int id = view.lerInteiro("Código do livro: ");
        view.mostrar(service.buscar(id));
        if (view.lerTexto("Confirma exclusão? (S/N): ").trim().equalsIgnoreCase("S")) {
            service.excluir(id);
            view.mostrar("Livro excluído com sucesso.");
        } else view.mostrar("Exclusão cancelada.");
    }
}
