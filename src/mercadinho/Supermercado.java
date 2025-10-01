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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Supermercado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\110f5a81-8864-4bc1-aa8d-e19c47dc577a-removebg-preview.png"));
		setTitle("Supermercado");
		setFont(new Font("SansSerif", Font.BOLD, 13));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 11, 757, 426);
		contentPane.add(panel);
		
		JLabel lblMercadinho = new JLabel("MERCADINHO");
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
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("SansSerif", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TIPO", "NOME"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(10, 76, 364, 116);
		panel.add(table);
		
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
		
		JLabel lblQuantidade = new JLabel("Unidades:");
		lblQuantidade.setForeground(new Color(23, 0, 0));
		lblQuantidade.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblQuantidade.setBounds(367, 203, 119, 33);
		panel.add(lblQuantidade);
		
		JLabel lblnome = new JLabel("Nome do produto:");
		lblnome.setForeground(new Color(23, 0, 0));
		lblnome.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblnome.setBounds(20, 203, 193, 33);
		panel.add(lblnome);
		
		JLabel lblNewLabel = new JLabel("Tipo de produto:");
		lblNewLabel.setForeground(new Color(23, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 279, 193, 33);
		panel.add(lblNewLabel);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(23, 0, 0));
		lblValor.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblValor.setBounds(369, 279, 117, 33);
		panel.add(lblValor);
		
		JLabel lblnome_1 = new JLabel("");
		lblnome_1.setForeground(new Color(23, 0, 0));
		lblnome_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblnome_1.setBackground(new Color(255, 255, 255));
		lblnome_1.setBounds(20, 235, 271, 33);
		panel.add(lblnome_1);
		
		JLabel lblnome_1_1 = new JLabel("");
		lblnome_1_1.setForeground(new Color(23, 0, 0));
		lblnome_1_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblnome_1_1.setBounds(20, 311, 271, 33);
		panel.add(lblnome_1_1);
		
		JLabel lblnome_1_2 = new JLabel("");
		lblnome_1_2.setForeground(new Color(23, 0, 0));
		lblnome_1_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblnome_1_2.setBounds(367, 235, 146, 33);
		panel.add(lblnome_1_2);
		
		JLabel lblnome_1_1_1 = new JLabel("");
		lblnome_1_1_1.setForeground(new Color(23, 0, 0));
		lblnome_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblnome_1_1_1.setBounds(367, 311, 146, 33);
		panel.add(lblnome_1_1_1);
	}
}
