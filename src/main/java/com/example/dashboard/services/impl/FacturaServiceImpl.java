package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Factura;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.FacturaRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.FacturaService;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        super((BaseRepository<Factura, Long>) facturaRepository);
        this.facturaRepository = facturaRepository;
    }
}
