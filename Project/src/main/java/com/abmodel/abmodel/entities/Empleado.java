package com.abmodel.abmodel.entities;

public class Empleado {

    //Atributos
    private long id;
    private String nombre, email, empresa, rol;

    //Constructor
    public Empleado(long id, String nombre, String email, String empresa, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.empresa = empresa;
        this.rol = rol;
    }

    //Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
