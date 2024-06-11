package com.example.dashboard.controllers;

import com.example.dashboard.entities.Sucursal;
import com.example.dashboard.services.impl.SucursalServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/sucursal")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalServiceImpl> {
    private SucursalServiceImpl service;
    public SucursalController(SucursalServiceImpl service) {
        super(service);
    }

}
