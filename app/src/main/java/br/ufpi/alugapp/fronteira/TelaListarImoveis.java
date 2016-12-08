package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaListarImoveis extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Imovel> imoveis;
    private ListView listView;
    private CursorAdapter dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_imoveis);

        this.imoveis = (ArrayList<Imovel>) getIntent().getSerializableExtra("imoveis");

        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new ImovelAdapter(this, imoveis));

        //click item da lista
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int idx, long id) {
        Imovel imv = this.imoveis.get(idx);
        Intent intent = new Intent(this, TelaDetalhesImovel.class);
        intent.putExtra("imovel", imv);
        startActivity(intent);
    }

}
