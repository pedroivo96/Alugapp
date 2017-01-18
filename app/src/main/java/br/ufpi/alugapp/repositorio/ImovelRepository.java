package br.ufpi.alugapp.repositorio;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import br.ufpi.alugapp.entidades.Imovel;
import br.ufpi.alugapp.entidades.LocalMapa;

//import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by wellyson on 05/12/16.
 */

public class ImovelRepository{

    SQLite sqlite;
    SQLiteDatabase db;

    public ImovelRepository(Context context){
        this.sqlite = new SQLite(context);
    }

    public Imovel inserirImovel(String descricao, String endereco, LocalMapa local, float preco, int idCorretor){

        db = sqlite.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("endereco", endereco);
            values.put("descricao", descricao);
            values.put("preco", preco);
            values.put("idCorretor", idCorretor);
            values.put("latitude", local.latitude);
            values.put("longitude", local.longitude);
            values.put("visible", 0);
            values.put("favoritado", 0);

            long id = db.insert("imoveis", "", values);

            return new Imovel(descricao, endereco, local, preco, idCorretor, (int) id);

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public ArrayList<Imovel> listarMeusImoveis(int idCorretor){

        db = sqlite.getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("imoveis", null, "idCorretor = "+idCorretor,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Imovel imv = new Imovel();

                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                    imoveis.add(imv);

                } while (c.moveToNext());
            }

            return imoveis;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public ArrayList<Imovel> listarMeusFavoritos(int idCliente){

        db = sqlite.getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("favoritos", null, "visible = 1 and idCliente = "+idCliente,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Imovel imv = new Imovel();

                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                    imoveis.add(imv);

                } while (c.moveToNext());
            }

            return imoveis;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Imovel alterarImovel(String descricao, String endereco, float preco, int idImovel){

        db = sqlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("endereco", endereco);
            values.put("descricao", descricao);
            values.put("preco", preco);

            db.update("imoveis", values, "_id = "+idImovel, null);

            return this.buscarPeloID(idImovel);

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public boolean excluirDaBusca(int idImovel){

        db = sqlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("visible", 1);

            db.update("imoveis", values, "_id = "+idImovel, null);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    public boolean favoritarImovel(int idImovel, int idCliente){

        db = sqlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("idImovel", idImovel);
            values.put("idCliente", idCliente);

            long id = db.insert("favoritos", "", values);

            return true;

        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    public ArrayList<Imovel> pesquisarEndereco(String endereco){
        db = sqlite.getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("imoveis", null, "visible = 1 and endereco like '%" + endereco + "%'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Imovel imv = new Imovel();

                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                    imoveis.add(imv);

                } while (c.moveToNext());
            }

            return imoveis;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public ArrayList<Imovel> pesquisarDescricao(String descricao){
        db = sqlite.getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("imoveis", null, "visible = 1 and descricao like '%" + descricao + "%'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Imovel imv = new Imovel();

                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                    imoveis.add(imv);

                } while (c.moveToNext());
            }

            return imoveis;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public ArrayList<Imovel> pesquisarFaixaPreco(float faixaPreco){
        db = sqlite.getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("imoveis", null, "visible = 1 and preco <= "+faixaPreco,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    Imovel imv = new Imovel();

                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                    imoveis.add(imv);

                } while (c.moveToNext());
            }

            return imoveis;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

    public Imovel buscarPeloID(int idImovel){

        SQLiteDatabase db = sqlite.getReadableDatabase();
        Imovel imv = new Imovel();

        try {
            Cursor c = db.query("imoveis", null, "_id = "+idImovel,
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    imv.idImovel = (int) c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getDouble(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getDouble(c.getColumnIndex("longitude"));
                    imv.preco = c.getFloat(c.getColumnIndex("preco"));
                    imv.visible = c.getInt(c.getColumnIndex("visible")) != 0 ? true : false;
                    imv.favoritado = c.getInt(c.getColumnIndex("favoritado")) != 0 ? true : false;

                } while (c.moveToNext());
            }

            return imv;

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }
    }

}
