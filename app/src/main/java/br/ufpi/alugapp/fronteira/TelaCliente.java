package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.Usuario;

public class TelaCliente extends AppCompatActivity {

    private Usuario user;
    Fachada controladores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cliente);

        this.controladores = new Fachada(this);

        this.user = (Usuario) getIntent().getSerializableExtra("user");

        TextView tNome = (TextView) findViewById(R.id.tNome);
        TextView tEmail = (TextView) findViewById(R.id.tEmail);

        tNome.setText(user.getNome());
        tEmail.setText(user.getEmail());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_usuario, menu);
        return true;
    }

    public void pesquisar(View view){
        Intent intent = new Intent(this, TelaPesquisarImovel.class);
        intent.putExtra("idCliente", this.user.getIdUser());
        startActivity(intent);
    }

    public void listarImoveisFavoritados(View view){

        ArrayList<Imovel> imoveis = controladores.controladorImoveis.listarMeusFavoritos(this.user.getIdUser());

        if(imoveis != null){
            if(!imoveis.isEmpty()){
                Intent intent = new Intent(this, TelaImoveisFavoritos.class);
                intent.putExtra("imoveis", imoveis);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Nenhum imóvel encontrado!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Erro. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }

    public void logout(View view){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
        finish();
    }

}
