package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.Usuario;

public class TelaCorretor extends AppCompatActivity {

    private Fachada controles;
    private Button bListarImoveis;
    private Button bListarVisitas;
    private int idCorretor;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_corretor);

        this.controles = new Fachada();
        this.user = (Usuario) getIntent().getSerializableExtra("user");

        TextView tNome = (TextView) findViewById(R.id.tNome);
        TextView tEmail = (TextView) findViewById(R.id.tEmail);

        tNome.setText(user.getNome());
        tEmail.setText(user.getEmail());

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
