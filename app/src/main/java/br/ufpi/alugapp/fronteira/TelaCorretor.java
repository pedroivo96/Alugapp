package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaCorretor extends AppCompatActivity {

    private Fachada controles;
    private Button bListarImoveis;
    private Button bListarVisitas;
    private int idCorretor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_corretor);

        this.controles = new Fachada();
        bListarImoveis = (Button)findViewById(R.id.bListarImoveis);
        bListarVisitas = (Button)findViewById(R.id.bListarVisitas);

        bListarImoveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Imovel> meusImoveis = controles.controladorImoveis.listarMeusImoveis(idCorretor);

                Intent i = new Intent(getApplication(),TelaListarImoveis.class);
                i.putExtra("imoveis", meusImoveis);

                startActivity(i);
            }
        });

        bListarVisitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
