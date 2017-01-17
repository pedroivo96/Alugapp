package br.ufpi.alugapp.repositorio;


import android.util.Log;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.LocalMapa;

//import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelRepository{

    public Imovel inserirImovel(String descricao, String endereco, LocalMapa local, float preco, int idCorretor){
        return null;
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){
        return null;
    }

    public ArrayList<Imovel> listarMeusFavoritos(int idCliente){
        return null;
    }

    public Imovel alterarImovel(String descricao, String endereco, float preco, int idImovel){
        return null;
    }

    public boolean excluirDaBusca(int idImovel){
        return false;
    }

    public boolean favoritarImovel(int idImovel, int idCliente){
        return false;
    }

    public ArrayList<Imovel> pesquisarEndereco(String endereco){
        return null;
    }

    public ArrayList<Imovel> pesquisarDescricao(String descricao){
        return null;
    }

    public ArrayList<Imovel> pesquisarFaixaPreco(float faixaPreco){
        return null;
    }

}
