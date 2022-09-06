package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.Gestores.GestorEmpleado;
import com.abmodel.abmodel.entities.Empleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class EmpleadoController {

    // Controlador info
    private GestorEmpleado gestorEmpleado = new GestorEmpleado(); // De la clase GestorEmpleado que contiene los empleados

    @GetMapping("/empleado") //Va a traer todos los usuarios
    public ResponseEntity<ArrayList<Empleado>> getEmpleados(){   //Vamos a responder una entidad
        return new ResponseEntity<>(gestorEmpleado.getEmpleados(), HttpStatus.ACCEPTED);
    }
}
