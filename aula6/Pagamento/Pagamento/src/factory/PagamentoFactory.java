package factory;

import pagamento.Cartao;
import pagamento.Dinheiro;
import pagamento.Pagamento;
import pagamento.Pix;

public class PagamentoFactory {

    public static Pagamento criar(int opcao) {

        if (opcao == 1) {
            return new Pix();
        }

        if (opcao == 2) {
            return new Cartao();
        }

        if (opcao == 3) {
            return new Dinheiro();
        }

        throw new IllegalArgumentException("Forma de pagamento inválida");


    }
}

