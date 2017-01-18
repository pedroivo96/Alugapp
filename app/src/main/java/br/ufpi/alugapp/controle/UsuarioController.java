package br.ufpi.alugapp.controle;

import android.content.Context;

import br.ufpi.alugapp.entidades.Usuario;
import br.ufpi.alugapp.repositorio.UsuarioRepository;

/**
 * Created by wellyson on 20/12/16.
 */

public class UsuarioController {

    private UsuarioRepository repositorioUsuario;

    public UsuarioController(Context context){
        this.repositorioUsuario = new UsuarioRepository(context);
    }

    public Usuario cadastrarCliente(String nome, String usuario, String senha, String email, String telefone){

        if(repositorioUsuario.buscarPorUsuario(usuario) == null && repositorioUsuario.buscarPorEmail(email) == null){
            return repositorioUsuario.cadastrarCliente(nome, usuario, senha, email, telefone);
        }

        return null; //usuario ou email cadastrado.
    }

    public Usuario cadastrarCorretor(String nome, String usuario, String senha, String email, String telefone){

        if(repositorioUsuario.buscarPorUsuario(usuario) == null && repositorioUsuario.buscarPorEmail(email) == null){
            return repositorioUsuario.cadastrarCorretor(nome, usuario, senha, email, telefone);
        }

        return null; //usuario ou email cadastrado.
    }

    public Usuario login(String usuario, String senha){

        return repositorioUsuario.login(usuario, senha);
    }
}
