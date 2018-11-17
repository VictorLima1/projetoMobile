package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {

    SQLiteDatabase db = null;
    DBHelper dbhelper = null;

    public DBAdapter(Context context){
        dbhelper = new DBHelper(context);
    }

    public void abreConexecao(){
        if(db == null)
            db = dbhelper.getWritableDatabase();
    }

    public void fecharConexao(){
        if(db != null && db.isOpen()){
            db.close();
            db = null;
        }
    }

    public void execComandoSql(String sql){
        abreConexecao();
        db.execSQL(sql);
        fecharConexao();
    }

    public Cursor execConsultSql(String sql){
        abreConexecao();
        return db.rawQuery(sql,null);
    }

}
