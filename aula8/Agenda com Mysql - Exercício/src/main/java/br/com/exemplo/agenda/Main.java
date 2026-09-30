package br.com.exemplo.agenda;

import br.com.exemplo.agenda.config.Conexao;
import br.com.exemplo.agenda.controller.ContatoController;
import br.com.exemplo.agenda.repository.ContatoRepository;
import br.com.exemplo.agenda.service.ContatoService;
import br.com.exemplo.agenda.view.AgendaView;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        ContatoRepository repository = new ContatoRepository(conexao);
        ContatoService service = new ContatoService(repository);
        AgendaView view = new AgendaView();
        ContatoController controller = new ContatoController(service, view);
        controller.iniciar();
    }
}
