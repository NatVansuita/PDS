package VIEW;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import CONTROLLER.ProdutoBBD;
import CONTROLLER.ProdutoControle;
import MODEL.Produto;

import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

public class TelaADM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textFieldNomeProduto;
	private JTextField textField;
	private JTextField textFieldValorEDit;
	private JTextField textFieldUnidadesCadastro;
	private JTextField textFieldUnidadesEDIT;
	private JComboBox comboBoxTipo = new JComboBox();
	private JLabel lblQuantidade = new JLabel();
	private JComboBox comboBoxNomeRemocao = new JComboBox();
	private JComboBox comboBoxNomeVisualizar = new JComboBox();
	private JComboBox comboBoxNomeEditar = new JComboBox();
	private JComboBox comboBoxTipoEdit = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaADM frame = new TelaADM();
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
	public TelaADM() {
		setFont(new Font("Dialog", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\DELL\\Downloads\\110f5a81-8864-4bc1-aa8d-e19c47dc577a-removebg-preview.png"));
		setTitle("Administração");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(23, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane.setBounds(0, 0, 484, 342);
		contentPane.add(tabbedPane);

		JPanel panelCadastrar = new JPanel();
		panelCadastrar.setBackground(new Color(255, 255, 255));
		panelCadastrar.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Cadastrar", null, panelCadastrar, null);
		panelCadastrar.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 11, 459, 292);
		panelCadastrar.add(panel);
		panel.setLayout(null);

		JLabel lblTextoExplicativoCadastro = new JLabel("CADASTRO");
		lblTextoExplicativoCadastro.setForeground(new Color(23, 0, 0));
		lblTextoExplicativoCadastro.setBounds(0, 0, 459, 64);
		lblTextoExplicativoCadastro.setToolTipText("Titulo");
		lblTextoExplicativoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoExplicativoCadastro.setFont(new Font("SansSerif", Font.BOLD, 50));
		panel.add(lblTextoExplicativoCadastro);

		JLabel lblnome = new JLabel("Nome do produto:");
		lblnome.setForeground(new Color(23, 0, 0));
		lblnome.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblnome.setBounds(10, 67, 216, 33);
		panel.add(lblnome);

		// ============================================================================CADASTRO============================================================================
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setToolTipText("Escreva o nome do Produto a ser cadastrado!");
		textFieldNomeProduto.setForeground(new Color(64, 0, 0));
		textFieldNomeProduto.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textFieldNomeProduto.setBounds(10, 99, 216, 33);
		panel.add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tipo de produto:");
		lblNewLabel.setForeground(new Color(23, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 143, 216, 33);
		panel.add(lblNewLabel);

		// =========================TIPO=========================
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBackground(new Color(255, 255, 255));
		comboBoxTipo.setToolTipText("Escolha o tipo do produto!");
		comboBoxTipo.setForeground(new Color(64, 0, 0));
		comboBoxTipo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "", "01.Carnes e derivados;", "02.Hortifruti;",
				"03.Grãos, cereais e farináceos;", "04.Laticínios e ovos;", "05.Bebidas;",
				"06.Enlatados, conservas e molhos;", "07.Produtos industrializados / processados;",
				"09.Temperos e condimentos;", "10.Produtos de padaria e confeitaria;" }));
		comboBoxTipo.setBounds(10, 177, 216, 33);
		panel.add(comboBoxTipo);

		// =========================BOTÃO CASTRAR=========================
		JButton btnNewButton_1 = new JButton("CADASTRAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = textFieldNomeProduto.getText();
				String valor = textField.getText();
				String quantidade = textFieldUnidadesCadastro.getText();

				String tipo = (String) comboBoxTipo.getSelectedItem();

				if (tipo == null || tipo.startsWith("--- Selecione") || tipo.trim().isEmpty()) {
					JOptionPane.showMessageDialog(TelaADM.this, "O campo 'Tipo de Produto' não pode ser vazio.");
					return;
				}

				ProdutoControle controle = new ProdutoControle();

				String mensagem = controle.cadastrarNovoProduto(nome, valor, quantidade, tipo);

				JOptionPane.showMessageDialog(TelaADM.this, mensagem);

				if (mensagem.contains("sucesso")) {
					textFieldNomeProduto.setText("");
					textField.setText("");
					textFieldUnidadesCadastro.setText("");
					comboBoxTipo.setSelectedIndex(0);
				}

			}
		});
		btnNewButton_1.setToolTipText("Cadastre o produto");
		btnNewButton_1.setForeground(new Color(23, 0, 0));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 234, 437, 27);
		panel.add(btnNewButton_1);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(23, 0, 0));
		lblValor.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblValor.setBounds(233, 143, 216, 33);
		panel.add(lblValor);

		// =========================VALOR=========================
		textField = new JTextField();
		textField.setToolTipText("Escreva o nome do Produto a ser cadastrado!");
		textField.setForeground(new Color(64, 0, 0));
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(233, 177, 216, 33);
		panel.add(textField);

		JLabel lblQuantidade = new JLabel("Unidades:");
		lblQuantidade.setForeground(new Color(23, 0, 0));
		lblQuantidade.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblQuantidade.setBounds(231, 67, 216, 33);
		panel.add(lblQuantidade);

		// =========================QUANIDADES=========================
		textFieldUnidadesCadastro = new JTextField();
		textFieldUnidadesCadastro.setToolTipText("Escreva a quantidade de unidades do produto!");
		textFieldUnidadesCadastro.setForeground(new Color(64, 0, 0));
		textFieldUnidadesCadastro.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textFieldUnidadesCadastro.setColumns(10);
		textFieldUnidadesCadastro.setBounds(231, 101, 216, 33);
		panel.add(textFieldUnidadesCadastro);

		JPanel panelRemover = new JPanel();
		panelRemover.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Remover", null, panelRemover, null);
		panelRemover.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 459, 292);
		panelRemover.add(panel_1);

		JLabel lblTextoExplicativoRemover = new JLabel("REMOÇÃO");
		lblTextoExplicativoRemover.setToolTipText("Titulo");
		lblTextoExplicativoRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoExplicativoRemover.setForeground(new Color(23, 0, 0));
		lblTextoExplicativoRemover.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblTextoExplicativoRemover.setBounds(0, 0, 459, 64);
		panel_1.add(lblTextoExplicativoRemover);

		JLabel lblnome_1 = new JLabel("Nome do produto:");
		lblnome_1.setForeground(new Color(23, 0, 0));
		lblnome_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblnome_1.setBounds(8, 102, 439, 33);
		panel_1.add(lblnome_1);

		JButton btnNewButton_1_1 = new JButton("REMOVER");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String produtoSelecionado = (String) comboBoxNomeRemocao.getSelectedItem();

				if (produtoSelecionado == null || produtoSelecionado.startsWith("--- Selecione")) {
					JOptionPane.showMessageDialog(null, "Selecione um produto válido para remover.");
					return;
				}

				int confirmacao = JOptionPane.showConfirmDialog(TelaADM.this,
						"Tem certeza que deseja remover o produto: " + produtoSelecionado + "?",
						"Confirmação de Remoção", JOptionPane.YES_NO_OPTION);

				if (confirmacao == JOptionPane.YES_OPTION) {

					ProdutoControle controller = new ProdutoControle();
					String resultado = controller.removerProdutoPorNome(produtoSelecionado);

					JOptionPane.showMessageDialog(TelaADM.this, resultado);

					popularComboBoxesProdutos();
				}
			}
		});
		btnNewButton_1_1.setToolTipText("Remova o produto");
		btnNewButton_1_1.setForeground(new Color(23, 0, 0));
		btnNewButton_1_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(10, 234, 437, 27);
		panel_1.add(btnNewButton_1_1);

		// ============================================================================REMOÇÃO============================================================================
		comboBoxNomeRemocao = new JComboBox();
		comboBoxNomeRemocao.setToolTipText("Selecione o nome do produto a ser removido!");
		comboBoxNomeRemocao.setForeground(new Color(64, 0, 0));
		comboBoxNomeRemocao.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBoxNomeRemocao.setBackground(Color.WHITE);
		comboBoxNomeRemocao.setBounds(8, 134, 439, 33);
		panel_1.add(comboBoxNomeRemocao);

		JPanel panelVisualizar = new JPanel();
		panelVisualizar.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Visualizar", null, panelVisualizar, null);
		panelVisualizar.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 11, 459, 292);
		panelVisualizar.add(panel_2);

		JLabel lblTextoExplicativoVizualizar = new JLabel("VISUALIZAR");
		lblTextoExplicativoVizualizar.setToolTipText("Titulo");
		lblTextoExplicativoVizualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoExplicativoVizualizar.setForeground(new Color(23, 0, 0));
		lblTextoExplicativoVizualizar.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblTextoExplicativoVizualizar.setBounds(0, 0, 459, 64);
		panel_2.add(lblTextoExplicativoVizualizar);

		JLabel lblnome_2 = new JLabel("Nome do produto:");
		lblnome_2.setForeground(new Color(23, 0, 0));
		lblnome_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblnome_2.setBounds(10, 121, 439, 33);
		panel_2.add(lblnome_2);

		// ============================================================================VISUALIZAÇÃO============================================================================
		comboBoxNomeVisualizar = new JComboBox();
		comboBoxNomeVisualizar.setToolTipText("Selecione o nome do produto que deseja visualizar!");
		comboBoxNomeVisualizar.setForeground(new Color(64, 0, 0));
		comboBoxNomeVisualizar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBoxNomeVisualizar.setBackground(Color.WHITE);
		comboBoxNomeVisualizar.setBounds(10, 155, 439, 33);
		panel_2.add(comboBoxNomeVisualizar);

		comboBoxNomeVisualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String produtoSelecionado = (String) comboBoxNomeVisualizar.getSelectedItem();

				if (produtoSelecionado == null || produtoSelecionado.startsWith("--- Selecione")) {
					return;
				}

				ProdutoControle controller = new ProdutoControle();
				Produto produtoCompleto = controller.buscarProduto(produtoSelecionado);

				if (produtoCompleto != null) {

					comboBoxNomeRemocao.setPopupVisible(false);

					String mensagem = String.format(
							"Informações do Produto:\n" + "---------------------------------\n" + "Nome: %s\n"
									+ "Tipo: %s\n" + "Preço: R$ %.2f\n" + "Estoque Disponível: %d unidades",
							produtoCompleto.getNomeProduto(), produtoCompleto.getTipo(), produtoCompleto.getValor(),
							produtoCompleto.getQuantidade());

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							JOptionPane.showMessageDialog(TelaADM.this, mensagem, "Detalhes do Produto",
									JOptionPane.INFORMATION_MESSAGE);
						}
					});
				}

				else {
					JOptionPane.showMessageDialog(TelaADM.this,
							"Erro: Não foi possível carregar os detalhes do produto.", "Erro de Busca",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel panelEditarInformações = new JPanel();
		panelEditarInformações.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Editar Informações", null, panelEditarInformações, null);
		panelEditarInformações.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 11, 459, 292);
		panelEditarInformações.add(panel_3);

		JLabel lblTextoExplicativoEditar = new JLabel("EDIT. INFOR.");
		lblTextoExplicativoEditar.setToolTipText("Titulo");
		lblTextoExplicativoEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoExplicativoEditar.setForeground(new Color(23, 0, 0));
		lblTextoExplicativoEditar.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblTextoExplicativoEditar.setBounds(0, 0, 459, 64);
		panel_3.add(lblTextoExplicativoEditar);

		JLabel lblnome_3 = new JLabel("Nome do produto:");
		lblnome_3.setForeground(new Color(23, 0, 0));
		lblnome_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblnome_3.setBounds(10, 67, 216, 33);
		panel_3.add(lblnome_3);

		JLabel lblNewLabel_2 = new JLabel("Tipo de produto:");
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setForeground(new Color(23, 0, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 143, 216, 33);
		panel_3.add(lblNewLabel_2);

		this.comboBoxTipoEdit = new JComboBox();
		this.comboBoxTipoEdit.setToolTipText("Escolha o tipo do produto!");
		this.comboBoxTipoEdit.setForeground(new Color(64, 0, 0));
		this.comboBoxTipoEdit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		this.comboBoxTipoEdit.setBackground(Color.WHITE);
		this.comboBoxTipoEdit.setBounds(10, 177, 216, 33);
		comboBoxTipoEdit.setModel(new DefaultComboBoxModel(new String[] { "", "01.Carnes e derivados;",
				"02.Hortifruti;", "03.Grãos, cereais e farináceos;", "04.Laticínios e ovos;", "05.Bebidas;",
				"06.Enlatados, conservas e molhos;", "07.Produtos industrializados / processados;",
				"09.Temperos e condimentos;", "10.Produtos de padaria e confeitaria;" }));
		panel_3.add(this.comboBoxTipoEdit);

		JButton btnNewButton_1_3 = new JButton("ATUALIZAR");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = (String) comboBoxNomeEditar.getSelectedItem();
				String precoStr = textFieldValorEDit.getText();
				String tipo = (String) comboBoxTipoEdit.getSelectedItem();
				String estoqueStr = textFieldUnidadesEDIT.getText();

				if (nome == null || nome.startsWith("--- Selecione")) {
					JOptionPane.showMessageDialog(TelaADM.this, "Selecione um produto para atualizar.");
					return;
				}

				ProdutoControle controller = new ProdutoControle();
				String resultado = controller.atualizarProduto(nome, precoStr, tipo, estoqueStr);

				JOptionPane.showMessageDialog(TelaADM.this, resultado);

				if (resultado.contains("sucesso")) {
					limparCamposEdicao();

					popularComboBoxesProdutos();
				}
			}
		});
		btnNewButton_1_3.setToolTipText("Registre a atualização do produto o produto");
		btnNewButton_1_3.setForeground(new Color(23, 0, 0));
		btnNewButton_1_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_1_3.setBackground(Color.WHITE);
		btnNewButton_1_3.setBounds(10, 234, 437, 27);
		panel_3.add(btnNewButton_1_3);

		JLabel lblValor_1 = new JLabel("Valor:");
		lblValor_1.setForeground(new Color(23, 0, 0));
		lblValor_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblValor_1.setBounds(233, 143, 216, 33);
		panel_3.add(lblValor_1);

		textFieldValorEDit = new JTextField();
		textFieldValorEDit.setToolTipText("Atualize o valor do produto!!");
		textFieldValorEDit.setForeground(new Color(64, 0, 0));
		textFieldValorEDit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textFieldValorEDit.setColumns(10);
		textFieldValorEDit.setBounds(233, 177, 216, 33);
		panel_3.add(textFieldValorEDit);

		// ============================================================================EDITAR============================================================================
		comboBoxNomeEditar = new JComboBox();
		comboBoxNomeEditar.setToolTipText("Selecione o nome do produto que deseja Editar as Informações!");
		comboBoxNomeEditar.setForeground(new Color(64, 0, 0));
		comboBoxNomeEditar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBoxNomeEditar.setBackground(Color.WHITE);
		comboBoxNomeEditar.setBounds(10, 99, 216, 33);
		panel_3.add(comboBoxNomeEditar);

		JLabel lblQuantidade_1 = new JLabel("Unidades:");
		lblQuantidade_1.setForeground(new Color(23, 0, 0));
		lblQuantidade_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblQuantidade_1.setBounds(233, 65, 216, 33);
		panel_3.add(lblQuantidade_1);

		textFieldUnidadesEDIT = new JTextField();
		textFieldUnidadesEDIT.setToolTipText("Escreva a quantidade de unidades do produto!");
		textFieldUnidadesEDIT.setForeground(new Color(64, 0, 0));
		textFieldUnidadesEDIT.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textFieldUnidadesEDIT.setColumns(10);
		textFieldUnidadesEDIT.setBounds(233, 99, 216, 33);
		panel_3.add(textFieldUnidadesEDIT);

		comboBoxNomeEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nomeSelecionado = (String) comboBoxNomeEditar.getSelectedItem();

				if (nomeSelecionado == null || nomeSelecionado.startsWith("--- Selecione")) {

					limparCamposEdicao();
					return;
				}

				ProdutoControle controller = new ProdutoControle();
				Produto produtoCompleto = controller.buscarProduto(nomeSelecionado);

				if (produtoCompleto != null) {

					textFieldUnidadesEDIT.setText(String.valueOf(produtoCompleto.getQuantidade()));

					textFieldValorEDit.setText(String.format("%.2f", produtoCompleto.getValor()));

					String tipoProduto = produtoCompleto.getTipo().trim();

					comboBoxTipoEdit.setSelectedItem(tipoProduto);

				} else {
					limparCamposEdicao();
					JOptionPane.showMessageDialog(TelaADM.this, "Erro ao carregar dados para edição.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel panelSaida = new JPanel();
		panelSaida.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("SAIDA", null, panelSaida, null);
		panelSaida.setLayout(null);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 11, 459, 292);
		panelSaida.add(panel_2_1);

		// ============================================================================SAIR============================================================================
		JButton btnMudarParaCliente = new JButton("Mudar para Cliente");
		btnMudarParaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supermercado telaCompra = new Supermercado();
				telaCompra.setVisible(true);
				TelaADM.this.setVisible(false);
			}
		});
		btnMudarParaCliente.setToolTipText("Ir para a área do cliente");
		btnMudarParaCliente.setForeground(new Color(23, 0, 0));
		btnMudarParaCliente.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnMudarParaCliente.setBackground(Color.WHITE);
		btnMudarParaCliente.setBounds(10, 123, 439, 32);
		panel_2_1.add(btnMudarParaCliente);

		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				TelaADM.this.setVisible(false);
				login.setVisible(true);
			}
		});
		btnSair.setToolTipText("Sair do sistema");
		btnSair.setForeground(new Color(23, 0, 0));
		btnSair.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(10, 178, 439, 32);
		panel_2_1.add(btnSair);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		popularComboBoxesProdutos();
	}

	private void popularComboBoxesProdutos() {

		comboBoxNomeRemocao.removeAllItems();
		comboBoxNomeVisualizar.removeAllItems();
		comboBoxNomeEditar.removeAllItems();

		ProdutoControle controller = new ProdutoControle();
		List<Produto> listaProdutos = controller.listarProdutosParaView();

		if (listaProdutos.isEmpty()) {
			comboBoxNomeRemocao.addItem("Nenhum produto cadastrado");
			comboBoxNomeVisualizar.addItem("Nenhum produto cadastrado");
			comboBoxNomeEditar.addItem("Nenhum produto cadastrado");
			return;
		}

		String itemInicial = "--- Selecione um Produto ---";
		comboBoxNomeRemocao.addItem(itemInicial);
		comboBoxNomeVisualizar.addItem(itemInicial);
		comboBoxNomeEditar.addItem(itemInicial);

		for (Produto produto : listaProdutos) {

			String nomeProduto = produto.getNomeProduto();

			comboBoxNomeRemocao.addItem(nomeProduto);
			comboBoxNomeVisualizar.addItem(nomeProduto);
			comboBoxNomeEditar.addItem(nomeProduto);
		}
	}

	private void limparCamposEdicao() {

		textFieldUnidadesEDIT.setText("");

		textFieldValorEDit.setText("");

		if (comboBoxNomeEditar.getItemCount() > 0) {
			comboBoxNomeEditar.setSelectedIndex(0);
		}

	}

}
