package com.example.dashboard.controllers;

import com.example.dashboard.entities.ArticuloManufacturadoDetalle;
import com.example.dashboard.services.impl.ArticuloManufacturadoDetalleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articuloManufacturadoDetalle")
public class ArticuloManufacturadoDetalleController extends BaseControllerImpl <ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleServiceImpl> {
    private ArticuloManufacturadoDetalleServiceImpl service;

    public ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleServiceImpl service) {
        super(service);
    }
}
