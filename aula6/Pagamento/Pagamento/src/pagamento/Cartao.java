package pagamento;

public class Cartao implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via CARTÃO: R$ " + valor);
    }
}