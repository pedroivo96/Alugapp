package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaDetalhesImovelCorretor extends AppCompatActivity {

    private Imovel imv;
    private TextView tValor;
    private TextView tEndereco;
    private TextView tDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_imovel_corretor);

        tValor = (TextView) findViewById(R.id.tValor);
        tEndereco = (TextView) findViewById(R.id.tEndereco);
        tDescricao = (TextView) findViewById(R.id.tDescricao);

        this.imv = (Imovel) getIntent().getSerializableExtra("imovel");

        tValor.setText(Float.toString(imv.getPreco()));
        tEndereco.setText(imv.getEndereco());
        tDescricao.setText(imv.getDescricao());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_corretor, menu);
        return true;
    }

    public void verNoMapa(View v){
        //Intent intent = new Intent(this, .class);
        //intent.putExtra("imovel", this.imv);
        // startActivity(intent);
    }

    public void alterar(View v){
        Intent intent = new Intent(this, TelaAlterarImovel.class);
        intent.putExtra("imovel", this.imv);
        startActivity(intent);
    }
}
