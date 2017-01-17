package br.ufpi.alugapp.repositorio;

import java.util.ArrayList;
import java.util.Date;

import br.ufpi.alugapp.entidades.Visita;

/**
 * Created by wellyson on 17/01/17.
 */

public class VisitaRepository {

    public ArrayList<Visita> listarVisitas(int idCorretor){
        return null;
    }

    public boolean responderSolicitacaoVisita(int idVisita, String resposta){
        return false;
    }

    public boolean solicitarVisita(int idImovel, int idCliente, int idCorretor, Date data, String mensagem){
        return false;
    }
}
