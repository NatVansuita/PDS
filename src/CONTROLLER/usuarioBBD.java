package CONTROLLER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Usuario;

public class usuarioBBD {
	 
	
	public boolean cadastrarUsuario(Usuario usuario) {
	        
	        // Comando SQL para inserir um novo usuário
	        // isAdministrador é TINYINT(1) no banco (1 para true, 0 para false)
	        String sql = "INSERT INTO Usuarios (textFieldNome, formattedTextFieldCPF, grupoTipoUsuario) VALUES (?, ?, ?)";
	        
	        Connection conexao = conexaoBBD.conectar();
	        PreparedStatement pstmt = null;

	        if (conexao == null) {
	            return false; // Não conseguiu conectar
	        };
	        
	        try {
	            pstmt = conexao.prepareStatement(sql);
	            
	            // Define os valores nos placeholders (?)
	            pstmt.setString(1, usuario.getNome());
	            pstmt.setString(2, usuario.getCPF());
	            
	            // O setBoolean converte o true/false Java para 1/0 do MySQL
	            pstmt.setBoolean(3, usuario.getTipocliente()); 

	            // Executa a inserção
	            pstmt.executeUpdate();
	            
	            return true; // Sucesso
	            
	        } catch (SQLException e) {
	            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
	            // Tratar erros de chave duplicada (CPF) ou outros
	            return false; 
	            
	        } finally {
	            // Sempre fechar a conexão no bloco finally
	            conexaoBBD.fecharConexao(conexao);
	            // Em projetos mais robustos, você também fecharia o pstmt
	        }
	    };
	    
	   
	    public Usuario buscarUsuario(String nome, String cpf) {
	        // Comando SQL para buscar um usuário que corresponda ao nome E ao cpf
	        String sql = "SELECT textFieldNome, formattedTextFieldCPF, grupoTipoUsuario FROM Usuarios WHERE textFieldNome = ? AND formattedTextFieldCPF = ?";
	        
	        Connection conexao = conexaoBBD.conectar();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Usuario usuarioEncontrado = null;

	        if (conexao == null) {
	            return null; // Falha na conexão
	        }
	        
	        try {
	            pstmt = conexao.prepareStatement(sql);
	            
	            // 1. Define os parâmetros para a busca
	            pstmt.setString(1, nome);
	            pstmt.setString(2, cpf);

	            // 2. Executa a consulta
	            rs = pstmt.executeQuery();
	            
	            // 3. Verifica se encontrou algum registro (o cursor avança)
	            if (rs.next()) {
	                // Pega os dados do banco para criar o objeto Usuario
	                String nomeBBD = rs.getString("textFieldNome");
	                String cpfBBD = rs.getString("formattedTextFieldCPF");
	                // O JDBC converte o TINYINT(1) do banco para boolean do Java
	                boolean grupoTipoUsuarioBBD = rs.getBoolean("grupoTipoUsuario"); 

	                // Cria e preenche o objeto Usuario
	                usuarioEncontrado = new Usuario(nomeBBD, cpfBBD, grupoTipoUsuarioBBD);
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Erro ao buscar usuário: " + e.getMessage());
	        } finally {
	            // Fechar o ResultSet e o PreparedStatement é boa prática
	            // Fechar a conexão é obrigatório
	            conexaoBBD.fecharConexao(conexao); 
	            // Você também deve fechar o pstmt e o rs aqui, se for a sua convenção.
	        }

	        return usuarioEncontrado;
	    }
	}
