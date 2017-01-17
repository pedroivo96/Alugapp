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

    ImovelRepository repositorioImovel;

    public ImovelController(){
        this.repositorioImovel = new ImovelRepository();
    }

    public ArrayList<Imovel> pesquisar(String endereco, String descricao, float faixaPreco){

        ArrayList<Imovel> resultadoPorEndereco, resultadoPorDescricao, resultadoPorPreco, enderecoDescricao, descricaoPreco;

        //resultadoPorEndereco =
        //resultadoPorDescricao =
        //resultadoPorPreco =

        /*if(endereco != "" && descricao != ""){
            for(Imovel i : resultadoPorEndereco){
                for(Imovel i2 : resultadoPorDescricao)
                    if (i.equals(i2))
                        enderecoDescricao.add(i);
            }
        }else if(descricao != "" && faixaPreco != ""){
            for(Imovel i : resultadoPorDescricao){
                for(Imovel i2 : resultadoPorPreco)
                    if (i.equals(i2))
                        descricaoPreco.add(i);
            }
        }else if(faixaPreco != ""){

        }*/

        return null;
    }

    public Imovel inserirImovel(String descricao, String endereco, LocalMapa local, float preco,int idCorretor){



        return null;
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){
        ArrayList<Imovel> meusImoveis = new ArrayList<>();

        return meusImoveis;
    }

    public ArrayList<Imovel> listarMeusFavoritos(int idCliente){
        ArrayList<Imovel> meusFavoritos = new ArrayList<>();

        return meusFavoritos;
    }

    public Imovel alterarImovel(String descricao , String endereco , float preco, int idImovel){

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
