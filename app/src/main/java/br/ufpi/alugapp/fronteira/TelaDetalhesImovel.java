package br.ufpi.alugapp.fronteira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaDetalhesImovel extends AppCompatActivity {

    private Imovel imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_imovel);

        this.imv = (Imovel) getIntent().getSerializableExtra("imovel");

        Toast.makeText(this, imv.endereco, Toast.LENGTH_SHORT).show();
    }
}
