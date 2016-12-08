package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;

public class TelaPesquisarImovel extends AppCompatActivity {

    private Fachada controles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisar_imovel);

        this.controles = new Fachada();
    }

    public void pesquisar(View view){
        TextView tPesquisa = (TextView) findViewById(R.id.tPesquisa);
        String pesquisa = tPesquisa.getText().toString();
        ArrayList<Imovel> imoveis = controles.controladorImoveis.pesquisarImoveis(pesquisa);

        if(imoveis == null){
            Toast.makeText(this, "Nenhum imóvel encontrado!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, TelaListarImoveis.class);
            intent.putExtra("imoveis", imoveis);
            startActivity(intent);
        }
    }
}
