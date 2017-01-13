package br.ufpi.alugapp.entidades;

import java.util.ArrayList;

/**
 * Created by wellyson on 20/12/16.
 */

public class Corretor extends Usuario{

    public ArrayList<Imovel> meusImoveis;

    public Corretor(String nome, String usuario, String senha, String email, String telefone, int idUser){

        super(nome, usuario, senha, email, telefone, idUser);
        this.meusImoveis = new ArrayList<>();
    }

    public ArrayList<Imovel> getMeusImoveis() {
        return meusImoveis;
    }

    public void setMeusImoveis(ArrayList<Imovel> meusImoveis) {
        this.meusImoveis = meusImoveis;
    }
}
