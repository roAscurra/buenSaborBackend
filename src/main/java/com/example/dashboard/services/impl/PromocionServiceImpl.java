package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Promocion;
import com.example.dashboard.repositories.PromocionRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.PromocionService;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl extends BaseServiceImpl<Promocion, Long> implements PromocionService {

    private PromocionRepository promocionRepository;

    public PromocionServiceImpl(PromocionRepository promocionRepository) {
        super(promocionRepository);
        this.promocionRepository = promocionRepository;
    }
}
