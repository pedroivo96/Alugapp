package br.ufpi.alugapp.entidades;

import java.io.Serializable;

/**
 * Created by wellyson on 20/12/16.
 */

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public String nome;
    public String usuario;
    public String senha;
    public String email;
    public String telefone;
    public String idUser;

    public Usuario(){}

    public Usuario(String nome, String usuario, String senha, String email, String telefone){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String user) {
        this.usuario = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
