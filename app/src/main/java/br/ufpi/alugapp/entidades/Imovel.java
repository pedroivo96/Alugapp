package br.ufpi.alugapp.entidades;

/**
 * Created by wellyson on 05/12/16.
 */

public class Imovel {

    String descricao;
    String endereco;
    int idImovel;
    int idCorretor;
    boolean visible;
    LocalMapa local;

    public Imovel(int idImovel, String descricao, String endereco, LocalMapa local, int idCorretor){
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
