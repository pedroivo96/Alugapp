package br.ufpi.alugapp.repositorio;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.LocalMapa;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelRepository{

    private String imovelID = "0";

    ArrayList<Imovel> pesquisar(String pesquisa){
        final ArrayList<Imovel> imoveis = new ArrayList<>();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Imovel imovel = dataSnapshot.getValue(Imovel.class);

                imoveis.add(imovel);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

            }
        };

        Firebase.mDatabase.child("imoveis").equalTo(pesquisa).addListenerForSingleValueEvent(postListener);

        return imoveis;
    }

    Imovel inserirImovel(String descricao, String endereco, LocalMapa local, double idCorretor, float preco){
        Imovel imovel = new Imovel(descricao, endereco, local, idCorretor, preco);

        Firebase.mDatabase.child("imoveis").child(imovelID).setValue(imovel);

        return imovel;
    }

    ArrayList<Imovel> listarMeusImoveis(double idCorretor){

        final ArrayList<Imovel> imoveis = new ArrayList<>();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Imovel imovel = dataSnapshot.getValue(Imovel.class);

                imoveis.add(imovel);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

            }
        };

        Firebase.mDatabase.child("imoveis").equalTo(idCorretor).addListenerForSingleValueEvent(postListener);
        return imoveis;
    }

}
