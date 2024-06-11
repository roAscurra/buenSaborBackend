package com.example.dashboard.services.impl;

import com.example.dashboard.entities.ArticuloManufacturado;
import com.example.dashboard.repositories.ArticuloManufacturadoRepository;
import com.example.dashboard.repositories.BaseRepository;

import com.example.dashboard.services.ArticuloManufacturadoService;
import com.example.dashboard.services.BaseServiceImpl;
import org.springframework.stereotype.Service;
@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {


    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super((BaseRepository<ArticuloManufacturado, Long>) articuloManufacturadoRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }
}
