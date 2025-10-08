package CONTROLLER;

import MODEL.Usuario;

public class LoginController {

	private usuarioBBD usuarioBBd=  new usuarioBBD();
	
	public Usuario autenticar(String nome, String cpf) {
		Usuario usuario = usuarioBBd.buscarUsuario(nome, cpf);
		return usuario;
	}
}
