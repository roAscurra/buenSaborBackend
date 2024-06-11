package com.example.dashboard.controllers;

import com.example.dashboard.entities.Localidad;
import com.example.dashboard.services.impl.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/localidad")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
    private LocalidadServiceImpl service;
    public LocalidadController(LocalidadServiceImpl service) {
        super(service);
    }
}
