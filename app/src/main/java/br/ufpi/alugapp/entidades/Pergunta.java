package br.ufpi.alugapp.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wellyson on 12/01/17.
 */

public class Pergunta implements Serializable {

    private static final long serialVersionUID = 1L;

    public int idPergunta;
    public int idImovel;
    public int idCliente;
    public int idCorretor;
    public String pergunta;
    public String resposta;

    public Pergunta(){}

    public Pergunta(int idPergunta , int idImovel, int idCliente , int idCorretor, String pergunta , String resposta){
        this.idPergunta = idPergunta;
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.idCorretor = idCorretor;
    }

    public int getIdCorretor() {
        return idCorretor;
    }

    public void setIdCorretor(int idCorretor) {
        this.idCorretor = idCorretor;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
