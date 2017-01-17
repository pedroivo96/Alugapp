package br.ufpi.alugapp.fronteira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Pergunta;

/**
 * Created by wellyson on 16/01/17.
 */

public class PerguntaAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Pergunta> perguntas;

    public PerguntaAdapter(Context context, ArrayList<Pergunta> perguntas) {
        this.context = context;
        this.perguntas = perguntas;
    }

    @Override
    public int getCount() {
        return perguntas != null ? perguntas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return perguntas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_perguntas, parent, false);
        // Faz findViewById das views que precisa atualizar
        TextView tIDImovel = (TextView) view.findViewById(R.id.tIDImovel);
        TextView tPergunta = (TextView) view.findViewById(R.id.tPergunta);
        // Atualiza os valores das views
        Pergunta p = perguntas.get(position);

        tIDImovel.setText(p.getIdImovel());
        tPergunta.setText(p.getPergunta());

        return view;
    }
}
