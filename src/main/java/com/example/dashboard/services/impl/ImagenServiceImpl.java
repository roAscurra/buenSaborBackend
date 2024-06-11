package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Imagen;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.ImagenRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.ImagenService;
import org.springframework.stereotype.Service;

@Service
public class ImagenServiceImpl extends BaseServiceImpl<Imagen,Long> implements ImagenService {

    private ImagenRepository imagenRepository;

    public ImagenServiceImpl(ImagenRepository imagenRepository) {
        super((BaseRepository<Imagen, Long>) imagenRepository);
        this.imagenRepository = imagenRepository;
    }
}
