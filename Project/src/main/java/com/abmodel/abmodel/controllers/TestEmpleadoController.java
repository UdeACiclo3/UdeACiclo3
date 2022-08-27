package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.Enum_RoleName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEmpleadoController {
    Empleado empleado = new Empleado(1, "Juan Camilo", "juancamilo@gmail.com", "ecopetrol",
            Enum_RoleName.ADMIN);

    @RequestMapping(value = "empleado")
    public String business(){
        return "Datos del empleado -->   \n " +
                "Id: " + empleado.getId() +
                "Nombre: " + empleado.getNombre() +
                "Email: " + empleado.getEmail() +
                "Empresa: " + empleado.getEmpresa() +
                "Rol: " + empleado.getRol();
    }
}
