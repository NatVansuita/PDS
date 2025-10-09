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

			pstmt.setString(1, produto.getNomeProduto());
			pstmt.setString(2, produto.getTipo());
			pstmt.setDouble(3, produto.getValor());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar produto: " + e.getMessage());
			return false;

		} finally {
			conexaoBBD.fecharConexao(conexao);
		}
	}

	public List<Produto> ListarTodosOsProdutos() {
		String sql = "SELECT nome, preco, tipo, quantidadeEstoque FROM Produtos";

		List<Produto> produtos = new ArrayList<>();
		Connection conexao = conexaoBBD.conectar();

		if (conexao == null) {
			System.err.println("ERRO DAO: Conexão nula. Verifique o ConexaoDAO.");
			return produtos;
		}

		try (PreparedStatement pstmt = conexao.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				// Mapeamento dos dados do banco para o objeto Produto
				System.out.println("Produto lido: " + rs.getString("nome"));
				String nome = rs.getString("nome");
				double preco = rs.getDouble("preco");
				int estoque = rs.getInt("quantidadeEstoque");
				String tipo = rs.getString("tipo");

				Produto produto = new Produto(nome, preco, tipo, estoque);

				produtos.add(produto);
			}

		} catch (SQLException e) {
			System.err.println("ERRO SQL ao listar produtos: " + e.getMessage());
		} finally {
		}

		return produtos;
	}

	public boolean removerProduto(String nomeProduto) {
		String sql = "DELETE FROM Produtos WHERE nome = ?";

		Connection conexao = conexaoBBD.conectar();

		if (conexao == null) {
			System.err.println("ERRO DAO: Falha na conexão para remoção.");
			return false;
		}

		try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {

			pstmt.setString(1, nomeProduto);

			int linhasAfetadas = pstmt.executeUpdate();

			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("ERRO SQL ao remover produto: " + e.getMessage());
			return false;
		}

	}

	public Produto buscarProdutoPorNome(String nomeProduto) {
		String sql = "SELECT nome, preco, tipo, quantidadeEstoque FROM Produtos WHERE nome = ?";

		Connection conexao = conexaoBBD.conectar();

		if (conexao == null) {
			System.err.println("ERRO DAO: Falha na conexão para busca.");
			return null;
		}

		try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {

			pstmt.setString(1, nomeProduto);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					String nome = rs.getString("nome");
					double preco = rs.getDouble("preco");
					int estoque = rs.getInt("quantidadeEstoque");
					String tipo = rs.getString("tipo");

					return new Produto(nome, preco, tipo, estoque);
				}
			}

		} catch (SQLException e) {
			System.err.println("ERRO SQL ao buscar produto por nome: " + e.getMessage());
		}
		return null;
	}

	public boolean atualizarProduto(Produto produto) {
		String sql = "UPDATE Produtos SET preco = ?, tipo = ?, quantidadeEstoque = ? WHERE nome = ?";

		Connection conexao = conexaoBBD.conectar();
		if (conexao == null)
			return false;

		try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {

			pstmt.setDouble(1, produto.getValor());
			pstmt.setString(2, produto.getTipo());
			pstmt.setInt(3, produto.getQuantidade());

			pstmt.setString(4, produto.getNomeProduto());

			int linhasAfetadas = pstmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.err.println("ERRO SQL ao atualizar produto: " + e.getMessage());
			return false;
		}
	}

}