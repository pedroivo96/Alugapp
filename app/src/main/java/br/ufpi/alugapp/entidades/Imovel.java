package br.ufpi.alugapp.entidades;

import java.io.Serializable;

/**
 * Created by wellyson on 05/12/16.
 */

public class Imovel implements Serializable{

    private static final long serialVersionUID = 1L;

    public String descricao;
    public String endereco;
    public int idImovel;
    public int idCorretor;
    public boolean visible;
    public LocalMapa local;
    public float preco;

    public Imovel(String descricao, String endereco, LocalMapa local, float preco, int idCorretor, int idImovel){
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.endereco = endereco;
        this.idCorretor = idCorretor;
        this.visible = true;
        this.local = local;
        this.preco = preco;
    }

    void setVisible(boolean visible){
        this.visible = visible;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public int getIdCorretor() {
        return idCorretor;
    }

    public void setIdCorretor(int idCorretor) {
        this.idCorretor = idCorretor;
    }

    public boolean isVisible() {
        return visible;
    }

    public LocalMapa getLocal() {
        return local;
    }

    public void setLocal(LocalMapa local) {
        this.local = local;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
