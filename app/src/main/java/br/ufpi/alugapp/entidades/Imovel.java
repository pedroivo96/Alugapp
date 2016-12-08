package br.ufpi.alugapp.entidades;

/**
 * Created by wellyson on 05/12/16.
 */

public class Imovel {

    public String descricao;
    public String endereco;
    public double idImovel;
    public double idCorretor;
    public boolean visible;
    public LocalMapa local;

    public Imovel(){}

    public Imovel(String descricao, String endereco, LocalMapa local, double idCorretor){
        this.idImovel = idImovel;
        this.descricao = descricao;
        this.endereco = endereco;
        this.idCorretor = idCorretor;
        this.visible = true;
        this.local = local;
    }

    void setVisible(boolean visible){
        this.visible = visible;
    }
}
