package service;

import pagamento.Pagamento;

public class PagamentoService {

    private Pagamento pagamento;

    public PagamentoService(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento(double valor) {
        pagamento.pagar(valor);
    }
}
