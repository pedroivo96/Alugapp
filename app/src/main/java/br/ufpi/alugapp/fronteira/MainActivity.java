package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.ufpi.alugapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserir(View view){
        Intent intent = new Intent(this, TelaInserirImovel.class);
        startActivity(intent);
    }

    public void pesquisar(View view){
        Intent intent = new Intent(this, TelaPesquisarImovel.class);
        startActivity(intent);
    }
}
