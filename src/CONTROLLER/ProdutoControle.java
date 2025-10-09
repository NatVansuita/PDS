package CONTROLLER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Produto;


public class ProdutoControle {
	
	private ProdutoBBD produto = new ProdutoBBD();

    public String cadastrarNovoProduto(String nome, String tipo, String preco, String estoque) {
        
        if (nome.trim().isEmpty() || tipo.trim().isEmpty() || preco.trim().isEmpty() || estoque.trim().isEmpty()) {
            return "Erro: Todos os campos são obrigatórios.";
        }

        try {
        	
        	System.out.println("DEBUG - Preço antes da conversão: [" + preco + "]");
            System.out.println("DEBUG - Estoque antes da conversão: [" + estoque + "]");
        	
            String precoLimpo = preco.replaceAll("[^0-9,.]", "").replace(",", ".");
            double precoo = Double.parseDouble(precoLimpo);
            
            
            String estoqueLimpo = estoque.replaceAll("[^0-9]", "").trim();
            int estoquee = Integer.parseInt(estoqueLimpo);

            if (precoo <= 0 || estoquee < 0) {
                return "Erro: Preço deve ser positivo e Estoque não pode ser negativo.";
            }

            Produto novoProduto = new Produto(nome, precoo, tipo, estoquee);
            
            if (produto.cadastrarProduto(novoProduto)) {
                return "Produto '" + nome + "' cadastrado com sucesso!";
            } 
            else {
                return "Erro interno ao salvar produto no banco de dados.";
            }
            
        } 
        
        catch (NumberFormatException e) {
            return "Erro: Preço e Quantidade devem ser números válidos.";
        }
    } 
        
    

    public List<Produto> listarProdutosParaView() {
        return produto.ListarTodosOsProdutos(); 
    }
    
    public String removerProdutoPorNome(String nomeProduto) {
        
       
        if (produto.removerProduto(nomeProduto)) { 
            return "Produto '" + nomeProduto + "' removido com sucesso!";
        } 
        
        else {
            return "Erro: Falha ao tentar remover o produto, ou produto não encontrado.";
        }
    }
    
    public Produto buscarProduto(String nomeProduto) {
        return produto.buscarProdutoPorNome(nomeProduto);
    }
    
    
    public String atualizarProduto(String nome, String precoStr, String tipo, String estoqueStr) {
        if (precoStr.trim().isEmpty() || estoqueStr.trim().isEmpty()) {
            return "Erro: Preço e Estoque não podem ser vazios.";
        }

        try {
            double preco = Double.parseDouble(precoStr.replace(",", "."));
            int estoque = Integer.parseInt(estoqueStr);

            if (preco <= 0 || estoque < 0) {
                return "Erro: Preço deve ser positivo e Estoque não pode ser negativo.";
            }
            
            Produto produtoAtualizado = new Produto(nome, preco, tipo, estoque);
            
            if (produto.atualizarProduto(produtoAtualizado)) {
                return "Produto '" + nome + "' atualizado com sucesso!";
            } else {
                return "Erro: Falha ao atualizar no banco de dados.";
            }
            
        } catch (NumberFormatException e) {
            return "Erro: Verifique se Preço e Estoque são números válidos.";
        }
        
    }


	public void diminuirEstoque(String nome, int quantidade) {
		// TODO Auto-generated method stub
		
	}
    
    
}