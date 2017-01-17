package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufpi.alugapp.R;

public class TelaSolicitarVisita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_solicitar_visita);
    }

    public void solicitarVisita(View view){

        EditText edtData = (EditText) findViewById(R.id.edtData);
        EditText edtHorario = (EditText) findViewById(R.id.edtHorario);
        EditText edtMensagem = (EditText) findViewById(R.id.edtMensagem);

        String padraoData = "dd/MM/yyyy";
        String padraoHorario = "HH:mm";
        SimpleDateFormat sdfData = new SimpleDateFormat(padraoData);
        SimpleDateFormat sdfHorario = new SimpleDateFormat(padraoHorario);

        sdfData.setLenient(false);
        sdfHorario.setLenient(false);

        String dataString = edtData.getText().toString();
        String horarioString = edtHorario.getText().toString();

        try {
            Date data = sdfData.parse(dataString);
            Date horario = sdfHorario.parse(horarioString);



            // Data formatada corretamente
        } catch (ParseException e) {
            // Erro de parsing!!
            e.printStackTrace();
        }
    }
}
