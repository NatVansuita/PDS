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
				
				JTable TableCarrinho = new JTable();
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
				btnAdcionar.setForeground(new Color(23, 0, 0));
				btnAdcionar.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnAdcionar.setBounds(10, 177, 151, 59);
				panel_2.add(btnAdcionar);
				
				JButton btnRemoverItens = new JButton("Remover itens");
				btnRemoverItens.setForeground(new Color(23, 0, 0));
				btnRemoverItens.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnRemoverItens.setBounds(10, 253, 151, 59);
				panel_2.add(btnRemoverItens);
				
				JButton btnFinalizar = new JButton("FINALIZAR");
				btnFinalizar.setForeground(new Color(23, 0, 0));
				btnFinalizar.setFont(new Font("SansSerif", Font.BOLD, 11));
				btnFinalizar.setBounds(10, 331, 151, 59);
				panel_2.add(btnFinalizar);
				
				
	}
	
private void popularTabela() {
	    
	    // 1. Obtém o modelo atual da sua tabela
	    DefaultTableModel modelo = (DefaultTableModel) tableListaProdutos.getModel();
	    
	    // 2. Limpa todas as linhas existentes
	    modelo.setRowCount(0); 

	    // 3. CORREÇÃO MVC: Chama o Controller (ProdutoControle) e não o DAO (ProdutoBBD).
	    ProdutoBBD controller = new ProdutoBBD(); 
	    
	    // 4. Chama o método do Controller que busca a lista completa.
	    List<Produto> listarTodosProdutos = controller.listarTodosProdutos(); 

	    if (listarTodosProdutos.isEmpty()) {
	        System.out.println("Nenhum produto cadastrado no banco de dados.");
	        return; 
	    }

	    // 5. Itera sobre a lista e adiciona cada item como uma nova linha
	    for (Produto produto : listarTodosProdutos) {
	        
	        // Usando os getters que você utilizou
	        modelo.addRow(new Object[] {
	            produto.getNomeProduto(),
	            produto.getTipo(),
	            produto.getValor(),
	            produto.getQuantidade()
	        });
	    }
	    
	    // CORREÇÃO: A linha "popularTabela();" (que causava o loop infinito) foi removida.
	    
	    
	}

}
