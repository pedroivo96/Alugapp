package br.ufpi.alugapp.controle;

import java.util.ArrayList;

import br.ufpi.alugapp.entidades.Pergunta;
import br.ufpi.alugapp.repositorio.PerguntaRepository;

/**
 * Created by wellyson on 17/01/17.
 */

public class PerguntaController {

    private PerguntaRepository repositorioPergunta;

    public PerguntaController(){
        this.repositorioPergunta = new PerguntaRepository();
    }

    public ArrayList<Pergunta> listarPerguntas(int idCorretor){

        return repositorioPergunta.listarPerguntas(idCorretor);
    }

    public boolean responderPergunta(int idPergunta, String resposta){

        return repositorioPergunta.responderPergunta(idPergunta, resposta);
    }

    public boolean perguntar(int idImovel, int idCliente, int idCorretor, String pergunta){

        return repositorioPergunta.perguntar(idImovel, idCliente, idCorretor, pergunta);
    }
}
