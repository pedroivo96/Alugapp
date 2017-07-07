package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.LocalMapa;

public class TelaInserirImovel extends AppCompatActivity {

    private Fachada controles;
    EditText edtEndereco;
    EditText edtDescricao;
    EditText edtPreco;
    TextView tIDCorretor;
    LocalMapa lm;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inserir_imovel);

        this.controles = new Fachada(this);

        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtPreco = (EditText) findViewById(R.id.edtPreco);
        tIDCorretor = (TextView) findViewById(R.id.tIDCorretor);

        i = getIntent();

        edtEndereco.setText(i.getStringExtra("endereco"));

        lm = new LocalMapa(i.getDoubleExtra("latitude", -1) , i.getDoubleExtra("longitude", -1));

    }

    public void inserirImovel(View v){

        if(edtDescricao.getText().toString().isEmpty() || edtEndereco.getText().toString().isEmpty() ||
                edtPreco.getText().toString().isEmpty()){
            Toast.makeText(this, "Entrada Inválida", Toast.LENGTH_SHORT).show();
        }
        else{
            Imovel imv = controles.controladorImoveis.inserirImovel(edtDescricao.getText().toString(), edtEndereco.getText().toString(), lm, Float.parseFloat(edtPreco.getText().toString()), i.getIntExtra("IDCorretor", -1));

            if(imv != null){
                Intent intent = new Intent(this, TelaDetalhesImovelCorretor.class);
                intent.putExtra("imovel", imv);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Erro. Tente Novamente", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
