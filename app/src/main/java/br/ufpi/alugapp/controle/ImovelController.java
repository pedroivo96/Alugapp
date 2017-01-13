package br.ufpi.alugapp.controle;

import br.ufpi.alugapp.entidades.LocalMapa;
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

    public ArrayList<Imovel> pesquisarImoveis(String endereco, String descricao, float FaixaPreco){
        //return repositorio.pesquisarImoveis(pesquisa);
        return null;
    }

    public boolean inserirImovel(String descricao, String endereco, LocalMapa local, float preco,int idCorretor){

        return false;
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){
        ArrayList<Imovel> meusImoveis = new ArrayList<Imovel>();

        return meusImoveis;
    }

    public ArrayList<Imovel> listarMeusFavoritos(){
        ArrayList<Imovel> meusFavoritos = new ArrayList<Imovel>();

        return meusFavoritos;
    }

    public Imovel alterarImovel(String descricao , String endereco , float preco){

        return null;
    }

    public boolean excluirDaBusca(int idImovel){
        return false;
    }

    public boolean favoritarImovel(int idImovel , int idCliente){
        return false;
    }

    public boolean subcadeiaIgual(String cadeia1 , String cadeia2){

        String [] tokens1 = cadeia1.split(" ");
        String [] tokens2 = cadeia2.split(" ");

        for(String s : tokens1){
            for(String s2 : tokens2){
                if(s.equals(s2))
                    return true;
            }
        }
        return false;
    }


}
