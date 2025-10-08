package CONTROLLER;

import MODEL.Usuario;

public class UsuarioContole {
	private usuarioBBD usuarioBBD = new usuarioBBD();

    public String cadastrarNovoUsuario(String nome, String cpf, boolean tipoUsuario) {
        
        // 1. Você pode adicionar validações de negócio aqui (ex: verificar se o CPF é válido, se campos não estão vazios)

        // 2. Cria o objeto Model (entidade)
        Usuario novoUsuario = new Usuario(nome, cpf, tipoUsuario);
        
        // 3. Chama a camada de acesso a dados (DAO) para persistir o objeto
        if (usuarioBBD.cadastrarUsuario(novoUsuario)) {
            return "Cadastro realizado com sucesso!";
        }
        
        else {
            // Uma mensagem mais detalhada sobre o erro (ex: CPF já cadastrado) seria melhor
            return "Erro ao realizar o cadastro. Tente novamente."; 
        }
    }
}
