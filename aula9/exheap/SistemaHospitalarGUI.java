import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SistemaHospitalarGUI extends JFrame {
    private MinHeap<Paciente> fila;
    private JTable tabelaPacientes;
    private DefaultTableModel modeloTabela;
    private JTextArea txtLog;
    private JTextField txtNome, txtId;
    private JComboBox<Integer> cbPrioridade;
    
    
    private List<Paciente> listaTeste;

    public SistemaHospitalarGUI() {
        fila = new MinHeap<>(50);
        listaTeste = new ArrayList<>();
        
        setTitle("Sistema de Triagem Hospitalar - Min-Heap Modularizado");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        
        JPanel painelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel painelCadastro = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        painelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastrar Paciente Individual"));

        painelCadastro.add(new JLabel("Nome:"));
        txtNome = new JTextField(8);
        painelCadastro.add(txtNome);

        painelCadastro.add(new JLabel("ID:"));
        txtId = new JTextField(4);
        painelCadastro.add(txtId);

        painelCadastro.add(new JLabel("Prioridade:"));
        cbPrioridade = new JComboBox<>(new Integer[]{1, 2, 3});
        painelCadastro.add(cbPrioridade);

        JButton btnInserir = new JButton("Inserir na Fila");
        painelCadastro.add(btnInserir);

        JButton btnAtender = new JButton("Atender Próximo");
        painelCadastro.add(btnAtender);
        
        painelSuperior.add(painelCadastro);

        
        JPanel painelTestes = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        painelTestes.setBorder(BorderFactory.createTitledBorder("Gerenciamento de Testes"));

        JButton btnAcrescentarTeste = new JButton("Adicionar à Lista de Teste");
        JButton btnRodarTeste = new JButton("Rodar Teste Automático");
        JButton btnLimparTeste = new JButton("Limpar Lista de Teste");
        
        painelTestes.add(btnAcrescentarTeste);
        painelTestes.add(btnRodarTeste);
        painelTestes.add(btnLimparTeste);

        painelSuperior.add(painelTestes);
        add(painelSuperior, BorderLayout.NORTH);

        
        modeloTabela = new DefaultTableModel(new Object[]{"Posição", "Nome", "ID", "Prioridade", "Ordem Chegada"}, 0);
        tabelaPacientes = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaPacientes);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Estado Atual da Fila (Heap Mínima)"));

        txtLog = new JTextArea(8, 20);
        txtLog.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(txtLog);
        scrollLog.setBorder(BorderFactory.createTitledBorder("Log de Atendimento"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollTabela, scrollLog);
        splitPane.setDividerLocation(220);
        add(splitPane, BorderLayout.CENTER);

        btnInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText().trim();
                    if (nome.isEmpty()) {
                        JOptionPane.showMessageDialog(SistemaHospitalarGUI.this, "Informe o nome.");
                        return;
                    }
                    int id = Integer.parseInt(txtId.getText().trim());
                    int prioridade = (Integer) cbPrioridade.getSelectedItem();

                    Paciente p = new Paciente(nome, id, prioridade);
                    fila.inserir(p);
                    adicionarLog("Inserido manualmente: " + p);
                    atualizarTabela();

                    txtNome.setText("");
                    txtId.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SistemaHospitalarGUI.this, "ID numérico inválido.");
                }
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fila.tamanho > 0) {
                    Paciente p = fila.removerMin();
                    adicionarLog("ATENDIDO: " + p);
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(SistemaHospitalarGUI.this, "A fila está vazia!");
                }
            }
        });

        btnAcrescentarTeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText().trim();
                    if (nome.isEmpty()) {
                        JOptionPane.showMessageDialog(SistemaHospitalarGUI.this, "Informe o nome para adicionar à lista de teste.");
                        return;
                    }
                    int id = Integer.parseInt(txtId.getText().trim());
                    int prioridade = (Integer) cbPrioridade.getSelectedItem();

                    Paciente p = new Paciente(nome, id, prioridade);
                    listaTeste.add(p);
                    adicionarLog("Adicionado à lista de teste: " + p);

                    txtNome.setText("");
                    txtId.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SistemaHospitalarGUI.this, "ID numérico inválido.");
                }
            }
        });

        btnLimparTeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTeste.clear();
                adicionarLog("Lista de teste limpa.");
            }
        });

        btnRodarTeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Paciente> pacientesParaRodar = new ArrayList<>(listaTeste);
                if (pacientesParaRodar.isEmpty()) {
                    pacientesParaRodar.add(new Paciente("Carlos", 103, 1));
                    pacientesParaRodar.add(new Paciente("Ana", 101, 2));
                    pacientesParaRodar.add(new Paciente("Bruno", 102, 3));
                    pacientesParaRodar.add(new Paciente("Daniela", 104, 2));
                    pacientesParaRodar.add(new Paciente("Eduardo", 105, 3));
                    pacientesParaRodar.add(new Paciente("Fernanda", 106, 1));
                    pacientesParaRodar.add(new Paciente("Gabriel", 107, 2));
                    pacientesParaRodar.add(new Paciente("Helena", 108, 3));
                    pacientesParaRodar.add(new Paciente("Igor", 109, 1));
                    pacientesParaRodar.add(new Paciente("Julia", 110, 2));
                }
                executarTesteAutomatico(pacientesParaRodar);
            }
        });
    }

    private void atualizarTabela() {
        modeloTabela.setRowCount(0);
        for (int i = 0; i < fila.tamanho; i++) {
            Paciente p = fila.obter(i);
            if (p != null) {
                modeloTabela.addRow(new Object[]{i, p.getNome(), p.getId(), p.getPrioridade(), p.getOrdemChegada()});
            }
        }
    }

    private void adicionarLog(String texto) {
        txtLog.append(texto + "\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());
    }

    private void executarTesteAutomatico(List<Paciente> pacientes) {
        fila = new MinHeap<>(50);
        modeloTabela.setRowCount(0);
        txtLog.setText("");

        adicionarLog("=== INICIANDO TESTE DO HOSPITAL ===");

        new Thread(() -> {
            try {
                adicionarLog("\n--- INSERINDO PACIENTES ---");
                for (Paciente p : pacientes) {
                    SwingUtilities.invokeLater(() -> {
                        fila.inserir(p);
                        adicionarLog("Inserido: " + p);
                        atualizarTabela();
                    });
                    Thread.sleep(400);
                }

                adicionarLog("\n--- REMOVENDO / ATENDENDO PACIENTES ---");
                while (fila.tamanho > 0) {
                    SwingUtilities.invokeLater(() -> {
                        Paciente p = fila.removerMin();
                        adicionarLog("Removido/Atendido: " + p);
                        atualizarTabela();
                    });
                    Thread.sleep(600);
                }

                SwingUtilities.invokeLater(() -> {
                    adicionarLog("\n✅ Todos os pacientes foram atendidos!");
                    JOptionPane.showMessageDialog(this, "Teste automático finalizado com sucesso!");
                });
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SistemaHospitalarGUI().setVisible(true);
        });
    }
}