package CONTROLLER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Produto;

public class ProdutoBBD {
	
	
	public boolean cadastrarProduto(Produto produto) {
        // Comando SQL para inserir um novo produto
        String sql = "INSERT INTO Produtos (nome, tipo , preco, quantidadeEstoque) VALUES (?, ?, ?, ?)";
        
        Connection conexao = conexaoBBD.conectar();
        PreparedStatement pstmt = null;

        if (conexao == null) {
            return false;
        }
        
        try {
            pstmt = conexao.prepareStatement(sql);
            
            // 1. Define os valores
            pstmt.setString(1, produto.getNomeProduto());
            pstmt.setString(2, produto.getTipo());
            pstmt.setDouble(3, produto.getValor());
            pstmt.setInt(4, produto.getQuantidade()); 

            // 2. Executa a inserção
            pstmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
            return false; 
            
        } finally {
            conexaoBBD.fecharConexao(conexao);
            // Em produção, fecharia o pstmt também
        }
    }
	
	
	public List<Produto> ListarTodosOsProdutos(){
		String sql = "SELECT nome, preco, tipo, quantidadeEstoque FROM Produtos";
		
		List<Produto> produtos = new ArrayList<>();
        Connection conexao = conexaoBBD.conectar();
        
        if (conexao == null) {
            System.err.println("ERRO DAO: Conexão nula. Verifique o ConexaoDAO.");
            return produtos;
        }
        
        try (PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                // Mapeamento dos dados do banco para o objeto Produto
            	System.out.println("Produto lido: " + rs.getString("nome"));
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco"); // O tipo deve ser double
                int estoque = rs.getInt("quantidadeEstoque");
                String tipo = rs.getString("tipo");

                // 🔑 CRÍTICO: Crie o objeto Produto na ordem correta
                Produto produto = new Produto(nome, preco, tipo, estoque);
                
                produtos.add(produto);
            }
            
        } catch (SQLException e) {
            System.err.println("ERRO SQL ao listar produtos: " + e.getMessage());
        } finally {
            // Certifique-se de fechar a conexão no seu método ConexaoDAO.fecharConexao()
        }

        return produtos;
	}
	
	public boolean removerProduto(String nomeProduto) {
	    // 🔑 O comando SQL DELETE
	    String sql = "DELETE FROM Produtos WHERE nome = ?";
	    
	    // Use sua classe de conexão:
	    Connection conexao = conexaoBBD.conectar(); 
	    
	    if (conexao == null) {
	        System.err.println("ERRO DAO: Falha na conexão para remoção.");
	        return false;
	    }
	    
	    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	        
	        // 1. Define o nome do produto no SQL (onde o '?' está)
	        pstmt.setString(1, nomeProduto);
	        
	        // 2. Executa a deleção
	        int linhasAfetadas = pstmt.executeUpdate();
	        
	        // Se linhasAfetadas > 0, significa que o produto foi encontrado e deletado
	        return linhasAfetadas > 0;
	        
	    } catch (SQLException e) {
	        System.err.println("ERRO SQL ao remover produto: " + e.getMessage());
	        return false;
	    } 
	
	}  
	
	public Produto buscarProdutoPorNome(String nomeProduto) {
	    // 🔑 O comando SQL SELECT com a condição WHERE
	    String sql = "SELECT nome, preco, tipo, quantidadeEstoque FROM Produtos WHERE nome = ?";
	    
	    Connection conexao = conexaoBBD.conectar();
	    
	    if (conexao == null) {
	        System.err.println("ERRO DAO: Falha na conexão para busca.");
	        return null;
	    }
	    
	    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	        
	        // 1. Define o nome do produto no SQL
	        pstmt.setString(1, nomeProduto);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            
	            if (rs.next()) { // Se encontrou o primeiro (e único) resultado
	                // Mapeamento dos dados do banco para o objeto Produto
	                String nome = rs.getString("nome");
	                double preco = rs.getDouble("preco");
	                int estoque = rs.getInt("quantidadeEstoque");
	                String tipo = rs.getString("tipo");

	                // 2. Retorna o objeto Produto
	                return new Produto(nome, preco, tipo, estoque);
	            }
	        }
	        
	    } catch (SQLException e) {
	        System.err.println("ERRO SQL ao buscar produto por nome: " + e.getMessage());
	    } 
	    return null; // Retorna null se não encontrou ou deu erro
	    
	}
	
	public boolean atualizarProduto(Produto produto) {
	    // 🔑 O comando SQL UPDATE
	    String sql = "UPDATE Produtos SET preco = ?, tipo = ?, quantidadeEstoque = ? WHERE nome = ?";
	    
	    Connection conexao = conexaoBBD.conectar(); 
	    if (conexao == null) return false;
	    
	    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	        
	        // Define os novos valores (na ordem dos '?' no SQL)
	        pstmt.setDouble(1, produto.getValor());
	        pstmt.setString(2, produto.getTipo());
	        pstmt.setInt(3, produto.getQuantidade());
	        
	        // Define a condição WHERE (usando o nome como chave)
	        pstmt.setString(4, produto.getNomeProduto()); 
	        
	        int linhasAfetadas = pstmt.executeUpdate();
	        return linhasAfetadas > 0;
	        
	    } catch (SQLException e) {
	        System.err.println("ERRO SQL ao atualizar produto: " + e.getMessage());
	        return false;
	    } 
}
	
	}
