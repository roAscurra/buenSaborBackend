package com.example.dashboard.controllers;

import com.example.dashboard.entities.Domicilio;
import com.example.dashboard.services.impl.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl> {
    private DomicilioServiceImpl service;
    public DomicilioController(DomicilioServiceImpl service) {
        super(service);
    }
}
