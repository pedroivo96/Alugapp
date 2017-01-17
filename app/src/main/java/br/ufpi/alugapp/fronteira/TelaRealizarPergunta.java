package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;

public class TelaRealizarPergunta extends AppCompatActivity {

    private Fachada controles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_realizar_pergunta);

        this.controles = new Fachada();
    }

    public void perguntar(View view){

        EditText edtPergunta = (EditText) findViewById(R.id.edtPergunta);
        String pergunta = edtPergunta.toString();

        if (pergunta != "") {

            //chamar controlador

            //se ok
            finish();

        }else{
            Toast.makeText(this, "Entrada Inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
