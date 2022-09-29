package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.services.EmpleadoService;
import com.abmodel.abmodel.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    // Controlador info
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @PostMapping("/users")
    public Response postusuario(@RequestBody Empleado usuario) {
        return empleadoService.crearEmpleado(usuario);
    }

    @GetMapping("/users") //Va a traer todos los usuarios
    public List<Empleado> getEmpleados(){   //Vamos a responder una entidad
        return empleadoService.getEmpleados();
    }

    @GetMapping("/users/{id}")
    public Empleado getUsuarios(@PathVariable long id) {
       return empleadoService.getEmpleado(id);
    }


    @PatchMapping("/users/{id}")
    public Response patchUsuario(@RequestBody Empleado empleadoUpdate, @PathVariable long id){
        return empleadoService.editarEmpleado(id, empleadoUpdate);

    }
    @DeleteMapping("/users/{id}")
    public Response deleteUsuario(@PathVariable long id){
        return empleadoService.eliminarEmpleado(id);
    }
}
