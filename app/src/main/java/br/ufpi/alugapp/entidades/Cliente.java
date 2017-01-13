package br.ufpi.alugapp.entidades;

import java.util.ArrayList;

/**
 * Created by wellyson on 20/12/16.
 */

public class Cliente extends Usuario{

    public ArrayList<Imovel> imoveisFavoritos;

    public Cliente(String nome, String usuario, String senha, String email, String telefone, int idUser){
        super(nome, usuario, senha, email, telefone, idUser);
        this.imoveisFavoritos = new ArrayList<>();
    }

    public ArrayList<Imovel> getImoveisFavoritos() {
        return imoveisFavoritos;
    }

    public void setImoveisFavoritos(ArrayList<Imovel> imoveisFavoritos) {
        this.imoveisFavoritos = imoveisFavoritos;
    }
}
