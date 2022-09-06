package com.abmodel.abmodel.Gestores;

import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.Enum_RoleName;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

public class GestorEmpleado {

    private ArrayList<Empleado> empleados; //Lista de objetos para probar controlador

    public GestorEmpleado(){
        this.empleados = new ArrayList<>();

        //Informacion de prueba
        //this.empleados.add(new Empleado(1, "José Rodriguez", "jose_rodruiguez@gmail.com", "Huevos s.a.", Enum_RoleName.ADMIN.name()));
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //@RequestMapping(value = "nombreEmpleado")
    //public String getNombreEmpleado(){
    //    return empleados.get(0).getNombre();
    //}
}
