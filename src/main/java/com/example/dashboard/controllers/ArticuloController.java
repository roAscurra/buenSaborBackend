package com.example.dashboard.controllers;

import com.example.dashboard.entities.Articulo;
import com.example.dashboard.services.impl.ArticuloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articulos")
public class ArticuloController extends BaseControllerImpl<Articulo, ArticuloServiceImpl>{
    private ArticuloServiceImpl service;
    public ArticuloController(ArticuloServiceImpl service) {
        super(service);
    }
}
