package br.ufpi.alugapp.fronteira;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;

/**
 * Created by wellyson on 08/12/16.
 */

public class ImovelAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Imovel> imoveis;

    public ImovelAdapter(Context context, ArrayList<Imovel> imoveis) {

        this.context = context;
        this.imoveis = imoveis;
    }

    @Override
    public int getCount() {
        return imoveis != null ? imoveis.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return imoveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_resultado, parent, false);
        // Faz findViewById das views que precisa atualizar
        TextView descricao = (TextView) view.findViewById(R.id.tDescricao);
        TextView endereco = (TextView) view.findViewById(R.id.tEndereco);
        TextView preco = (TextView) view.findViewById(R.id.tPreco);
        // Atualiza os valores das views
        Imovel imv = imoveis.get(position);
        descricao.setText(imv.descricao);
        endereco.setText(imv.endereco);
        preco.setText(Float.toString(imv.preco));

        return view;
    }
}
