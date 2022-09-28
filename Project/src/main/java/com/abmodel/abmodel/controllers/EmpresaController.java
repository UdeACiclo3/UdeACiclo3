package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Empresa;
import com.abmodel.abmodel.entities.Transaccion;
import com.abmodel.abmodel.services.EmpresaService;
import com.abmodel.abmodel.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @RequestMapping("enterprises")
    public List<Empresa> getEmpresas(){
        return empresaService.getEmpresas();
    }
    @PostMapping("enterprises")
    public Response crearEmpresa(@RequestBody Empresa empresa){
        return empresaService.crearEmpresa(empresa);
    }
    @RequestMapping("enterprises/{id}")
    public Empresa buscarEmpresaPorId(@PathVariable long id){
        return empresaService.getEmpresa(id);
    }
    @PatchMapping("enterprises/{id}")
    public Response actualizarEmpresa(@PathVariable long id, @RequestBody Empresa empresa){
        return empresaService.editarEmpresa(id, empresa);
    }
    @DeleteMapping("enterprises/{id}")
    public Response eliminarEmpresa(@PathVariable long id){
        return empresaService.eliminarEmpresa(id);
    }

    //Transacciones
    @GetMapping("movements")
    public List<Transaccion> getTransacciones(){
        return empresaService.getTransacciones();
    }

    @PostMapping("enterprises/{id}/movements")
    public Response crearTransaccion(@PathVariable long id, @RequestBody Transaccion transaccion){
        return  empresaService.agregarTransaccion(id, transaccion);
    }

    @GetMapping("enterprises/{id}/movements")
    public List<Transaccion> getTransaccionesPorEmpresa(@PathVariable long id){
        return  empresaService.getTransaccionesPorEmpresa(id);
    }

    @PatchMapping("enterprises/{id}/movements")
    public Response actualizarTransaccion(@PathVariable long id, @RequestBody Transaccion transaction){
        return empresaService.actualizarTransaccion(id, transaction);
    }

    @DeleteMapping("enterprises/{id}/movements")
    public Response deleteTransaccion(@PathVariable long id){
        return empresaService.eliminarTransaccion(id);
    }
}
