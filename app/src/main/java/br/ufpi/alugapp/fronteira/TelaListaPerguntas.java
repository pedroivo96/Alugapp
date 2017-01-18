package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Pergunta;

public class TelaListaPerguntas extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayList<Pergunta> perguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_perguntas);

        this.perguntas = (ArrayList<Pergunta>) getIntent().getSerializableExtra("perguntas");

        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new PerguntaAdapter(this, perguntas));

        //click item da lista
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int idx, long id)  {
        Pergunta p = this.perguntas.get(idx);
        Intent intent = new Intent(this, TelaResponderPergunta.class);
        intent.putExtra("pergunta", p);
        startActivity(intent);
    }
}
