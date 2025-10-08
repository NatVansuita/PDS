package MODEL;

public class Produto {
	
	private String nomeProduto;
	private int Quantidade;
	private String tipo;
	private double valor;
	
	
	public Produto(String nomeProduto, double valor, String tipo, int quantidade ) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.tipo = tipo;
		this.Quantidade = quantidade;
		
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public int getQuantidade() {
		return Quantidade;
	}


	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
