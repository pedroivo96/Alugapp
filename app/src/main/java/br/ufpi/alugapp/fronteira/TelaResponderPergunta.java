package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Pergunta;

public class TelaResponderPergunta extends AppCompatActivity {

    Fachada controles;
    TextView tIDImovel, tPergunta;
    Pergunta p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_responder_pergunta);

        this.controles = new Fachada(this);

        this.p = (Pergunta) getIntent().getSerializableExtra("pergunta");

        tIDImovel = (TextView) findViewById(R.id.tIDImovel);
        tPergunta = (TextView) findViewById(R.id.tPergunta);

        tIDImovel.setText(Integer.toString(p.getIdImovel()));
        tPergunta.setText(p.getPergunta());

    }

    public void enviarResposta(View view){

        EditText edtResposta = (EditText) findViewById(R.id.edtResposta);

        String resposta = edtResposta.getText().toString();

        if (!resposta.isEmpty()) {
            if(controles.controladorPerguntas.responderPergunta(p.getIdPergunta(), resposta)){
                Toast.makeText(this, "Resposta cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Erro. Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Entrada Inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
