package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;

public class TelaSolicitarVisita extends AppCompatActivity {

    private Fachada controles;
    private int IDImovel;
    private int IDCliente;
    private int IDCorretor;
    private Date data;
    private TextView tIDImovel;
    private EditText edtMensagem;
    private CalendarView calendario;
    private Spinner spHoras;
    private Spinner spMinutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_solicitar_visita);

        controles = new Fachada(this);

        IDImovel = getIntent().getIntExtra("IDImovel", 0);
        IDCliente = getIntent().getIntExtra("IDCliente", 0);
        IDCorretor = getIntent().getIntExtra("IDCorretor", 0);

        tIDImovel = (TextView) findViewById(R.id.tIDImovel);
        tIDImovel.setText(Integer.toString(IDImovel));

        edtMensagem = (EditText) findViewById(R.id.edtMensagem);
        calendario = (CalendarView) findViewById(R.id.calendar) ;
        spHoras = (Spinner) findViewById(R.id.spHoras);
        spMinutos = (Spinner) findViewById(R.id.spMinutos);

        data = new Date();

        final String[] horas = new String[24];
        final String[] minutos = new String[60];

        for(int i = 0; i < 24 ; i++){
            horas[i] = Integer.toString(i);
        }
        for(int i = 0 ; i < 60 ; i++){
            minutos[i] = Integer.toString(i);
        }

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                data.setDate(i);
                data.setMonth(i1);
                data.setYear(i2);
            }
        });

        ArrayAdapter<String> adapterHoras = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, horas);
        ArrayAdapter<String> adapterMinutos = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item, minutos);

        spHoras.setAdapter(adapterHoras);
        spMinutos.setAdapter(adapterMinutos);

        spHoras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int hora = Integer.parseInt(horas[i]);

                data.setHours(hora);
            }
        });

        spMinutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int minuto = Integer.parseInt(minutos[i]);

                data.setMinutes(minuto);
            }
        });
    }

    public void solicitarVisita(View view){

        if(edtMensagem.getText().toString().isEmpty() == false){

            if(controles.controladorVisitas.solicitarVisita(IDImovel , IDCliente , IDCorretor , data , edtMensagem.getText().toString())){
                Toast.makeText(this, "Solicitação Enviada com Sucesso", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Erro ! Tente Novamente", Toast.LENGTH_SHORT).show();
            }


        }
        else{
            Toast.makeText(this, "Entrada Inválida", Toast.LENGTH_SHORT).show();
        }

    }
}
