package br.ufpi.alugapp.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import br.ufpi.alugapp.entidades.Visita;

/**
 * Created by wellyson on 17/01/17.
 */

public class VisitaRepository {

    SQLite sqlite;
    SQLiteDatabase db;

    public VisitaRepository(Context context){
        this.sqlite = new SQLite(context);
    }

    public ArrayList<Visita> listarVisitas(int idCorretor){

        db = sqlite.getReadableDatabase();
        ArrayList<Visita> visitas = new ArrayList<>();

        try {
            Cursor c = db.query("visitas", null, "idCorretor = "+idCorretor,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Visita v = new Visita();

                    v.idVisita = (int) c.getLong(c.getColumnIndex("_id"));
                    v.idImovel = c.getInt(c.getColumnIndex("idImovel"));
                    v.idCliente = c.getInt(c.getColumnIndex("idCliente"));
                    v.idCorretor = c.getInt(c.getColumnIndex("idCorretor"));
                    v.mensagem = c.getString(c.getColumnIndex("mensagem"));
                    v.resposta = c.getString(c.getColumnIndex("resposta"));
                    v.data  = new Date(c.getLong(c.getColumnIndex("data")));

                    visitas.add(v);

                } while (c.moveToNext());
            }

            return visitas;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public boolean responderSolicitacaoVisita(int idVisita, String resposta){

        db = sqlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("resposta", resposta);

            db.update("visitas", values, "_id = "+idVisita, null);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    public boolean solicitarVisita(int idImovel, int idCliente, int idCorretor, Date data, String mensagem){

        db = sqlite.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("idImovel", idImovel);
            values.put("idCliente", idCliente);
            values.put("idCorretor", idCorretor);
            values.put("mensagem", mensagem);
            values.put("data", data.getTime());

            long id = db.insert("visitas", "", values);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

}
