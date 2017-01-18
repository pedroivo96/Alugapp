package br.ufpi.alugapp.repositorio;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.ufpi.alugapp.entidades.Cliente;
import br.ufpi.alugapp.entidades.Corretor;
import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.Usuario;

public class UsuarioRepository {

    SQLite sqlite;
    SQLiteDatabase db;

    public UsuarioRepository(Context context){
        this.sqlite = new SQLite(context);
    }

    public Usuario cadastrarCliente(String nome, String usuario, String senha, String email, String telefone){

        db = sqlite.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("nome", nome);
            values.put("usuario", usuario);
            values.put("senha", senha);
            values.put("email", email);
            values.put("telefone", telefone);
            values.put("tipo", 1);

            long id = db.insert("usuarios", "", values);

            return new Usuario(nome, usuario, senha, email, telefone, (int) id);

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Usuario cadastrarCorretor(String nome, String usuario, String senha, String email, String telefone){

        db = sqlite.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("nome", nome);
            values.put("usuario", usuario);
            values.put("senha", senha);
            values.put("email", email);
            values.put("telefone", telefone);
            values.put("tipo", 2);

            long id = db.insert("usuarios", "", values);

            return new Usuario(nome, usuario, senha, email, telefone, (int) id);

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Usuario login(String usuario, String senha){

        db = sqlite.getReadableDatabase();
        Usuario user = null;

        try {
            Cursor c = db.query("usuarios", null, "usuario = '"+usuario+"' and senha = '"+senha+"'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    int tipo = c.getInt(c.getColumnIndex("tipo"));
                    if(tipo == 1){
                        user = new Cliente();
                    }else{
                        user = new Corretor();
                    }
                    user.idUser = (int) c.getLong(c.getColumnIndex("_id"));
                    user.nome = c.getString(c.getColumnIndex("nome"));
                    user.usuario = c.getString(c.getColumnIndex("usuario"));
                    user.senha = c.getString(c.getColumnIndex("senha"));
                    user.email = c.getString(c.getColumnIndex("email"));
                    user.telefone = c.getString(c.getColumnIndex("telefone"));

                } while (c.moveToNext());
            }

            return user;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Usuario buscarPorUsuario(String usuario){

        db = sqlite.getReadableDatabase();
        Usuario user = null;

        try {
            Cursor c = db.query("usuarios", null, "usuario = '"+usuario+"'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    int tipo = c.getInt(c.getColumnIndex("tipo"));
                    if(tipo == 1){
                        user = new Cliente();
                    }else{
                        user = new Corretor();
                    }
                    user.idUser = (int) c.getLong(c.getColumnIndex("_id"));
                    user.nome = c.getString(c.getColumnIndex("nome"));
                    user.usuario = c.getString(c.getColumnIndex("usuario"));
                    user.senha = c.getString(c.getColumnIndex("senha"));
                    user.email = c.getString(c.getColumnIndex("email"));
                    user.telefone = c.getString(c.getColumnIndex("telefone"));

                } while (c.moveToNext());
            }

            return user;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Usuario buscarPorEmail(String email){

        db = sqlite.getReadableDatabase();
        Usuario user = null;

        try {
            Cursor c = db.query("usuarios", null, "email = '"+email+"'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    int tipo = c.getInt(c.getColumnIndex("tipo"));
                    if(tipo == 1){
                        user = new Cliente();
                    }else{
                        user = new Corretor();
                    }
                    user.idUser = (int) c.getLong(c.getColumnIndex("_id"));
                    user.nome = c.getString(c.getColumnIndex("nome"));
                    user.usuario = c.getString(c.getColumnIndex("usuario"));
                    user.senha = c.getString(c.getColumnIndex("senha"));
                    user.email = c.getString(c.getColumnIndex("email"));
                    user.telefone = c.getString(c.getColumnIndex("telefone"));

                } while (c.moveToNext());
            }

            return user;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

}
