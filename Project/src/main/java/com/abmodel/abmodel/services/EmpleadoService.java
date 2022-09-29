package com.abmodel.abmodel.services;

import com.abmodel.abmodel.dto.CredentialsDto;
import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.repositories.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmpleadoService {
    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public Response crearEmpleado(Empleado empleado){
        Response response = new Response();
        try{
            empleado.setFechaCreacion(LocalDateTime.now());
            empleado.setFechaActualizacion(LocalDateTime.now());
            this.empleadoRepository.save(empleado);
            response.setCode(200);
            response.setMessage("Empleado creado con éxito");
        }catch(Exception exception){
            response.setCode(500);
            response.setMessage("Error: " + exception.getMessage());
        }
        return response;
    }

    public List<Empleado> getEmpleados(){
        return this.empleadoRepository.findAll();
    }

    public Empleado getEmpleado(long id){
        Optional<Empleado> empleadoEncontrado = this.empleadoRepository.findById(id);
        if(empleadoEncontrado.isPresent()){
            return empleadoEncontrado.get();
        }else {
            return null;
        }
    }

    public Response editarEmpleado(long id, Empleado empleadoActualizado){
        Response response = new Response();
        if(id == 0){
            response.setCode(500);
            response.setMessage("Error: el id no es válido");
            return response;
        }
        Empleado empleadoEncontrado = getEmpleado(id);
        if (empleadoEncontrado == null){
            response.setCode(500);
            response.setMessage("Error: la empresa no esta registrada en la base de datos");
            return response;
        }
        boolean esNecesarioActualizar = false;
        //Validación de cada campo que trae el Empleado actualizado
        if(empleadoActualizado.getNombre()!=null){
            empleadoEncontrado.setNombre(empleadoActualizado.getNombre());
            esNecesarioActualizar = true;
        }
        if(empleadoActualizado.getRol()!=null){
            empleadoEncontrado.setRol(empleadoActualizado.getRol());
            esNecesarioActualizar = true;
        }
        if(empleadoEncontrado.getEmpresa()!=null){
            empleadoEncontrado.setEmpresa(empleadoActualizado.getEmpresa());
            esNecesarioActualizar = true;
        }
        if(empleadoEncontrado.getEmail()!=null){
            empleadoEncontrado.setEmail(empleadoActualizado.getEmail());
            esNecesarioActualizar = true;
        }

        if (esNecesarioActualizar){
            empleadoEncontrado.setFechaActualizacion(LocalDateTime.now());
            empleadoRepository.save(empleadoEncontrado);
            response.setCode(200);
            response.setMessage("Empleado actualizado");
        }else{
            response.setCode(500);
            response.setMessage("Error: la petición no contiene campos para actualizar");
        }
        return response;
    }

    public Response eliminarEmpleado(long id){
        Response response = new Response();
        try{
            this.empleadoRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Emplado eliminado exitosamente");
            return response;
        }catch (Exception e){
            response.setCode(500);
            response.setMessage("Error: " + e.getMessage());
            return response;
        }
    }




    public Response loginUser(CredentialsDto credentials){
        Response response = new Response();

        List<Empleado> existe = this.empleadoRepository.validaCredenciales(credentials.getUser(),credentials.getPassword());
        if(existe != null && existe.size() > 0){
            response.setCode(200);
            response.setMessage("Usuario autenticado exitosamente.");
            return  response;
        }

        response.setCode(500);
        response.setMessage("Error, sus datos de acceso no son válidos");
        return  response;
    }
}
