package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.LocalMapa;

public class TelaInserirImovel extends AppCompatActivity {

    private Fachada controles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inserir_imovel);



        EditText edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        EditText edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        EditText edtPreco = (EditText) findViewById(R.id.edtPreco);
        TextView tIDCorretor = (TextView) findViewById(R.id.tIDCorretor);

        Intent i = getIntent();

        edtEndereco.setText(i.getStringExtra("endereco"));

        tIDCorretor.setText(i.getStringExtra("IDCorretor").toString());

        LocalMapa lm = new LocalMapa(i.getDoubleExtra("latitude", -1) , i.getDoubleExtra("longitude", -1));

        controles.controladorImoveis.inserirImovel(edtEndereco.getText().toString(),
                                                   edtDescricao.getText().toString(),
                                                   i.getSerializableExtra("localMapa"),
                                                   Float.parseFloat(edtPreco.getText().toString()),
                                                   i.getIntExtra("IDCorretor", -1));
    }

}
