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

    public ArrayList<Imovel> pesquisarImoveis(String pesquisa){
        return repositorio.pesquisarImoveis(pesquisa);
    }

    public boolean inserirImovel(Imovel i){
        return repositorio.inserirImovel(i);
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){
        ArrayList<Imovel> meusImoveis = new ArrayList<Imovel>();

        return meusImoveis;
    }
}
