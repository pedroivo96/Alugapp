package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import br.ufpi.alugapp.R;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.Usuario;

public class TelaCliente extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cliente);

        this.user = (Usuario) getIntent().getSerializableExtra("user");

        TextView tNome = (TextView) findViewById(R.id.tNome);
        TextView tEmail = (TextView) findViewById(R.id.tEmail);

        tNome.setText(user.getNome());
        tEmail.setText(user.getEmail());
    }

    public void pesquisar(View view){
        Intent intent = new Intent(this, TelaPesquisarImovel.class);
        startActivity(intent);
    }

    public void listarImoveisFavoritados(View view){
        //chmar controlador
        /*Intent intent = new Intent(this, TelaListaMeusImoveis.class);
        intent.putExtra("imoveis", imoveis);
        startActivity(intent);*/
    }

    public void logout(View view){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
        finish();
    }

}
