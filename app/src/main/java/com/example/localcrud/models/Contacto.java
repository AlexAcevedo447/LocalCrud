package com.example.localcrud.models;

public class Contacto {
    int id = 0;
    String nombre = "";
    String telefono = "";
    String correo = "";
    int edad = 0;

    public Contacto() {

    }

    public Contacto(int id) {
        this.id = id;
    }

    public Contacto(String nombre, String telefono, String correo, int edad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
    }

    public Contacto(int id, String nombre, String telefono, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
