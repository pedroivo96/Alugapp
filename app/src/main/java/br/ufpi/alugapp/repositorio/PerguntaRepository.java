package br.ufpi.alugapp.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.ufpi.alugapp.entidades.Pergunta;

/**
 * Created by wellyson on 17/01/17.
 */

public class PerguntaRepository {

    SQLite sqlite;
    SQLiteDatabase db;

    public PerguntaRepository(Context context){
        this.sqlite = new SQLite(context);
    }

    public ArrayList<Pergunta> listarPerguntas(int idCorretor){

        db = sqlite.getReadableDatabase();
        ArrayList<Pergunta> perguntas = new ArrayList<>();

        try {
            Cursor c = db.query("perguntas", null, "idCorretor = "+idCorretor,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Pergunta p = new Pergunta();

                    p.idPergunta = (int) c.getLong(c.getColumnIndex("_id"));
                    p.idImovel = c.getInt(c.getColumnIndex("idImovel"));
                    p.idCliente = c.getInt(c.getColumnIndex("idCliente"));
                    p.idCorretor = c.getInt(c.getColumnIndex("idCorretor"));
                    p.pergunta = c.getString(c.getColumnIndex("pergunta"));
                    p.resposta = c.getString(c.getColumnIndex("resposta"));

                    perguntas.add(p);

                } while (c.moveToNext());
            }

            return perguntas;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public boolean responderPergunta(int idPergunta, String resposta){

        db = sqlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("resposta", resposta);

            db.update("perguntas", values, "_id = "+idPergunta, null);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    public boolean perguntar(int idImovel, int idCliente, int idCorretor, String pergunta){

        db = sqlite.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("idImovel", idImovel);
            values.put("idCliente", idCliente);
            values.put("idCorretor", idCorretor);
            values.put("pergunta", pergunta);

            long id = db.insert("perguntas", "", values);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }
}
