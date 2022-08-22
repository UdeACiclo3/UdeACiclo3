package com.abmodel.abmodel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {
    @RequestMapping(value = "business")
    public String business(){
        return "Este es nuestro primer controller";
    }
}
