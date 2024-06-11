package com.example.dashboard.services.impl;

import com.example.dashboard.entities.Usuario;
import com.example.dashboard.repositories.BaseRepository;
import com.example.dashboard.repositories.UsuarioRepository;
import com.example.dashboard.services.BaseServiceImpl;
import com.example.dashboard.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super((BaseRepository<Usuario,Long>) usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }
}
