package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Articulo;
import com.example.dashboard.repositories.ArticuloRepository;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.services.ArticuloService;
import com.example.dashboard.services.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl extends BaseServiceImpl<Articulo, Long> implements ArticuloService {
    private ArticuloRepository articuloRepository;
    public ArticuloServiceImpl(ArticuloRepository articuloRepository){
        super((BaseRepository<Articulo, Long>) articuloRepository);
        this.articuloRepository = articuloRepository;
    }

}
