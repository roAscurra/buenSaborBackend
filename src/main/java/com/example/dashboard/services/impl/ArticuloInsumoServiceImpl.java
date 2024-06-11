package com.example.dashboard.services.impl;

import com.example.dashboard.entities.ArticuloInsumo;
import com.example.dashboard.repositories.ArticuloInsumoRepository;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.services.ArticuloInsumoService;
import com.example.dashboard.services.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(ArticuloInsumoRepository articuloInsumoRepository){
        super((BaseRepository<ArticuloInsumo, Long>) articuloInsumoRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }
}
