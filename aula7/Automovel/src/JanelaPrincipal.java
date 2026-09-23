//Prof. Ledón.

public class JanelaPrincipal extends javax.swing.JFrame {

    private AVL avl = new AVL();

    public JanelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAtravessa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALV de automóveis");
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Preço:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 230, 120, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("ALV de automóveis");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 10, 370, 60);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 130, 120, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Ano de Fab.:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 180, 120, 30);

        txtPlaca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtPlaca);
        txtPlaca.setBounds(300, 80, 190, 40);

        txtMarca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(300, 130, 190, 40);

        txtAno.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtAno.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtAno);
        txtAno.setBounds(300, 180, 150, 40);

        txtPreco.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtPreco.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtPreco);
        txtPreco.setBounds(300, 230, 150, 40);

        btnSair.setBackground(new java.awt.Color(240, 240, 240));
        btnSair.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 51));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(650, 300, 90, 30);

        btnPesquisar.setBackground(new java.awt.Color(240, 240, 240));
        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(0, 0, 51));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(500, 300, 140, 30);

        btnRemover.setBackground(new java.awt.Color(240, 240, 240));
        btnRemover.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(0, 0, 51));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemover);
        btnRemover.setBounds(360, 300, 130, 30);

        btnAtravessa.setBackground(new java.awt.Color(240, 240, 240));
        btnAtravessa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnAtravessa.setForeground(new java.awt.Color(0, 0, 51));
        btnAtravessa.setText("Atravessamentos");
        btnAtravessa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtravessaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtravessa);
        btnAtravessa.setBounds(150, 300, 200, 30);

        txtArea.setBackground(new java.awt.Color(237, 235, 255));
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtArea.setForeground(new java.awt.Color(0, 0, 51));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 350, 720, 160);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Placa: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(160, 80, 120, 30);

        btnInserir.setBackground(new java.awt.Color(240, 240, 240));
        btnInserir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnInserir.setForeground(new java.awt.Color(0, 0, 51));
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(20, 300, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 770, 530);

        setSize(new java.awt.Dimension(829, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Automovel au = new Automovel(txtPlaca.getText(), "", 0, 0.0f);
        //Sugestão: utilize avl.searchAVL(au) e mostrar uma mensagem adequada se 
        //encontrou ou não encontrou.
        //...
        //...
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAtravessaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtravessaActionPerformed
        txtArea.setText("");
        txtArea.setText("Pré-ordem:\n"
                + "..." + "\nEm-ordem: ...");
        //Limpar os campos:
        txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");
    }//GEN-LAST:event_btnAtravessaActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            String placa = txtPlaca.getText().toUpperCase();
            String marca = txtMarca.getText();
            int ano = Integer.parseInt(txtAno.getText());
            //...
            //... inserir na árvore AVL
            //...
        } catch (Exception erro) {
            txtArea.setText("Erro nos dados digitados!\n");
        }
        //Limpar os campos:
        txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");

    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Automovel au = new Automovel();
        au.setPlaca(txtPlaca.getText());
        //Sugestão: utilize avl.removeAVL(au)) e mostrar uma mensagem adequada se conseguiu eliminar ou não.
        //Limpar campos:
        //...
    }//GEN-LAST:event_btnRemoverActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtravessa;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
