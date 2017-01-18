package br.ufpi.alugapp.controle;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

import br.ufpi.alugapp.entidades.Visita;
import br.ufpi.alugapp.repositorio.VisitaRepository;

/**
 * Created by wellyson on 17/01/17.
 */

public class VisitaController {

    private VisitaRepository repositorioVisita;

    public VisitaController(Context context){
        this.repositorioVisita = new VisitaRepository(context);
    }

    public ArrayList<Visita> listarVisitas(int idCorretor){

        return repositorioVisita.listarVisitas(idCorretor);
    }

    public boolean responderSolicitacaoVisita(int idVisita, String resposta){

        return repositorioVisita.responderSolicitacaoVisita(idVisita, resposta);
    }

    public boolean solicitarVisita(int idImovel, int idCliente, int idCorretor, Date data, String mensagem){

        return repositorioVisita.solicitarVisita(idImovel, idCliente, idCorretor, data, mensagem);
    }

}
