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
        db.execSQL("create table if not exists imoveis (_id integer primary key autoincrement, endereco text, descricao text, " +
                "idCorretor integer, latitude real, longitude real, preco real, visible integer, favoritado integer);");

        db.execSQL("create table if not exists usuarios (_id integer primary key autoincrement, nome text, usuario text, senha text," +
                "email text, telefone text, tipo integer);");

        db.execSQL("create table if not exists perguntas (_id integer primary key autoincrement, idImovel integer, idCliente integer," +
                "idCorretor integer, pergunta text, resposta text);");

        db.execSQL("create table if not exists visitas (_id integer primary key autoincrement, idImovel integer, idCliente integer," +
                "idCorretor integer, data integer, mensagem text, resposta text);");

        db.execSQL("create table if not exists favoritos (idImovel integer, idCliente integer);");

        Log.d(TAG, "criou a databases!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

