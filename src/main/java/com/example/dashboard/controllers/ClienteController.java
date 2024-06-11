package com.example.dashboard.controllers;

import com.example.dashboard.entities.Cliente;
import com.example.dashboard.services.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
    private ClienteServiceImpl service;
    public ClienteController(ClienteServiceImpl service) {
        super(service);
    }
}
