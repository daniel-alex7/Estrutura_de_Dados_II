package pagamento;

public class Pix implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via PIX: R$ " + valor);
    }
}
