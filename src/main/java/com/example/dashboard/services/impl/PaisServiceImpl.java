package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Pais;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.PaisRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.PaisService;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais,Long> implements PaisService {

    private PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        super((BaseRepository<Pais, Long>) paisRepository);
        this.paisRepository = paisRepository;
    }
}
