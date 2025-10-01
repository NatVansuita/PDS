package mercadinho;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

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
		setBounds(100, 100, 793, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 757, 686);
		contentPane.add(panel);
		
		JLabel lblMercadinho = new JLabel("MERCADINHO");
		lblMercadinho.setBackground(new Color(245, 245, 245));
		lblMercadinho.setBounds(94, 11, 569, 54);
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

		btnCarrinho.setBounds(673, 11, 74, 34);
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
	}
}
