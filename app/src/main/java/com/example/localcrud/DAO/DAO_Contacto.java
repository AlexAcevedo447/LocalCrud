package com.example.localcrud.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.localcrud.models.Contacto;

import java.util.ArrayList;

public class DAO_Contacto {
    SQLiteDatabase db;
    ArrayList<Contacto> lista = new ArrayList<Contacto>();
    Contacto obj;
    String DBName = "DBContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    public DAO_Contacto(Context ctt){
        this.db = ctt.openOrCreateDatabase(DBName,Context.MODE_PRIVATE,null);
        this.db.execSQL(tabla);
    }

    public boolean insertar(Contacto cont){
        try{
            ContentValues contenedor = new ContentValues();

            contenedor.put("nombre",cont.getNombre());
            contenedor.put("telefono",cont.getTelefono());
            contenedor.put("email",cont.getCorreo());
            contenedor.put("edad",cont.getEdad());

            this.db.insert("contacto",null,contenedor);

            return true;

        }catch (Exception e){
            return false;
        }
    }

    public boolean eliminar(int id){
        return true;
    }

    public boolean editar(Contacto cont){
        try{
            ContentValues contenedor = new ContentValues();

            contenedor.put("nombre",cont.getNombre());
            contenedor.put("telefono",cont.getTelefono());
            contenedor.put("email",cont.getCorreo());
            contenedor.put("edad",cont.getEdad());

            this.db.update("contacto",contenedor,"id="+cont.getId(),null);

            return true;

        }catch (Exception e){
            return false;
        }
    }

    public ArrayList<Contacto> verTodos(){

        lista.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM contacto",null);

        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();

            do {
                lista.add(new Contacto(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4)));
            }while(cursor.moveToNext());


        }
        return lista;
    }

    public Contacto verUno(int position){

        Cursor cursor = db.rawQuery("SELECT * FROM contacto",null);
        cursor.moveToPosition(position);

        obj = new Contacto(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4)
        );

        return obj;
    }
}
