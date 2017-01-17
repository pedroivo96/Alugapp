package br.ufpi.alugapp.fronteira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Visita;

/**
 * Created by wellyson on 16/01/17.
 */

public class VisitaAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Visita> visitas;

    public VisitaAdapter(Context context, ArrayList<Visita> visitas) {
        this.context = context;
        this.visitas = visitas;
    }

    @Override
    public int getCount() {
        return visitas != null ? visitas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return visitas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_visitas, parent, false);
        // Faz findViewById das views que precisa atualizar
        TextView tIDImovel = (TextView) view.findViewById(R.id.tIDImovel);
        TextView tData = (TextView) view.findViewById(R.id.tData);
        TextView tMensagem = (TextView) view.findViewById(R.id.tMensagem);
        // Atualiza os valores das views
        Visita v = visitas.get(position);
        tIDImovel.setText(v.getIdImovel());
        tData.setText(v.getData().toString());
        tMensagem.setText(v.getMensagem());

        return view;
    }
}
