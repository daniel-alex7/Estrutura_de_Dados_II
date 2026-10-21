package br.com.exemplo.avl.dto;

public record SolicitacaoUpdateRequest(
    String solicitante,
    String descricao
) {}
