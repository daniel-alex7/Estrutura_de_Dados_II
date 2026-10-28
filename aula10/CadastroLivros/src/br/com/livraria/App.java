package br.com.livraria;

import br.com.livraria.config.Conexao;
import br.com.livraria.controller.LivroController;
import br.com.livraria.repository.LivroMySqlRepository;
import br.com.livraria.repository.LivroRepository;
import br.com.livraria.service.LivroService;
import br.com.livraria.view.LivroView;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            LivroRepository repository = new LivroMySqlRepository(new Conexao());
            LivroService service = new LivroService(repository);
            LivroView view = new LivroView(scanner);
            LivroController controller = new LivroController(service, view);
            controller.iniciar();
        }
    }
}
