package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import CONTROLLER.ProdutoBBD;
import CONTROLLER.ProdutoControle; // Importar o Controller
import MODEL.Produto; // Importar a classe Produto
import java.util.List; // Para usar listas
import javax.swing.table.DefaultTableModel; 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.UIManager;


public class Supermercado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableListaProdutos;
	private JTable TableCarrinho; 
	private JTextField textFieldNomeCliente;
    private JTextField textFieldCpfCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado frame = new Supermercado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supermercado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\mercadinhop.png"));
		setTitle("Supermercado");
		setFont(new Font("SansSerif", Font.BOLD, 13));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 704);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 938, 650);
		contentPane.add(panel);
		
		JLabel lblMercadinho = new JLabel("MERCADINHO");
		lblMercadinho.setBackground(new Color(245, 245, 245));
		lblMercadinho.setBounds(94, 11, 750, 54);
		panel.add(lblMercadinho);
		lblMercadinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercadinho.setForeground(new Color(23, 0, 0));
		lblMercadinho.setFont(new Font("SansSerif", Font.BOLD, 50));
		
		JButton btnCarrinho = new JButton("");
		btnCarrinho.setBackground(new Color(255, 255, 255));
		btnCarrinho.setToolTipText("Carrinho de Compras");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Downloads\\mercadinhop.png");
		Image img = icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		btnCarrinho.setIcon(scaledIcon);

		btnCarrinho.setBounds(854, 11, 74, 34);
		panel.add(btnCarrinho);
		
		JButton btnSair = new JButton();
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setToolTipText("Sair do sistema");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon icon2 = new ImageIcon("C:\\\\Users\\\\DELL\\\\Downloads\\\\vecteezy_log-out-vector-icon-in-black-color_6141417.jpg");
		Image img2 = icon2.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);
		btnSair.setIcon(scaledIcon2);
		
		btnSair.setBounds(10, 11, 74, 34);
		panel.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(10, 84, 737, 272);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		tableListaProdutos = new JTable();
		tableListaProdutos.setForeground(new Color(24, 0, 0));
		tableListaProdutos.setFont(new Font("SansSerif", Font.BOLD, 15));
		tableListaProdutos.setModel(new DefaultTableModel(	
		    new Object[][] {
		    },
		    new String[] {
		    		"NOME", "TIPO", "VALOR", "QUANT. DE UNI. DISPONÍVEIS"
		    }
		) {
		    boolean[] columnEditables = new boolean[] {
		    		true, true, true, true
		    };
		    public boolean isCellEditable(int row, int column) {
		        return columnEditables[column];
		    }
		});
		
		
		
				// 🔑 Coloca a tabela dentro de um JScrollPane
				JScrollPane scrollPane = new JScrollPane(tableListaProdutos);
				scrollPane.setBounds(10, 52, 717, 209);
				panel_1.add(scrollPane);
				
				tableListaProdutos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
				tableListaProdutos.getTableHeader().setBackground(new Color(23, 0, 0)); // Cor de fundo do cabeçalho
				tableListaProdutos.getTableHeader().setForeground(Color.WHITE); // Cor do texto do cabeçalho

				// Define a altura padrão das linhas (para dar um respiro)
				tableListaProdutos.setRowHeight(25);
				
				JLabel tituloTabela = new JLabel("LISTA DE PRODUTOS", SwingConstants.CENTER);
				tituloTabela.setBackground(new Color(240, 240, 240));
				tituloTabela.setBounds(10, 11, 717, 30);
				tituloTabela.setForeground(new Color(24, 0, 0));
				panel_1.add(tituloTabela);
				tituloTabela.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(UIManager.getColor("Button.background"));
				panel_1_1.setBounds(11, 368, 737, 272);
				panel.add(panel_1_1);
				
				TableCarrinho = new JTable();
				TableCarrinho.setForeground(new Color(24, 0, 0));
				TableCarrinho.setFont(new Font("SansSerif", Font.BOLD, 15));
				TableCarrinho.setModel(new DefaultTableModel(
				    new Object[][] {
				    },
				    new String[] {
				    		"NOME", "TIPO", "VALOR", "UNIDADES"
				    }
				) {
				    boolean[] columnEditables = new boolean[] {
				    		true, true, true, true
				    };
				    public boolean isCellEditable(int row, int column) {
				        return columnEditables[column];
				    }
				});
				
				TableCarrinho.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
				TableCarrinho.getTableHeader().setBackground(new Color(23, 0, 0)); // Cor de fundo do cabeçalho
				TableCarrinho.getTableHeader().setForeground(Color.WHITE); // Cor do texto do cabeçalho

				// Define a altura padrão das linhas (para dar um respiro)
				TableCarrinho.setRowHeight(25);
				
				JScrollPane scrollPane_1 = new JScrollPane(TableCarrinho);
				scrollPane_1.setBounds(10, 52, 717, 209);
				panel_1_1.add(scrollPane_1);
				
				JLabel tituloTabela_1 = new JLabel("Carrinho de Compras", SwingConstants.CENTER);
				tituloTabela_1.setForeground(new Color(24, 0, 0));
				tituloTabela_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
				tituloTabela_1.setBackground(UIManager.getColor("Button.background"));
				tituloTabela_1.setBounds(10, 11, 717, 30);
				panel_1_1.add(tituloTabela_1);
				
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(757, 84, 171, 556);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				
				
				JButton btnAdcionar = new JButton("Adicionar itens");
				btnAdcionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// 1. Capturar a linha selecionada na tabela de produtos
				        int linhaSelecionada = tableListaProdutos.getSelectedRow();
				        
				        if (linhaSelecionada == -1) {
				            JOptionPane.showMessageDialog(Supermercado.this, "Selecione um produto da lista para adicionar ao carrinho.", "Erro de Seleção", JOptionPane.WARNING_MESSAGE);
				            return;
				        }

				        // Obtém o modelo da tabela de produtos
				        DefaultTableModel modeloProdutos = (DefaultTableModel) tableListaProdutos.getModel();
				        
				        // 2. Extrair dados do produto selecionado
				        String nomeProduto = (String) modeloProdutos.getValueAt(linhaSelecionada, 0);
				        String tipoProduto = (String) modeloProdutos.getValueAt(linhaSelecionada, 1);
				        String valorStr = (String) modeloProdutos.getValueAt(linhaSelecionada, 2); // Ex: "R$ 5.00"
				        String estoqueAtualStr = modeloProdutos.getValueAt(linhaSelecionada, 3).toString();
				        
				        int estoqueAtual;
				        
				        try {
				            // Tenta converter o valor do estoque da tabela para um número inteiro.
				            estoqueAtual = Integer.parseInt(estoqueAtualStr.trim());
				        } catch (NumberFormatException ex) {
				            // Se não for um número válido (ex: "Nenhum produto cadastrado"), assume 0.
				            estoqueAtual = 0; 
				            System.err.println("Erro ao converter estoque para inteiro: " + estoqueAtualStr);
				        } 
				        
				        // Se a linha for o placeholder de "Nenhum produto cadastrado"
				        if (nomeProduto.startsWith("Nenhum produto")) {
				            JOptionPane.showMessageDialog(Supermercado.this, "Não há produtos válidos para adicionar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				            return;
				        }

				        // 3. Solicitar a quantidade ao usuário
				        String quantStr = JOptionPane.showInputDialog(Supermercado.this, 
				            "Quantas unidades de " + nomeProduto + " deseja adicionar?", 
				            "Quantidade", JOptionPane.QUESTION_MESSAGE);
				        
				        // Validação da quantidade
				        if (quantStr == null || quantStr.trim().isEmpty()) {
				            return; // Usuário cancelou ou deixou vazio
				        }
				        
				        int quantidadeDesejada;
				        try {
				            quantidadeDesejada = Integer.parseInt(quantStr.trim());
				        } catch (NumberFormatException ex) {
				            JOptionPane.showMessageDialog(Supermercado.this, "Por favor, insira um número inteiro válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
				            return;
				        }
				        
				        // 4. Validar se a quantidade é maior que zero
				        if (quantidadeDesejada <= 0) {
				            JOptionPane.showMessageDialog(Supermercado.this, "A quantidade deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
				            return;
				        }
				        
				        // 5. Validar Estoque
				        if (quantidadeDesejada > estoqueAtual) {
				            JOptionPane.showMessageDialog(Supermercado.this, 
				                "Estoque insuficiente! Apenas " + estoqueAtual + " unidades disponíveis.", 
				                "Estoque Esgotado", JOptionPane.WARNING_MESSAGE);
				            return;
				        }

				        // 6. Adicionar ao Carrinho
				        DefaultTableModel modeloCarrinho = (DefaultTableModel) TableCarrinho.getModel();
				        
				        // Verifica se o item já está no carrinho (lógica de agrupamento)
				        for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
				            if (modeloCarrinho.getValueAt(i, 0).equals(nomeProduto)) {
				                // Item já existe: Atualiza apenas a quantidade
				                int quantAtual = (int) modeloCarrinho.getValueAt(i, 3);
				                modeloCarrinho.setValueAt(quantAtual + quantidadeDesejada, i, 3);
				                
				                JOptionPane.showMessageDialog(Supermercado.this, quantidadeDesejada + " unidades de " + nomeProduto + " adicionadas.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				                return;
				            }
				        }
				        
				        // Item não existe: Adiciona uma nova linha
				        Object[] novaLinha = new Object[] {
				            nomeProduto,
				            tipoProduto,
				            valorStr,
				            quantidadeDesejada // Apenas a quantidade que o cliente quer
				        };
				        modeloCarrinho.addRow(novaLinha);
				        
				        JOptionPane.showMessageDialog(Supermercado.this, quantidadeDesejada + " unidades de " + nomeProduto + " adicionadas.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				    }
				});
				
				
				btnAdcionar.setForeground(new Color(23, 0, 0));
				btnAdcionar.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnAdcionar.setBounds(10, 177, 151, 59);
				panel_2.add(btnAdcionar);
				
				JButton btnRemoverItens = new JButton("Remover itens");
				btnRemoverItens.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// 1. Captura a linha selecionada na tabela do carrinho
						int linhaSelecionada = TableCarrinho.getSelectedRow();
						
						// 2. Verifica se alguma linha foi selecionada
						if (linhaSelecionada == -1) {
							JOptionPane.showMessageDialog(Supermercado.this, 
									"Selecione um item no carrinho para remover.", 
									"Erro de Seleção", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						// 3. Pede confirmação ao usuário
						String nomeItem = (String) ((DefaultTableModel) TableCarrinho.getModel()).getValueAt(linhaSelecionada, 0);
						int confirmacao = JOptionPane.showConfirmDialog(Supermercado.this, 
								"Tem certeza que deseja remover " + nomeItem + " do carrinho?", 
								"Confirmar Remoção", JOptionPane.YES_NO_OPTION);

						// 4. Se o usuário confirmar, remove a linha
						if (confirmacao == JOptionPane.YES_OPTION) {
							DefaultTableModel modeloCarrinho = (DefaultTableModel) TableCarrinho.getModel();
							
							// 🔑 REMOVE A LINHA DO MODELO
							modeloCarrinho.removeRow(linhaSelecionada);
							
							JOptionPane.showMessageDialog(Supermercado.this, 
									nomeItem + " removido do carrinho.", 
									"Sucesso", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnRemoverItens.setForeground(new Color(23, 0, 0));
				btnRemoverItens.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnRemoverItens.setBounds(10, 253, 151, 59);
				panel_2.add(btnRemoverItens);
				
				JButton btnFinalizar = new JButton("FINALIZAR");

				btnFinalizar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {



				DefaultTableModel modeloCarrinho = (DefaultTableModel) TableCarrinho.getModel();

				int totalLinhas = modeloCarrinho.getRowCount();


				if (totalLinhas == 0) {

				JOptionPane.showMessageDialog(Supermercado.this, "O carrinho está vazio. Adicione produtos antes de finalizar.", "Aviso", JOptionPane.WARNING_MESSAGE);

				return;

				}



				int confirmacao = JOptionPane.showConfirmDialog(Supermercado.this,

				"Deseja finalizar a compra?",

				"Confirmação de Compra", JOptionPane.YES_NO_OPTION);



				if (confirmacao == JOptionPane.YES_OPTION) {


				ProdutoControle controller = new ProdutoControle();

				int produtosComprados = 0;


				// Itera sobre o carrinho (de trás para frente para evitar problemas de índice ao remover, embora não seja necessário aqui)

				for (int i = 0; i < totalLinhas; i++) {


				String nome = (String) modeloCarrinho.getValueAt(i, 0);

				// A quantidade está na última coluna (índice 3)

				int quantidade = (int) modeloCarrinho.getValueAt(i, 3);


				// 🔑 Diminui o estoque no banco de dados

				controller.diminuirEstoque(nome, quantidade);


				produtosComprados++;

				}


				// Limpa o carrinho após a compra

				modeloCarrinho.setRowCount(0);


				// Recarrega a tabela de produtos para mostrar o estoque atualizado

				popularTabelaProdutos();


				JOptionPane.showMessageDialog(Supermercado.this,

				"Compra finalizada com sucesso! " + produtosComprados + " itens registrados.",

				"Sucesso", JOptionPane.INFORMATION_MESSAGE);

				}

				}

				});
				btnFinalizar.setForeground(new Color(23, 0, 0));
				btnFinalizar.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnFinalizar.setBounds(10, 331, 151, 59);
				panel_2.add(btnFinalizar);
	    
				popularTabelaProdutos();
	}
	
	private void popularTabelaProdutos() {
	    
	    // 1. Acessa o modelo da tabela
	    DefaultTableModel modelo = (DefaultTableModel) tableListaProdutos.getModel();
	    
	    // 2. Limpa todas as linhas existentes
	    modelo.setRowCount(0);

	    // 3. Chama o Controller para buscar a lista de Produtos
	    ProdutoControle controller = new ProdutoControle();
	    List<Produto> listaProdutos = controller.listarProdutosParaView(); // Reusa o método do Controller

	    // 4. Itera sobre a lista e adiciona cada produto como uma nova linha
	    for (Produto produto : listaProdutos) {
	        
	        // Cria um array de Object para a nova linha
	        // A ordem deve ser a mesma definida na JTable: NOME, TIPO, VALOR, QUANT.
	        Object[] linha = new Object[] {
	            produto.getNomeProduto(),
	            produto.getTipo(),
	            // Formata o preço para R$ 0.00
	            String.format("R$ %.2f", produto.getValor()),
	            produto.getQuantidade()
	        };
	        
	        // Adiciona a linha ao modelo da tabela
	        modelo.addRow(linha);
	    }
	    
	    // Opcional: Se não houver produtos, adicione uma linha informativa
	    if (listaProdutos.isEmpty()) {
	        Object[] linhaVazia = new Object[] {
	            "Nenhum produto cadastrado", "", "", ""
	        };
	        modelo.addRow(linhaVazia);
	    }
	}

}
