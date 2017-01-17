package br.ufpi.alugapp.fronteira;

import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Visita;

public class TelaResponderVisita extends AppCompatActivity {

    TextView tIDImovel, tData, tMensagem;
    Visita v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_responder_visita);

        this.v = (Visita) getIntent().getSerializableExtra("visita");

        TextView tIDImovel = (TextView) findViewById(R.id.tIDImovel);
        TextView tData = (TextView) findViewById(R.id.tData);
        TextView tMensagem = (TextView) findViewById(R.id.tMensagem);

        tIDImovel.setText(Integer.toString(v.getIdImovel()));
        tData.setText(v.getData().toString());
        tMensagem.setText(v.getMensagem());
    }

    public void enviarResposta(View view){

        EditText edtResposta = (EditText) findViewById(R.id.edtResposta);
        String resposta = edtResposta.getText().toString();

        if (resposta != "") {
            //chamar controlador
        }else{
            Toast.makeText(this, "Entrada Inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
