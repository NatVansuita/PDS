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
    
	public List<Produto> listarTodosProdutos() {
        // SQL para selecionar TODOS os campos (incluindo o ID, que é útil)
        String sql = "SELECT id, nome, preco, quantidadeEstoque, tipo_produto FROM Produtos";
        
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = conexaoBBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (conexao == null) {
            return produtos; // Retorna lista vazia se não houver conexão
        }
        
        try {
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            // Itera sobre o resultado e cria um objeto Produto para cada linha
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int estoque = rs.getInt("quantidadeEstoque");
                String tipo = rs.getString("tipo_produto");

                // Cria o objeto Produto (use o construtor que aceita todos os campos)
                Produto produto = new Produto(nome, preco, tipo, estoque);
                // NOTA: Se o seu construtor de Produto precisar do ID, use o construtor com ID
                
                produtos.add(produto);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            // Feche a conexão e o Statement
            conexaoBBD.fecharConexao(conexao);
        }

        return produtos;
    }
}
