package com.example.dashboard.services.impl;

import com.example.dashboard.entities.ArticuloManufacturadoDetalle;
import com.example.dashboard.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.services.ArticuloManufacturadoDetalleService;
import com.example.dashboard.services.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoDetalleServiceImpl extends BaseServiceImpl<ArticuloManufacturadoDetalle, Long> implements ArticuloManufacturadoDetalleService {
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleServiceImpl(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository) {
        super((BaseRepository<ArticuloManufacturadoDetalle, Long>) articuloManufacturadoDetalleRepository);
        this.articuloManufacturadoDetalleRepository = articuloManufacturadoDetalleRepository;
    }
}
