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


    //Implementar métodos listarImoveis , buscarImovel , InserirImovel
    //Lista de imóveis chama listar imoveis do Repositorio e retorna uma lista
    //Existem duas buscas : Pelo id e atraves de uma String
    //Inserir imovel recebe um objeto Imovel e usa o metodo inserirImovel do repositorio

    public List<Imovel> listarImoveis(){
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();

        return imoveis;
    }

    public Imovel buscarImovel(int id){
        Imovel i = new Imovel();

        return i;
    }

    public Imovel buscarImovel(String descricao){
        Imovel i = new Imovel();

        return i;
    }

    public boolean inserirImovel(Imovel i){

        return false;
    }
}
