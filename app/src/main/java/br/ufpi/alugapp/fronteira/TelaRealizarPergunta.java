package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaRealizarPergunta extends AppCompatActivity {

    private Fachada controles;
    private int idCliente;
    private Imovel imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_realizar_pergunta);

        this.imv = (Imovel) getIntent().getSerializableExtra("imovel");
        this.idCliente = getIntent().getIntExtra("idCliente", 0);

        TextView tIDImovel = (TextView) findViewById(R.id.tIDImovel);
        tIDImovel.setText(Integer.toString(this.imv.getIdImovel()));

        this.controles = new Fachada(this);
    }

    public void perguntar(View view){

        EditText edtPergunta = (EditText) findViewById(R.id.edtPergunta);
        String pergunta = edtPergunta.toString();

        if (!pergunta.isEmpty()) {

            if(controles.controladorPerguntas.perguntar(this.imv.getIdImovel(), idCliente, this.imv.idCorretor, pergunta)){
                Toast.makeText(this, "Pergunta realizada com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Erro. Tente novamente!", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Entrada Inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
