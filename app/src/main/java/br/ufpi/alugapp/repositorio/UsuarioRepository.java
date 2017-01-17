package br.ufpi.alugapp.repositorio;


import br.ufpi.alugapp.entidades.Cliente;
import br.ufpi.alugapp.entidades.Usuario;

public class UsuarioRepository {

    public Usuario cadastrarCliente(String nome, String usuario, String senha, String email, String telefone){
        return null;
    }

    public Usuario cadastrarCorretor(String nome, String usuario, String senha, String email, String telefone){
        //insere, atribui um id e retorna o obj.
        return null;
    }

    public Usuario login(String usuario, String senha){
        //verifica e retorna o obj.
        return null;
    }

    public Usuario buscarPorUsuario(String usuario){
        return null;
    }

    public Usuario buscarPorEmail(String email){
        return null;
    }

}
