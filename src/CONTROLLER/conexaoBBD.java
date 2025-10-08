package CONTROLLER;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class conexaoBBD {
	// Configurações do seu banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_banco"; // Mude o nome_do_seu_banco
    private static final String USUARIO = "root"; // Mude para o seu usuário do MySQL
    private static final String SENHA = "Glsarah25!";   // Mude para a sua senha do MySQL

    public static Connection conectar() {
        Connection conexao = null;
        
        try {
            // 1. Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Estabelece a conexão
            conexao = (Connection) DriverManager.getConnection(URL,USUARIO,SENHA);
            return conexao;
        } 
        
        catch (ClassNotFoundException e) {
            // O driver não foi encontrado (verifique o JAR)
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
            return null;
        } 
        
        catch (SQLException e) {
            // Erro de conexão (URL, usuário, senha incorretos ou servidor desligado)
            System.err.println("Erro de Conexão com o Banco de Dados: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
};

