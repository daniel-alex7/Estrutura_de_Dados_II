package br.com.exemplo.agenda.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/agenda_db?useUnicode=true&characterEncoding=UTF-8";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void main(String[] args) {
        try {
            Conexao conexaoObj = new Conexao();
            Connection conexao = conexaoObj.abrir();
            
            if (conexao != null) {
                System.out.println("Conexão realizada com sucesso!");
                conexao.close(); // Boa prática: fechar após o teste
            } else {
                System.out.println("Falha ao conectar.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}