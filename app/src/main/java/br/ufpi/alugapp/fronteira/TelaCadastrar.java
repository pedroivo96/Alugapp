package br.ufpi.alugapp.fronteira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpi.alugapp.R;
import br.ufpi.alugapp.controle.Fachada;
import br.ufpi.alugapp.entidades.Cliente;
import br.ufpi.alugapp.entidades.Corretor;
import br.ufpi.alugapp.entidades.Usuario;

public class TelaCadastrar extends AppCompatActivity {

    private Fachada controles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        this.controles = new Fachada();
    }

    public void cadastrar(View view){

        EditText edtNome = ((EditText) findViewById(R.id.edtNome));
        EditText edtUsuario = ((EditText) findViewById(R.id.edtUsuario));
        EditText edtSenha = ((EditText) findViewById(R.id.edtSenha));
        EditText edtEmail= ((EditText) findViewById(R.id.edtEmail));
        EditText edtTelefone = ((EditText) findViewById(R.id.edtTelefone));

        String nome = edtNome.getText().toString();
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String email = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();

        Usuario user = controles.controladorUsuarios.cadastrar(nome, usuario, senha, email, telefone);

        if(user != null){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent;

            if(user instanceof Cliente){
                intent  = new Intent(this, TelaCliente.class);
            }else if(user instanceof Corretor){
                intent = new Intent(this, TelaCorretor.class);
            }else{
                intent  = new Intent(this, TelaDonoImobiliaria.class);
            }

            intent.putExtra("user", user);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuário Inválido!", Toast.LENGTH_LONG).show();
        }
    }
}
