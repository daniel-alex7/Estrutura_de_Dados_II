package br.com.exemplo.avl.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.exemplo.avl.dto.SolicitacaoRequest;
import br.com.exemplo.avl.dto.SolicitacaoUpdateRequest;
import br.com.exemplo.avl.model.Solicitacao;
import br.com.exemplo.avl.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
    private final SolicitacaoRepository repository;

    public SolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(SolicitacaoRequest request) {
        Solicitacao solicitacao = request.toEntity();
        if (repository.buscar(solicitacao.getNumero()) != null) {
            throw new RuntimeException("Solicitação com o número " + solicitacao.getNumero() + " já existe.");
        }
        repository.inserir(solicitacao);
    }

    public Solicitacao buscar(int numero) {
        return repository.buscar(numero);
    }

    public boolean atualizar(int numero, SolicitacaoUpdateRequest request) {
        if (request.solicitante() == null || request.solicitante().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do solicitante não pode ser vazio.");
        }
        if (request.descricao() == null || request.descricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }

        return repository.atualizar(numero, request.solicitante(), request.descricao());
    }

    public boolean remover(int numero) {
        return repository.remover(numero);
    }

    public List<Solicitacao> listar() {
        return repository.listar();
    }

    public String exibirArvore() {
        return repository.exibirArvore();
    }
}
