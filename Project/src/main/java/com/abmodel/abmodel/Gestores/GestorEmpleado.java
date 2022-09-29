package com.abmodel.abmodel.Gestores;

import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.entities.Empresa;
import com.abmodel.abmodel.entities.Enum_RoleName;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestorEmpleado {

    private ArrayList<Empleado> empleados; //Lista de objetos para probar controlador

    public GestorEmpleado() {
        this.empleados = new ArrayList<>();

        //Informacion de prueba
        this.empleados.add(new Empleado(1, LocalDateTime.now(), LocalDateTime.now(), "José Rodriguez", "jose_rodruiguez@gmail.com",
                new Empresa(1,"Sigmi", "27", "26626", "5845", LocalDateTime.now(), LocalDateTime.now()),
                Enum_RoleName.ADMIN));
        this.empleados.add(new Empleado(2, LocalDateTime.now(), LocalDateTime.now(),"David Ortiz", "davidestebanortizjernandez@gmail.com",
                new Empresa(2, "plantaringeneria", "22", "321055", "1111", LocalDateTime.now(), LocalDateTime.now()),
                Enum_RoleName.OPERARIO));
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getEmpleado(long id) throws Exception {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id){
                empleadoEncontrado =  empleado;
            }
        }
        return empleadoEncontrado;
    }


    public String agegrarEmpleado(Empleado empleado) throws Exception {
        String response = "";
        try {
            //Consulta de existencia del usuario
            Empleado prueba = getEmpleado(empleado.getId());
            if(prueba!=null){
                //Error si el usuario ya existe
                throw new Exception("Usuario existe");
            }
            //Creacion del usuario
            empleado.setFechaCreacion(LocalDateTime.now());
            empleado.setFechaActualizacion(LocalDateTime.now());
            this.empleados.add(empleado);
            response = "Empleado agregado con éxito";
        } catch (Exception e) {
            response = "Error: " + e.getMessage();
        }
        return response;
    }

    public Empleado updateUsuario(Empleado empleado_update, long id) throws Exception {
        try {
            Empleado empleado_bdts = getEmpleado(id);

            if(empleado_update.getEmpresa() != null && !empleado_update.getEmpresa().equals("")) {
                empleado_bdts.setEmpresa(empleado_update.getEmpresa());

            }
            if(empleado_update.getNombre() != null && !empleado_update.getNombre().equals("")) {
                empleado_bdts.setNombre(empleado_update.getNombre());
            }
            if(empleado_update.getEmail() != null && !empleado_update.getEmail().equals("")) {
                empleado_bdts.setEmail(empleado_update.getEmail());
            }
            empleado_bdts.setFechaActualizacion(LocalDateTime.now());
            return empleado_bdts;

        } catch (Exception e) {
            throw new Exception("Usuario no existe, fallo actualizacion");
        }


    }

    public String deleteUsuario(long id) throws Exception {
        try {
            Empleado empleado = getEmpleado(id);

            this.empleados.remove(empleado);

            return "Eliminado exitoso";
        } catch (Exception e) {
            throw new Exception("Usuario NO Existe para Eliminar");
        }

    }
}
