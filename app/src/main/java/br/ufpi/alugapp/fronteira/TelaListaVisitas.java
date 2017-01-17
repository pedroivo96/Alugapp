package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Visita;

public class TelaListaVisitas extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayList<Visita> visitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_visitas);

        this.visitas = (ArrayList<Visita>) getIntent().getSerializableExtra("visitas");

        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new VisitaAdapter(this, visitas));

        //click item da lista
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int idx, long id)  {
        Visita v = this.visitas.get(idx);
        Intent intent = new Intent(this, TelaResponderVisita.class);
        intent.putExtra("visita", v);
        startActivity(intent);
    }
}
