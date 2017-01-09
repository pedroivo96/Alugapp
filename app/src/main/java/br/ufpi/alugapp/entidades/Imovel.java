package br.ufpi.alugapp.entidades;

import java.io.Serializable;

/**
 * Created by wellyson on 05/12/16.
 */

public class Imovel implements Serializable{

    private static final long serialVersionUID = 1L;

    public String descricao;
    public String endereco;
    public double idImovel;
    public double idCorretor;
    public boolean visible;
    public LocalMapa local;
    public float preco;

    public Imovel(){}

    public Imovel(String descricao, String endereco, LocalMapa local, double idCorretor, float preco){
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
}
