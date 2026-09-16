package controller;

import factory.PagamentoFactory;
import pagamento.Pagamento;
import service.PagamentoService;

public class PagamentoController {

    public void pagar(int opcao, double valor) {

        Pagamento pagamento = PagamentoFactory.criar(opcao);

        PagamentoService service =
                new PagamentoService(pagamento);

        service.realizarPagamento(valor);
    }
}

