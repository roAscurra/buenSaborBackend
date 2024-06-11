package com.example.dashboard.services.impl;

import com.example.dashboard.entities.UnidadMedida;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.UnidadMedidaRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.UnidadMedidaService;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(UnidadMedidaRepository unidadMedidaRepository) {
        super((BaseRepository<UnidadMedida, Long>) unidadMedidaRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
}
