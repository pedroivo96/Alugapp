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

    private ImovelRepository repositorioImovel;

    public ImovelController() {
        this.repositorioImovel = new ImovelRepository();
    }

    public ArrayList<Imovel> pesquisar(String endereco, String descricao, float faixaPreco) {

        ArrayList<Imovel> resultadoPorEndereco, resultadoPorDescricao, resultadoPorPreco;
        ArrayList<Imovel> enderecoDescricao = new ArrayList<>(), enderecoDescricaoPreco = new ArrayList<>();
        ArrayList<Imovel> enderecoPreco = new ArrayList<>(), descricaoPreco = new ArrayList<>();

        resultadoPorEndereco = this.repositorioImovel.pesquisarEndereco(endereco);
        resultadoPorDescricao = this.repositorioImovel.pesquisarDescricao(descricao);
        resultadoPorPreco = this.repositorioImovel.pesquisarFaixaPreco(faixaPreco);

        if(!endereco.isEmpty() && descricao.isEmpty() && faixaPreco == 0.0f){
            return resultadoPorEndereco;
        }
        if(endereco.isEmpty() && !descricao.isEmpty() && faixaPreco == 0.0f){
            return resultadoPorDescricao;
        }

        if(endereco.isEmpty() && descricao.isEmpty() && faixaPreco != 0.0f){
            return resultadoPorPreco;
        }

        if (!endereco.isEmpty() && !descricao.isEmpty() && faixaPreco != 0.0f) {
            for (Imovel i : resultadoPorEndereco) {
                for (Imovel i2 : resultadoPorDescricao)
                    if (i.equals(i2))
                        enderecoDescricao.add(i);
            }
            for (Imovel i : resultadoPorPreco) {
                for (Imovel i2 : enderecoDescricao)
                    if (i.equals(i2))
                        enderecoDescricaoPreco.add(i);
            }
            return enderecoDescricaoPreco;
        }else{
            if(faixaPreco == 0.0f) {
                for (Imovel i : resultadoPorEndereco) {
                    for (Imovel i2 : resultadoPorDescricao)
                        if (i.equals(i2))
                            enderecoDescricao.add(i);
                }
                return enderecoDescricao;
            }
            if(!descricao.isEmpty()){
                for (Imovel i : resultadoPorPreco) {
                    for (Imovel i2 : resultadoPorEndereco)
                        if (i.equals(i2))
                            enderecoPreco.add(i);
                }
                return enderecoPreco;
            }
            if(!endereco.isEmpty()){
                for (Imovel i : resultadoPorPreco) {
                    for (Imovel i2 : resultadoPorDescricao)
                        if (i.equals(i2))
                            descricaoPreco.add(i);
                }
                return descricaoPreco;
            }
        }
        return null;
    }

    public Imovel inserirImovel(String descricao, String endereco, LocalMapa local, float preco, int idCorretor){

        return repositorioImovel.inserirImovel(descricao, endereco, local, preco, idCorretor);
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){

        return repositorioImovel.listarMeusImoveis(idCorretor);
    }

    public ArrayList<Imovel> listarMeusFavoritos(int idCliente){

        return repositorioImovel.listarMeusFavoritos(idCliente);
    }

    public Imovel alterarImovel(String descricao , String endereco , float preco, int idImovel){

        return repositorioImovel.alterarImovel(descricao, endereco, preco, idImovel);
    }

    public boolean excluirDaBusca(int idImovel){

        return repositorioImovel.excluirDaBusca(idImovel);
    }

    public boolean favoritarImovel(int idImovel , int idCliente){

        return repositorioImovel.favoritarImovel(idImovel, idCliente);
    }

}
