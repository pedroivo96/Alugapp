package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.Usuario;
import br.ufpi.alugapp.entidades.Visita;

public class TelaCorretor extends AppCompatActivity {

    private Fachada controles;
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
    }

    public void inserirImovel(View view){
        Intent intent = new Intent(this, TelaMapa.class);
        intent.putExtra("comando", 1);
        intent.putExtra("IDCorretor", this.user.getIdUser());
        startActivity(intent);
    }

    public void listarMeusImoveis(View view){

        //chamar controlador
        //ArrayList<Imovel> imoveis =

        /*if(imoveis != null){
            Intent intent = new Intent(this, TelaListaMeusImoveis.class);
            intent.putExtra("imoveis", imoveis);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Nenhum imóvel encontrado!", Toast.LENGTH_SHORT).show();
        }*/

    }

    public void listarVisitas(View view){

        //chamar controlador
        //ArrayList<Visita> visitas =

        /*if(visitas != null) {
            Intent intent = new Intent(this, TelaListaVisitas.class);
            intent.putExtra("visitas", visitas);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Nenhuma visita encontrada!", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void listarPerguntas(View view){

        //chamar controlador
        //ArrayList<Pergunta> perguntas =

        /*if(perguntas != null) {
            Intent intent = new Intent(this, TelaListaPerguntas.class);
            intent.putExtra("perguntas", perguntas);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Nenhuma pergunta encontrada!", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void pesquisar(View view){
        Intent intent = new Intent(this, TelaPesquisarImovel.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
        finish();
    }
}
