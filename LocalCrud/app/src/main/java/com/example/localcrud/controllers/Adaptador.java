package com.example.localcrud.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.localcrud.DAO.DAO_Contacto;
import com.example.localcrud.R;
import com.example.localcrud.models.Contacto;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Contacto> lista;
    private DAO_Contacto dao;
    private Contacto obj = null;
    private Activity a;

    private TextView nombre, edad, telefono, email;
    private Button editar,eliminar;

    public Adaptador(ArrayList<Contacto>list, Activity ac, DAO_Contacto dao_contacto){
        this.lista = list;
        this.a = ac;
        this.dao = dao_contacto;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Contacto getItem(int id) {
        obj = lista.get(id);
        return null;
    }

    @Override
    public long getItemId(int position) {
        obj = lista.get(position);
        return obj.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        //validamos si la vista existe
        if(v == null){
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item,null);
        }

        //Obtenemos objeto de tipo contacto
        this.obj = this.lista.get(position);

        this.enlazarElementosVista(v);

        this.llenarCamposVista(this.obj,position);

        this.eventosBotonesVista();

        return v;
    }

    private void enlazarElementosVista(View v){

        //llamamos los TV de la vista
        this.nombre = v.findViewById(R.id.t_nombre);
        this.edad = v.findViewById(R.id.t_edad);
        this.telefono = v.findViewById(R.id.t_telefono);
        this.email = v.findViewById(R.id.t_email);
        //llamamos los botones de la vista
        this.editar =  v.findViewById(R.id.editar);
        this.eliminar =  v.findViewById(R.id.eliminar);
    }

    private void llenarCamposVista(Contacto c, int position){
        //Llenar Textviews
        this.nombre.setText(c.getNombre());
        this.edad.setText(""+c.getEdad());
        this.telefono.setText(c.getTelefono());
        this.email.setText(c.getCorreo());

        //Colocar etiquetas a los botones
        this.editar.setTag(position);
        this.eliminar.setTag(position);
    }

    private void eventosBotonesVista(){
        this.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        this.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
