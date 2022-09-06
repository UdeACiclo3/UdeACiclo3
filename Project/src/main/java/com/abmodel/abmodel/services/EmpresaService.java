package com.abmodel.abmodel.services;

import com.abmodel.abmodel.entities.Empresa;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService {
    //Atributos
    private List<Empresa> empresas;

    //Método constructor
    public EmpresaService() {
        empresas = new ArrayList<>();
    }

    //Servicios
    public Response crearEmpresa(Empresa empresa){
        Response response = new Response();
        empresas.add(empresa);
        response.setCode(200);
        response.setMessage("Empresa registrada exitosamente");
        return response;
    }

    public Empresa getEmpresa(long id){
        Empresa empresaEncontrada = null;
        for (Empresa empresa: empresas) {
            if(empresa.getId()== id){
                empresaEncontrada = empresa;
            }
        }
        return empresaEncontrada;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public Response editarEmpresa(Empresa empresaActualizada){
        Response response = new Response();
        Empresa empresaEncontrada = getEmpresa(empresaActualizada.getId());
        if(empresaEncontrada==null){
            response.setCode(500);
            response.setMessage("Error: la empresa no esta registrada");
            return response;
        }
        empresaEncontrada.setNombreempresa(empresaActualizada.getNombreempresa());
        empresaEncontrada.setDireccion(empresaActualizada.getDireccion());
        empresaEncontrada.setTelefono(empresaActualizada.getTelefono());
        empresaEncontrada.setNit(empresaActualizada.getNit());
        response.setCode(200);
        response.setMessage("Empresa actualizada");
        return response;
    }

    public Response eliminarEmpresa(long id){
        Response response = new Response();

        Empresa empresaAEliminar = getEmpresa(id);
        if (empresaAEliminar==null){
            response.setCode(500);
            response.setMessage("Error: la empresa no esta registrada");
            return response;
        }
        empresas.remove(empresaAEliminar);
        return response;
    }
}
