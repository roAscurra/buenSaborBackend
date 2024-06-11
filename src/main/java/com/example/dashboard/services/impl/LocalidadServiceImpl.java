package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Localidad;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.LocalidadRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.LocalidadService;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(LocalidadRepository localidadRepository) {
        super((BaseRepository<Localidad,Long>) localidadRepository);
        this.localidadRepository = localidadRepository;
    }
}
