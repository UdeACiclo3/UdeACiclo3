package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.Gestores.GestorEmpleado;
import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    // Controlador info
    private GestorEmpleado gestorEmpleado = new GestorEmpleado(); // De la clase GestorEmpleado que contiene los empleados

    @PostMapping("/users")
    public ResponseEntity<String> postusuario(@RequestBody Empleado usuario) {
        try {
            String mensaje = gestorEmpleado.agegrarEmpleado(usuario);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users") //Va a traer todos los usuarios
    public ResponseEntity<List<Empleado>> getEmpleados(){   //Vamos a responder una entidad
        return new ResponseEntity<>(gestorEmpleado.getEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsuarios(@PathVariable long id) {
        try {
            Empleado empleado = gestorEmpleado.getEmpleado(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/users/{id}")
    public ResponseEntity<Object> patchUsuario(@RequestBody Empleado empleado_update, @PathVariable long id){
        try {
            Empleado empleado_bdts = gestorEmpleado.updateUsuario(empleado_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion existosa",empleado_bdts),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage() ,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteUsuario(@PathVariable long id){

        try {
            String mensaje = gestorEmpleado.deleteUsuario(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
