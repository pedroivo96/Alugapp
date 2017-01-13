package br.ufpi.alugapp.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import br.ufpi.alugapp.entidades.Imovel;

/**
 * Created by wellyson on 07/12/16.
 */

public class SQLite  extends SQLiteOpenHelper {

    private static final String TAG = "sql";

    // Nome do banco
    private static final String NOME_BANCO = "alugapp";
    private static final int VERSAO_BANCO = 1;

    public SQLite(Context context) {
        // context, nome do banco, factory, versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists imovel (_id integer primary key autoincrement, endereco text, descricao text, " +
                "idCorretor integer, latitude real, longitude real);");
        Log.d(TAG, "criou a database!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean inserirImovel(Imovel imv){

        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("endereco", imv.endereco);
            values.put("descricao", imv.descricao);
            values.put("idCorretor", imv.idCorretor);
            values.put("latitude", imv.local.latitude);
            values.put("longitude", imv.local.longitude);

            long id = db.insert("imovel", "", values);
        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }

        return true;
    }

    public ArrayList<Imovel> pesquisarImoveis(String pesquisa){

        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Imovel> imoveis = new ArrayList<>();

        try {
            Cursor c = db.query("imovel", null, "descricao like '%" + pesquisa + "%' or endereco like '%"+ pesquisa + "%'",
                    null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    /*Imovel imv = new Imovel();
                    imoveis.add(imv);

                    imv.idImovel = c.getLong(c.getColumnIndex("_id"));
                    imv.descricao = c.getString(c.getColumnIndex("descricao"));
                    imv.endereco = c.getString(c.getColumnIndex("endereco"));
                    imv.local.latitude = c.getLong(c.getColumnIndex("latitude"));
                    imv.local.longitude = c.getLong(c.getColumnIndex("longitude"));*/

                } while (c.moveToNext());
            }

        }catch (Exception e){
            return null;
        }finally {
            db.close();
        }

        return imoveis;
    }

}

