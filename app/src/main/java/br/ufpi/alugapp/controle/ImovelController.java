package br.ufpi.alugapp.controle;

import br.ufpi.alugapp.repositorio.ImovelRepository;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.alugapp.entidades.Imovel;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelController {

<<<<<<< HEAD
    ImovelRepository repositorio = new ImovelRepository();
=======
    ImovelRepository repositorio;
>>>>>>> fac7f4700d6fd9793e79920889ba8ad612e8dce9

    public ImovelController(){
        this.repositorio = new ImovelRepository();
    }

<<<<<<< HEAD
    public ArrayList<Imovel> pesquisarImoveis(String pesquisa){

        return repositorio.pesquisarImoveis(pesquisa);
=======
    public Imovel buscarImovel(int id){

        return null;
    }

    public ArrayList<Imovel> pesquisarImoveis(String descricao){

        return null;
>>>>>>> fac7f4700d6fd9793e79920889ba8ad612e8dce9
    }

    public boolean inserirImovel(Imovel i){

<<<<<<< HEAD
        return repositorio.inserirImovel(i);
=======
        return false;
>>>>>>> fac7f4700d6fd9793e79920889ba8ad612e8dce9
    }
}
