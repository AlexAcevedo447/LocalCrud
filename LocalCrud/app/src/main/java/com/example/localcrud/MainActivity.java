package com.example.localcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.localcrud.DAO.DAO_Contacto;
import com.example.localcrud.controllers.Adaptador;
import com.example.localcrud.models.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //acceso a datos
    private Contacto c;
    private DAO_Contacto obj_cont = null;
    private Adaptador adaptador = null;
    private ArrayList<Contacto>list = null;

    //elementos vista-dialogo
    private Button guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.obj_cont = new DAO_Contacto(this);
        this.list = obj_cont.verTodos();
        this.adaptador = new Adaptador(this.list,this,this.obj_cont);

        //acceso a vistas y elementos de vista
        ListView lista = findViewById(R.id.lista);
        Button agregar = findViewById(R.id.agregar);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //vista previa del registro vista.xml
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //confirmacion de agregar dialogo.xml
                Dialog dialogo = new Dialog(MainActivity.this);

                dialogo.setTitle("Nuevo Registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();

                final EditText nombre = dialogo.findViewById(R.id.nombre);
                final EditText telefono = dialogo.findViewById(R.id.telefono);
                final EditText email = dialogo.findViewById(R.id.email);
                final EditText edad = dialogo.findViewById(R.id.edad);

                guardar = dialogo.findViewById(R.id.agregar);
                cancelar = dialogo.findViewById(R.id.cancelar);

                //eventos a botones de dialogo
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String nm = nombre.getText().toString();
                            String tl = telefono.getText().toString();
                            String corr = email.getText().toString();
                            int age = Integer.parseInt(edad.getText().toString());

                            c = new Contacto(nm,tl,corr,age);

                            try {
                                obj_cont.insertar(c);
                                Toast.makeText(getApplication(),"Registro guardado",Toast.LENGTH_LONG);

                            }catch (Exception e){
                                Toast.makeText(getApplication(),"No se pudo insertar el registro",Toast.LENGTH_LONG);
                            }
                            list = obj_cont.verTodos();

                            adaptador.notifyDataSetChanged();
                            dialogo.dismiss();


                        }catch (Exception e){
                            Toast.makeText(getApplication(),"Debes ingresar todos los datos", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       dialogo.dismiss();
                    }
                });
            }
        });


    }

}