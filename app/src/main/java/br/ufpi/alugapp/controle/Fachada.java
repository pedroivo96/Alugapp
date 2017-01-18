package br.ufpi.alugapp.controle;

import android.content.Context;

import br.ufpi.alugapp.entidades.Visita;

/**
 * Created by wellyson on 05/12/16.
 */

public class Fachada {

    public ImovelController controladorImoveis;
    public UsuarioController controladorUsuarios;
    public PerguntaController controladorPerguntas;
    public VisitaController controladorVisitas;

    public Fachada(Context context){
        this.controladorImoveis = new ImovelController(context);
        this.controladorUsuarios = new UsuarioController(context);
        this.controladorPerguntas = new PerguntaController(context);
        this.controladorVisitas = new VisitaController(context);
    }
}
