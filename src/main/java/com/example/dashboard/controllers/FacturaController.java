package com.example.dashboard.controllers;

import com.example.dashboard.entities.Factura;
import com.example.dashboard.services.impl.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{
    private FacturaServiceImpl service;
    public FacturaController(FacturaServiceImpl service) {
        super(service);
    }
}

