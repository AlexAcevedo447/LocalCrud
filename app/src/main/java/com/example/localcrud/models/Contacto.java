package com.example.localcrud.models;

public class Contacto {
    int id = 0;
    String nombre = "";
    String telefofno = "";
    String correo = "";
    int edad = 0;

    public Contacto(){

    }

    public Contacto(int id) {
        this.id = id;
    }

    public Contacto(int id, String nombre, String telefofno, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefofno = telefofno;
        this.correo = correo;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefofno() {
        return telefofno;
    }

    public void setTelefofno(String telefofno) {
        this.telefofno = telefofno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
