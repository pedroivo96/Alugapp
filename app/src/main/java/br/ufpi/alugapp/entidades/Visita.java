package br.ufpi.alugapp.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wellyson on 12/01/17.
 */

public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;

    int idVisita;
    int idImovel;
    int idCliente;
    int idCorretor;
    Date data;
    String mensagem;
    String resposta;

    public Visita(int idImovel , int idCliente , Date data , String mensagem , String resposta , int idVisita){
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.data = data;
        this.mensagem = mensagem;
        this.resposta = resposta;
        this.idVisita = idVisita;
    }


    public int getIdCorretor() {
        return idCorretor;
    }

    public void setIdCorretor(int idCorretor) {
        this.idCorretor = idCorretor;
    }

    public int getIdVisita() {
        return idVisita;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
