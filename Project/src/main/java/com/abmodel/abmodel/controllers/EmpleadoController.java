package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.Enum_RoleName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class EmpleadoController {
    //Clase de prueba del empleado
    ArrayList<Empleado> empleados;

    public EmpleadoController() {
        empleados = new ArrayList<>();
    }

    public void crearEmpleado(){
        Empleado empleado = new Empleado(1, "José Rodriguez", "jose_rodruiguez@gmail.com",
                "Huevos s.a.", Enum_RoleName.ADMIN.name());
        empleados.add(empleado);
    }
    @RequestMapping(value = "nombreEmpleado")
    public String getNombreEmpleado(){
        return empleados.get(0).getNombre();
    }

}
