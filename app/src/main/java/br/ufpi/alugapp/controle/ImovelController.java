package br.ufpi.alugapp.controle;

import br.ufpi.alugapp.repositorio.ImovelRepository;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelController {

    ImovelRepository repositorio;

    public ImovelController(){
        this.repositorio = new ImovelRepository();
    }


}
