package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        EditText tEndereco = (EditText) findViewById(R.id.tEndereco);
        String endereco = tEndereco.getText().toString();
        EditText tDescricao = (EditText) findViewById(R.id.tDescricao);
        String descricao = tDescricao.getText().toString();
        EditText tFaixaPreco = (EditText) findViewById(R.id.tFaixaPreco);
        float faixaPreco = Float.parseFloat(tFaixaPreco.getText().toString());

        ArrayList<Imovel> imoveis = controles.controladorImoveis.pesquisar(endereco, descricao, faixaPreco);

        if(imoveis == null){
            Toast.makeText(this, "Nenhum imóvel encontrado!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, TelaResultadoPesquisa.class);
            intent.putExtra("imoveis", imoveis);
            startActivity(intent);
        }
    }
}
