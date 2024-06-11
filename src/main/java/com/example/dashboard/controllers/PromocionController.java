package com.example.dashboard.controllers;

import com.example.dashboard.entities.Promocion;
import com.example.dashboard.services.impl.PromocionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/promociones")
public class PromocionController extends BaseControllerImpl<Promocion, PromocionServiceImpl> {
    private PromocionServiceImpl service;
    public PromocionController(PromocionServiceImpl service) {
        super(service);
    }
}
