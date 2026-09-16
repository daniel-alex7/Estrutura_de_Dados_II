package app;

import java.util.Scanner;

import controller.PagamentoController;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - PIX");
        System.out.println("2 - Cartão");
        System.out.println("3 - Dinheiro");
        System.out.print("Escolha: ");

        int opcao = sc.nextInt();

        System.out.print("Valor: R$ ");
        double valor = sc.nextDouble();

        PagamentoController controller =
                new PagamentoController();

        controller.pagar(opcao, valor);

        sc.close();
    }
}