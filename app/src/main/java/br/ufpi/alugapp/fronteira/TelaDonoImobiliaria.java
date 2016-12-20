package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.net.InterfaceAddress;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;

public class TelaDonoImobiliaria extends AppCompatActivity {

    private Fachada controles;
    private Button bListarImoveis;
    private Button bListarCorretores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dono_imobiliaria);

        controles = new Fachada();

        bListarImoveis = (Button) findViewById(R.id.bDonoListarImoveis);
        bListarCorretores = (Button) findViewById(R.id.bDonoListarCorretores);
    }
}
