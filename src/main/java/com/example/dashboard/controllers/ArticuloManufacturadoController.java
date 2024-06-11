package com.example.dashboard.controllers;

import com.example.dashboard.entities.ArticuloManufacturado;
import com.example.dashboard.services.impl.ArticuloManufacturadoServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImpl <ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {
    private ArticuloManufacturadoServiceImpl service;

    public ArticuloManufacturadoController(ArticuloManufacturadoServiceImpl service) {
        super(service);
    }
}
