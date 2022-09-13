package com.abmodel.abmodel.services;

import com.abmodel.abmodel.entities.Empresa;
import com.abmodel.abmodel.repositories.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private IEmpresaRepository empresaRepository;

    //Método constructor
    public EmpresaService(IEmpresaRepository repository) {
        this.empresaRepository = repository;
    }

    //Servicios
    public Response crearEmpresa(Empresa empresa){
        Response response = new Response();
        try {
            if(empresaRepository.buscarEmpresaPorNombre(empresa.getNombre()).size()>0){
                throw new Exception("El nombre de la empresa ya esta registrado en la base de datos");
            }
            if(empresaRepository.buscarEmpresaPorNit(empresa.getNit()).size()>0){
                throw new Exception("El nit de la empresa ya esta registrado en la base de datos");
            }
            this.empresaRepository.save(empresa);
            response.setCode(200);
            response.setMessage("Empresa registrada exitosamente");
        }catch(Exception e){
            response.setCode(500);
            response.setMessage("Error: " + e.getMessage());
        }
        return response;
    }


    public Empresa getEmpresa(long id){
        Optional<Empresa> empresaEncontrada = this.empresaRepository.findById(id);
        if(empresaEncontrada.isPresent()){
            return empresaEncontrada.get();
        }else{
            return null;
        }
    }

    public List<Empresa> getEmpresas() {
        return this.empresaRepository.findAll();
    }

    public Response editarEmpresa(long id, Empresa empresaActualizada){
        Response response = new Response();

        //Validación del id
        if(id == 0){
            response.setCode(500);
            response.setMessage("Error: el id no es válido");
            return response;
        }
        Empresa empresaEncontrada = getEmpresa(id);
        if (empresaEncontrada == null){
            response.setCode(500);
            response.setMessage("Error: la empresa no esta registrada en la base de datos");
            return response;
        }

        boolean esNecesarioActualizar = false;

        //Validación de cada campo que trae la empresaActualizada
        if (empresaActualizada.getNombre() !=null){
            empresaEncontrada.setNombre(empresaActualizada.getNombre());
            esNecesarioActualizar = true;
        }
        if (empresaActualizada.getDireccion()!=null){
            empresaEncontrada.setDireccion(empresaActualizada.getDireccion());
            esNecesarioActualizar = true;
        }
        if(empresaActualizada.getTelefono()!=null){
            empresaEncontrada.setTelefono(empresaActualizada.getTelefono());
            esNecesarioActualizar = true;
        }
        if(empresaActualizada.getNit()!=null){
            empresaEncontrada.setNit(empresaActualizada.getNit());
            esNecesarioActualizar = true;
        }

        if (esNecesarioActualizar){
            empresaRepository.save(empresaEncontrada);
            response.setCode(200);
            response.setMessage("Empresa actualizada");
        }else{
            response.setCode(500);
            response.setMessage("Error: la petición no contiene campos para actualizar");
        }
        return response;

    }

    public Response eliminarEmpresa(long id){
        Response response = new Response();
        try{
            this.empresaRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Empresa eliminada exitosamente");
            return response;
        }catch (Exception e){
            response.setCode(500);
            response.setMessage("Error: " + e.getMessage());
            return response;
        }
    }
}
