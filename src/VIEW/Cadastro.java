package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import CONTROLLER.UsuarioContole;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JRadioButton rdbtnADM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setFont(new Font("SansSerif", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\110f5a81-8864-4bc1-aa8d-e19c47dc577a-removebg-preview.png"));
		setTitle("Mercadinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 464, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 444, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CADASTRO");
		lblTitulo.setForeground(new Color(23, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblTitulo.setBounds(10, 11, 424, 54);
		panel_1.add(lblTitulo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 98, 444, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(23, 0, 0));
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNome.setBounds(10, 11, 89, 43);
		panel_2.add(lblNome);
		
		
		//==============================NOME==============================
		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("Insira o seu nome completo!");
		textFieldNome.setForeground(new Color(64, 0, 0));
		textFieldNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textFieldNome.setBounds(94, 24, 340, 28);
		panel_2.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setForeground(new Color(23, 0, 0));
		lblCPF.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblCPF.setBounds(10, 65, 89, 43);
		panel_2.add(lblCPF);
		
		
		//==============================CPF==============================
		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCPF.setPlaceholderCharacter('_');
		}
		
		catch(java.text.ParseException e){
			e.printStackTrace();
		};
		
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField(mascaraCPF);
		formattedTextFieldCPF.setToolTipText("Insira o seu CPF completo!");
		formattedTextFieldCPF.setForeground(new Color(64, 0, 0));
		formattedTextFieldCPF.setFont(new Font("SansSerif", Font.PLAIN, 18));
		formattedTextFieldCPF.setBounds(94, 75, 340, 28);
		panel_2.add(formattedTextFieldCPF);
		
		
		//==============================JradioButton==============================
		rdbtnADM = new JRadioButton("ADM");
		rdbtnADM.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnADM.setForeground(new Color(23, 0, 0));
		rdbtnADM.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnADM.setBackground(new Color(255, 255, 255));
		rdbtnADM.setBounds(94, 129, 144, 28);
		panel_2.add(rdbtnADM);
		
		JLabel lblSou = new JLabel("SOU:");
		lblSou.setForeground(new Color(23, 0, 0));
		lblSou.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblSou.setBounds(10, 119, 89, 43);
		panel_2.add(lblSou);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCliente.setForeground(new Color(23, 0, 0));
		rdbtnCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
		rdbtnCliente.setBackground(Color.WHITE);
		rdbtnCliente.setBounds(269, 129, 144, 28);
		panel_2.add(rdbtnCliente);
		
		//==============================CRIAÇÃO DO GRUPO==============================
		ButtonGroup grupoTipoUsuario = new ButtonGroup();
		grupoTipoUsuario.add(rdbtnCliente);
		grupoTipoUsuario.add(rdbtnADM);
		
		JButton btnNewButton_1 = new JButton("CADASTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioContole contole = new UsuarioContole();
				
				String nome = textFieldNome.getText();
				String cpf = formattedTextFieldCPF.getText();
				boolean tipoUsuario = rdbtnADM.isSelected();
				String mensagem = contole.cadastrarNovoUsuario(nome, cpf, tipoUsuario);
				JOptionPane.showMessageDialog(Cadastro.this, mensagem);
				
				Login login = new Login();
				login.setVisible(true);
				Cadastro.this.setVisible(false);
				
			}
		});
		btnNewButton_1.setForeground(new Color(23, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_1.setBounds(10, 173, 424, 27);
		panel_2.add(btnNewButton_1);
	}
}
