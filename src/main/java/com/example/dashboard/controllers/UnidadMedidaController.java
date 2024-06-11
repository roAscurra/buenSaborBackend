package com.example.dashboard.controllers;

import com.example.dashboard.entities.UnidadMedida;

import com.example.dashboard.services.impl.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/unidadMedida")
public class UnidadMedidaController extends BaseControllerImpl <UnidadMedida, UnidadMedidaServiceImpl> {
    private UnidadMedidaServiceImpl service;

    public UnidadMedidaController(UnidadMedidaServiceImpl service) {
        super(service);
    }
}