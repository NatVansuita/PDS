package CONTROLLER;

import MODEL.Usuario;

public class UsuarioContole {
	private usuarioBBD usuarioBBD = new usuarioBBD();

    public String cadastrarNovoUsuario(String nome, String cpf, boolean tipoUsuario) {
        
        Usuario novoUsuario = new Usuario(nome, cpf, tipoUsuario);
        
        if (usuarioBBD.cadastrarUsuario(novoUsuario)) {
            return "Cadastro realizado com sucesso!";
        }
        
        else {
            return "Erro ao realizar o cadastro. Tente novamente."; 
        }
    }
}
