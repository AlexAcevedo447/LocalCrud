package com.example.localcrud.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.localcrud.models.Contacto;

import java.util.ArrayList;

public class DAO_Contacto {
    SQLiteDatabase db;
    ArrayList<Contacto> lista;
    Contacto obj;
    private Context ct;
    String DBName = "DBContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    public DAO_Contacto(Context ctt){
        this.ct = ctt;
        this.db = ctt.openOrCreateDatabase(DBName,Context.MODE_WORLD_WRITEABLE,null);
        this.db.execSQL(tabla);
    }

    public boolean insertar(Contacto cont){

        return true;
    }

    public boolean eliminar(int id){
        return true;
    }

    public boolean editar(Contacto cont){
        return true;
    }

    public ArrayList<Contacto> verTodos(){
        return this.lista;
    }

    public Contacto verUno(){
        return this.obj;
    }
}
