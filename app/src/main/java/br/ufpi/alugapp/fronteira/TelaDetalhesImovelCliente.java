package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaDetalhesImovelCliente extends AppCompatActivity {

    private Imovel imv;
    private int idCliente;
    private TextView tValor;
    private TextView tEndereco;
    private TextView tDescricao;
    private TextView tIDCorretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_imovel_cliente);

        tValor = (TextView) findViewById(R.id.tValor);
        tEndereco = (TextView) findViewById(R.id.tEndereco);
        tDescricao = (TextView) findViewById(R.id.tDescricao);
        tIDCorretor = (TextView) findViewById(R.id.tIDCorretor);

        this.imv = (Imovel) getIntent().getSerializableExtra("imovel");
        this.idCliente = getIntent().getIntExtra("idCliente", 0);

        tValor.setText(Float.toString(imv.getPreco()));
        tEndereco.setText(imv.getEndereco());
        tDescricao.setText(imv.getDescricao());
        tIDCorretor.setText(Integer.toString(imv.getIdCorretor()));
    }

    public void verNoMapa(View v){
        Intent intent = new Intent(this, TelaMapa.class);
        intent.putExtra("comando", 2);
        intent.putExtra("latitude", this.imv.getLocal().latitude);
        intent.putExtra("longitude", this.imv.getLocal().longitude);
        startActivity(intent);
    }

    public void solicitarVisita(View v){
        Intent intent = new Intent(this, TelaSolicitarVisita.class);
        intent.putExtra("IDImovel", this.imv.getIdImovel());
        startActivity(intent);
    }

    public void perguntar(View v){
        Intent intent = new Intent(this, TelaRealizarPergunta.class);
        intent.putExtra("imovel", this.imv);
        intent.putExtra("IDCliente", this.idCliente);
        startActivity(intent);
    }
}
