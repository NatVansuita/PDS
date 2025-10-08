package MODEL;

public class Usuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String nome;
	private String CPF;
	private boolean Tipocliente;
	
	//construtor
	public Usuario(String nome, String cPF, boolean tipocliente) {
		super();
		this.nome = nome;
		CPF = cPF;
		Tipocliente = tipocliente;
	}

	//get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public boolean getTipocliente() {
		return Tipocliente;
	}

	public void setTipocliente(boolean tipocliente) {
		Tipocliente = tipocliente;
	}

}
