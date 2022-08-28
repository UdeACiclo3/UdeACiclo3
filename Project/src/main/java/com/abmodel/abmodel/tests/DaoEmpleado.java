package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Empleado;

import java.util.ArrayList;

public class TestEmpleadoController {
    private Empleado empleado;

    public void crearEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public Empleado getEmpleado(){
        return empleado;
    }
}
