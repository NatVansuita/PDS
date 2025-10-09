package CONTROLLER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Usuario;

public class usuarioBBD {
	 
	
	public boolean cadastrarUsuario(Usuario usuario) {
	        
	        String sql = "INSERT INTO Usuarios (textFieldNome, formattedTextFieldCPF, grupoTipoUsuario) VALUES (?, ?, ?)";
	        
	        Connection conexao = conexaoBBD.conectar();
	        PreparedStatement pstmt = null;

	        if (conexao == null) {
	            return false; 
	        };
	        
	        try {
	            pstmt = conexao.prepareStatement(sql);
	            
	            pstmt.setString(1, usuario.getNome());
	            pstmt.setString(2, usuario.getCPF());
	            
	            pstmt.setBoolean(3, usuario.getTipocliente()); 

	            pstmt.executeUpdate();
	            
	            return true;
	            
	        } catch (SQLException e) {
	            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
	            return false; 
	            
	        } finally {
	            conexaoBBD.fecharConexao(conexao);
	        }
	    };
	    
	   
	    public Usuario buscarUsuario(String nome, String cpf) {
	        String sql = "SELECT textFieldNome, formattedTextFieldCPF, grupoTipoUsuario FROM Usuarios WHERE textFieldNome = ? AND formattedTextFieldCPF = ?";
	        
	        Connection conexao = conexaoBBD.conectar();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Usuario usuarioEncontrado = null;

	        if (conexao == null) {
	            return null; 
	        }
	        
	        try {
	            pstmt = conexao.prepareStatement(sql);
	            
	            pstmt.setString(1, nome);
	            pstmt.setString(2, cpf);

	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                String nomeBBD = rs.getString("textFieldNome");
	                String cpfBBD = rs.getString("formattedTextFieldCPF");
	                boolean grupoTipoUsuarioBBD = rs.getBoolean("grupoTipoUsuario"); 

	                usuarioEncontrado = new Usuario(nomeBBD, cpfBBD, grupoTipoUsuarioBBD);
	            }
	            
	        } catch (SQLException e) {
	            System.err.println("Erro ao buscar usuário: " + e.getMessage());
	        } finally {
	            conexaoBBD.fecharConexao(conexao); 
	        }

	        return usuarioEncontrado;
	    }
	}
