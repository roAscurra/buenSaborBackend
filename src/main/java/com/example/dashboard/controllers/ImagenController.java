package com.example.dashboard.controllers;

import com.example.dashboard.entities.Imagen;
import com.example.dashboard.services.impl.ImagenServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/imagen")
public class ImagenController extends BaseControllerImpl<Imagen, ImagenServiceImpl>{
    private ImagenServiceImpl service;
    public ImagenController(ImagenServiceImpl service) {
        super(service);
    }
}
