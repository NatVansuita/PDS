package CONTROLLER;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        
        // 1. Validação de Entrada e Conversão
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

            // 2. Cria o objeto Model
            Produto novoProduto = new Produto(nome, precoo, tipo, estoquee);
            
            // 3. Chama a camada DAO para salvar
            if (produto.cadastrarProduto(novoProduto)) {
                return "Produto '" + nome + "' cadastrado com sucesso!";
            } else {
                return "Erro interno ao salvar produto no banco de dados.";
            }
            
        } catch (NumberFormatException e) {
            return "Erro: Preço e Quantidade devem ser números válidos.";
        }
        
       
    }
    
    public List<Produto> getProdutosParaTabela() {
        return produto.listarTodosProdutos();
    }
    
}
