package br.ufpi.alugapp.controle;

import br.ufpi.alugapp.repositorio.ImovelRepository;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.alugapp.entidades.Imovel;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelController {

    ImovelRepository repositorio;

    public ImovelController(){
        this.repositorio = new ImovelRepository();
    }

    public Imovel buscarImovel(int id){

        return null;
    }

    public ArrayList<Imovel> pesquisarImoveis(String descricao){

        return null;
    }

    public boolean inserirImovel(Imovel i){

        return false;
    }
}
