package CONTROLLER;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class conexaoBBD {
	
	private static final String URL = "jdbc:mysql://localhost:3306/cadastro_banco"; 
	private static final String USUARIO = "root"; 
	private static final String SENHA = "Glsarah25!"; 

	public static Connection conectar() {
		Connection conexao = null;

		try {
			// Estou carregando o driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Estabeleço a conexão com o banco
			conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
			return conexao;
		}

		catch (ClassNotFoundException e) {
			System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
			return null;
		}

		catch (SQLException e) {
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