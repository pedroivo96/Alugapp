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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufpi.alugapp.R;

public class TelaSolicitarVisita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_solicitar_visita);

        int IDimovel = getIntent().getIntExtra("IDImovel", 0);
        TextView tIDImovel = (TextView) findViewById(R.id.tIDImovel);
        tIDImovel.setText(Integer.toString(IDimovel));
    }

    public void solicitarVisita(View view){

    //    final EditText edtData = (EditText) findViewById(R.id.edtData);
     //   EditText edtHorario = (EditText) findViewById(R.id.edtHorario);
        EditText edtMensagem = (EditText) findViewById(R.id.edtMensagem);
        CalendarView calendario = (CalendarView) findViewById(R.id.calendar) ;
        Spinner spHoras = (Spinner) findViewById(R.id.spHoras);
        Spinner spMinutos = (Spinner) findViewById(R.id.spMinutos);

        final Date data = new Date();

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
             //   edtData.setText("Data : " + i + " / " + i1 + " / " + i2);
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
}
