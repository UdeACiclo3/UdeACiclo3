package com.abmodel.abmodel.controllers;

import com.abmodel.abmodel.dto.CredentialsDto;
import com.abmodel.abmodel.entities.Empleado;
import com.abmodel.abmodel.services.EmpleadoService;
import com.abmodel.abmodel.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    private EmpleadoService empleadoService;

    public LoginController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/registro")
    public String registro(){
        return "login/registro";
    }

    @PostMapping("login/postlogin")
    public RedirectView postlogin(CredentialsDto credenciales){
        Response response = empleadoService.loginUser(credenciales);
        System.out.println(response);
        if(response.getCode() == 200){
            return new RedirectView("/inicio");
        }
        else{
            return new RedirectView("/error");
        }
    }

    @GetMapping("error")
    public String error(){
        return "login/error";
    }
}
