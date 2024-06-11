package com.example.dashboard.controllers;

import com.example.dashboard.entities.Pais;
import com.example.dashboard.services.impl.PaisServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/pais")
public class PaisController extends BaseControllerImpl<Pais, PaisServiceImpl>{
    private PaisServiceImpl service;
    public PaisController(PaisServiceImpl service) {
        super(service);
    }
}
