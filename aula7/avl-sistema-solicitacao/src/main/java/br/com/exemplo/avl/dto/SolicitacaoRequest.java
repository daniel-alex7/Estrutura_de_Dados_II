package br.com.exemplo.avl.dto;

import br.com.exemplo.avl.model.Solicitacao;

public record SolicitacaoRequest(
    int numero,
    String solicitante,
    String descricao
) {
    public Solicitacao toEntity() {
        return new Solicitacao(numero, solicitante, descricao);
    }
}