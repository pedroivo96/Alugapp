package br.ufpi.alugapp.controle;

/**
 * Created by wellyson on 05/12/16.
 */

public class Fachada {

    public ImovelController controladorImoveis;

    public Fachada(){
        this.controladorImoveis = new ImovelController();
    }
}
