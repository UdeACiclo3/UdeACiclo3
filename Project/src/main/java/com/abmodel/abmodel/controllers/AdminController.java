package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.entities.Transaccion;
import com.abmodel.abmodel.services.EmpleadoService;
import com.abmodel.abmodel.services.EmpresaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    private EmpresaService empresaService;

    public AdminController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }
    @GetMapping("transacciones")
    public String transaccionesregistradas(Model transaccion){
        List<Transaccion> transaccionesDB = empresaService.getTransacciones();
        transaccion.addAttribute("transacciones", transaccionesDB);
        return "/admin/transacciones";
    }
}
