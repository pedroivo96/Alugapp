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
    public Date data;
    public String pergunta;
    public String resposta;

    public Pergunta(int idPergunta , int idImovel, int idCliente , Date data , String pergunta , String resposta){
        this.idPergunta = idPergunta;
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.data = data;
        this.pergunta = pergunta;
        this.resposta = resposta;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
